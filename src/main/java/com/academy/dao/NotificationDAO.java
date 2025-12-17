package com.academy.dao;

import java.util.List;

import com.academy.models.Notification;

public interface NotificationDAO {
    // Méthodes CRUD de base
    void save(Notification notification);
    Notification findById(int idNotification);
    List<Notification> findAll();
    void update(Notification notification);
    void delete(int idNotification);
    
    // Méthodes de recherche spécifiques
    List<Notification> findByEtudiant(int idEtudiant);
    List<Notification> findByStatut(Notification.StatutNotification statut);
    List<Notification> findByEtudiantAndStatut(int idEtudiant, Notification.StatutNotification statut);
}

