package com.academy.models;

import java.util.ArrayList;
import java.util.List;

public class Programme {
    // Attributs
    private int idProgramme;
    private int idFiliere;
    private String intitule;
    private String annee;
    
    // Relations
    private Filiere filiere;
    private List<Module> modules;
    
    // Constructeurs
    public Programme() {
        this.modules = new ArrayList<>();
    }
    
    public Programme(int idProgramme, int idFiliere, String intitule, String annee) {
        this();
        this.idProgramme = idProgramme;
        this.idFiliere = idFiliere;
        this.intitule = intitule;
        this.annee = annee;
    }
    
    // Getters
    public int getIdProgramme() {
        return idProgramme;
    }
    
    public int getIdFiliere() {
        return idFiliere;
    }
    
    public String getIntitule() {
        return intitule;
    }
    
    public String getAnnee() {
        return annee;
    }
    
    public Filiere getFiliere() {
        return filiere;
    }
    
    public List<Module> getModules() {
        return modules;
    }
    
    // Setters
    public void setIdProgramme(int idProgramme) {
        this.idProgramme = idProgramme;
    }
    
    public void setIdFiliere(int idFiliere) {
        this.idFiliere = idFiliere;
    }
    
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
    
    public void setAnnee(String annee) {
        this.annee = annee;
    }
    
    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
    
    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
    
}

