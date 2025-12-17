package com.academy.dao;

import java.util.List;

import com.academy.models.Enseignant;

public interface EnseignantDAO {
    // Méthodes CRUD de base
    void save(Enseignant enseignant);
    Enseignant findById(int idEnseignant);
    List<Enseignant> findAll();
    void update(Enseignant enseignant);
    void delete(int idEnseignant);
    
    // Méthodes de recherche spécifiques
    Enseignant findByEmail(String email);
    List<Enseignant> findByNom(String nom);
    List<Enseignant> findByStatut(Enseignant.StatutEnseignant statut);
    List<Enseignant> findByGrade(String grade);
    List<Enseignant> findBySpecialite(String specialite);
    List<Enseignant> findByDepartement(int idDepartement);
}

