package com.academy.models;

import java.util.ArrayList;
import java.util.List;

public class Salle {
    // Attributs
    private int idSalle;
    private String nom;
    private int capacite;
    private TypeSalle typeSalle;
    private String bloc;
    private boolean disponibilite;
    
    // Relations
    private List<Seance> seances;
    private List<Examen> examens;
    
    // Enum pour le type de salle
    public enum TypeSalle {
        Cours, TD, TP
    }
    
    // Constructeurs
    public Salle() {
        this.seances = new ArrayList<>();
        this.examens = new ArrayList<>();
    }
    
    public Salle(int idSalle, String nom, int capacite, TypeSalle typeSalle, 
                String bloc, boolean disponibilite) {
        this();
        this.idSalle = idSalle;
        this.nom = nom;
        this.capacite = capacite;
        this.typeSalle = typeSalle;
        this.bloc = bloc;
        this.disponibilite = disponibilite;
    }
    
    // Getters
    public int getIdSalle() {
        return idSalle;
    }
    
    public String getNom() {
        return nom;
    }
    
    public int getCapacite() {
        return capacite;
    }
    
    public TypeSalle getTypeSalle() {
        return typeSalle;
    }
    
    public String getBloc() {
        return bloc;
    }
    
    public boolean isDisponibilite() {
        return disponibilite;
    }
    
    public List<Seance> getSeances() {
        return seances;
    }
    
    public List<Examen> getExamens() {
        return examens;
    }
    
    // Setters
    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    
    public void setTypeSalle(TypeSalle typeSalle) {
        this.typeSalle = typeSalle;
    }
    
    public void setBloc(String bloc) {
        this.bloc = bloc;
    }
    
    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }
    
    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }
    
    public void setExamens(List<Examen> examens) {
        this.examens = examens;
    }
    
}

