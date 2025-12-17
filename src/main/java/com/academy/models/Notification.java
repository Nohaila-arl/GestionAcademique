package com.academy.models;

import java.sql.Date;

public class Notification {
    // Attributs
    private int idNotification;
    private int idEtudiant;
    private String titre;
    private String message;
    private Date dateEnvoi;
    private StatutNotification statut;
    
    // Relations
    private Etudiant etudiant;
    
    // Enum pour le statut de notification
    public enum StatutNotification {
        Lu, NonLu
    }
    
    // Constructeurs
    public Notification() {
    }
    
    public Notification(int idNotification, int idEtudiant, String titre, 
                       String message, Date dateEnvoi, StatutNotification statut) {
        this.idNotification = idNotification;
        this.idEtudiant = idEtudiant;
        this.titre = titre;
        this.message = message;
        this.dateEnvoi = dateEnvoi;
        this.statut = statut;
    }
    
    // Getters
    public int getIdNotification() {
        return idNotification;
    }
    
    public int getIdEtudiant() {
        return idEtudiant;
    }
    
    public String getTitre() {
        return titre;
    }
    
    public String getMessage() {
        return message;
    }
    
    public Date getDateEnvoi() {
        return dateEnvoi;
    }
    
    public StatutNotification getStatut() {
        return statut;
    }
    
    public Etudiant getEtudiant() {
        return etudiant;
    }
    
    // Setters
    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }
    
    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }
    
    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }
    
    public void setStatut(StatutNotification statut) {
        this.statut = statut;
    }
    
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    
}

