package com.academy.models;

import java.util.ArrayList;
import java.util.List;

public class Module {
    // Attributs
    private int idModule;
    private int idEnseignant;
    private int idFiliere;
    private int idSemestre;
    private String code;
    private String intitule;
    private String description;
    private int heureCM;
    private int heureTD;
    private int heureTP;
    private int credits;
    
    // Relations
    private Enseignant enseignant;
    private Filiere filiere;
    private Semestre semestre;
    private List<Seance> seances;
    private List<Note> notes;
    private List<Examen> examens;
    private List<Planning> plannings;
    private List<Document> documents;
    
    // Constructeurs
    public Module() {
        this.seances = new ArrayList<>();
        this.notes = new ArrayList<>();
        this.examens = new ArrayList<>();
        this.plannings = new ArrayList<>();
        this.documents = new ArrayList<>();
    }
    
    public Module(int idModule, int idEnseignant, int idFiliere, int idSemestre, 
                  String code, String intitule, String description, int heureCM, 
                  int heureTD, int heureTP, int credits) {
        this();
        this.idModule = idModule;
        this.idEnseignant = idEnseignant;
        this.idFiliere = idFiliere;
        this.idSemestre = idSemestre;
        this.code = code;
        this.intitule = intitule;
        this.description = description;
        this.heureCM = heureCM;
        this.heureTD = heureTD;
        this.heureTP = heureTP;
        this.credits = credits;
    }
    
    // Getters
    public int getIdModule() {
        return idModule;
    }
    
    public int getIdEnseignant() {
        return idEnseignant;
    }
    
    public int getIdFiliere() {
        return idFiliere;
    }
    
    public int getIdSemestre() {
        return idSemestre;
    }
    
    public String getCode() {
        return code;
    }
    
    public String getIntitule() {
        return intitule;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getHeureCM() {
        return heureCM;
    }
    
    public int getHeureTD() {
        return heureTD;
    }
    
    public int getHeureTP() {
        return heureTP;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public Enseignant getEnseignant() {
        return enseignant;
    }
    
    public Filiere getFiliere() {
        return filiere;
    }
    
    public Semestre getSemestre() {
        return semestre;
    }
    
    public List<Seance> getSeances() {
        return seances;
    }
    
    public List<Note> getNotes() {
        return notes;
    }
    
    public List<Examen> getExamens() {
        return examens;
    }
    
    public List<Planning> getPlannings() {
        return plannings;
    }
    
    public List<Document> getDocuments() {
        return documents;
    }
    
    // Setters
    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }
    
    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }
    
    public void setIdFiliere(int idFiliere) {
        this.idFiliere = idFiliere;
    }
    
    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setHeureCM(int heureCM) {
        this.heureCM = heureCM;
    }
    
    public void setHeureTD(int heureTD) {
        this.heureTD = heureTD;
    }
    
    public void setHeureTP(int heureTP) {
        this.heureTP = heureTP;
    }
    
    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }
    
    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
    
    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }
    
    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }
    
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
    
    public void setExamens(List<Examen> examens) {
        this.examens = examens;
    }
    
    public void setPlannings(List<Planning> plannings) {
        this.plannings = plannings;
    }
    
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
    
}

