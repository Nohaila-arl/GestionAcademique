package com.academy.dao;

import java.util.List;

import com.academy.models.Programme;

public interface ProgrammeDAO {
    // Méthodes CRUD de base
    void save(Programme programme);
    Programme findById(int idProgramme);
    List<Programme> findAll();
    void update(Programme programme);
    void delete(int idProgramme);
    
    // Méthodes de recherche spécifiques
    List<Programme> findByFiliere(int idFiliere);
    List<Programme> findByAnnee(String annee);
    List<Programme> findByIntitule(String intitule);
}

