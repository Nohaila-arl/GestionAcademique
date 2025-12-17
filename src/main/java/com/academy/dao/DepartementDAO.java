package com.academy.dao;

import java.util.List;

import com.academy.models.Departement;

public interface DepartementDAO {
    // Méthodes CRUD de base
    void save(Departement departement);
    Departement findById(int idDepartement);
    List<Departement> findAll();
    void update(Departement departement);
    void delete(int idDepartement);
    
    // Méthodes de recherche spécifiques
    Departement findByCode(String code);
    List<Departement> findByResponsable(int idResponsable);
    List<Departement> findByNom(String nom);
}

