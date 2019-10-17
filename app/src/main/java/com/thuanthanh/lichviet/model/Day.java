package com.thuanthanh.lichviet.model;

public class Day {
    private String dayOfWeek;
    private String ngayThangDuong;
    private String ngayThangAm;
    private String gioAm;
    private String tuoiXung;
    private String gioHoangDao;
    private String soSuKien;

    public Day(String dayOfWeek, String ngayThangDuong, String ngayThangAm, String gioAm, String tuoiXung, String gioHoangDao, String soSuKien) {
        this.dayOfWeek = dayOfWeek;
        this.ngayThangDuong = ngayThangDuong;
        this.ngayThangAm = ngayThangAm;
        this.gioAm = gioAm;
        this.tuoiXung = tuoiXung;
        this.gioHoangDao = gioHoangDao;
        this.soSuKien = soSuKien;
    }

    public Day() {

    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getNgayThangDuong() {
        return ngayThangDuong;
    }

    public void setNgayThangDuong(String ngayThangDuong) {
        this.ngayThangDuong = ngayThangDuong;
    }

    public String getNgayThangAm() {
        return ngayThangAm;
    }

    public void setNgayThangAm(String ngayThangAm) {
        this.ngayThangAm = ngayThangAm;
    }

    public String getGioAm() {
        return gioAm;
    }

    public void setGioAm(String gioAm) {
        this.gioAm = gioAm;
    }

    public String getTuoiXung() {
        return tuoiXung;
    }

    public void setTuoiXung(String tuoiXung) {
        this.tuoiXung = tuoiXung;
    }

    public String getGioHoangDao() {
        return gioHoangDao;
    }

    public void setGioHoangDao(String gioHoangDao) {
        this.gioHoangDao = gioHoangDao;
    }

    public String getSoSuKien() {
        return soSuKien;
    }

    public void setSoSuKien(String soSuKien) {
        this.soSuKien = soSuKien;
    }
}
