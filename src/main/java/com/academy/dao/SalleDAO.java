package com.academy.dao;

import java.util.List;

import com.academy.models.Salle;

public interface SalleDAO {
    // Méthodes CRUD de base
    void save(Salle salle);
    Salle findById(int idSalle);
    List<Salle> findAll();
    void update(Salle salle);
    void delete(int idSalle);
    
    // Méthodes de recherche spécifiques
    Salle findByNom(String nom);
    List<Salle> findByType(Salle.TypeSalle typeSalle);
    List<Salle> findByBloc(String bloc);
    List<Salle> findByDisponibilite(boolean disponibilite);
    List<Salle> findByCapaciteMin(int capaciteMin);
}

