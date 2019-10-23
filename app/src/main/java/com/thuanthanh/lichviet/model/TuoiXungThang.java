package com.thuanthanh.lichviet.model;

public class TuoiXungThang {
    public int imgTuoiXungThang;
    public String conGiap;
    public String nguHanh;

    public TuoiXungThang(int imgTuoiXungThang, String conGiap, String nguHanh) {
        this.imgTuoiXungThang = imgTuoiXungThang;
        this.conGiap = conGiap;
        this.nguHanh = nguHanh;
    }

    public int getImgTuoiXungThang() {
        return imgTuoiXungThang;
    }

    public void setImgTuoiXungThang(int imgTuoiXungThang) {
        this.imgTuoiXungThang = imgTuoiXungThang;
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
