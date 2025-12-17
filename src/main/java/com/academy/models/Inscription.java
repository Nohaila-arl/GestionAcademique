package com.academy.models;

import java.sql.Date;

public class Inscription {
    // Attributs
    private int idInscription;
    private int idEtudiant;
    private int idModule;
    private int idSemestre;
    private Date dateInscription;
    private String statut;
    
    // Relations
    private Etudiant etudiant;
    private Module module;
    private Semestre semestre;
    
    // Constructeurs
    public Inscription() {
    }
    
    public Inscription(int idInscription, int idEtudiant, int idModule, 
                     int idSemestre, Date dateInscription, String statut) {
        this.idInscription = idInscription;
        this.idEtudiant = idEtudiant;
        this.idModule = idModule;
        this.idSemestre = idSemestre;
        this.dateInscription = dateInscription;
        this.statut = statut;
    }
    
    // Getters
    public int getIdInscription() {
        return idInscription;
    }
    
    public int getIdEtudiant() {
        return idEtudiant;
    }
    
    public int getIdModule() {
        return idModule;
    }
    
    public int getIdSemestre() {
        return idSemestre;
    }
    
    public Date getDateInscription() {
        return dateInscription;
    }
    
    public String getStatut() {
        return statut;
    }
    
    public Etudiant getEtudiant() {
        return etudiant;
    }
    
    public Module getModule() {
        return module;
    }
    
    public Semestre getSemestre() {
        return semestre;
    }
    
    // Setters
    public void setIdInscription(int idInscription) {
        this.idInscription = idInscription;
    }
    
    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }
    
    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }
    
    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }
    
    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }
    
    public void setStatut(String statut) {
        this.statut = statut;
    }
    
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    
    public void setModule(Module module) {
        this.module = module;
    }
    
    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }
}

