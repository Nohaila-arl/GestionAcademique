package com.academy.dao;

import java.sql.Date;
import java.util.List;

import com.academy.models.Seance;

public interface SeanceDAO {
    // Méthodes CRUD de base
    void save(Seance seance);
    Seance findById(int idSeance);
    List<Seance> findAll();
    void update(Seance seance);
    void delete(int idSeance);
    
    // Méthodes de recherche spécifiques
    List<Seance> findByModule(int idModule);
    List<Seance> findByEnseignant(int idEnseignant);
    List<Seance> findBySalle(int idSalle);
    List<Seance> findByDate(Date dateSeance);
    List<Seance> findByModuleAndDate(int idModule, Date dateSeance);
}

