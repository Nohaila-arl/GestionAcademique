package com.academy.services;

import java.sql.Date;
import java.util.List;

import com.academy.dao.BulletinDAO;
import com.academy.dao.EtudiantDAO;
import com.academy.dao.InscriptionDAO;
import com.academy.dao.ModuleDAO;
import com.academy.dao.RapportDAO;
import com.academy.dao.SemestreDAO;
import com.academy.models.Etudiant;
import com.academy.models.Inscription;
import com.academy.models.Module;
import com.academy.models.Rapport;
import com.academy.models.Semestre;

public class SemestreService {
    private SemestreDAO semestreDAO;
    private ModuleDAO moduleDAO;
    private InscriptionDAO inscriptionDAO;
    private EtudiantDAO etudiantDAO;
    private BulletinDAO bulletinDAO;
    private RapportDAO rapportDAO;

    public SemestreService() {
        // Les DAO seront injectés via constructeur ou setters dans une implémentation réelle
    }

    public void genererBulletins(int idSemestre) {
        Semestre semestre = semestreDAO.findById(idSemestre);
        if (semestre == null) {
            return;
        }
        
        List<Inscription> inscriptions = listerInscriptions(idSemestre);
        if (inscriptions != null) {
            for (Inscription inscription : inscriptions) {
                // Générer le bulletin pour chaque étudiant
                // Cette logique nécessiterait BulletinService
            }
        }
    }

    public void genererStatistiques(int idSemestre) {
        Semestre semestre = semestreDAO.findById(idSemestre);
        if (semestre != null) {
            // Générer les statistiques du semestre
        }
    }

    public Rapport genererRapport(int idSemestre) {
        Semestre semestre = semestreDAO.findById(idSemestre);
        if (semestre == null) {
            return null;
        }
        
        Rapport rapport = new Rapport();
        rapport.setTitre("Rapport du semestre - " + semestre.getAnneeUniversitaire());
        rapport.setTypeRapport("Semestre");
        rapport.setDateGeneration(new Date(System.currentTimeMillis()));
        rapport.setAuteur("Système");
        
        StringBuilder contenu = new StringBuilder();
        contenu.append("Année universitaire: ").append(semestre.getAnneeUniversitaire()).append("\n");
        contenu.append("Date début: ").append(semestre.getDateDebut()).append("\n");
        contenu.append("Date fin: ").append(semestre.getDateFin()).append("\n");
        contenu.append("Nombre de modules: ").append(listerModules(idSemestre) != null ? listerModules(idSemestre).size() : 0).append("\n");
        contenu.append("Nombre d'étudiants: ").append(listerEtudiants(idSemestre) != null ? listerEtudiants(idSemestre).size() : 0).append("\n");
        
        rapport.setContenu(contenu.toString());
        rapportDAO.save(rapport);
        
        return rapport;
    }

    public boolean estActif(int idSemestre) {
        Semestre semestre = semestreDAO.findById(idSemestre);
        if (semestre == null) {
            return false;
        }
        
        Date aujourdhui = new Date(System.currentTimeMillis());
        return !aujourdhui.before(semestre.getDateDebut()) && !aujourdhui.after(semestre.getDateFin());
    }

    public boolean estCloture(int idSemestre) {
        Semestre semestre = semestreDAO.findById(idSemestre);
        if (semestre == null) {
            return false;
        }
        
        Date aujourdhui = new Date(System.currentTimeMillis());
        return aujourdhui.after(semestre.getDateFin());
    }

    public int getDureeEnSemaines(int idSemestre) {
        Semestre semestre = semestreDAO.findById(idSemestre);
        if (semestre == null) {
            return 0;
        }
        
        long diff = semestre.getDateFin().getTime() - semestre.getDateDebut().getTime();
        return (int)(diff / (1000 * 60 * 60 * 24 * 7)); // Convertir en semaines
    }

    public List<Module> listerModules(int idSemestre) {
        return moduleDAO.findBySemestre(idSemestre);
    }

    public List<Etudiant> listerEtudiants(int idSemestre) {
        List<Inscription> inscriptions = listerInscriptions(idSemestre);
        if (inscriptions == null) {
            return null;
        }
        
        List<Etudiant> etudiants = new java.util.ArrayList<>();
        for (Inscription inscription : inscriptions) {
            Etudiant etudiant = etudiantDAO.findById(inscription.getIdEtudiant());
            if (etudiant != null && !etudiants.contains(etudiant)) {
                etudiants.add(etudiant);
            }
        }
        
        return etudiants;
    }

    public List<Inscription> listerInscriptions(int idSemestre) {
        return inscriptionDAO.findBySemestre(idSemestre);
    }
}
