package com.academy.models;

public class PrerequisFiliere {
    // Attributs
    private int idPrerequis;
    private int idFiliere;
    private String description;
    private TypePrerequis typePrerequis;
    private String niveauMinimal;
    
    // Relations
    private Filiere filiere;
    
    // Enum pour le type de prérequis
    public enum TypePrerequis {
        Academique, Competence, Diplomatique
    }
    
    // Constructeurs
    public PrerequisFiliere() {
    }
    
    public PrerequisFiliere(int idPrerequis, int idFiliere, String description, 
                           TypePrerequis typePrerequis, String niveauMinimal) {
        this.idPrerequis = idPrerequis;
        this.idFiliere = idFiliere;
        this.description = description;
        this.typePrerequis = typePrerequis;
        this.niveauMinimal = niveauMinimal;
    }
    
    // Getters
    public int getIdPrerequis() {
        return idPrerequis;
    }
    
    public int getIdFiliere() {
        return idFiliere;
    }
    
    public String getDescription() {
        return description;
    }
    
    public TypePrerequis getTypePrerequis() {
        return typePrerequis;
    }
    
    public String getNiveauMinimal() {
        return niveauMinimal;
    }
    
    public Filiere getFiliere() {
        return filiere;
    }
    
    // Setters
    public void setIdPrerequis(int idPrerequis) {
        this.idPrerequis = idPrerequis;
    }
    
    public void setIdFiliere(int idFiliere) {
        this.idFiliere = idFiliere;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setTypePrerequis(TypePrerequis typePrerequis) {
        this.typePrerequis = typePrerequis;
    }
    
    public void setNiveauMinimal(String niveauMinimal) {
        this.niveauMinimal = niveauMinimal;
    }
    
    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
    
}

