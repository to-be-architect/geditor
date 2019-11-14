package com.mxgraph.io.gliffy.model;

public class Diagram {

    public Stage stage;
    public Metadata metadata;
    public EmbeddedResources embeddedResources;
    private String version;

    public Diagram() {
        super();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
