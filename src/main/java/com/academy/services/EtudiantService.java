package com.academy.services;

import java.sql.Date;
import java.util.List;

import com.academy.dao.BulletinDAO;
import com.academy.dao.DocumentDAO;
import com.academy.dao.EtudiantDAO;
import com.academy.dao.ExamenDAO;
import com.academy.dao.FiliereDAO;
import com.academy.dao.InscriptionDAO;
import com.academy.dao.ModuleDAO;
import com.academy.dao.NoteDAO;
import com.academy.dao.NotificationDAO;
import com.academy.dao.PlanningDAO;
import com.academy.dao.ReclamationDAO;
import com.academy.dao.SeanceDAO;
import com.academy.models.Bulletin;
import com.academy.models.Document;
import com.academy.models.Etudiant;
import com.academy.models.Examen;
import com.academy.models.Filiere;
import com.academy.models.Inscription;
import com.academy.models.Module;
import com.academy.models.Note;
import com.academy.models.Notification;
import com.academy.models.Planning;
import com.academy.models.Reclamation;
import com.academy.models.Seance;

public class EtudiantService {
    private EtudiantDAO etudiantDAO;
    private FiliereDAO filiereDAO;
    private ModuleDAO moduleDAO;
    private PlanningDAO planningDAO;
    private SeanceDAO seanceDAO;
    private ExamenDAO examenDAO;
    private NoteDAO noteDAO;
    private BulletinDAO bulletinDAO;
    private ReclamationDAO reclamationDAO;
    private NotificationDAO notificationDAO;
    private DocumentDAO documentDAO;
    private InscriptionDAO inscriptionDAO;

    public EtudiantService() {
        // Les DAO seront injectés via constructeur ou setters dans une implémentation réelle
    }

    public Filiere consulterFiliereAffectee(int idEtudiant) {
        Etudiant etudiant = etudiantDAO.findById(idEtudiant);
        if (etudiant != null && etudiant.getIdFiliere() != 0) {
            return filiereDAO.findById(etudiant.getIdFiliere());
        }
        return null;
    }

    public List<Module> consulterModulesFiliere(int idEtudiant) {
        Filiere filiere = consulterFiliereAffectee(idEtudiant);
        if (filiere != null) {
            return moduleDAO.findByFiliere(filiere.getIdFiliere());
        }
        return null;
    }

    public List<Module> consulterModulesDisponibles(int idEtudiant) {
        // Retourner tous les modules de la filière de l'étudiant
        return consulterModulesFiliere(idEtudiant);
    }

    public Planning consulterPlanning(int idEtudiant) {
        // Récupérer le planning basé sur les modules de l'étudiant
        List<Inscription> inscriptions = inscriptionDAO.findByEtudiant(idEtudiant);
        if (inscriptions != null && !inscriptions.isEmpty()) {
            Module module = moduleDAO.findById(inscriptions.get(0).getIdModule());
            if (module != null) {
                List<Planning> plannings = planningDAO.findByModule(module.getIdModule());
                if (plannings != null && !plannings.isEmpty()) {
                    return plannings.get(0);
                }
            }
        }
        return null;
    }

    public Planning consulterPlanningHebdomadaire(int idEtudiant) {
        return consulterPlanning(idEtudiant);
    }

    public List<Seance> consulterSeancesJour(int idEtudiant, Date date) {
        List<Inscription> inscriptions = inscriptionDAO.findByEtudiant(idEtudiant);
        if (inscriptions == null) {
            return null;
        }
        
        List<Seance> seancesJour = new java.util.ArrayList<>();
        for (Inscription inscription : inscriptions) {
            List<Seance> seances = seanceDAO.findByModule(inscription.getIdModule());
            if (seances != null) {
                for (Seance seance : seances) {
                    if (seance.getDateSeance().equals(date)) {
                        seancesJour.add(seance);
                    }
                }
            }
        }
        
        return seancesJour;
    }

    public List<Examen> consulterCalendrierExamens(int idEtudiant) {
        List<Inscription> inscriptions = inscriptionDAO.findByEtudiant(idEtudiant);
        if (inscriptions == null) {
            return null;
        }
        
        List<Examen> examens = new java.util.ArrayList<>();
        for (Inscription inscription : inscriptions) {
            List<Examen> examensModule = examenDAO.findByModule(inscription.getIdModule());
            if (examensModule != null) {
                examens.addAll(examensModule);
            }
        }
        
        return examens;
    }

    public List<Note> consulterNotes(int idEtudiant) {
        return noteDAO.findByEtudiant(idEtudiant);
    }

    public List<Note> consulterNotesModule(int idEtudiant, int idModule) {
        Note note = noteDAO.findByEtudiantAndModule(idEtudiant, idModule);
        if (note != null) {
            List<Note> notes = new java.util.ArrayList<>();
            notes.add(note);
            return notes;
        }
        return null;
    }

    public float consulterMoyenneGenerale(int idEtudiant) {
        List<Note> notes = consulterNotes(idEtudiant);
        if (notes == null || notes.isEmpty()) {
            return 0f;
        }
        
        float somme = 0f;
        for (Note note : notes) {
            somme += note.getMoyenneFinale();
        }
        
        return somme / notes.size();
    }

    public float consulterMoyenneModule(int idEtudiant, int idModule) {
        Note note = noteDAO.findByEtudiantAndModule(idEtudiant, idModule);
        if (note != null) {
            return (float)note.getMoyenneFinale();
        }
        return 0f;
    }

    public int consulterCreditsValides(int idEtudiant) {
        List<Note> notes = consulterNotes(idEtudiant);
        if (notes == null) {
            return 0;
        }
        
        int creditsValides = 0;
        for (Note note : notes) {
            if (note.getMoyenneFinale() >= 10.0) {
                Module module = moduleDAO.findById(note.getIdModule());
                if (module != null) {
                    creditsValides += module.getCredits();
                }
            }
        }
        
        return creditsValides;
    }

    public int consulterCreditsInscrits(int idEtudiant) {
        List<Inscription> inscriptions = inscriptionDAO.findByEtudiant(idEtudiant);
        if (inscriptions == null) {
            return 0;
        }
        
        int creditsInscrits = 0;
        for (Inscription inscription : inscriptions) {
            Module module = moduleDAO.findById(inscription.getIdModule());
            if (module != null) {
                creditsInscrits += module.getCredits();
            }
        }
        
        return creditsInscrits;
    }

    public Bulletin telechargerBulletin(int idEtudiant, int idSemestre) {
        return bulletinDAO.findByEtudiantAndSemestre(idEtudiant, idSemestre);
    }

    public List<Bulletin> consulterHistoriqueBulletins(int idEtudiant) {
        return bulletinDAO.findByEtudiant(idEtudiant);
    }

    public void exporterBulletinPDF(int idEtudiant, int idSemestre) {
        Bulletin bulletin = telechargerBulletin(idEtudiant, idSemestre);
        if (bulletin != null) {
            // Logique d'exportation en PDF
        }
    }

    public List<Reclamation> consulterReclamations(int idEtudiant) {
        return reclamationDAO.findByEtudiant(idEtudiant);
    }

    public Reclamation consulterStatutReclamation(int idEtudiant, int idReclamation) {
        Reclamation reclamation = reclamationDAO.findById(idReclamation);
        if (reclamation != null && reclamation.getIdEtudiant() == idEtudiant) {
            return reclamation;
        }
        return null;
    }

    public List<Notification> consulterNotifications(int idEtudiant) {
        return notificationDAO.findByEtudiant(idEtudiant);
    }

    public void marquerNotificationLue(int idNotification) {
        Notification notification = notificationDAO.findById(idNotification);
        if (notification != null) {
            notification.setStatut(Notification.StatutNotification.Lu);
            notificationDAO.update(notification);
        }
    }

    public void supprimerNotification(int idNotification) {
        notificationDAO.delete(idNotification);
    }

    public List<Document> telechargerDocumentsModule(int idModule) {
        return documentDAO.findByModule(idModule);
    }

    public Document telechargerDocument(int idDocument) {
        return documentDAO.findById(idDocument);
    }
}
