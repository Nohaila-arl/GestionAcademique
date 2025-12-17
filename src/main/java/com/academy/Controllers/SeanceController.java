package controllers;

import services.SeanceService;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import models.Etudiant;
import models.Seance;

public class SeanceController {
    private SeanceService seanceService;

    public SeanceController() {
        this.seanceService = new SeanceService();
    }

    // PUT /seances/{id}/reporter
    public void reporterSeance(int idSeance, Date nouvelleDate, Time nouvelleHeure) {
        seanceService.reporterSeance(idSeance, nouvelleDate, nouvelleHeure);
    }

    // POST /seances/{id}/notifier-etudiants
    public void notifierEtudiants(int idSeance, String message) {
        seanceService.notifierEtudiants(idSeance, message);
    }

    // POST /seances/{id}/notifier-modification
    public void notifierModification(int idSeance) {
        seanceService.notifierModification(idSeance);
    }

    // POST /seances/{id}/notifier-annulation
    public void notifierAnnulation(int idSeance) {
        seanceService.notifierAnnulation(idSeance);
    }

    // GET /seances/{id}/presents
    public List<Etudiant> getPresents(int idSeance) {
        return seanceService.consulterPresents(idSeance);
    }

    // GET /seances/{id}/absents
    public List<Etudiant> getAbsents(int idSeance) {
        return seanceService.consulterAbsents(idSeance);
    }

    // GET /seances/{id}/taux-presence
    public float getTauxPresence(int idSeance) {
        return seanceService.calculerTauxPresence(idSeance);
    }

    // GET /seances/{id}/verifier-disponibilite-salle
    public boolean verifierDisponibiliteSalle(int idSeance) {
        return seanceService.verifierDisponibiliteSalle(idSeance);
    }

    // GET /seances/{id}/verifier-disponibilite-enseignant
    public boolean verifierDisponibiliteEnseignant(int idSeance) {
        return seanceService.verifierDisponibiliteEnseignant(idSeance);
    }

    // GET /seances/{id}/verifier-conflit-horaire
    public boolean verifierConflitHoraire(int idSeance) {
        return seanceService.verifierConflitHoraire(idSeance);
    }
}

