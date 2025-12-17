package com.academy.services;

import java.util.List;

import com.academy.dao.InscriptionDAO;
import com.academy.dao.ModuleDAO;
import com.academy.dao.NoteDAO;
import com.academy.dao.PlanningDAO;
import com.academy.dao.StatistiquesDAO;
import com.academy.models.Etudiant;
import com.academy.models.Inscription;
import com.academy.models.Module;
import com.academy.models.Note;
import com.academy.models.Planning;
import com.academy.models.Statistiques;

public class ModuleService {
    private ModuleDAO moduleDAO;
    private InscriptionDAO inscriptionDAO;
    private NoteDAO noteDAO;
    private PlanningDAO planningDAO;
    private StatistiquesDAO statistiquesDAO;

    public ModuleService() {
        // Les DAO seront injectés via constructeur ou setters dans une implémentation réelle
    }

    public void modifierContenu(int idModule, String description) {
        Module module = moduleDAO.findById(idModule);
        if (module != null) {
            module.setDescription(description);
            moduleDAO.update(module);
        }
    }

    public void modifierVolumesHoraires(int idModule, int cm, int td, int tp) {
        Module module = moduleDAO.findById(idModule);
        if (module != null) {
            module.setHeureCM(cm);
            module.setHeureTD(td);
            module.setHeureTP(tp);
            moduleDAO.update(module);
        }
    }

    public void modifierCredits(int idModule, int credits) {
        Module module = moduleDAO.findById(idModule);
        if (module != null) {
            module.setCredits(credits);
            moduleDAO.update(module);
        }
    }

    public Planning genererPlanning(int idModule) {
        List<Planning> plannings = planningDAO.findByModule(idModule);
        if (plannings != null && !plannings.isEmpty()) {
            return plannings.get(0);
        }
        return null;
    }

    public List<Etudiant> obtenirListeEtudiants(int idModule) {
        return obtenirEtudiantsInscrits(idModule);
    }

    public int getNombreEtudiants(int idModule) {
        List<Inscription> inscriptions = inscriptionDAO.findByModule(idModule);
        return inscriptions != null ? inscriptions.size() : 0;
    }

    public List<Etudiant> obtenirEtudiantsInscrits(int idModule) {
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

    public float calculerMoyenneModule(int idModule) {
        List<Note> notes = noteDAO.findByModule(idModule);
        if (notes == null || notes.isEmpty()) {
            return 0f;
        }
        
        float somme = 0f;
        for (Note note : notes) {
            somme += note.getMoyenneFinale();
        }
        
        return somme / notes.size();
    }

    public boolean verifierPrerequisEtudiant(int idModule, int idEtudiant) {
        // Cette méthode nécessiterait une table de prérequis pour les modules
        // Pour l'instant, retourner true par défaut
        return true;
    }

    public float calculerTauxReussite(int idModule) {
        List<Note> notes = noteDAO.findByModule(idModule);
        if (notes == null || notes.isEmpty()) {
            return 0f;
        }
        
        int reussis = 0;
        for (Note note : notes) {
            if (note.getMoyenneFinale() >= 10.0) {
                reussis++;
            }
        }
        
        return (reussis * 100.0f) / notes.size();
    }

    public float calculerTauxPresence(int idModule) {
        // Cette méthode nécessiterait une table de présence
        // Pour l'instant, retourner une valeur par défaut
        return 0f;
    }

    public Statistiques genererStatistiques(int idModule) {
        Module module = moduleDAO.findById(idModule);
        if (module == null) {
            return null;
        }
        
        Statistiques stats = new Statistiques();
        stats.setTypeStat("Module");
        stats.setPeriode("Semestriel");
        stats.setValeur(calculerTauxReussite(idModule));
        
        return stats;
    }
}
