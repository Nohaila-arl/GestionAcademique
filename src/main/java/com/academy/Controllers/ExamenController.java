package controllers;

import services.ExamenService;
import java.sql.Date;
import java.util.List;
import models.Note;

public class ExamenController {
    private ExamenService examenService;

    public ExamenController() {
        this.examenService = new ExamenService();
    }

    // PUT /examens/{id}/reporter
    public void reporterExamen(int idExamen, Date nouvelleDate) {
        examenService.reporterExamen(idExamen, nouvelleDate);
    }

    // GET /examens/{id}/verifier-disponibilite-salle
    public boolean verifierDisponibiliteSalle(int idExamen) {
        return examenService.verifierDisponibiliteSalle(idExamen);
    }

    // GET /examens/{id}/verifier-capacite-salle
    public boolean verifierCapaciteSalle(int idExamen) {
        return examenService.verifierCapaciteSalle(idExamen);
    }

    // POST /examens/{id}/notifier-etudiants
    public void notifierEtudiants(int idExamen) {
        examenService.notifierEtudiants(idExamen);
    }

    // POST /examens/{id}/notifier-enseignant
    public void notifierEnseignant(int idExamen) {
        examenService.notifierEnseignant(idExamen);
    }

    // POST /examens/{id}/notifier-modification
    public void notifierModification(int idExamen) {
        examenService.notifierModification(idExamen);
    }

    // GET /examens/{id}/liste-surveillance
    public void genererListeSurveillance(int idExamen) {
        examenService.genererListeSurveillance(idExamen);
    }

    // GET /examens/{id}/proces-verbal
    public void genererProcesVerbal(int idExamen) {
        examenService.genererProcesVerbal(idExamen);
    }

    // GET /examens/{id}/moyenne
    public float calculerMoyenne(int idExamen) {
        return examenService.calculerMoyenne(idExamen);
    }

    // GET /examens/{id}/notes
    public List<Note> consulterNotes(int idExamen) {
        return examenService.consulterNotes(idExamen);
    }
}

