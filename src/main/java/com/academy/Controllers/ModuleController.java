package controllers;

import services.ModuleService;
import java.util.List;
import models.Etudiant;
import models.Module;
import models.Planning;
import models.Statistiques;

public class ModuleController {
    private ModuleService moduleService;

    public ModuleController() {
        this.moduleService = new ModuleService();
    }

    // PUT /modules/{id}/contenu
    public void modifierContenu(int idModule, String description) {
        moduleService.modifierContenu(idModule, description);
    }

    // PUT /modules/{id}/volumes-horaires
    public void modifierVolumesHoraires(int idModule, int cm, int td, int tp) {
        moduleService.modifierVolumesHoraires(idModule, cm, td, tp);
    }

    // PUT /modules/{id}/credits
    public void modifierCredits(int idModule, int credits) {
        moduleService.modifierCredits(idModule, credits);
    }

    // GET /modules/{id}/planning
    public Planning genererPlanning(int idModule) {
        return moduleService.genererPlanning(idModule);
    }

    // GET /modules/{id}/etudiants
    public List<Etudiant> obtenirListeEtudiants(int idModule) {
        return moduleService.obtenirListeEtudiants(idModule);
    }

    // GET /modules/{id}/nombre-etudiants
    public int getNombreEtudiants(int idModule) {
        return moduleService.getNombreEtudiants(idModule);
    }

    // GET /modules/{id}/etudiants-inscrits
    public List<Etudiant> obtenirEtudiantsInscrits(int idModule) {
        return moduleService.obtenirEtudiantsInscrits(idModule);
    }

    // GET /modules/{id}/moyenne
    public float calculerMoyenneModule(int idModule) {
        return moduleService.calculerMoyenneModule(idModule);
    }

    // GET /modules/{id}/verifier-prerequis/{idEtudiant}
    public boolean verifierPrerequisEtudiant(int idModule, int idEtudiant) {
        return moduleService.verifierPrerequisEtudiant(idModule, idEtudiant);
    }

    // GET /modules/{id}/taux-reussite
    public float getTauxReussite(int idModule) {
        return moduleService.calculerTauxReussite(idModule);
    }

    // GET /modules/{id}/taux-presence
    public float getTauxPresence(int idModule) {
        return moduleService.calculerTauxPresence(idModule);
    }

    // GET /modules/{id}/statistiques
    public Statistiques getStatistiques(int idModule) {
        return moduleService.genererStatistiques(idModule);
    }
}

