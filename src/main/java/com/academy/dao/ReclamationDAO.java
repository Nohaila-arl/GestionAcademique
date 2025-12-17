package com.academy.dao;

import java.util.List;

import com.academy.models.Reclamation;

public interface ReclamationDAO {
    // Méthodes CRUD de base
    void save(Reclamation reclamation);
    Reclamation findById(int idReclamation);
    List<Reclamation> findAll();
    void update(Reclamation reclamation);
    void delete(int idReclamation);
    
    // Méthodes de recherche spécifiques
    List<Reclamation> findByEtudiant(int idEtudiant);
    List<Reclamation> findByModule(int idModule);
    List<Reclamation> findByStatut(Reclamation.StatutReclamation statut);
    List<Reclamation> findByType(String typeReclamation);
    List<Reclamation> findByEtudiantAndStatut(int idEtudiant, Reclamation.StatutReclamation statut);
}

