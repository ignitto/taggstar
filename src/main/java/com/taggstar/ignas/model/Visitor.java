package com.taggstar.ignas.model;

public class Visitor {

    private Integer visitorId;
    private String dim1;
    private Integer dim2;
    private String dim3;
    private Integer dim4;
    private String label;

    public Visitor() {
    }

    public Visitor(Integer visitorId, String dim1, Integer dim2, String dim3, Integer dim4, String label) {
        this.visitorId = visitorId;
        this.dim1 = dim1;
        this.dim2 = dim2;
        this.dim3 = dim3;
        this.dim4 = dim4;
        this.label = label;
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public String getDim1() {
        return dim1;
    }

    public void setDim1(String dim1) {
        this.dim1 = dim1;
    }

    public Integer getDim2() {
        return dim2;
    }

    public void setDim2(Integer dim2) {
        this.dim2 = dim2;
    }

    public String getDim3() {
        return dim3;
    }

    public void setDim3(String dim3) {
        this.dim3 = dim3;
    }

    public Integer getDim4() {
        return dim4;
    }

    public void setDim4(Integer dim4) {
        this.dim4 = dim4;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
