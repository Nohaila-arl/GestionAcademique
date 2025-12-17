package com.academy.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Filiere {
    // Attributs
    private int idFiliere;
    private int idDepartement;
    private String code;
    private String nom;
    private String niveau;
    private int capacite;
    private Date dateCreation;
    private String statut;
    
    // Relations
    private Departement departement;
    private List<Etudiant> etudiants;
    private List<Programme> programmes;
    private List<Module> modules;
    
    // Constructeurs
    public Filiere() {
        this.etudiants = new ArrayList<>();
        this.programmes = new ArrayList<>();
        this.modules = new ArrayList<>();
    }
    
    public Filiere(int idFiliere, int idDepartement, String code, String nom, 
                   String niveau, int capacite, Date dateCreation, String statut) {
        this();
        this.idFiliere = idFiliere;
        this.idDepartement = idDepartement;
        this.code = code;
        this.nom = nom;
        this.niveau = niveau;
        this.capacite = capacite;
        this.dateCreation = dateCreation;
        this.statut = statut;
    }
    
    // Getters
    public int getIdFiliere() {
        return idFiliere;
    }
    
    public int getIdDepartement() {
        return idDepartement;
    }
    
    public String getCode() {
        return code;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getNiveau() {
        return niveau;
    }
    
    public int getCapacite() {
        return capacite;
    }
    
    public Date getDateCreation() {
        return dateCreation;
    }
    
    public String getStatut() {
        return statut;
    }
    
    public Departement getDepartement() {
        return departement;
    }
    
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }
    
    public List<Programme> getProgrammes() {
        return programmes;
    }
    
    public List<Module> getModules() {
        return modules;
    }
    
    // Setters
    public void setIdFiliere(int idFiliere) {
        this.idFiliere = idFiliere;
    }
    
    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    public void setStatut(String statut) {
        this.statut = statut;
    }
    
    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
    
    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
    
    public void setProgrammes(List<Programme> programmes) {
        this.programmes = programmes;
    }
    
    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
    
}

