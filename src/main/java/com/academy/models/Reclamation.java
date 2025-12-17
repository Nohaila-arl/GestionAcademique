package com.academy.models;

import java.sql.Date;

public class Reclamation {
    // Attributs
    private int idReclamation;
    private int idEtudiant;
    private int idModule;
    private String typeReclamation;
    private String description;
    private Date dateEnvoi;
    private StatutReclamation statut;
    
    // Relations
    private Etudiant etudiant;
    private Module module;
    
    // Enum pour le statut de réclamation
    public enum StatutReclamation {
        EnAttente, Traité, Rejeté
    }
    
    // Constructeurs
    public Reclamation() {
    }
    
    public Reclamation(int idReclamation, int idEtudiant, int idModule, 
                      String typeReclamation, String description, 
                      Date dateEnvoi, StatutReclamation statut) {
        this.idReclamation = idReclamation;
        this.idEtudiant = idEtudiant;
        this.idModule = idModule;
        this.typeReclamation = typeReclamation;
        this.description = description;
        this.dateEnvoi = dateEnvoi;
        this.statut = statut;
    }
    
    // Getters
    public int getIdReclamation() {
        return idReclamation;
    }
    
    public int getIdEtudiant() {
        return idEtudiant;
    }
    
    public int getIdModule() {
        return idModule;
    }
    
    public String getTypeReclamation() {
        return typeReclamation;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Date getDateEnvoi() {
        return dateEnvoi;
    }
    
    public StatutReclamation getStatut() {
        return statut;
    }
    
    public Etudiant getEtudiant() {
        return etudiant;
    }
    
    public Module getModule() {
        return module;
    }
    
    // Setters
    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }
    
    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }
    
    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }
    
    public void setTypeReclamation(String typeReclamation) {
        this.typeReclamation = typeReclamation;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }
    
    public void setStatut(StatutReclamation statut) {
        this.statut = statut;
    }
    
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    
    public void setModule(Module module) {
        this.module = module;
    }
    
}

