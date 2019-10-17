package com.thuanthanh.lichviet.model;

public class DanhNgon {
    private int imgShare;
    private String danhngon;
    private String tacgia;

    public DanhNgon() {
    }

    public DanhNgon(int imgShare, String danhngon, String tacgia) {
        this.imgShare = imgShare;
        this.danhngon = danhngon;
        this.tacgia = tacgia;
    }

    public int getImgShare() {
        return imgShare;
    }

    public void setImgShare(int imgShare) {
        this.imgShare = imgShare;
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
