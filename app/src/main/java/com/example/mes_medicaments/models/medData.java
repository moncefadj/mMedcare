package com.example.mes_medicaments.models;

public class medData {
    private String nomMed ;
    private String descriptionMed ;
    private String tempsMed ;
    private int img;

    public medData(String nomMed,String descriptionMed,String tempsMed,int img) {
        this.nomMed = nomMed;
        this.descriptionMed = descriptionMed;
        this.tempsMed = tempsMed;
        this.img = img;

    }

    public String getNomMed() {
        return nomMed;
    }

    public void setNomMed(String nomMed) {
        this.nomMed = nomMed;
    }

    public String getDescriptionMed() {
        return descriptionMed;
    }

    public void setDescriptionMed(String descriptionMed) {
        this.descriptionMed = descriptionMed;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTempsMed() {
        return tempsMed;
    }

    public void setTempsMed(String tempsMed) {
        this.tempsMed = tempsMed;
    }
}
