package com.academy.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.academy.dao.DocumentDAO;
import com.academy.dao.EtudiantDAO;
import com.academy.dao.InscriptionDAO;
import com.academy.dao.ModuleDAO;
import com.academy.dao.NotificationDAO;
import com.academy.models.Document;
import com.academy.models.Etudiant;
import com.academy.models.Inscription;
import com.academy.models.Notification;

public class DocumentService {
    private DocumentDAO documentDAO;
    private ModuleDAO moduleDAO;
    private EtudiantDAO etudiantDAO;
    private InscriptionDAO inscriptionDAO;
    private NotificationDAO notificationDAO;

    public DocumentService() {
        // Les DAO seront injectés via constructeur ou setters dans une implémentation réelle
    }

    public void telecharger(int idDocument) {
        Document document = documentDAO.findById(idDocument);
        if (document != null && document.getFichier() != null) {
            // Logique de téléchargement du fichier
            // Dans une implémentation réelle, cela pourrait retourner un InputStream ou un byte[]
        }
    }

    public void partager(int idDocument) {
        Document document = documentDAO.findById(idDocument);
        if (document != null) {
            // Logique de partage du document
            // Cela pourrait créer des liens de partage ou envoyer des notifications
            notifierEtudiants(idDocument);
        }
    }

    public void notifierEtudiants(int idDocument) {
        Document document = documentDAO.findById(idDocument);
        if (document == null) {
            return;
        }
        
        List<Etudiant> etudiants = getEtudiantsModule(document.getIdModule());
        for (Etudiant etudiant : etudiants) {
            Notification notification = new Notification();
            notification.setIdEtudiant(etudiant.getIdEtudiant());
            notification.setTitre("Nouveau document disponible");
            notification.setMessage("Un nouveau document a été ajouté pour le module " + document.getIdModule());
            notification.setStatut(Notification.StatutNotification.NonLu);
            notificationDAO.save(notification);
        }
    }

    public String getCheminFichier(int idDocument) {
        Document document = documentDAO.findById(idDocument);
        if (document != null && document.getFichier() != null) {
            return document.getFichier();
        }
        return null;
    }

    public long getTailleFichier(int idDocument) {
        Document document = documentDAO.findById(idDocument);
        if (document != null && document.getFichier() != null) {
            File file = new File(document.getFichier());
            if (file.exists()) {
                return file.length();
            }
        }
        return 0L;
    }

    public String getExtension(int idDocument) {
        Document document = documentDAO.findById(idDocument);
        if (document != null && document.getFichier() != null) {
            String fichier = document.getFichier();
            int lastDot = fichier.lastIndexOf('.');
            if (lastDot > 0 && lastDot < fichier.length() - 1) {
                return fichier.substring(lastDot + 1).toLowerCase();
            }
        }
        return null;
    }
    
    private List<Etudiant> getEtudiantsModule(int idModule) {
        List<Inscription> inscriptions = inscriptionDAO.findByModule(idModule);
        List<Etudiant> etudiants = new ArrayList<>();
        if (inscriptions != null) {
            for (Inscription inscription : inscriptions) {
                Etudiant etudiant = etudiantDAO.findById(inscription.getIdEtudiant());
                if (etudiant != null) {
                    etudiants.add(etudiant);
                }
            }
        }
        return etudiants;
    }
}

