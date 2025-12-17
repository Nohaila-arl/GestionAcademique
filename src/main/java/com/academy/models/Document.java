package com.academy.models;


import java.sql.Date;

public class Document {
    // Attributs
    private int idDocument;
    private int idModule;
    private int idEnseignant;
    private String titre;
    private String typeDocument;
    private String fichier;
    private Date dateDepot;
    
    // Relations
    private Module module;
    private Enseignant enseignant;
    
    // Constructeurs
    public Document() {
    }
    
    public Document(int idDocument, int idModule, int idEnseignant, String titre, 
                   String typeDocument, String fichier, Date dateDepot) {
        this.idDocument = idDocument;
        this.idModule = idModule;
        this.idEnseignant = idEnseignant;
        this.titre = titre;
        this.typeDocument = typeDocument;
        this.fichier = fichier;
        this.dateDepot = dateDepot;
    }
    
    // Getters
    public int getIdDocument() {
        return idDocument;
    }
    
    public int getIdModule() {
        return idModule;
    }
    
    public int getIdEnseignant() {
        return idEnseignant;
    }
    
    public String getTitre() {
        return titre;
    }
    
    public String getTypeDocument() {
        return typeDocument;
    }
    
    public String getFichier() {
        return fichier;
    }
    
    public Date getDateDepot() {
        return dateDepot;
    }
    
    public Module getModule() {
        return module;
    }
    
    public Enseignant getEnseignant() {
        return enseignant;
    }
    
    // Setters
    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }
    
    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }
    
    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }
    
    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }
    
    public void setFichier(String fichier) {
        this.fichier = fichier;
    }
    
    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }
    
    public void setModule(Module module) {
        this.module = module;
    }
    
    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }
    
}

