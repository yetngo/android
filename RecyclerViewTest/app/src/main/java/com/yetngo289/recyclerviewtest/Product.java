package com.yetngo289.recyclerviewtest;

public class Product {
    private String masp,tensp,mota,giatien;
    public Product(){

    }
    public Product(String masp, String tensp,String mota,String giatien) {
        this.masp = masp;
        this.tensp = tensp;
        this.mota=mota;
        this.giatien=giatien;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }
    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }
}
