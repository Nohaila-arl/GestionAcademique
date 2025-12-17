package com.academy.services;

import java.util.List;

import com.academy.dao.EtudiantDAO;
import com.academy.dao.FiliereDAO;
import com.academy.dao.NoteDAO;
import com.academy.dao.StatistiquesDAO;
import com.academy.models.Etudiant;
import com.academy.models.Filiere;
import com.academy.models.Note;
import com.academy.models.Statistiques;

public class FiliereService {
    private FiliereDAO filiereDAO;
    private EtudiantDAO etudiantDAO;
    private NoteDAO noteDAO;
    private StatistiquesDAO statistiquesDAO;

    public FiliereService() {
        // Les DAO seront injectés via constructeur ou setters dans une implémentation réelle
    }

    public boolean verifierCapacite(Filiere filiere) {
        if (filiere == null) {
            return false;
        }
        
        List<Etudiant> etudiants = etudiantDAO.findByFiliere(filiere.getIdFiliere());
        int nombreEtudiants = etudiants != null ? etudiants.size() : 0;
        
        return nombreEtudiants < filiere.getCapacite();
    }

    public int getPlacesDisponibles(Filiere filiere) {
        if (filiere == null) {
            return 0;
        }
        
        List<Etudiant> etudiants = etudiantDAO.findByFiliere(filiere.getIdFiliere());
        int nombreEtudiants = etudiants != null ? etudiants.size() : 0;
        
        return Math.max(0, filiere.getCapacite() - nombreEtudiants);
    }

    public boolean estComplete(Filiere filiere) {
        return !verifierCapacite(filiere);
    }

    public boolean verifierAdmissibiliteEtudiant(Filiere filiere, Etudiant etudiant) {
        if (filiere == null || etudiant == null) {
            return false;
        }
        
        // Vérifier les prérequis de la filière
        // Cette méthode nécessiterait une table de prérequis
        // Pour l'instant, retourner true si la filière n'est pas complète
        return verifierCapacite(filiere);
    }

    public float calculerTauxReussite(Filiere filiere) {
        if (filiere == null) {
            return 0f;
        }
        
        List<Etudiant> etudiants = etudiantDAO.findByFiliere(filiere.getIdFiliere());
        if (etudiants == null || etudiants.isEmpty()) {
            return 0f;
        }
        
        int totalEtudiants = etudiants.size();
        int etudiantsReussis = 0;
        
        for (Etudiant etudiant : etudiants) {
            List<Note> notes = noteDAO.findByEtudiant(etudiant.getIdEtudiant());
            if (notes != null && !notes.isEmpty()) {
                float moyenne = calculerMoyenneEtudiant(notes);
                if (moyenne >= 10.0f) {
                    etudiantsReussis++;
                }
            }
        }
        
        return totalEtudiants > 0 ? (etudiantsReussis * 100.0f / totalEtudiants) : 0f;
    }

    public float calculerMoyenneGenerale(Filiere filiere) {
        if (filiere == null) {
            return 0f;
        }
        
        List<Etudiant> etudiants = etudiantDAO.findByFiliere(filiere.getIdFiliere());
        if (etudiants == null || etudiants.isEmpty()) {
            return 0f;
        }
        
        float sommeMoyennes = 0f;
        int nombreEtudiantsAvecNotes = 0;
        
        for (Etudiant etudiant : etudiants) {
            List<Note> notes = noteDAO.findByEtudiant(etudiant.getIdEtudiant());
            if (notes != null && !notes.isEmpty()) {
                sommeMoyennes += calculerMoyenneEtudiant(notes);
                nombreEtudiantsAvecNotes++;
            }
        }
        
        return nombreEtudiantsAvecNotes > 0 ? (sommeMoyennes / nombreEtudiantsAvecNotes) : 0f;
    }

    public Statistiques genererStatistiques(Filiere filiere) {
        if (filiere == null) {
            return null;
        }
        
        Statistiques stats = new Statistiques();
        stats.setTypeStat("Filiere");
        stats.setPeriode("Annuel");
        stats.setValeur(calculerTauxReussite(filiere));
        
        return stats;
    }
    
    private float calculerMoyenneEtudiant(List<Note> notes) {
        if (notes == null || notes.isEmpty()) {
            return 0f;
        }
        
        float somme = 0f;
        for (Note note : notes) {
            somme += note.getMoyenneFinale();
        }
        
        return somme / notes.size();
    }
}
