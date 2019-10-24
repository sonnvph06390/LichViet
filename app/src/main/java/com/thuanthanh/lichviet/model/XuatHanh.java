package com.thuanthanh.lichviet.model;

public class XuatHanh {
    public int imgXuatHanh;
    public String than;
    public String huong;

    public XuatHanh(int imgXuatHanh, String than, String huong) {
        this.imgXuatHanh = imgXuatHanh;
        this.than = than;
        this.huong = huong;
    }

    public int getImgXuatHanh() {
        return imgXuatHanh;
    }

    public void setImgXuatHanh(int imgXuatHanh) {
        this.imgXuatHanh = imgXuatHanh;
    }

    public String getThan() {
        return than;
    }

    public void setThan(String than) {
        this.than = than;
    }

    public String getHuong() {
        return huong;
    }

    public void setHuong(String huong) {
        this.huong = huong;
    }
}
