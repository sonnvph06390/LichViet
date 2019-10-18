package com.thuanthanh.lichviet.model;

public class DoiNgayTaoSukien {
    private String doiNgay;
    private String taoSuKien;
    private String xemNgayTot;

    public DoiNgayTaoSukien() {
    }

    public DoiNgayTaoSukien(String doiNgay, String taoSuKien, String xemNgayTot) {
        this.doiNgay = doiNgay;
        this.taoSuKien = taoSuKien;
        this.xemNgayTot = xemNgayTot;
    }

    public String getDoiNgay() {
        return doiNgay;
    }

    public void setDoiNgay(String doiNgay) {
        this.doiNgay = doiNgay;
    }

    public String getTaoSuKien() {
        return taoSuKien;
    }

    public void setTaoSuKien(String taoSuKien) {
        this.taoSuKien = taoSuKien;
    }

    public String getXemNgayTot() {
        return xemNgayTot;
    }

    public void setXemNgayTot(String xemNgayTot) {
        this.xemNgayTot = xemNgayTot;
    }
}
