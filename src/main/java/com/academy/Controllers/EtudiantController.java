package controllers;

import services.EtudiantService;
import java.sql.Date;
import java.util.List;
import models.Bulletin;
import models.Document;
import models.Examen;
import models.Filiere;
import models.Module;
import models.Notification;
import models.Note;
import models.Planning;
import models.Reclamation;
import models.Seance;

public class EtudiantController {
    private EtudiantService etudiantService;

    public EtudiantController() {
        this.etudiantService = new EtudiantService();
    }

    // GET /etudiants/{id}/filiere
    public Filiere getFiliereAffectee(int idEtudiant) {
        return etudiantService.consulterFiliereAffectee(idEtudiant);
    }

    // GET /etudiants/{id}/modules-filiere
    public List<Module> getModulesFiliere(int idEtudiant) {
        return etudiantService.consulterModulesFiliere(idEtudiant);
    }

    // GET /etudiants/{id}/modules-disponibles
    public List<Module> getModulesDisponibles(int idEtudiant) {
        return etudiantService.consulterModulesDisponibles(idEtudiant);
    }

    // GET /etudiants/{id}/planning
    public Planning getPlanning(int idEtudiant) {
        return etudiantService.consulterPlanning(idEtudiant);
    }

    // GET /etudiants/{id}/planning-hebdomadaire
    public Planning getPlanningHebdomadaire(int idEtudiant) {
        return etudiantService.consulterPlanningHebdomadaire(idEtudiant);
    }

    // GET /etudiants/{id}/seances/{date}
    public List<Seance> getSeancesJour(int idEtudiant, Date date) {
        return etudiantService.consulterSeancesJour(idEtudiant, date);
    }

    // GET /etudiants/{id}/calendrier-examens
    public List<Examen> getCalendrierExamens(int idEtudiant) {
        return etudiantService.consulterCalendrierExamens(idEtudiant);
    }

    // GET /etudiants/{id}/notes
    public List<Note> getNotes(int idEtudiant) {
        return etudiantService.consulterNotes(idEtudiant);
    }

    // GET /etudiants/{id}/notes/modules/{idModule}
    public List<Note> getNotesModule(int idEtudiant, int idModule) {
        return etudiantService.consulterNotesModule(idEtudiant, idModule);
    }

    // GET /etudiants/{id}/moyenne-generale
    public float getMoyenneGenerale(int idEtudiant) {
        return etudiantService.consulterMoyenneGenerale(idEtudiant);
    }

    // GET /etudiants/{id}/moyenne/modules/{idModule}
    public float getMoyenneModule(int idEtudiant, int idModule) {
        return etudiantService.consulterMoyenneModule(idEtudiant, idModule);
    }

    // GET /etudiants/{id}/credits-valides
    public int getCreditsValides(int idEtudiant) {
        return etudiantService.consulterCreditsValides(idEtudiant);
    }

    // GET /etudiants/{id}/credits-inscrits
    public int getCreditsInscrits(int idEtudiant) {
        return etudiantService.consulterCreditsInscrits(idEtudiant);
    }

    // GET /etudiants/{id}/bulletins/{idSemestre}
    public Bulletin getBulletin(int idEtudiant, int idSemestre) {
        return etudiantService.telechargerBulletin(idEtudiant, idSemestre);
    }

    // GET /etudiants/{id}/historique-bulletins
    public List<Bulletin> getHistoriqueBulletins(int idEtudiant) {
        return etudiantService.consulterHistoriqueBulletins(idEtudiant);
    }

    // GET /etudiants/{id}/exporter-bulletin/{idSemestre}
    public void exporterBulletinPDF(int idEtudiant, int idSemestre) {
        etudiantService.exporterBulletinPDF(idEtudiant, idSemestre);
    }

    // GET /etudiants/{id}/reclamations
    public List<Reclamation> getReclamations(int idEtudiant) {
        return etudiantService.consulterReclamations(idEtudiant);
    }

    // GET /etudiants/{id}/reclamations/{idReclamation}
    public Reclamation getStatutReclamation(int idEtudiant, int idReclamation) {
        return etudiantService.consulterStatutReclamation(idEtudiant, idReclamation);
    }

    // GET /etudiants/{id}/notifications
    public List<Notification> getNotifications(int idEtudiant) {
        return etudiantService.consulterNotifications(idEtudiant);
    }

    // PUT /etudiants/notifications/{id}/marquer-lue
    public void marquerNotificationLue(int idNotification) {
        etudiantService.marquerNotificationLue(idNotification);
    }

    // DELETE /etudiants/notifications/{id}
    public void supprimerNotification(int idNotification) {
        etudiantService.supprimerNotification(idNotification);
    }

    // GET /etudiants/modules/{idModule}/documents
    public List<Document> getDocumentsModule(int idModule) {
        return etudiantService.telechargerDocumentsModule(idModule);
    }

    // GET /etudiants/documents/{idDocument}
    public Document getDocument(int idDocument) {
        return etudiantService.telechargerDocument(idDocument);
    }
}

