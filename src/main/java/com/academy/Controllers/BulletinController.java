package controllers;

import services.BulletinService;
import java.util.List;
import models.Note;

public class BulletinController {
    private BulletinService bulletinService;

    public BulletinController() {
        this.bulletinService = new BulletinService();
    }

    // GET /bulletins/{id}/moyenne
    public float calculerMoyenne(int idBulletin) {
        return bulletinService.calculerMoyenne(idBulletin);
    }

    // GET /bulletins/{id}/decision
    public String genererDecision(int idBulletin) {
        return bulletinService.genererDecision(idBulletin);
    }

    // GET /bulletins/{id}/mention
    public String attribuerMention(int idBulletin) {
        return bulletinService.attribuerMention(idBulletin);
    }

    // GET /bulletins/{id}/credits-valides
    public int getCreditsValides(int idBulletin) {
        return bulletinService.calculerCreditsValides(idBulletin);
    }

    // GET /bulletins/{id}/credits-obtenus
    public int getCreditsObtenus(int idBulletin) {
        return bulletinService.calculerCreditsObtenus(idBulletin);
    }

    // POST /bulletins/{id}/generer
    public void genererBulletin(int idBulletin) {
        bulletinService.genererBulletin(idBulletin);
    }

    // GET /bulletins/{id}/afficher
    public void afficherBulletin(int idBulletin) {
        bulletinService.afficherBulletin(idBulletin);
    }

    // GET /bulletins/{id}/exporter-pdf
    public void exporterPDF(int idBulletin) {
        bulletinService.exporterPDF(idBulletin);
    }

    // POST /bulletins/{id}/envoyer-email
    public void envoyerParEmail(int idBulletin) {
        bulletinService.envoyerParEmail(idBulletin);
    }

    // GET /bulletins/{id}/notes
    public List<Note> listerNotes(int idBulletin) {
        return bulletinService.listerNotes(idBulletin);
    }

    // GET /bulletins/{id}/observations
    public String getObservations(int idBulletin) {
        return bulletinService.getObservations(idBulletin);
    }
}

