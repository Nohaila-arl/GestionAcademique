package controllers;

import services.FiliereService;
import models.Etudiant;
import models.Filiere;
import models.Statistiques;

public class FiliereController {
    private FiliereService filiereService;

    public FiliereController() {
        this.filiereService = new FiliereService();
    }

    // GET /filieres/{id}/verifier-capacite
    public boolean verifierCapacite(Filiere filiere) {
        return filiereService.verifierCapacite(filiere);
    }

    // GET /filieres/{id}/places-disponibles
    public int getPlacesDisponibles(Filiere filiere) {
        return filiereService.getPlacesDisponibles(filiere);
    }

    // GET /filieres/{id}/est-complete
    public boolean estComplete(Filiere filiere) {
        return filiereService.estComplete(filiere);
    }

    // POST /filieres/{id}/verifier-admissibilite
    public boolean verifierAdmissibiliteEtudiant(Filiere filiere, Etudiant etudiant) {
        return filiereService.verifierAdmissibiliteEtudiant(filiere, etudiant);
    }

    // GET /filieres/{id}/taux-reussite
    public float getTauxReussite(Filiere filiere) {
        return filiereService.calculerTauxReussite(filiere);
    }

    // GET /filieres/{id}/moyenne-generale
    public float getMoyenneGenerale(Filiere filiere) {
        return filiereService.calculerMoyenneGenerale(filiere);
    }

    // GET /filieres/{id}/statistiques
    public Statistiques getStatistiques(Filiere filiere) {
        return filiereService.genererStatistiques(filiere);
    }
}

