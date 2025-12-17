package com.academy.dao;

import java.util.List;

import com.academy.models.Responsable;

public interface ResponsableDAO {
    // Méthodes CRUD de base
    void save(Responsable responsable);
    Responsable findById(int idResponsable);
    List<Responsable> findAll();
    void update(Responsable responsable);
    void delete(int idResponsable);
    
    // Méthodes de recherche spécifiques
    Responsable findByEmail(String email);
    List<Responsable> findByNom(String nom);
    List<Responsable> findByFonction(String fonction);
}

