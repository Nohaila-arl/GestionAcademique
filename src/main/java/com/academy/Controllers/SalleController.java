package controllers;

import services.SalleService;
import java.sql.Date;
import java.util.List;
import models.Planning;

public class SalleController {
    private SalleService salleService;

    public SalleController() {
        this.salleService = new SalleService();
    }

    // GET /salles/{id}/planning-occupation
    public Planning genererPlanningOccupation(int idSalle) {
        return salleService.genererPlanningOccupation(idSalle);
    }

    // GET /salles/{id}/creneaux-disponibles/{date}
    public List<String> getCreneauxDisponibles(int idSalle, Date date) {
        return salleService.getCreneauxDisponibles(idSalle, date);
    }

    // GET /salles/{id}/verifier-capacite/{nombreEtudiants}
    public boolean verifierCapaciteRequise(int idSalle, int nombreEtudiants) {
        return salleService.verifierCapaciteRequise(idSalle, nombreEtudiants);
    }
}

