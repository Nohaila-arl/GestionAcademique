package com.academy.dao;

import java.util.List;

import com.academy.models.Bulletin;

public interface BulletinDAO {
    // Méthodes CRUD de base
    void save(Bulletin bulletin);
    Bulletin findById(int idBulletin);
    List<Bulletin> findAll();
    void update(Bulletin bulletin);
    void delete(int idBulletin);
    
    // Méthodes de recherche spécifiques
    List<Bulletin> findByEtudiant(int idEtudiant);
    List<Bulletin> findBySemestre(int idSemestre);
    Bulletin findByEtudiantAndSemestre(int idEtudiant, int idSemestre);
    List<Bulletin> findByDecision(Bulletin.Decision decision);
    List<Bulletin> findByMoyenneSuperieure(double moyenne);
}

