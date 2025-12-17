package com.academy.models;

import java.sql.Date;

public class Rapport {
    // Attributs
    private int idRapport;
    private String titre;
    private String typeRapport;
    private Date dateGeneration;
    private String auteur;
    private String contenu;
    
    // Relations optionnelles
    private Departement departement;
    private Responsable responsable;
    
    // Constructeurs
    public Rapport() {
    }
    
    public Rapport(int idRapport, String titre, String typeRapport, 
                  Date dateGeneration, String auteur, String contenu) {
        this.idRapport = idRapport;
        this.titre = titre;
        this.typeRapport = typeRapport;
        this.dateGeneration = dateGeneration;
        this.auteur = auteur;
        this.contenu = contenu;
    }
    
    // Getters
    public int getIdRapport() {
        return idRapport;
    }
    
    public String getTitre() {
        return titre;
    }
    
    public String getTypeRapport() {
        return typeRapport;
    }
    
    public Date getDateGeneration() {
        return dateGeneration;
    }
    
    public String getAuteur() {
        return auteur;
    }
    
    public String getContenu() {
        return contenu;
    }
    
    public Departement getDepartement() {
        return departement;
    }
    
    public Responsable getResponsable() {
        return responsable;
    }
    
    // Setters
    public void setIdRapport(int idRapport) {
        this.idRapport = idRapport;
    }
    
    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    public void setTypeRapport(String typeRapport) {
        this.typeRapport = typeRapport;
    }
    
    public void setDateGeneration(Date dateGeneration) {
        this.dateGeneration = dateGeneration;
    }
    
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    
    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
    
    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }
    
}

