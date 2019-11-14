yieldUnescaped '<!DOCTYPE html>'
html {
    head {
        title("Ge")
        meta('http-equiv': 'Content-Type', content: 'text/html; charset=utf-8')
        meta('name': "viewport", content: "width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no")
        link(rel: 'icon', href: 'favicon.ico', type: "image/x-icon")
        link(rel: "stylesheet", type: "text/css", href: "styles/grapheditor.css")
        script(src: '/js/Open.js') {}
    }

    body(onload: 'main();') {
        form(method: "POST",
                enctype: "multipart/form-data",
                action: "",
                name: "openForm",
                id: "openForm",
                onsubmit: "return handleSubmit();",
                'accept-charset': "UTF-8") {

            table(style: "width:100%;") {
                tr(style: "height:40px;vertical-align:top;", colspan: "2") {
                    td(style: "height:40px;vertical-align:top;", colspan: "2") {
                        input(type: "file", name: "upfile", onchange: "fileChanged()") {}
                    }
                }

                tr {
                    td(colspan: "2", height: "120px", id: "openSupported", style: "font-family:arial;color:grey;font-size:9pt;vertical-align:top;text-align:left;") {
                    }
                }

                tr {
                    td {}
                    td(style: "vertical-align:middle;text-align:right;white-space:nowrap;") {
                        input(type: "button",
                                id: "closeButton",
                                class: "geBtn",
                                value: "Cancel",
                                onclick: "hideWindow(true);") {
                        }
                        input(type: "submit",
                                id: "openButton",
                                class: "geBtn gePrimaryBtn",
                                value: "Open",
                                disabled: "disabled") {}
                    }
                }
            }
        }
    }
}