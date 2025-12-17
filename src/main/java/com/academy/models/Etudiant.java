package com.academy.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Etudiant {
    // Attributs
    private int idEtudiant;
    private int idFiliere;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String cne;
    private String cin;
    private String adresse;
    private Date dateInscription;
    private String statut;
    
    // Relations
    private Filiere filiere;
    private List<Inscription> inscriptions;
    private List<Note> notes;
    private List<Bulletin> bulletins;
    private List<Reclamation> reclamations;
    private List<Notification> notifications;
    
    // Constructeurs
    public Etudiant() {
        this.inscriptions = new ArrayList<>();
        this.notes = new ArrayList<>();
        this.bulletins = new ArrayList<>();
        this.reclamations = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }
    
    public Etudiant(int idEtudiant, int idFiliere, String nom, String prenom, 
                   String email, String telephone, String cne, String cin, 
                   String adresse, Date dateInscription, String statut) {
        this();
        this.idEtudiant = idEtudiant;
        this.idFiliere = idFiliere;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.cne = cne;
        this.cin = cin;
        this.adresse = adresse;
        this.dateInscription = dateInscription;
        this.statut = statut;
    }
    
    // Getters
    public int getIdEtudiant() {
        return idEtudiant;
    }
    
    public int getIdFiliere() {
        return idFiliere;
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
    
    public String getCne() {
        return cne;
    }
    
    public String getCin() {
        return cin;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public Date getDateInscription() {
        return dateInscription;
    }
    
    public String getStatut() {
        return statut;
    }
    
    public Filiere getFiliere() {
        return filiere;
    }
    
    public List<Inscription> getInscriptions() {
        return inscriptions;
    }
    
    public List<Note> getNotes() {
        return notes;
    }
    
    public List<Bulletin> getBulletins() {
        return bulletins;
    }
    
    public List<Reclamation> getReclamations() {
        return reclamations;
    }
    
    public List<Notification> getNotifications() {
        return notifications;
    }
    
    // Setters
    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }
    
    public void setIdFiliere(int idFiliere) {
        this.idFiliere = idFiliere;
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
    
    public void setCne(String cne) {
        this.cne = cne;
    }
    
    public void setCin(String cin) {
        this.cin = cin;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }
    
    public void setStatut(String statut) {
        this.statut = statut;
    }
    
    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
    
    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
    
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
    
    public void setBulletins(List<Bulletin> bulletins) {
        this.bulletins = bulletins;
    }
    
    public void setReclamations(List<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }
    
    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
    
}

