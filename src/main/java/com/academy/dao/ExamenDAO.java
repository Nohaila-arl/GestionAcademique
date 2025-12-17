package com.academy.dao;

import java.sql.Date;
import java.util.List;

import com.academy.models.Examen;

public interface ExamenDAO {
    // Méthodes CRUD de base
    void save(Examen examen);
    Examen findById(int idExamen);
    List<Examen> findAll();
    void update(Examen examen);
    void delete(int idExamen);
    
    // Méthodes de recherche spécifiques
    List<Examen> findByModule(int idModule);
    List<Examen> findByType(Examen.TypeExamen typeExamen);
    List<Examen> findByDate(Date dateExamen);
    List<Examen> findBySalle(String salle);
    List<Examen> findByModuleAndDate(int idModule, Date dateExamen);
}

