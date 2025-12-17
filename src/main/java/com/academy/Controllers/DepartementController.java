package controllers;

import services.DepartementService;
import models.Departement;
import models.Rapport;
import models.Statistiques;
import java.util.List;

public class DepartementController {
    private DepartementService departementService;

    public DepartementController() {
        this.departementService = new DepartementService();
    }

    // GET /departements/{id}/statistiques
    public Statistiques getStatistiques(int idDepartement) {
        Departement departement = new Departement();
        departement.setIdDepartement(idDepartement);
        return departementService.genererStatistiques(departement);
    }

    // GET /departements/{id}/rapport-activites
    public Rapport getRapportActivites(int idDepartement) {
        Departement departement = new Departement();
        departement.setIdDepartement(idDepartement);
        return departementService.genererRapportActivites(departement);
    }

    // GET /departements/{id}/nombre-etudiants
    public int getNombreEtudiants(int idDepartement) {
        return departementService.calculerNombreEtudiants(idDepartement);
    }

    // GET /departements/{id}/nombre-enseignants
    public int getNombreEnseignants(int idDepartement) {
        return departementService.calculerNombreEnseignants(idDepartement);
    }

    // GET /departements/{id}/taux-reussite
    public float getTauxReussite(int idDepartement) {
        return departementService.calculerTauxReussiteGlobal(idDepartement);
    }
}

