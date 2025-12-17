package controllers;

import services.ResponsableService;
import models.Departement;
import models.Etudiant;
import models.Filiere;
import models.Rapport;
import models.Statistiques;
import java.util.List;

public class ResponsableController {
    private ResponsableService responsableService;

    public ResponsableController() {
        this.responsableService = new ResponsableService();
    }

    // POST /responsables/gerer-departement
    public void gererDepartement(Departement departement) {
        responsableService.gererDepartement(departement);
    }

    // PUT /responsables/modifier-departement
    public void modifierInformationsDepartement(Departement departement) {
        responsableService.modifierInformationsDepartement(departement);
    }

    // PUT /responsables/filieres/{id}/capacite
    public void definirCapaciteFiliere(int idFiliere, int capacite) {
        responsableService.definirCapaciteFiliere(idFiliere, capacite);
    }

    // POST /responsables/enseignants/{idEnseignant}/modules/{idModule}
    public void affecterEnseignantModule(int idEnseignant, int idModule) {
        responsableService.affecterEnseignantModule(idEnseignant, idModule);
    }

    // PUT /responsables/enseignants/{idEnseignant}/modules/{idModule}
    public void modifierAffectationEnseignant(int idEnseignant, int idModule) {
        responsableService.modifierAffectationEnseignant(idEnseignant, idModule);
    }

    // POST /responsables/modules/{idModule}/prerequis
    public void definirPrerequisModule(int idModule, List<Integer> prerequis) {
        responsableService.definirPrerequisModule(idModule, prerequis);
    }

    // POST /responsables/semestres/{id}/planifier-examens
    public void planifierExamens(int idSemestre) {
        responsableService.planifierExamens(idSemestre);
    }

    // GET /responsables/departements/{id}/rapport
    public Rapport getRapportDepartement(int idDepartement) {
        return responsableService.genererRapportsDepartement(idDepartement);
    }

    // GET /responsables/filieres/{id}/rapport
    public Rapport getRapportFiliere(int idFiliere) {
        return responsableService.genererRapportFiliere(idFiliere);
    }

    // GET /responsables/statistiques-globales
    public Statistiques getStatistiquesGlobales() {
        return responsableService.consulterStatistiquesGlobales();
    }

    // GET /responsables/filieres/{id}/etudiants
    public List<Etudiant> getEtudiantsParFiliere(int idFiliere) {
        return responsableService.listerEtudiantsParFiliere(idFiliere);
    }

    // GET /responsables/exporter-excel
    public void exporterDonneesExcel() {
        responsableService.exporterDonneesExcel();
    }

    // POST /responsables/semestres/{id}/valider-candidatures
    public void validerCandidatures(int idSemestre) {
        responsableService.validerCandidatures(idSemestre);
    }

    // POST /responsables/filieres/{id}/affecter-etudiants
    public void affecterEtudiantsFiliere(int idFiliere, List<Integer> idsEtudiants) {
        responsableService.affecterEtudiantsFiliere(idFiliere, idsEtudiants);
    }

    // POST /responsables/filieres
    public void ajouterFiliere(Filiere filiere) {
        responsableService.ajouterFiliere(filiere);
    }
}

