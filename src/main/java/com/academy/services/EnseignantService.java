package com.academy.services;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.academy.dao.DocumentDAO;
import com.academy.dao.EnseignantDAO;
import com.academy.dao.InscriptionDAO;
import com.academy.dao.ModuleDAO;
import com.academy.dao.NoteDAO;
import com.academy.dao.PlanningDAO;
import com.academy.dao.ReclamationDAO;
import com.academy.dao.SeanceDAO;
import com.academy.models.Document;
import com.academy.models.Etudiant;
import com.academy.models.Inscription;
import com.academy.models.Module;
import com.academy.models.Note;
import com.academy.models.Planning;
import com.academy.models.Reclamation;
import com.academy.models.Seance;

public class EnseignantService {
    private EnseignantDAO enseignantDAO;
    private ModuleDAO moduleDAO;
    private SeanceDAO seanceDAO;
    private DocumentDAO documentDAO;
    private NoteDAO noteDAO;
    private InscriptionDAO inscriptionDAO;
    private PlanningDAO planningDAO;
    private ReclamationDAO reclamationDAO;

    public EnseignantService() {
        // Les DAO seront injectés via constructeur ou setters dans une implémentation réelle
    }

    public int calculerChargeHoraire(int idEnseignant) {
        List<Module> modules = consulterModules(idEnseignant);
        if (modules == null) {
            return 0;
        }
        
        int totalHeures = 0;
        for (Module module : modules) {
            totalHeures += module.getHeureCM() + module.getHeureTD() + module.getHeureTP();
        }
        
        return totalHeures;
    }

    public Planning consulterPlanning(int idEnseignant) {
        List<Planning> plannings = planningDAO.findByEnseignant(idEnseignant);
        if (plannings != null && !plannings.isEmpty()) {
            return plannings.get(0);
        }
        return null;
    }

    public Planning consulterPlanningHebdomadaire(int idEnseignant) {
        // Retourner le planning hebdomadaire de l'enseignant
        return consulterPlanning(idEnseignant);
    }

    public boolean verifierDisponibilite(int idEnseignant, Date date, Time heureDebut, Time heureFin) {
        List<Seance> seances = seanceDAO.findByEnseignant(idEnseignant);
        if (seances == null) {
            return true;
        }
        
        for (Seance seance : seances) {
            if (seance.getDateSeance().equals(date)) {
                // Vérifier les conflits d'horaires
                if (seance.getHeureDebut().before(heureFin) && 
                    seance.getHeureFin().after(heureDebut)) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public List<Module> consulterModules(int idEnseignant) {
        return moduleDAO.findByEnseignant(idEnseignant);
    }

    public List<Module> consulterModulesSemestre(int idEnseignant, int idSemestre) {
        List<Module> modules = consulterModules(idEnseignant);
        if (modules == null) {
            return null;
        }
        
        List<Module> modulesSemestre = new java.util.ArrayList<>();
        for (Module module : modules) {
            if (module.getIdSemestre() == idSemestre) {
                modulesSemestre.add(module);
            }
        }
        
        return modulesSemestre;
    }

    public List<Seance> consulterSeances(int idEnseignant) {
        return seanceDAO.findByEnseignant(idEnseignant);
    }

    public List<Document> consulterDocuments(int idEnseignant) {
        return documentDAO.findByEnseignant(idEnseignant);
    }

    public void validerNotes(int idEnseignant, int idModule) {
        List<Note> notes = consulterNotesModule(idModule);
        if (notes != null) {
            for (Note note : notes) {
                // Marquer les notes comme validées
                noteDAO.update(note);
            }
        }
    }

    public List<Note> consulterNotesModule(int idModule) {
        return noteDAO.findByModule(idModule);
    }

    public List<Etudiant> consulterEtudiantsModule(int idModule) {
        List<Inscription> inscriptions = inscriptionDAO.findByModule(idModule);
        if (inscriptions == null) {
            return null;
        }
        
        List<Etudiant> etudiants = new java.util.ArrayList<>();
        for (Inscription inscription : inscriptions) {
            Etudiant etudiant = inscription.getEtudiant();
            if (etudiant != null) {
                etudiants.add(etudiant);
            }
        }
        
        return etudiants;
    }

    public List<Note> consulterNotesEtudiant(int idEtudiant, int idModule) {
        Note note = noteDAO.findByEtudiantAndModule(idEtudiant, idModule);
        if (note != null) {
            List<Note> notes = new java.util.ArrayList<>();
            notes.add(note);
            return notes;
        }
        return null;
    }

    public float calculerTauxPresenceModule(int idModule) {
        // Cette méthode nécessiterait une table de présence
        // Pour l'instant, retourner une valeur par défaut
        return 0f;
    }

    public List<Reclamation> consulterReclamations(int idEnseignant) {
        // Les réclamations sont liées aux modules, pas directement aux enseignants
        List<Module> modules = consulterModules(idEnseignant);
        if (modules == null) {
            return null;
        }
        
        List<Reclamation> reclamations = new java.util.ArrayList<>();
        for (Module module : modules) {
            List<Reclamation> reclamationsModule = reclamationDAO.findByModule(module.getIdModule());
            if (reclamationsModule != null) {
                reclamations.addAll(reclamationsModule);
            }
        }
        
        return reclamations;
    }
}
