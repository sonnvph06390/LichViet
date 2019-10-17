package com.thuanthanh.lichviet.model;

public class TuViBoiToan {
    private int imgTuvi;
    private String tvTitleTuvi;

    public TuViBoiToan() {
    }

    public TuViBoiToan(int imgTuvi, String tvTitleTuvi) {
        this.imgTuvi = imgTuvi;
        this.tvTitleTuvi = tvTitleTuvi;
    }

    public int getImgTuvi() {
        return imgTuvi;
    }

    public void setImgTuvi(int imgTuvi) {
        this.imgTuvi = imgTuvi;
    }

    public String getTvTitleTuvi() {
        return tvTitleTuvi;
    }

    public void setTvTitleTuvi(String tvTitleTuvi) {
        this.tvTitleTuvi = tvTitleTuvi;
    }
}
