package controllers;

import services.EnseignantService;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import models.Document;
import models.Etudiant;
import models.Module;
import models.Note;
import models.Planning;
import models.Reclamation;
import models.Seance;

public class EnseignantController {
    private EnseignantService enseignantService;

    public EnseignantController() {
        this.enseignantService = new EnseignantService();
    }

    // GET /enseignants/{id}/charge-horaire
    public int getChargeHoraire(int idEnseignant) {
        return enseignantService.calculerChargeHoraire(idEnseignant);
    }

    // GET /enseignants/{id}/planning
    public Planning getPlanning(int idEnseignant) {
        return enseignantService.consulterPlanning(idEnseignant);
    }

    // GET /enseignants/{id}/planning-hebdomadaire
    public Planning getPlanningHebdomadaire(int idEnseignant) {
        return enseignantService.consulterPlanningHebdomadaire(idEnseignant);
    }

    // GET /enseignants/{id}/verifier-disponibilite
    public boolean verifierDisponibilite(int idEnseignant, Date date, Time heureDebut, Time heureFin) {
        return enseignantService.verifierDisponibilite(idEnseignant, date, heureDebut, heureFin);
    }

    // GET /enseignants/{id}/modules
    public List<Module> getModules(int idEnseignant) {
        return enseignantService.consulterModules(idEnseignant);
    }

    // GET /enseignants/{id}/modules/semestres/{idSemestre}
    public List<Module> getModulesSemestre(int idEnseignant, int idSemestre) {
        return enseignantService.consulterModulesSemestre(idEnseignant, idSemestre);
    }

    // GET /enseignants/{id}/seances
    public List<Seance> getSeances(int idEnseignant) {
        return enseignantService.consulterSeances(idEnseignant);
    }

    // GET /enseignants/{id}/documents
    public List<Document> getDocuments(int idEnseignant) {
        return enseignantService.consulterDocuments(idEnseignant);
    }

    // POST /enseignants/{id}/valider-notes/modules/{idModule}
    public void validerNotes(int idEnseignant, int idModule) {
        enseignantService.validerNotes(idEnseignant, idModule);
    }

    // GET /enseignants/modules/{idModule}/notes
    public List<Note> getNotesModule(int idModule) {
        return enseignantService.consulterNotesModule(idModule);
    }

    // GET /enseignants/modules/{idModule}/etudiants
    public List<Etudiant> getEtudiantsModule(int idModule) {
        return enseignantService.consulterEtudiantsModule(idModule);
    }

    // GET /enseignants/etudiants/{idEtudiant}/modules/{idModule}/notes
    public List<Note> getNotesEtudiant(int idEtudiant, int idModule) {
        return enseignantService.consulterNotesEtudiant(idEtudiant, idModule);
    }

    // GET /enseignants/modules/{idModule}/taux-presence
    public float getTauxPresenceModule(int idModule) {
        return enseignantService.calculerTauxPresenceModule(idModule);
    }

    // GET /enseignants/{id}/reclamations
    public List<Reclamation> getReclamations(int idEnseignant) {
        return enseignantService.consulterReclamations(idEnseignant);
    }
}

