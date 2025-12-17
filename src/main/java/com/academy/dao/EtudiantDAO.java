package com.academy.dao;

import java.util.List;

import com.academy.models.Etudiant;

public interface EtudiantDAO {
    // Méthodes CRUD de base
    void save(Etudiant etudiant);
    Etudiant findById(int idEtudiant);
    List<Etudiant> findAll();
    void update(Etudiant etudiant);
    void delete(int idEtudiant);
    
    // Méthodes de recherche spécifiques
    Etudiant findByCNE(String cne);
    Etudiant findByCIN(String cin);
    Etudiant findByEmail(String email);
    List<Etudiant> findByFiliere(int idFiliere);
    List<Etudiant> findByNom(String nom);
    List<Etudiant> findByStatut(String statut);
}

