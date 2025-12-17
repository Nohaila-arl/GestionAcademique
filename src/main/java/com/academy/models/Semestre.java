package com.academy.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Semestre {
    // Attributs
    private int idSemestre;
    private String anneeUniversitaire;
    private Date dateDebut;
    private Date dateFin;
    
    // Relations
    private List<Module> modules;
    private List<Inscription> inscriptions;
    private List<Bulletin> bulletins;
    
    // Constructeurs
    public Semestre() {
        this.modules = new ArrayList<>();
        this.inscriptions = new ArrayList<>();
        this.bulletins = new ArrayList<>();
    }
    
    public Semestre(int idSemestre, String anneeUniversitaire, Date dateDebut, Date dateFin) {
        this();
        this.idSemestre = idSemestre;
        this.anneeUniversitaire = anneeUniversitaire;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
    
    // Getters
    public int getIdSemestre() {
        return idSemestre;
    }
    
    public String getAnneeUniversitaire() {
        return anneeUniversitaire;
    }
    
    public Date getDateDebut() {
        return dateDebut;
    }
    
    public Date getDateFin() {
        return dateFin;
    }
    
    public List<Module> getModules() {
        return modules;
    }
    
    public List<Inscription> getInscriptions() {
        return inscriptions;
    }
    
    public List<Bulletin> getBulletins() {
        return bulletins;
    }
    
    // Setters
    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }
    
    public void setAnneeUniversitaire(String anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }
    
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    
    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
    
    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
    
    public void setBulletins(List<Bulletin> bulletins) {
        this.bulletins = bulletins;
    }
}

