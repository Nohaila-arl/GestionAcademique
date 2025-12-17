package com.academy.models;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Enseignant {
    // Attributs
    private int idEnseignant;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String grade;
    private String specialite;
    private Date dateRecrutement;
    private StatutEnseignant statut;
    private Integer idDepartement; // Optionnel
    
    // Relations
    private Departement departement;
    private List<Module> modules;
    private List<Seance> seances;
    private List<Document> documents;
    private List<Examen> examens;
    private List<Planning> plannings;
    
    // Enum pour le statut
    public enum StatutEnseignant {
        Permanent, Vacataire
    }
    
    // Constructeurs
    public Enseignant() {
        this.modules = new ArrayList<>();
        this.seances = new ArrayList<>();
        this.documents = new ArrayList<>();
        this.examens = new ArrayList<>();
        this.plannings = new ArrayList<>();
    }
    
    public Enseignant(int idEnseignant, String nom, String prenom, String email, 
                     String telephone, String grade, String specialite, 
                     Date dateRecrutement, StatutEnseignant statut) {
        this();
        this.idEnseignant = idEnseignant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.grade = grade;
        this.specialite = specialite;
        this.dateRecrutement = dateRecrutement;
        this.statut = statut;
    }
    
    // Getters
    public int getIdEnseignant() {
        return idEnseignant;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    public String getGrade() {
        return grade;
    }
    
    public String getSpecialite() {
        return specialite;
    }
    
    public Date getDateRecrutement() {
        return dateRecrutement;
    }
    
    public StatutEnseignant getStatut() {
        return statut;
    }
    
    public Integer getIdDepartement() {
        return idDepartement;
    }
    
    public Departement getDepartement() {
        return departement;
    }
    
    public List<Module> getModules() {
        return modules;
    }
    
    public List<Seance> getSeances() {
        return seances;
    }
    
    public List<Document> getDocuments() {
        return documents;
    }
    
    public List<Examen> getExamens() {
        return examens;
    }
    
    public List<Planning> getPlannings() {
        return plannings;
    }
    
    // Setters
    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    
    public void setDateRecrutement(Date dateRecrutement) {
        this.dateRecrutement = dateRecrutement;
    }
    
    public void setStatut(StatutEnseignant statut) {
        this.statut = statut;
    }
    
    public void setIdDepartement(Integer idDepartement) {
        this.idDepartement = idDepartement;
    }
    
    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
    
    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
    
    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }
    
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
    
    public void setExamens(List<Examen> examens) {
        this.examens = examens;
    }
    
    public void setPlannings(List<Planning> plannings) {
        this.plannings = plannings;
    }
    
}

