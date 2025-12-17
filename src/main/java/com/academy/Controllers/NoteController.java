package controllers;

import services.NoteService;

public class NoteController {
    private NoteService noteService;

    public NoteController() {
        this.noteService = new NoteService();
    }

    // GET /notes/{id}/moyenne-finale
    public float calculerMoyenneFinale(int idNote) {
        return noteService.calculerMoyenneFinale(idNote);
    }

    // GET /notes/{id}/moyenne-avec-coefficient
    public float calculerMoyenneAvecCoefficient(int idNote) {
        return noteService.calculerMoyenneAvecCoefficient(idNote);
    }

    // GET /notes/{id}/est-valide
    public boolean estValide(int idNote) {
        return noteService.estValide(idNote);
    }

    // GET /notes/{id}/mention
    public String obtenirMention(int idNote) {
        return noteService.obtenirMention(idNote);
    }

    // GET /notes/{id}/verifier-saisie
    public boolean verifierSaisie(int idNote) {
        return noteService.verifierSaisie(idNote);
    }

    // GET /notes/{id}/verifier-coherence
    public boolean verifierCoherence(int idNote) {
        return noteService.verifierCoherence(idNote);
    }
}

