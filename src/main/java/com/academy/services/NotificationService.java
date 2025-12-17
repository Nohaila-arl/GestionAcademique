package com.academy.services;

import java.sql.Date;
import java.util.List;

import com.academy.dao.EtudiantDAO;
import com.academy.dao.FiliereDAO;
import com.academy.dao.InscriptionDAO;
import com.academy.dao.NotificationDAO;
import com.academy.models.Etudiant;
import com.academy.models.Filiere;
import com.academy.models.Notification;

public class NotificationService {
    private NotificationDAO notificationDAO;
    private EtudiantDAO etudiantDAO;
    private FiliereDAO filiereDAO;
    private InscriptionDAO inscriptionDAO;

    public NotificationService() {
        // Les DAO seront injectés via constructeur ou setters dans une implémentation réelle
    }

    public void envoyerNotification(int idNotification) {
        Notification notification = notificationDAO.findById(idNotification);
        if (notification != null) {
            // Marquer la notification comme envoyée
            notification.setDateEnvoi(new Date(System.currentTimeMillis()));
            notificationDAO.update(notification);
        }
    }

    public void envoyerNotificationGroupe(List<Integer> idsEtudiants) {
        if (idsEtudiants == null) {
            return;
        }
        
        for (Integer idEtudiant : idsEtudiants) {
            List<Notification> notifications = notificationDAO.findByEtudiant(idEtudiant);
            if (notifications != null) {
                for (Notification notification : notifications) {
                    if (notification.getStatut() == Notification.StatutNotification.NonLu) {
                        envoyerNotification(notification.getIdNotification());
                    }
                }
            }
        }
    }

    public void envoyerNotificationFiliere(int idFiliere) {
        Filiere filiere = filiereDAO.findById(idFiliere);
        if (filiere == null) {
            return;
        }
        
        List<Etudiant> etudiants = etudiantDAO.findByFiliere(idFiliere);
        if (etudiants != null) {
            for (Etudiant etudiant : etudiants) {
                List<Notification> notifications = notificationDAO.findByEtudiant(etudiant.getIdEtudiant());
                if (notifications != null) {
                    for (Notification notification : notifications) {
                        if (notification.getStatut() == Notification.StatutNotification.NonLu) {
                            envoyerNotification(notification.getIdNotification());
                        }
                    }
                }
            }
        }
    }

    public boolean estLu(int idNotification) {
        Notification notification = notificationDAO.findById(idNotification);
        return notification != null && notification.getStatut() == Notification.StatutNotification.Lu;
    }

    public String getApercu(int idNotification) {
        Notification notification = notificationDAO.findById(idNotification);
        if (notification != null) {
            return notification.getTitre() + ": " + notification.getMessage();
        }
        return null;
    }
}
