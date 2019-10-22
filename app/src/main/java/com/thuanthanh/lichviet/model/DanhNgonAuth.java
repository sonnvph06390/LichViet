package com.thuanthanh.lichviet.model;

public class DanhNgonAuth {
    private String danhngon;
    private String tacgia;

    public DanhNgonAuth() {
    }

    public DanhNgonAuth(String danhngon, String tacgia) {
        this.danhngon = danhngon;
        this.tacgia = tacgia;
    }

    public String getDanhngon() {
        return danhngon;
    }

    public void setDanhngon(String danhngon) {
        this.danhngon = danhngon;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }
}
