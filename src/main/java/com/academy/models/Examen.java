package com.academy.models;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Examen {
    // Attributs
    private int idExamen;
    private int idModule;
    private TypeExamen typeExamen;
    private Date dateExamen;
    private Time heureDebut;
    private Time heureFin;
    private String salle;
    private float coefficient;
    
    // Relations
    private Module module;
    private List<Note> notes;
    
    // Enum pour le type d'examen
    public enum TypeExamen {
        CC, TP, Final
    }
    
    // Constructeurs
    public Examen() {
        this.notes = new ArrayList<>();
    }
    
    public Examen(int idExamen, int idModule, TypeExamen typeExamen, 
                 Date dateExamen, Time heureDebut, Time heureFin, 
                 String salle, float coefficient) {
        this();
        this.idExamen = idExamen;
        this.idModule = idModule;
        this.typeExamen = typeExamen;
        this.dateExamen = dateExamen;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.salle = salle;
        this.coefficient = coefficient;
    }
    
    // Getters
    public int getIdExamen() {
        return idExamen;
    }
    
    public int getIdModule() {
        return idModule;
    }
    
    public TypeExamen getTypeExamen() {
        return typeExamen;
    }
    
    public Date getDateExamen() {
        return dateExamen;
    }
    
    public Time getHeureDebut() {
        return heureDebut;
    }
    
    public Time getHeureFin() {
        return heureFin;
    }
    
    public String getSalle() {
        return salle;
    }
    
    public float getCoefficient() {
        return coefficient;
    }
    
    public Module getModule() {
        return module;
    }
    
    public List<Note> getNotes() {
        return notes;
    }
    
    // Setters
    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }
    
    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }
    
    public void setTypeExamen(TypeExamen typeExamen) {
        this.typeExamen = typeExamen;
    }
    
    public void setDateExamen(Date dateExamen) {
        this.dateExamen = dateExamen;
    }
    
    public void setHeureDebut(Time heureDebut) {
        this.heureDebut = heureDebut;
    }
    
    public void setHeureFin(Time heureFin) {
        this.heureFin = heureFin;
    }
    
    public void setSalle(String salle) {
        this.salle = salle;
    }
    
    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }
    
    public void setModule(Module module) {
        this.module = module;
    }
    
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
    
}

