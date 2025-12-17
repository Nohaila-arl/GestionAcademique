package com.academy.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.academy.dao.PlanningDAO;
import com.academy.dao.SalleDAO;
import com.academy.dao.SeanceDAO;
import com.academy.models.Planning;
import com.academy.models.Salle;
import com.academy.models.Seance;

public class SalleService {
    private SalleDAO salleDAO;
    private PlanningDAO planningDAO;
    private SeanceDAO seanceDAO;

    public SalleService() {
        // Les DAO seront injectés via constructeur ou setters dans une implémentation réelle
    }

    public Planning genererPlanningOccupation(int idSalle) {
        List<Planning> plannings = planningDAO.findBySalle(idSalle);
        if (plannings != null && !plannings.isEmpty()) {
            return plannings.get(0);
        }
        return null;
    }

    public List<String> getCreneauxDisponibles(int idSalle, Date date) {
        Salle salle = salleDAO.findById(idSalle);
        if (salle == null) {
            return null;
        }
        
        List<String> creneauxDisponibles = new ArrayList<>();
        
        // Récupérer les séances de la salle pour cette date
        List<Seance> seances = seanceDAO.findBySalle(idSalle);
        if (seances != null) {
            for (Seance seance : seances) {
                if (seance.getDateSeance().equals(date)) {
                    // Ajouter les créneaux occupés
                    creneauxDisponibles.add("Occupé: " + seance.getHeureDebut() + " - " + seance.getHeureFin());
                }
            }
        }
        
        // Ajouter les créneaux disponibles (simplifié)
        creneauxDisponibles.add("Disponible: 08:00 - 10:00");
        creneauxDisponibles.add("Disponible: 10:00 - 12:00");
        creneauxDisponibles.add("Disponible: 14:00 - 16:00");
        creneauxDisponibles.add("Disponible: 16:00 - 18:00");
        
        return creneauxDisponibles;
    }

    public boolean verifierCapaciteRequise(int idSalle, int nombreEtudiants) {
        Salle salle = salleDAO.findById(idSalle);
        if (salle == null) {
            return false;
        }
        
        return salle.getCapacite() >= nombreEtudiants;
    }
}
