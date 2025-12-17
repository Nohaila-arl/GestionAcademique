package com.academy.dao;

import java.util.List;

import com.academy.models.Note;

public interface NoteDAO {
    // Méthodes CRUD de base
    void save(Note note);
    Note findById(int idNote);
    List<Note> findAll();
    void update(Note note);
    void delete(int idNote);
    
    // Méthodes de recherche spécifiques
    List<Note> findByEtudiant(int idEtudiant);
    List<Note> findByModule(int idModule);
    Note findByEtudiantAndModule(int idEtudiant, int idModule);
    List<Note> findByMoyenneSuperieure(double moyenne);
}

