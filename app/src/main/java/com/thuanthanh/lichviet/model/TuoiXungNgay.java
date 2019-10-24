package com.thuanthanh.lichviet.model;

public class TuoiXungNgay {
    public int imgTuoiXungNgay;
    public String conGiap;
    public String nguHanh;

    public TuoiXungNgay(int imgTuoiXungNgay, String conGiap, String nguHanh) {
        this.imgTuoiXungNgay = imgTuoiXungNgay;
        this.conGiap = conGiap;
        this.nguHanh = nguHanh;
    }

    public int getImgTuoiXungNgay() {
        return imgTuoiXungNgay;
    }

    public void setImgTuoiXungNgay(int imgTuoiXungNgay) {
        this.imgTuoiXungNgay = imgTuoiXungNgay;
    }

    public String getConGiap() {
        return conGiap;
    }

    public void setConGiap(String conGiap) {
        this.conGiap = conGiap;
    }

    public String getNguHanh() {
        return nguHanh;
    }

    public void setNguHanh(String nguHanh) {
        this.nguHanh = nguHanh;
    }
}
