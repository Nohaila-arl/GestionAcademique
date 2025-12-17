package com.academy.dao;

import java.util.List;

import com.academy.models.Inscription;

public interface InscriptionDAO {
    // Méthodes CRUD de base
    void save(Inscription inscription);
    Inscription findById(int idInscription);
    List<Inscription> findAll();
    void update(Inscription inscription);
    void delete(int idInscription);
    
    // Méthodes de recherche spécifiques
    List<Inscription> findByEtudiant(int idEtudiant);
    List<Inscription> findByModule(int idModule);
    List<Inscription> findBySemestre(int idSemestre);
    Inscription findByEtudiantAndModule(int idEtudiant, int idModule);
    List<Inscription> findByStatut(String statut);
}

