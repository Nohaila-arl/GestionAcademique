package com.academy.dao;

import java.util.List;

import com.academy.models.PrerequisFiliere;

public interface PrerequisFiliereDAO {
    // Méthodes CRUD de base
    void save(PrerequisFiliere prerequisFiliere);
    PrerequisFiliere findById(int idPrerequis);
    List<PrerequisFiliere> findAll();
    void update(PrerequisFiliere prerequisFiliere);
    void delete(int idPrerequis);
    
    // Méthodes de recherche spécifiques
    List<PrerequisFiliere> findByFiliere(int idFiliere);
    List<PrerequisFiliere> findByType(PrerequisFiliere.TypePrerequis typePrerequis);
    List<PrerequisFiliere> findByNiveauMinimal(String niveauMinimal);
}

