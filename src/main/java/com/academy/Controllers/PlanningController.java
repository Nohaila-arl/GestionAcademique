package controllers;

import services.PlanningService;
import java.util.List;

public class PlanningController {
    private PlanningService planningService;

    public PlanningController() {
        this.planningService = new PlanningService();
    }

    // POST /plannings/generer-hebdomadaire
    public void genererPlanningHebdomadaire() {
        planningService.genererPlanningHebdomadaire();
    }

    // POST /plannings/generer-mensuel
    public void genererPlanningMensuel() {
        planningService.genererPlanningMensuel();
    }

    // POST /plannings/generer-etudiant/{idEtudiant}
    public void genererPlanningEtudiant(int idEtudiant) {
        planningService.genererPlanningEtudiant(idEtudiant);
    }

    // POST /plannings/generer-enseignant/{idEnseignant}
    public void genererPlanningEnseignant(int idEnseignant) {
        planningService.genererPlanningEnseignant(idEnseignant);
    }

    // POST /plannings/generer-salle/{idSalle}
    public void genererPlanningSalle(int idSalle) {
        planningService.genererPlanningSalle(idSalle);
    }

    // GET /plannings/{id}/verifier-conflits
    public boolean verifierConflits(int idPlanning) {
        return planningService.verifierConflits(idPlanning);
    }

    // GET /plannings/{id}/detecter-conflits
    public List<String> detecterConflits(int idPlanning) {
        return planningService.detecterConflits(idPlanning);
    }

    // GET /plannings/{id}/verifier-disponibilite
    public boolean verifierDisponibilite(int idPlanning) {
        return planningService.verifierDisponibilite(idPlanning);
    }

    // GET /plannings/{id}/exporter-pdf
    public void exporterPDF(int idPlanning) {
        planningService.exporterPDF(idPlanning);
    }

    // GET /plannings/{id}/exporter-ics
    public void exporterICS(int idPlanning) {
        planningService.exporterICS(idPlanning);
    }

    // POST /plannings/{id}/envoyer-email
    public void envoyerParEmail(int idPlanning) {
        planningService.envoyerParEmail(idPlanning);
    }
}

