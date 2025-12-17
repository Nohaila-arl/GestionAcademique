package com.academy.dao;

import java.util.List;

import com.academy.models.Rapport;

public interface RapportDAO {
    // Méthodes CRUD de base
    void save(Rapport rapport);
    Rapport findById(int idRapport);
    List<Rapport> findAll();
    void update(Rapport rapport);
    void delete(int idRapport);
    
    // Méthodes de recherche spécifiques
    List<Rapport> findByType(String typeRapport);
    List<Rapport> findByAuteur(String auteur);
    List<Rapport> findByTitre(String titre);
}

