package com.example.mes_medicaments.models;

public class medData {
    private String nomMed ;
    private String descriptionMed ;
    private String tempsMed ,tempsMed2;
    private int img;

    public medData(String nomMed,String descriptionMed,String tempsMed,String tempsMed2,int img) {
        this.nomMed = nomMed;
        this.descriptionMed = descriptionMed;
        this.tempsMed = tempsMed;
        this.tempsMed2 = tempsMed2;
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

    public String getTempsMed2() {
        return tempsMed2;
    }

    public void setTempsMed2(String tempsMed2) {
        this.tempsMed2 = tempsMed2;
    }
}
