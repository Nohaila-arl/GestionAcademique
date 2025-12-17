package com.academy.services;

import java.sql.Date;
import java.util.List;

import com.academy.dao.ModuleDAO;
import com.academy.dao.ProgrammeDAO;
import com.academy.dao.RapportDAO;
import com.academy.models.Module;
import com.academy.models.Programme;
import com.academy.models.Rapport;

public class ProgrammeService {
    private ProgrammeDAO programmeDAO;
    private ModuleDAO moduleDAO;
    private RapportDAO rapportDAO;

    public ProgrammeService() {
        // Les DAO seront injectés via constructeur ou setters dans une implémentation réelle
    }

    public boolean verifierCoherence(int idProgramme) {
        Programme programme = programmeDAO.findById(idProgramme);
        if (programme == null) {
            return false;
        }
        
        // Vérifier que le programme respecte les contraintes
        int totalCredits = calculerTotalCredits(idProgramme);
        // Supposons qu'un programme doit avoir entre 120 et 180 crédits
        return totalCredits >= 120 && totalCredits <= 180;
    }

    public int calculerTotalCredits(int idProgramme) {
        Programme programme = programmeDAO.findById(idProgramme);
        if (programme == null) {
            return 0;
        }
        
        List<Module> modules = moduleDAO.findByFiliere(programme.getIdFiliere());
        if (modules == null) {
            return 0;
        }
        
        int totalCredits = 0;
        for (Module module : modules) {
            totalCredits += module.getCredits();
        }
        
        return totalCredits;
    }

    public boolean respecteConstraintes(int idProgramme) {
        return verifierCoherence(idProgramme);
    }

    public Rapport genererRapport(int idProgramme) {
        Programme programme = programmeDAO.findById(idProgramme);
        if (programme == null) {
            return null;
        }
        
        Rapport rapport = new Rapport();
        rapport.setTitre("Rapport du programme - " + programme.getIntitule());
        rapport.setTypeRapport("Programme");
        rapport.setDateGeneration(new Date(System.currentTimeMillis()));
        rapport.setAuteur("Système");
        
        StringBuilder contenu = new StringBuilder();
        contenu.append("Programme: ").append(programme.getIntitule()).append("\n");
        contenu.append("Année: ").append(programme.getAnnee()).append("\n");
        contenu.append("Total crédits: ").append(calculerTotalCredits(idProgramme)).append("\n");
        contenu.append("Cohérence: ").append(verifierCoherence(idProgramme) ? "Oui" : "Non").append("\n");
        
        rapport.setContenu(contenu.toString());
        
        return rapport;
    }

    public void exporterProgramme(int idProgramme) {
        Programme programme = programmeDAO.findById(idProgramme);
        if (programme != null) {
            // Logique d'exportation du programme
            // Cela pourrait exporter en PDF, Excel, etc.
        }
    }
}
