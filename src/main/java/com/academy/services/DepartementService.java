package com.academy.services;

import java.sql.Date;
import java.util.List;

import com.academy.dao.DepartementDAO;
import com.academy.dao.EnseignantDAO;
import com.academy.dao.EtudiantDAO;
import com.academy.dao.FiliereDAO;
import com.academy.dao.NoteDAO;
import com.academy.dao.RapportDAO;
import com.academy.dao.StatistiquesDAO;
import com.academy.models.Departement;
import com.academy.models.Enseignant;
import com.academy.models.Etudiant;
import com.academy.models.Filiere;
import com.academy.models.Note;
import com.academy.models.Rapport;
import com.academy.models.Statistiques;

public class DepartementService {
    private DepartementDAO departementDAO;
    private FiliereDAO filiereDAO;
    private EtudiantDAO etudiantDAO;
    private EnseignantDAO enseignantDAO;
    private StatistiquesDAO statistiquesDAO;
    private RapportDAO rapportDAO;
    private NoteDAO noteDAO;

    public DepartementService() {
        // Les DAO seront injectés via constructeur ou setters dans une implémentation réelle
    }

    public Statistiques genererStatistiques(Departement departement) {
        if (departement == null) {
            return null;
        }
        
        int nombreEtudiants = calculerNombreEtudiants(departement.getIdDepartement());
        int nombreEnseignants = calculerNombreEnseignants(departement.getIdDepartement());
        float tauxReussite = calculerTauxReussiteGlobal(departement.getIdDepartement());
        
        Statistiques stats = new Statistiques();
        stats.setTypeStat("Departement");
        stats.setPeriode("Annuel");
        stats.setValeur(tauxReussite);
        
        return stats;
    }

    public Rapport genererRapportActivites(Departement departement) {
        if (departement == null) {
            return null;
        }
        
        Rapport rapport = new Rapport();
        rapport.setTitre("Rapport d'activités - " + departement.getNom());
        rapport.setTypeRapport("Activites");
        rapport.setDateGeneration(new Date(System.currentTimeMillis()));
        rapport.setAuteur("Système");
        
        StringBuilder contenu = new StringBuilder();
        contenu.append("Nombre d'étudiants: ").append(calculerNombreEtudiants(departement.getIdDepartement())).append("\n");
        contenu.append("Nombre d'enseignants: ").append(calculerNombreEnseignants(departement.getIdDepartement())).append("\n");
        contenu.append("Taux de réussite: ").append(calculerTauxReussiteGlobal(departement.getIdDepartement())).append("%\n");
        
        rapport.setContenu(contenu.toString());
        
        return rapport;
    }

    public int calculerNombreEtudiants(int idDepartement) {
        List<Filiere> filieres = filiereDAO.findByDepartement(idDepartement);
        int total = 0;
        
        if (filieres != null) {
            for (Filiere filiere : filieres) {
                List<Etudiant> etudiants = etudiantDAO.findByFiliere(filiere.getIdFiliere());
                if (etudiants != null) {
                    total += etudiants.size();
                }
            }
        }
        
        return total;
    }

    public int calculerNombreEnseignants(int idDepartement) {
        List<Enseignant> enseignants = enseignantDAO.findByDepartement(idDepartement);
        return enseignants != null ? enseignants.size() : 0;
    }

    public float calculerTauxReussiteGlobal(int idDepartement) {
        List<Filiere> filieres = filiereDAO.findByDepartement(idDepartement);
        if (filieres == null || filieres.isEmpty()) {
            return 0f;
        }
        
        int totalEtudiants = 0;
        int etudiantsReussis = 0;
        
        for (Filiere filiere : filieres) {
            List<Etudiant> etudiants = etudiantDAO.findByFiliere(filiere.getIdFiliere());
            if (etudiants != null) {
                for (Etudiant etudiant : etudiants) {
                    totalEtudiants++;
                    List<Note> notes = noteDAO.findByEtudiant(etudiant.getIdEtudiant());
                    if (notes != null && !notes.isEmpty()) {
                        float moyenne = calculerMoyenneEtudiant(notes);
                        if (moyenne >= 10.0f) {
                            etudiantsReussis++;
                        }
                    }
                }
            }
        }
        
        return totalEtudiants > 0 ? (etudiantsReussis * 100.0f / totalEtudiants) : 0f;
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

