package com.academy.services;

import java.util.List;

import com.academy.dao.EtudiantDAO;
import com.academy.dao.InscriptionDAO;
import com.academy.dao.ModuleDAO;
import com.academy.dao.PlanningDAO;
import com.academy.dao.SeanceDAO;
import com.academy.models.Etudiant;
import com.academy.models.Inscription;
import com.academy.models.Module;
import com.academy.models.Planning;
import com.academy.models.Seance;

public class InscriptionService {
    private InscriptionDAO inscriptionDAO;
    private ModuleDAO moduleDAO;
    private EtudiantDAO etudiantDAO;
    private PlanningDAO planningDAO;
    private SeanceDAO seanceDAO;

    public InscriptionService() {
        // Les DAO seront injectés via constructeur ou setters dans une implémentation réelle
    }

    public boolean verifierPrerequis(Inscription inscription) {
        if (inscription == null) {
            return false;
        }
        
        Module module = moduleDAO.findById(inscription.getIdModule());
        if (module == null) {
            return false;
        }
        
        // Vérifier les prérequis du module
        // Cette méthode nécessiterait une table de prérequis pour les modules
        // Pour l'instant, retourner true par défaut
        return true;
    }

    public boolean verifierCapacite(Inscription inscription) {
        if (inscription == null) {
            return false;
        }
        
        Module module = moduleDAO.findById(inscription.getIdModule());
        if (module == null) {
            return false;
        }
        
        // Vérifier le nombre d'inscriptions pour ce module
        List<Inscription> inscriptions = inscriptionDAO.findByModule(inscription.getIdModule());
        int nombreInscrits = inscriptions != null ? inscriptions.size() : 0;
        
        // Supposons une capacité par défaut de 50 étudiants par module
        int capaciteModule = 50;
        
        return nombreInscrits < capaciteModule;
    }

    public boolean verifierConflitHoraire(Inscription inscription) {
        if (inscription == null) {
            return false;
        }
        
        // Récupérer les séances du module
        List<Seance> seancesModule = seanceDAO.findByModule(inscription.getIdModule());
        if (seancesModule == null || seancesModule.isEmpty()) {
            return false; // Pas de conflit si pas de séances
        }
        
        // Récupérer les autres inscriptions de l'étudiant
        List<Inscription> autresInscriptions = inscriptionDAO.findByEtudiant(inscription.getIdEtudiant());
        if (autresInscriptions == null) {
            return false;
        }
        
        // Vérifier les conflits d'horaires
        for (Inscription autreInscription : autresInscriptions) {
            if (autreInscription.getIdInscription() == inscription.getIdInscription()) {
                continue; // Ignorer l'inscription actuelle
            }
            
            List<Seance> autresSeances = seanceDAO.findByModule(autreInscription.getIdModule());
            if (autresSeances != null) {
                for (Seance seanceModule : seancesModule) {
                    for (Seance autreSeance : autresSeances) {
                        if (seanceModule.getDateSeance().equals(autreSeance.getDateSeance())) {
                            // Vérifier les conflits d'horaires
                            if (seanceModule.getHeureDebut().before(autreSeance.getHeureFin()) && 
                                seanceModule.getHeureFin().after(autreSeance.getHeureDebut())) {
                                return true; // Conflit détecté
                            }
                        }
                    }
                }
            }
        }
        
        return false; // Pas de conflit
    }

    public Module consulterModule(int idInscription) {
        Inscription inscription = inscriptionDAO.findById(idInscription);
        if (inscription != null) {
            return moduleDAO.findById(inscription.getIdModule());
        }
        return null;
    }

    public Planning consulterPlanning(int idInscription) {
        Inscription inscription = inscriptionDAO.findById(idInscription);
        if (inscription != null) {
            List<Planning> plannings = planningDAO.findByModule(inscription.getIdModule());
            if (plannings != null && !plannings.isEmpty()) {
                return plannings.get(0);
            }
        }
        return null;
    }

    public Etudiant consulterEtudiant(int idInscription) {
        Inscription inscription = inscriptionDAO.findById(idInscription);
        if (inscription != null) {
            return etudiantDAO.findById(inscription.getIdEtudiant());
        }
        return null;
    }
}
