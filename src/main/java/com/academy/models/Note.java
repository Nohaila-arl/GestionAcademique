package com.academy.models;

public class Note {
    // Attributs
    private int idNote;
    private int idEtudiant;
    private int idModule;
    private double noteCC;
    private double noteExam;
    private double moyenneFinale;
    
    // Relations
    private Etudiant etudiant;
    private Module module;
    private Examen examen;
    
    // Constructeurs
    public Note() {
    }
    
    public Note(int idNote, int idEtudiant, int idModule, double noteCC, 
               double noteExam, double moyenneFinale) {
        this.idNote = idNote;
        this.idEtudiant = idEtudiant;
        this.idModule = idModule;
        this.noteCC = noteCC;
        this.noteExam = noteExam;
        this.moyenneFinale = moyenneFinale;
    }
    
    // Getters
    public int getIdNote() {
        return idNote;
    }
    
    public int getIdEtudiant() {
        return idEtudiant;
    }
    
    public int getIdModule() {
        return idModule;
    }
    
    public double getNoteCC() {
        return noteCC;
    }
    
    public double getNoteExam() {
        return noteExam;
    }
    
    public double getMoyenneFinale() {
        return moyenneFinale;
    }
    
    public Etudiant getEtudiant() {
        return etudiant;
    }
    
    public Module getModule() {
        return module;
    }
    
    public Examen getExamen() {
        return examen;
    }
    
    // Setters
    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }
    
    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }
    
    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }
    
    public void setNoteCC(double noteCC) {
        this.noteCC = noteCC;
    }
    
    public void setNoteExam(double noteExam) {
        this.noteExam = noteExam;
    }
    
    public void setMoyenneFinale(double moyenneFinale) {
        this.moyenneFinale = moyenneFinale;
    }
    
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    
    public void setModule(Module module) {
        this.module = module;
    }
    
    public void setExamen(Examen examen) {
        this.examen = examen;
    }
}

