package com.academy.services;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.academy.dao.EnseignantDAO;
import com.academy.dao.InscriptionDAO;
import com.academy.dao.NotificationDAO;
import com.academy.dao.PlanningDAO;
import com.academy.dao.SalleDAO;
import com.academy.dao.SeanceDAO;
import com.academy.models.Enseignant;
import com.academy.models.Etudiant;
import com.academy.models.Inscription;
import com.academy.models.Notification;
import com.academy.models.Salle;
import com.academy.models.Seance;

public class SeanceService {
    private SeanceDAO seanceDAO;
    private SalleDAO salleDAO;
    private EnseignantDAO enseignantDAO;
    private InscriptionDAO inscriptionDAO;
    private NotificationDAO notificationDAO;
    private PlanningDAO planningDAO;

    public SeanceService() {
        // Les DAO seront injectés via constructeur ou setters dans une implémentation réelle
    }

    public void reporterSeance(int idSeance, Date nouvelleDate, Time nouvelleHeure) {
        Seance seance = seanceDAO.findById(idSeance);
        if (seance != null) {
            seance.setDateSeance(nouvelleDate);
            seance.setHeureDebut(nouvelleHeure);
            // Ajuster l'heure de fin en fonction de la durée
            seanceDAO.update(seance);
            notifierModification(idSeance);
        }
    }

    public void notifierEtudiants(int idSeance, String message) {
        Seance seance = seanceDAO.findById(idSeance);
        if (seance == null) {
            return;
        }
        
        List<Inscription> inscriptions = inscriptionDAO.findByModule(seance.getIdModule());
        if (inscriptions != null) {
            for (Inscription inscription : inscriptions) {
                Notification notification = new Notification();
                notification.setIdEtudiant(inscription.getIdEtudiant());
                notification.setTitre("Séance modifiée");
                notification.setMessage(message);
                notification.setStatut(Notification.StatutNotification.NonLu);
                notificationDAO.save(notification);
            }
        }
    }

    public void notifierModification(int idSeance) {
        notifierEtudiants(idSeance, "La séance a été modifiée.");
    }

    public void notifierAnnulation(int idSeance) {
        notifierEtudiants(idSeance, "La séance a été annulée.");
    }

    public List<Etudiant> consulterPresents(int idSeance) {
        // Cette méthode nécessiterait une table de présence
        // Pour l'instant, retourner une liste vide
        return new java.util.ArrayList<>();
    }

    public List<Etudiant> consulterAbsents(int idSeance) {
        // Cette méthode nécessiterait une table de présence
        // Pour l'instant, retourner une liste vide
        return new java.util.ArrayList<>();
    }

    public float calculerTauxPresence(int idSeance) {
        List<Etudiant> presents = consulterPresents(idSeance);
        List<Etudiant> absents = consulterAbsents(idSeance);
        
        int total = (presents != null ? presents.size() : 0) + (absents != null ? absents.size() : 0);
        if (total == 0) {
            return 0f;
        }
        
        return (presents != null ? presents.size() : 0) * 100.0f / total;
    }

    public boolean verifierDisponibiliteSalle(int idSeance) {
        Seance seance = seanceDAO.findById(idSeance);
        if (seance == null) {
            return false;
        }
        
        Salle salle = salleDAO.findById(seance.getIdSalle());
        if (salle == null || !salle.isDisponibilite()) {
            return false;
        }
        
        // Vérifier les conflits avec d'autres séances
        List<Seance> autresSeances = seanceDAO.findBySalle(seance.getIdSalle());
        if (autresSeances != null) {
            for (Seance autreSeance : autresSeances) {
                if (autreSeance.getIdSeance() != idSeance && 
                    autreSeance.getDateSeance().equals(seance.getDateSeance())) {
                    if (autreSeance.getHeureDebut().before(seance.getHeureFin()) && 
                        autreSeance.getHeureFin().after(seance.getHeureDebut())) {
                        return false; // Conflit détecté
                    }
                }
            }
        }
        
        return true;
    }

    public boolean verifierDisponibiliteEnseignant(int idSeance) {
        Seance seance = seanceDAO.findById(idSeance);
        if (seance == null) {
            return false;
        }
        
        Enseignant enseignant = enseignantDAO.findById(seance.getIdEnseignant());
        if (enseignant == null) {
            return false;
        }
        
        // Vérifier les conflits avec d'autres séances de l'enseignant
        List<Seance> autresSeances = seanceDAO.findByEnseignant(seance.getIdEnseignant());
        if (autresSeances != null) {
            for (Seance autreSeance : autresSeances) {
                if (autreSeance.getIdSeance() != idSeance && 
                    autreSeance.getDateSeance().equals(seance.getDateSeance())) {
                    if (autreSeance.getHeureDebut().before(seance.getHeureFin()) && 
                        autreSeance.getHeureFin().after(seance.getHeureDebut())) {
                        return false; // Conflit détecté
                    }
                }
            }
        }
        
        return true;
    }

    public boolean verifierConflitHoraire(int idSeance) {
        return !verifierDisponibiliteSalle(idSeance) || !verifierDisponibiliteEnseignant(idSeance);
    }
}
