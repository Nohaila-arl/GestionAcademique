package com.academy.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.academy.dao.EtudiantDAO;
import com.academy.dao.FiliereDAO;
import com.academy.dao.ModuleDAO;
import com.academy.dao.NoteDAO;
import com.academy.dao.RapportDAO;
import com.academy.dao.SalleDAO;
import com.academy.dao.StatistiquesDAO;
import com.academy.models.Etudiant;
import com.academy.models.Filiere;
import com.academy.models.Module;
import com.academy.models.Note;
import com.academy.models.Rapport;
import com.academy.models.Salle;

public class StatistiquesService {
    private StatistiquesDAO statistiquesDAO;
    private FiliereDAO filiereDAO;
    private EtudiantDAO etudiantDAO;
    private NoteDAO noteDAO;
    private ModuleDAO moduleDAO;
    private SalleDAO salleDAO;
    private RapportDAO rapportDAO;

    public StatistiquesService() {
        // Les DAO seront injectés via constructeur ou setters dans une implémentation réelle
    }

    public float calculerTauxReussiteFiliere(int idFiliere) {
        Filiere filiere = filiereDAO.findById(idFiliere);
        if (filiere == null) {
            return 0f;
        }
        
        List<Etudiant> etudiants = etudiantDAO.findByFiliere(idFiliere);
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

    public float calculerMoyenneFiliere(int idFiliere) {
        Filiere filiere = filiereDAO.findById(idFiliere);
        if (filiere == null) {
            return 0f;
        }
        
        List<Etudiant> etudiants = etudiantDAO.findByFiliere(idFiliere);
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

    public int calculerNombreEtudiantsFiliere(int idFiliere) {
        List<Etudiant> etudiants = etudiantDAO.findByFiliere(idFiliere);
        return etudiants != null ? etudiants.size() : 0;
    }

    public float calculerPresenceModule(int idModule) {
        // Cette méthode nécessiterait une table de présence
        // Pour l'instant, retourner une valeur par défaut
        return 0f;
    }

    public float calculerTauxReussiteModule(int idModule) {
        List<Note> notes = noteDAO.findByModule(idModule);
        if (notes == null || notes.isEmpty()) {
            return 0f;
        }
        
        int reussis = 0;
        for (Note note : notes) {
            if (note.getMoyenneFinale() >= 10.0) {
                reussis++;
            }
        }
        
        return (reussis * 100.0f) / notes.size();
    }

    public float calculerMoyenneModule(int idModule) {
        List<Note> notes = noteDAO.findByModule(idModule);
        if (notes == null || notes.isEmpty()) {
            return 0f;
        }
        
        float somme = 0f;
        for (Note note : notes) {
            somme += note.getMoyenneFinale();
        }
        
        return somme / notes.size();
    }

    public float calculerTauxReussiteDepartement(int idDepartement) {
        // Cette méthode nécessiterait DepartementDAO
        // Pour l'instant, retourner une valeur par défaut
        return 0f;
    }

    public int calculerEffectifTotal() {
        List<Etudiant> etudiants = etudiantDAO.findAll();
        return etudiants != null ? etudiants.size() : 0;
    }

    public float calculerTauxOccupationSalles() {
        List<Salle> salles = salleDAO.findAll();
        if (salles == null || salles.isEmpty()) {
            return 0f;
        }
        
        int sallesOccupees = 0;
        for (Salle salle : salles) {
            if (!salle.isDisponibilite()) {
                sallesOccupees++;
            }
        }
        
        return (sallesOccupees * 100.0f) / salles.size();
    }

    public Rapport genererRapportAnnuel() {
        Rapport rapport = new Rapport();
        rapport.setTitre("Rapport annuel");
        rapport.setTypeRapport("Annuel");
        rapport.setAuteur("Système");
        rapport.setContenu("Effectif total: " + calculerEffectifTotal());
        rapportDAO.save(rapport);
        return rapport;
    }

    public Rapport genererRapportSemestriel() {
        Rapport rapport = new Rapport();
        rapport.setTitre("Rapport semestriel");
        rapport.setTypeRapport("Semestriel");
        rapport.setAuteur("Système");
        rapport.setContenu("Effectif total: " + calculerEffectifTotal());
        rapportDAO.save(rapport);
        return rapport;
    }

    public Rapport genererRapportModule(int idModule) {
        Module module = moduleDAO.findById(idModule);
        if (module == null) {
            return null;
        }
        
        Rapport rapport = new Rapport();
        rapport.setTitre("Rapport du module - " + module.getIntitule());
        rapport.setTypeRapport("Module");
        rapport.setAuteur("Système");
        
        StringBuilder contenu = new StringBuilder();
        contenu.append("Module: ").append(module.getIntitule()).append("\n");
        contenu.append("Taux de réussite: ").append(calculerTauxReussiteModule(idModule)).append("%\n");
        contenu.append("Moyenne: ").append(calculerMoyenneModule(idModule)).append("\n");
        
        rapport.setContenu(contenu.toString());
        rapportDAO.save(rapport);
        
        return rapport;
    }

    public List<Module> identifierModulesDifficiles() {
        List<Module> modules = moduleDAO.findAll();
        if (modules == null) {
            return null;
        }
        
        List<Module> modulesDifficiles = new ArrayList<>();
        for (Module module : modules) {
            float tauxReussite = calculerTauxReussiteModule(module.getIdModule());
            if (tauxReussite < 50.0f) { // Moins de 50% de réussite
                modulesDifficiles.add(module);
            }
        }
        
        return modulesDifficiles;
    }

    public List<Etudiant> identifierEtudiantsEnDifficulte() {
        List<Etudiant> etudiants = etudiantDAO.findAll();
        if (etudiants == null) {
            return null;
        }
        
        List<Etudiant> etudiantsEnDifficulte = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            List<Note> notes = noteDAO.findByEtudiant(etudiant.getIdEtudiant());
            if (notes != null && !notes.isEmpty()) {
                float moyenne = calculerMoyenneEtudiant(notes);
                if (moyenne < 10.0f) {
                    etudiantsEnDifficulte.add(etudiant);
                }
            }
        }
        
        return etudiantsEnDifficulte;
    }

    public Map<String, Float> analyserPerformancesParFiliere() {
        List<Filiere> filieres = filiereDAO.findAll();
        if (filieres == null) {
            return null;
        }
        
        Map<String, Float> performances = new HashMap<>();
        for (Filiere filiere : filieres) {
            float tauxReussite = calculerTauxReussiteFiliere(filiere.getIdFiliere());
            performances.put(filiere.getNom(), tauxReussite);
        }
        
        return performances;
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
