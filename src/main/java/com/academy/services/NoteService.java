package com.academy.services;

import com.academy.dao.NoteDAO;
import com.academy.models.Note;

public class NoteService {
    private NoteDAO noteDAO;

    public NoteService() {
        // Le DAO sera injecté via constructeur ou setters dans une implémentation réelle
    }

    public float calculerMoyenneFinale(int idNote) {
        Note note = noteDAO.findById(idNote);
        if (note == null) {
            return 0f;
        }
        
        // Moyenne = (noteCC * 0.4) + (noteExam * 0.6)
        float moyenne = (float)(note.getNoteCC() * 0.4 + note.getNoteExam() * 0.6);
        note.setMoyenneFinale(moyenne);
        noteDAO.update(note);
        
        return moyenne;
    }

    public float calculerMoyenneAvecCoefficient(int idNote) {
        Note note = noteDAO.findById(idNote);
        if (note == null) {
            return 0f;
        }
        
        // Pour l'instant, on utilise la même formule que calculerMoyenneFinale
        return calculerMoyenneFinale(idNote);
    }

    public boolean estValide(int idNote) {
        Note note = noteDAO.findById(idNote);
        if (note == null) {
            return false;
        }
        
        float moyenne = calculerMoyenneFinale(idNote);
        return moyenne >= 10.0f;
    }

    public String obtenirMention(int idNote) {
        Note note = noteDAO.findById(idNote);
        if (note == null) {
            return null;
        }
        
        float moyenne = calculerMoyenneFinale(idNote);
        
        if (moyenne >= 16.0f) {
            return "Très Bien";
        } else if (moyenne >= 14.0f) {
            return "Bien";
        } else if (moyenne >= 12.0f) {
            return "Assez Bien";
        } else if (moyenne >= 10.0f) {
            return "Passable";
        } else {
            return "Non Admis";
        }
    }

    public boolean verifierSaisie(int idNote) {
        Note note = noteDAO.findById(idNote);
        if (note == null) {
            return false;
        }
        
        // Vérifier que les notes sont dans une plage valide (0-20)
        return note.getNoteCC() >= 0 && note.getNoteCC() <= 20 &&
               note.getNoteExam() >= 0 && note.getNoteExam() <= 20;
    }

    public boolean verifierCoherence(int idNote) {
        Note note = noteDAO.findById(idNote);
        if (note == null) {
            return false;
        }
        
        // Vérifier la cohérence : la moyenne finale doit correspondre au calcul
        float moyenneCalculee = calculerMoyenneFinale(idNote);
        float difference = (float)Math.abs(note.getMoyenneFinale() - moyenneCalculee);
        
        // Tolérance de 0.01 pour les erreurs d'arrondi
        return difference < 0.01f;
    }
}

