package com.thuanthanh.lichviet.model;

public class GioHoangDao {
    public int imgHoangDao;
    public String conGiap;
    public String gioHoangDao;

    public GioHoangDao(int imgHoangDao, String conGiap, String gioHoangDao) {
        this.imgHoangDao = imgHoangDao;
        this.conGiap = conGiap;
        this.gioHoangDao = gioHoangDao;
    }

    public int getImgHoangDao() {
        return imgHoangDao;
    }

    public void setImgHoangDao(int imgHoangDao) {
        this.imgHoangDao = imgHoangDao;
    }

    public String getConGiap() {
        return conGiap;
    }

    public void setConGiap(String conGiap) {
        this.conGiap = conGiap;
    }

    public String getGioHoangDao() {
        return gioHoangDao;
    }

    public void setGioHoangDao(String gioHoangDao) {
        this.gioHoangDao = gioHoangDao;
    }
}
