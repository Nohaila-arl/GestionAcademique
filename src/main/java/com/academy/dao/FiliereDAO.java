package com.academy.dao;

import java.util.List;

import com.academy.models.Filiere;

public interface FiliereDAO {
    // Méthodes CRUD de base
    void save(Filiere filiere);
    Filiere findById(int idFiliere);
    List<Filiere> findAll();
    void update(Filiere filiere);
    void delete(int idFiliere);
    
    // Méthodes de recherche spécifiques
    Filiere findByCode(String code);
    List<Filiere> findByDepartement(int idDepartement);
    List<Filiere> findByNiveau(String niveau);
    List<Filiere> findByStatut(String statut);
}

