package com.academy.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.academy.dao.EtudiantDAO;
import com.academy.dao.ExamenDAO;
import com.academy.dao.InscriptionDAO;
import com.academy.dao.ModuleDAO;
import com.academy.dao.NoteDAO;
import com.academy.dao.NotificationDAO;
import com.academy.dao.SalleDAO;
import com.academy.dao.SeanceDAO;
import com.academy.models.Etudiant;
import com.academy.models.Examen;
import com.academy.models.Inscription;
import com.academy.models.Module;
import com.academy.models.Note;
import com.academy.models.Notification;
import com.academy.models.Salle;
import com.academy.models.Seance;

public class ExamenService {
    private ExamenDAO examenDAO;
    private NoteDAO noteDAO;
    private SalleDAO salleDAO;
    private SeanceDAO seanceDAO;
    private ModuleDAO moduleDAO;
    private EtudiantDAO etudiantDAO;
    private NotificationDAO notificationDAO;
    private InscriptionDAO inscriptionDAO;

    public ExamenService() {
        // Les DAO seront injectés via constructeur ou setters dans une implémentation réelle
    }

    public void reporterExamen(int idExamen, Date nouvelleDate) {
        Examen examen = examenDAO.findById(idExamen);
        if (examen != null) {
            examen.setDateExamen(nouvelleDate);
            examenDAO.update(examen);
            notifierModification(idExamen);
        }
    }

    public boolean verifierDisponibiliteSalle(int idExamen) {
        Examen examen = examenDAO.findById(idExamen);
        if (examen == null || examen.getSalle() == null) {
            return false;
        }
        
        // Vérifier si la salle est disponible à cette date/heure
        List<Seance> seances = seanceDAO.findBySalle(getSalleIdFromName(examen.getSalle()));
        for (Seance seance : seances) {
            if (seance.getDateSeance().equals(examen.getDateExamen())) {
                // Vérifier les conflits d'horaires
                if (seance.getHeureDebut().before(examen.getHeureFin()) && 
                    seance.getHeureFin().after(examen.getHeureDebut())) {
                    return false;
                }
            }
        }
        
        // Vérifier les autres examens
        List<Examen> examens = examenDAO.findBySalle(examen.getSalle());
        for (Examen e : examens) {
            if (e.getIdExamen() != idExamen && e.getDateExamen().equals(examen.getDateExamen())) {
                if (e.getHeureDebut().before(examen.getHeureFin()) && 
                    e.getHeureFin().after(examen.getHeureDebut())) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public boolean verifierCapaciteSalle(int idExamen) {
        Examen examen = examenDAO.findById(idExamen);
        if (examen == null || examen.getSalle() == null) {
            return false;
        }
        
        Salle salle = salleDAO.findByNom(examen.getSalle());
        if (salle == null) {
            return false;
        }
        
        // Obtenir le nombre d'étudiants inscrits au module
        Module module = moduleDAO.findById(examen.getIdModule());
        if (module == null) {
            return false;
        }
        
        // Compter les étudiants inscrits au module (via InscriptionDAO)
        // Pour simplifier, on suppose qu'on peut obtenir ce nombre
        int nombreEtudiants = getNombreEtudiantsModule(examen.getIdModule());
        
        return salle.getCapacite() >= nombreEtudiants;
    }

    public void notifierEtudiants(int idExamen) {
        Examen examen = examenDAO.findById(idExamen);
        if (examen == null) {
            return;
        }
        
        List<Etudiant> etudiants = getEtudiantsModule(examen.getIdModule());
        for (Etudiant etudiant : etudiants) {
            Notification notification = new Notification();
            notification.setIdEtudiant(etudiant.getIdEtudiant());
            notification.setMessage("Examen du module " + examen.getIdModule() + " prévu le " + examen.getDateExamen());
            notification.setStatut(Notification.StatutNotification.NonLu);
            notificationDAO.save(notification);
        }
    }

    public void notifierEnseignant(int idExamen) {
        Examen examen = examenDAO.findById(idExamen);
        if (examen == null) {
            return;
        }
        
        Module module = moduleDAO.findById(examen.getIdModule());
        if (module != null) {
            // Créer une notification pour l'enseignant
            // Note: Dans un système réel, il faudrait un NotificationDAO pour enseignants
        }
    }

    public void notifierModification(int idExamen) {
        notifierEtudiants(idExamen);
        notifierEnseignant(idExamen);
    }

    public void genererListeSurveillance(int idExamen) {
        // Générer la liste des surveillants pour l'examen
        // Cette méthode pourrait créer un document ou retourner une liste
        Examen examen = examenDAO.findById(idExamen);
        if (examen != null) {
            // Logique de génération de liste de surveillance
        }
    }

    public void genererProcesVerbal(int idExamen) {
        // Générer le procès-verbal de l'examen
        Examen examen = examenDAO.findById(idExamen);
        if (examen != null) {
            // Logique de génération du procès-verbal
        }
    }

    public float calculerMoyenne(int idExamen) {
        List<Note> notes = consulterNotes(idExamen);
        if (notes == null || notes.isEmpty()) {
            return 0f;
        }
        
        float somme = 0f;
        for (Note note : notes) {
            somme += note.getMoyenneFinale();
        }
        
        return somme / notes.size();
    }

    public List<Note> consulterNotes(int idExamen) {
        Examen examen = examenDAO.findById(idExamen);
        if (examen == null) {
            return null;
        }
        
        // Récupérer toutes les notes pour ce module
        return noteDAO.findByModule(examen.getIdModule());
    }
    
    // Méthodes utilitaires privées
    private int getSalleIdFromName(String nomSalle) {
        Salle salle = salleDAO.findByNom(nomSalle);
        return salle != null ? salle.getIdSalle() : 0;
    }
    
    private int getNombreEtudiantsModule(int idModule) {
        List<Inscription> inscriptions = inscriptionDAO.findByModule(idModule);
        return inscriptions != null ? inscriptions.size() : 0;
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

