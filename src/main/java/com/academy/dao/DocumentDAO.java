package com.academy.dao;

import java.util.List;

import com.academy.models.Document;

public interface DocumentDAO {
    // Méthodes CRUD de base
    void save(Document document);
    Document findById(int idDocument);
    List<Document> findAll();
    void update(Document document);
    void delete(int idDocument);
    
    // Méthodes de recherche spécifiques
    List<Document> findByModule(int idModule);
    List<Document> findByEnseignant(int idEnseignant);
    List<Document> findByType(String typeDocument);
    List<Document> findByTitre(String titre);
}

