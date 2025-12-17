package controllers;

import services.PrerequisService;
import models.Etudiant;
import models.PrerequisFiliere;

public class PrerequisController {
    private PrerequisService prerequisService;

    public PrerequisController() {
        this.prerequisService = new PrerequisService();
    }

    // POST /prerequis/verifier-admissibilite
    public boolean verifierAdmissibilite(PrerequisFiliere prerequis, Etudiant etudiant) {
        return prerequisService.verifierAdmissibilite(prerequis, etudiant);
    }

    // POST /prerequis/verifier-niveau-academique
    public boolean verifierNiveauAcademique(PrerequisFiliere prerequis, Etudiant etudiant) {
        return prerequisService.verifierNiveauAcademique(prerequis, etudiant);
    }

    // POST /prerequis/verifier-competences
    public boolean verifierCompetences(PrerequisFiliere prerequis, Etudiant etudiant) {
        return prerequisService.verifierCompetences(prerequis, etudiant);
    }
}

