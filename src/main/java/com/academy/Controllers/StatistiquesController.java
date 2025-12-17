package controllers;

import services.StatistiquesService;
import java.util.List;
import java.util.Map;
import models.Etudiant;
import models.Module;
import models.Rapport;

public class StatistiquesController {
    private StatistiquesService statistiquesService;

    public StatistiquesController() {
        this.statistiquesService = new StatistiquesService();
    }

    // GET /statistiques/filieres/{id}/taux-reussite
    public float getTauxReussiteFiliere(int idFiliere) {
        return statistiquesService.calculerTauxReussiteFiliere(idFiliere);
    }

    // GET /statistiques/filieres/{id}/moyenne
    public float getMoyenneFiliere(int idFiliere) {
        return statistiquesService.calculerMoyenneFiliere(idFiliere);
    }

    // GET /statistiques/filieres/{id}/nombre-etudiants
    public int getNombreEtudiantsFiliere(int idFiliere) {
        return statistiquesService.calculerNombreEtudiantsFiliere(idFiliere);
    }

    // GET /statistiques/modules/{id}/presence
    public float getPresenceModule(int idModule) {
        return statistiquesService.calculerPresenceModule(idModule);
    }

    // GET /statistiques/modules/{id}/taux-reussite
    public float getTauxReussiteModule(int idModule) {
        return statistiquesService.calculerTauxReussiteModule(idModule);
    }

    // GET /statistiques/modules/{id}/moyenne
    public float getMoyenneModule(int idModule) {
        return statistiquesService.calculerMoyenneModule(idModule);
    }

    // GET /statistiques/departements/{id}/taux-reussite
    public float getTauxReussiteDepartement(int idDepartement) {
        return statistiquesService.calculerTauxReussiteDepartement(idDepartement);
    }

    // GET /statistiques/effectif-total
    public int getEffectifTotal() {
        return statistiquesService.calculerEffectifTotal();
    }

    // GET /statistiques/taux-occupation-salles
    public float getTauxOccupationSalles() {
        return statistiquesService.calculerTauxOccupationSalles();
    }

    // GET /statistiques/rapport-annuel
    public Rapport getRapportAnnuel() {
        return statistiquesService.genererRapportAnnuel();
    }

    // GET /statistiques/rapport-semestriel
    public Rapport getRapportSemestriel() {
        return statistiquesService.genererRapportSemestriel();
    }

    // GET /statistiques/rapport-module/{idModule}
    public Rapport getRapportModule(int idModule) {
        return statistiquesService.genererRapportModule(idModule);
    }

    // GET /statistiques/modules-difficiles
    public List<Module> identifierModulesDifficiles() {
        return statistiquesService.identifierModulesDifficiles();
    }

    // GET /statistiques/etudiants-en-difficulte
    public List<Etudiant> identifierEtudiantsEnDifficulte() {
        return statistiquesService.identifierEtudiantsEnDifficulte();
    }

    // GET /statistiques/performances-par-filiere
    public Map<String, Float> analyserPerformancesParFiliere() {
        return statistiquesService.analyserPerformancesParFiliere();
    }
}

