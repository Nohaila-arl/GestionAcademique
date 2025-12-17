package com.academy.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Responsable {
    // Attributs
    private int idResponsable;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String fonction;
    private Date dateNomination;
    private String bureau;
    
    // Relations
    private Departement departement;
    private List<Filiere> filieres;
    
    // Constructeurs
    public Responsable() {
        this.filieres = new ArrayList<>();
    }
    
    public Responsable(int idResponsable, String nom, String prenom, String email, 
                      String telephone, String fonction, Date dateNomination, String bureau) {
        this();
        this.idResponsable = idResponsable;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.fonction = fonction;
        this.dateNomination = dateNomination;
        this.bureau = bureau;
    }
    
    // Getters
    public int getIdResponsable() {
        return idResponsable;
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
    
    public String getFonction() {
        return fonction;
    }
    
    public Date getDateNomination() {
        return dateNomination;
    }
    
    public String getBureau() {
        return bureau;
    }
    
    public Departement getDepartement() {
        return departement;
    }
    
    public List<Filiere> getFilieres() {
        return filieres;
    }
    
    // Setters
    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
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
    
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
    
    public void setDateNomination(Date dateNomination) {
        this.dateNomination = dateNomination;
    }
    
    public void setBureau(String bureau) {
        this.bureau = bureau;
    }
    
    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
    
    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }
    
}

