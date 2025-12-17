package com.academy.dao;

import java.util.List;

import com.academy.models.Semestre;

public interface SemestreDAO {
    // Méthodes CRUD de base
    void save(Semestre semestre);
    Semestre findById(int idSemestre);
    List<Semestre> findAll();
    void update(Semestre semestre);
    void delete(int idSemestre);
    
    // Méthodes de recherche spécifiques
    List<Semestre> findByAnneeUniversitaire(String anneeUniversitaire);
    Semestre findByAnneeAndPeriode(String anneeUniversitaire, String periode);
}

