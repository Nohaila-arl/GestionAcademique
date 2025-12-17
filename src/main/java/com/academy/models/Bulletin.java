package com.academy.models;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Bulletin {
    // Attributs
    private int idBulletin;
    private int idEtudiant;
    private int idSemestre;
    private Date dateGeneration;
    private double moyenneGenerale;
    private Decision decision;
    private String mention;
    
    // Relations
    private Etudiant etudiant;
    private Semestre semestre;
    private List<Note> notes;
    
    // Enum pour la décision
    public enum Decision {
        Valide, NonValide, Rattrapage
    }
    
    // Constructeurs
    public Bulletin() {
        this.notes = new ArrayList<>();
    }
    
    public Bulletin(int idBulletin, int idEtudiant, int idSemestre, 
                   Date dateGeneration, double moyenneGenerale, 
                   Decision decision, String mention) {
        this();
        this.idBulletin = idBulletin;
        this.idEtudiant = idEtudiant;
        this.idSemestre = idSemestre;
        this.dateGeneration = dateGeneration;
        this.moyenneGenerale = moyenneGenerale;
        this.decision = decision;
        this.mention = mention;
    }
    
    // Getters
    public int getIdBulletin() {
        return idBulletin;
    }
    
    public int getIdEtudiant() {
        return idEtudiant;
    }
    
    public int getIdSemestre() {
        return idSemestre;
    }
    
    public Date getDateGeneration() {
        return dateGeneration;
    }
    
    public double getMoyenneGenerale() {
        return moyenneGenerale;
    }
    
    public Decision getDecision() {
        return decision;
    }
    
    public String getMention() {
        return mention;
    }
    
    public Etudiant getEtudiant() {
        return etudiant;
    }
    
    public Semestre getSemestre() {
        return semestre;
    }
    
    public List<Note> getNotes() {
        return notes;
    }
    
    // Setters
    public void setIdBulletin(int idBulletin) {
        this.idBulletin = idBulletin;
    }
    
    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }
    
    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }
    
    public void setDateGeneration(Date dateGeneration) {
        this.dateGeneration = dateGeneration;
    }
    
    public void setMoyenneGenerale(double moyenneGenerale) {
        this.moyenneGenerale = moyenneGenerale;
    }
    
    public void setDecision(Decision decision) {
        this.decision = decision;
    }
    
    public void setMention(String mention) {
        this.mention = mention;
    }
    
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    
    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }
    
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
    
}

