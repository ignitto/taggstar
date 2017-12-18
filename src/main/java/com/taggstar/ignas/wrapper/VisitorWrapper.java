package com.taggstar.ignas.wrapper;

import com.taggstar.ignas.model.Visitor;

public class VisitorWrapper {

    private Integer visitorId;
    private String label;

    public VisitorWrapper() {
    }

    public VisitorWrapper(Visitor visitor) {
        this.visitorId = visitor.getVisitorId();
        this.label = visitor.getLabel();
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
