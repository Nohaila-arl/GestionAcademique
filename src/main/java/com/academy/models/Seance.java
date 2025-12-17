package com.academy.models;

import java.sql.Date;
import java.sql.Time;

public class Seance {
    // Attributs
    private int idSeance;
    private int idModule;
    private int idEnseignant;
    private int idSalle;
    private Date dateSeance;
    private Time heureDebut;
    private Time heureFin;
    private TypeSeance typeSeance;
    private String statut;
    
    // Relations
    private Module module;
    private Enseignant enseignant;
    private Salle salle;
    
    // Enum pour le type de séance
    public enum TypeSeance {
        CM, TD, TP
    }
    
    // Constructeurs
    public Seance() {
    }
    
    public Seance(int idSeance, int idModule, int idEnseignant, int idSalle, 
                  Date dateSeance, Time heureDebut, Time heureFin, 
                  TypeSeance typeSeance, String statut) {
        this.idSeance = idSeance;
        this.idModule = idModule;
        this.idEnseignant = idEnseignant;
        this.idSalle = idSalle;
        this.dateSeance = dateSeance;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.typeSeance = typeSeance;
        this.statut = statut;
    }
    
    // Getters
    public int getIdSeance() {
        return idSeance;
    }
    
    public int getIdModule() {
        return idModule;
    }
    
    public int getIdEnseignant() {
        return idEnseignant;
    }
    
    public int getIdSalle() {
        return idSalle;
    }
    
    public Date getDateSeance() {
        return dateSeance;
    }
    
    public Time getHeureDebut() {
        return heureDebut;
    }
    
    public Time getHeureFin() {
        return heureFin;
    }
    
    public TypeSeance getTypeSeance() {
        return typeSeance;
    }
    
    public String getStatut() {
        return statut;
    }
    
    public Module getModule() {
        return module;
    }
    
    public Enseignant getEnseignant() {
        return enseignant;
    }
    
    public Salle getSalle() {
        return salle;
    }
    
    // Setters
    public void setIdSeance(int idSeance) {
        this.idSeance = idSeance;
    }
    
    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }
    
    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }
    
    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }
    
    public void setDateSeance(Date dateSeance) {
        this.dateSeance = dateSeance;
    }
    
    public void setHeureDebut(Time heureDebut) {
        this.heureDebut = heureDebut;
    }
    
    public void setHeureFin(Time heureFin) {
        this.heureFin = heureFin;
    }
    
    public void setTypeSeance(TypeSeance typeSeance) {
        this.typeSeance = typeSeance;
    }
    
    public void setStatut(String statut) {
        this.statut = statut;
    }
    
    public void setModule(Module module) {
        this.module = module;
    }
    
    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }
    
    public void setSalle(Salle salle) {
        this.salle = salle;
    }
    
}

