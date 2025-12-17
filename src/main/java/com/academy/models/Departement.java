package com.academy.models;


import java.util.ArrayList;
import java.util.List;

public class Departement {
    // Attributs
    private int idDepartement;
    private int idResponsable;
    private String nom;
    private String code;
    private String description;
    private String email;
    
    // Relations
    private Responsable responsable;
    private List<Filiere> filieres;
    
    // Constructeurs
    public Departement() {
        this.filieres = new ArrayList<>();
    }
    
    public Departement(int idDepartement, int idResponsable, String nom, String code, 
                      String description, String email) {
        this();
        this.idDepartement = idDepartement;
        this.idResponsable = idResponsable;
        this.nom = nom;
        this.code = code;
        this.description = description;
        this.email = email;
    }
    
    // Getters
    public int getIdDepartement() {
        return idDepartement;
    }
    
    public int getIdResponsable() {
        return idResponsable;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getCode() {
        return code;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getEmail() {
        return email;
    }
    
    public Responsable getResponsable() {
        return responsable;
    }
    
    public List<Filiere> getFilieres() {
        return filieres;
    }
    
    // Setters
    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }
    
    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }
    
    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }
    
}

