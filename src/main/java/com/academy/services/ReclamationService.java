package com.academy.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.academy.dao.NotificationDAO;
import com.academy.dao.ReclamationDAO;
import com.academy.models.Notification;
import com.academy.models.Reclamation;

public class ReclamationService {
    private ReclamationDAO reclamationDAO;
    private NotificationDAO notificationDAO;

    public ReclamationService() {
        // Les DAO seront injectés via constructeur ou setters dans une implémentation réelle
    }

    public void traiterReclamation(int idReclamation, String decision, String commentaire) {
        Reclamation reclamation = reclamationDAO.findById(idReclamation);
        if (reclamation != null) {
            if ("Acceptée".equalsIgnoreCase(decision)) {
                accepterReclamation(idReclamation);
            } else if ("Rejetée".equalsIgnoreCase(decision)) {
                rejeterReclamation(idReclamation, commentaire);
            }
            
            ajouterCommentaire(idReclamation, commentaire);
        }
    }

    public void accepterReclamation(int idReclamation) {
        Reclamation reclamation = reclamationDAO.findById(idReclamation);
        if (reclamation != null) {
            reclamation.setStatut(Reclamation.StatutReclamation.Traité);
            reclamationDAO.update(reclamation);
            notifierEtudiant(idReclamation, "Votre réclamation a été acceptée.");
        }
    }

    public void rejeterReclamation(int idReclamation, String motif) {
        Reclamation reclamation = reclamationDAO.findById(idReclamation);
        if (reclamation != null) {
            reclamation.setStatut(Reclamation.StatutReclamation.Rejeté);
            reclamationDAO.update(reclamation);
            ajouterCommentaire(idReclamation, "Motif du rejet: " + motif);
            notifierEtudiant(idReclamation, "Votre réclamation a été rejetée. Motif: " + motif);
        }
    }

    public void ajouterCommentaire(int idReclamation, String commentaire) {
        Reclamation reclamation = reclamationDAO.findById(idReclamation);
        if (reclamation != null) {
            String description = reclamation.getDescription();
            if (description == null) {
                description = "";
            }
            description += "\nCommentaire: " + commentaire;
            reclamation.setDescription(description);
            reclamationDAO.update(reclamation);
        }
    }

    public List<String> getHistorique(int idReclamation) {
        Reclamation reclamation = reclamationDAO.findById(idReclamation);
        if (reclamation == null) {
            return null;
        }
        
        List<String> historique = new ArrayList<>();
        historique.add("Date d'envoi: " + reclamation.getDateEnvoi());
        historique.add("Statut: " + reclamation.getStatut());
        historique.add("Description: " + reclamation.getDescription());
        
        return historique;
    }

    public void notifierEtudiant(int idReclamation, String message) {
        Reclamation reclamation = reclamationDAO.findById(idReclamation);
        if (reclamation != null) {
            Notification notification = new Notification();
            notification.setIdEtudiant(reclamation.getIdEtudiant());
            notification.setTitre("Réclamation #" + idReclamation);
            notification.setMessage(message);
            notification.setDateEnvoi(new Date(System.currentTimeMillis()));
            notification.setStatut(Notification.StatutNotification.NonLu);
            notificationDAO.save(notification);
        }
    }

    public String consulterStatut(int idReclamation) {
        Reclamation reclamation = reclamationDAO.findById(idReclamation);
        if (reclamation != null) {
            return reclamation.getStatut().name();
        }
        return null;
    }

    public String consulterReponse(int idReclamation) {
        Reclamation reclamation = reclamationDAO.findById(idReclamation);
        if (reclamation != null) {
            return reclamation.getDescription();
        }
        return null;
    }
}
