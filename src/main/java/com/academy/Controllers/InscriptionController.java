package controllers;

import services.InscriptionService;
import models.Etudiant;
import models.Inscription;
import models.Module;
import models.Planning;

public class InscriptionController {
    private InscriptionService inscriptionService;

    public InscriptionController() {
        this.inscriptionService = new InscriptionService();
    }

    // POST /inscriptions/verifier-prerequis
    public boolean verifierPrerequis(Inscription inscription) {
        return inscriptionService.verifierPrerequis(inscription);
    }

    // POST /inscriptions/verifier-capacite
    public boolean verifierCapacite(Inscription inscription) {
        return inscriptionService.verifierCapacite(inscription);
    }

    // POST /inscriptions/verifier-conflit-horaire
    public boolean verifierConflitHoraire(Inscription inscription) {
        return inscriptionService.verifierConflitHoraire(inscription);
    }

    // GET /inscriptions/{id}/module
    public Module getModule(int idInscription) {
        return inscriptionService.consulterModule(idInscription);
    }

    // GET /inscriptions/{id}/planning
    public Planning getPlanning(int idInscription) {
        return inscriptionService.consulterPlanning(idInscription);
    }

    // GET /inscriptions/{id}/etudiant
    public Etudiant getEtudiant(int idInscription) {
        return inscriptionService.consulterEtudiant(idInscription);
    }
}

