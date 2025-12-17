package com.academy.dao;

import java.util.List;

import com.academy.models.Planning;

public interface PlanningDAO {
    // Méthodes CRUD de base
    void save(Planning planning);
    Planning findById(int idPlanning);
    List<Planning> findAll();
    void update(Planning planning);
    void delete(int idPlanning);
    
    // Méthodes de recherche spécifiques
    List<Planning> findByModule(int idModule);
    List<Planning> findBySalle(int idSalle);
    List<Planning> findByEnseignant(int idEnseignant);
    List<Planning> findByJour(String jour);
    List<Planning> findByModuleAndJour(int idModule, String jour);
}

