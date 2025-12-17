package com.academy.dao;

import java.util.List;

import com.academy.models.Statistiques;

public interface StatistiquesDAO {
    // Méthodes CRUD de base
    void save(Statistiques statistiques);
    Statistiques findById(int idStat);
    List<Statistiques> findAll();
    void update(Statistiques statistiques);
    void delete(int idStat);
    
    // Méthodes de recherche spécifiques
    List<Statistiques> findByType(String typeStat);
    List<Statistiques> findByPeriode(String periode);
    List<Statistiques> findByTypeAndPeriode(String typeStat, String periode);
}

