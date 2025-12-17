package controllers;

import services.ReclamationService;
import java.util.List;

public class ReclamationController {
    private ReclamationService reclamationService;

    public ReclamationController() {
        this.reclamationService = new ReclamationService();
    }

    // POST /reclamations/{id}/traiter
    public void traiterReclamation(int idReclamation, String decision, String commentaire) {
        reclamationService.traiterReclamation(idReclamation, decision, commentaire);
    }

    // POST /reclamations/{id}/accepter
    public void accepterReclamation(int idReclamation) {
        reclamationService.accepterReclamation(idReclamation);
    }

    // POST /reclamations/{id}/rejeter
    public void rejeterReclamation(int idReclamation, String motif) {
        reclamationService.rejeterReclamation(idReclamation, motif);
    }

    // POST /reclamations/{id}/commentaire
    public void ajouterCommentaire(int idReclamation, String commentaire) {
        reclamationService.ajouterCommentaire(idReclamation, commentaire);
    }

    // GET /reclamations/{id}/historique
    public List<String> getHistorique(int idReclamation) {
        return reclamationService.getHistorique(idReclamation);
    }

    // POST /reclamations/{id}/notifier-etudiant
    public void notifierEtudiant(int idReclamation, String message) {
        reclamationService.notifierEtudiant(idReclamation, message);
    }

    // GET /reclamations/{id}/statut
    public String consulterStatut(int idReclamation) {
        return reclamationService.consulterStatut(idReclamation);
    }

    // GET /reclamations/{id}/reponse
    public String consulterReponse(int idReclamation) {
        return reclamationService.consulterReponse(idReclamation);
    }
}

