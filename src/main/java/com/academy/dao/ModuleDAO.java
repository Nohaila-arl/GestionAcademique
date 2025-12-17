package com.academy.dao;

import java.util.List;

import com.academy.models.Module;

public interface ModuleDAO {
    // Méthodes CRUD de base
    void save(Module module);
    Module findById(int idModule);
    List<Module> findAll();
    void update(Module module);
    void delete(int idModule);
    
    // Méthodes de recherche spécifiques
    Module findByCode(String code);
    List<Module> findByFiliere(int idFiliere);
    List<Module> findByEnseignant(int idEnseignant);
    List<Module> findBySemestre(int idSemestre);
    List<Module> findByIntitule(String intitule);
}

