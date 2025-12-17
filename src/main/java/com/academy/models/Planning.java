package com.academy.models;

import java.sql.Time;

public class Planning {
    // Attributs
    private int idPlanning;
    private int idModule;
    private int idSalle;
    private int idEnseignant;
    private String jour;
    private Time heureDebut;
    private Time heureFin;
    private TypeSeance typeSeance;
    
    // Relations
    private Module module;
    private Salle salle;
    private Enseignant enseignant;
    
    // Enum pour le type de séance
    public enum TypeSeance {
        CM, TD, TP
    }
    
    // Constructeurs
    public Planning() {
    }
    
    public Planning(int idPlanning, int idModule, int idSalle, int idEnseignant, 
                   String jour, Time heureDebut, Time heureFin, TypeSeance typeSeance) {
        this.idPlanning = idPlanning;
        this.idModule = idModule;
        this.idSalle = idSalle;
        this.idEnseignant = idEnseignant;
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.typeSeance = typeSeance;
    }
    
    // Getters
    public int getIdPlanning() {
        return idPlanning;
    }
    
    public int getIdModule() {
        return idModule;
    }
    
    public int getIdSalle() {
        return idSalle;
    }
    
    public int getIdEnseignant() {
        return idEnseignant;
    }
    
    public String getJour() {
        return jour;
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
    
    public Module getModule() {
        return module;
    }
    
    public Salle getSalle() {
        return salle;
    }
    
    public Enseignant getEnseignant() {
        return enseignant;
    }
    
    // Setters
    public void setIdPlanning(int idPlanning) {
        this.idPlanning = idPlanning;
    }
    
    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }
    
    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }
    
    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }
    
    public void setJour(String jour) {
        this.jour = jour;
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
    
    public void setModule(Module module) {
        this.module = module;
    }
    
    public void setSalle(Salle salle) {
        this.salle = salle;
    }
    
    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }
    
}

