package com.mxgraph.online;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation ExportProxyServlet
 */
@SuppressWarnings("serial")
@WebServlet(name = "ExportServlet", urlPatterns = "/export")
@Slf4j
public class ExportServlet extends HttpServlet {

    private final String[] supportedServices = {"EXPORT_URL", "PLANTUML_URL", "VSD_CONVERT_URL", "EMF_CONVERT_URL"};
    @Value("${server.port}")
    private String port;

    private void doRequest(String method, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int serviceId = 0;
            String proxyPath = "";
            String queryString = "";

            try {
                if (request.getQueryString() != null) {
                    queryString = "?" + request.getQueryString();
                }

                if (request.getPathInfo() != null) // /{serviceId}/*
                {
                    String[] pathParts = request.getPathInfo().split("/");

                    if (pathParts.length > 1) {
                        serviceId = Integer.parseInt(pathParts[1]);
                    }

                    if (pathParts.length > 2) {
                        proxyPath = String.join("/", Arrays.copyOfRange(pathParts, 2, pathParts.length));
                    }

                    if (serviceId < 0 || serviceId > supportedServices.length) {
                        serviceId = 0;
                    }
                }
            } catch (Exception e) {
                // Ignore and use 0
            }

            String EXPORT_URL = getHost();
            String exportUrl = System.getenv(supportedServices[serviceId]);
            if (exportUrl == null) {
                exportUrl = EXPORT_URL;
            }

            URL url = new URL(exportUrl + proxyPath + queryString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(method);
            //Copy request headers to export server
            Enumeration<String> headerNames = request.getHeaderNames();

            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                Enumeration<String> headers = request.getHeaders(headerName);

                while (headers.hasMoreElements()) {
                    String headerValue = headers.nextElement();
                    con.addRequestProperty(headerName, headerValue);
                }
            }

            if ("POST".equals(method)) {
                // Send post request
                con.setDoOutput(true);

                OutputStream params = con.getOutputStream();
                Utils.copy(request.getInputStream(), params);
                params.flush();
                params.close();
            }

            int responseCode = con.getResponseCode();
            //Copy response code
            response.setStatus(responseCode);

            //Copy response headers
            Map<String, List<String>> map = con.getHeaderFields();

            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();

                if (key != null) {
                    for (String val : entry.getValue()) {
                        response.addHeader(entry.getKey(), val);
                    }
                }
            }

            //Copy response
            OutputStream out = response.getOutputStream();

            //Error
            if (responseCode >= 400) {
                Utils.copy(con.getErrorStream(), out);
            } else //Success
            {
                Utils.copy(con.getInputStream(), out);
            }

            out.flush();
            out.close();
        } catch (Exception e) {
            log.info("", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest("GET", request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest("POST", request, response);
    }

    private String getIP() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }

    private String getHost() throws UnknownHostException {
        return "http://" + getIP() + ":" + port + "/";
    }
}