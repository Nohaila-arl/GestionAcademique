package com.academy.models;

public class Statistiques {
    // Attributs
    private int idStat;
    private String typeStat;
    private String periode;
    private float valeur;
    
    // Constructeurs
    public Statistiques() {
    }
    
    public Statistiques(int idStat, String typeStat, String periode, float valeur) {
        this.idStat = idStat;
        this.typeStat = typeStat;
        this.periode = periode;
        this.valeur = valeur;
    }
    
    // Getters
    public int getIdStat() {
        return idStat;
    }
    
    public String getTypeStat() {
        return typeStat;
    }
    
    public String getPeriode() {
        return periode;
    }
    
    public float getValeur() {
        return valeur;
    }
    
    // Setters
    public void setIdStat(int idStat) {
        this.idStat = idStat;
    }
    
    public void setTypeStat(String typeStat) {
        this.typeStat = typeStat;
    }
    
    public void setPeriode(String periode) {
        this.periode = periode;
    }
    
    public void setValeur(float valeur) {
        this.valeur = valeur;
    }
    
}

