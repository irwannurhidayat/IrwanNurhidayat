package com.example.irwannurhidayat;

public class ItemModel {
    String namejd, year;
    int karya;

    public ItemModel(String namejd, String year, int karya) {
        this.namejd = namejd;
        this.year = year;
        this.karya = karya;
    }

    public String getNamejd() {
        return namejd;
    }

    public void setNamejd(String namejd) {

        this.namejd = namejd;
    }

    public String getYear() {

        return year;
    }

    public void setYear(String year) {

        this.year = year;
    }

    public int getKarya() {

        return karya;
    }

    public void setKarya(int karya) {

        this.karya = karya;
    }
}
