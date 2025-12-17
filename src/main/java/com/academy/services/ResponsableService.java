package com.academy.services;

import java.util.List;

import com.academy.dao.DepartementDAO;
import com.academy.dao.EnseignantDAO;
import com.academy.dao.EtudiantDAO;
import com.academy.dao.FiliereDAO;
import com.academy.dao.ModuleDAO;
import com.academy.dao.PrerequisFiliereDAO;
import com.academy.dao.RapportDAO;
import com.academy.dao.StatistiquesDAO;
import com.academy.models.Departement;
import com.academy.models.Etudiant;
import com.academy.models.Filiere;
import com.academy.models.Module;
import com.academy.models.Rapport;
import com.academy.models.Statistiques;

public class ResponsableService {
    private DepartementDAO departementDAO;
    private FiliereDAO filiereDAO;
    private EnseignantDAO enseignantDAO;
    private ModuleDAO moduleDAO;
    private EtudiantDAO etudiantDAO;
    private RapportDAO rapportDAO;
    private StatistiquesDAO statistiquesDAO;
    private PrerequisFiliereDAO prerequisFiliereDAO;

    public ResponsableService() {
        // Les DAO seront injectés via constructeur ou setters dans une implémentation réelle
    }

    public void gererDepartement(Departement dept) {
        if (dept != null) {
            departementDAO.save(dept);
        }
    }

    public void modifierInformationsDepartement(Departement dept) {
        if (dept != null) {
            departementDAO.update(dept);
        }
    }

    public void definirCapaciteFiliere(int idFiliere, int capacite) {
        Filiere filiere = filiereDAO.findById(idFiliere);
        if (filiere != null) {
            filiere.setCapacite(capacite);
            filiereDAO.update(filiere);
        }
    }

    public void affecterEnseignantModule(int idEnseignant, int idModule) {
        Module module = moduleDAO.findById(idModule);
        if (module != null) {
            module.setIdEnseignant(idEnseignant);
            moduleDAO.update(module);
        }
    }

    public void modifierAffectationEnseignant(int idEnseignant, int idModule) {
        affecterEnseignantModule(idEnseignant, idModule);
    }

    public void definirPrerequisModule(int idModule, List<Integer> prerequis) {
        // Cette méthode nécessiterait une table de prérequis pour les modules
        // Pour l'instant, c'est une implémentation simplifiée
    }

    public void planifierExamens(int idSemestre) {
        // Planifier les examens pour un semestre
        // Cette méthode nécessiterait ExamenDAO et SemestreDAO
    }

    public Rapport genererRapportsDepartement(int idDepartement) {
        Departement departement = departementDAO.findById(idDepartement);
        if (departement == null) {
            return null;
        }
        
        Rapport rapport = new Rapport();
        rapport.setTitre("Rapport du département - " + departement.getNom());
        rapport.setTypeRapport("Departement");
        rapport.setAuteur("Responsable");
        rapport.setContenu("Rapport généré pour le département: " + departement.getNom());
        rapportDAO.save(rapport);
        
        return rapport;
    }

    public Rapport genererRapportFiliere(int idFiliere) {
        Filiere filiere = filiereDAO.findById(idFiliere);
        if (filiere == null) {
            return null;
        }
        
        Rapport rapport = new Rapport();
        rapport.setTitre("Rapport de la filière - " + filiere.getNom());
        rapport.setTypeRapport("Filiere");
        rapport.setAuteur("Responsable");
        rapport.setContenu("Rapport généré pour la filière: " + filiere.getNom());
        rapportDAO.save(rapport);
        
        return rapport;
    }

    public Statistiques consulterStatistiquesGlobales() {
        Statistiques stats = new Statistiques();
        stats.setTypeStat("Global");
        stats.setPeriode("Annuel");
        stats.setValeur(0f); // À calculer selon les besoins
        return stats;
    }

    public List<Etudiant> listerEtudiantsParFiliere(int idFiliere) {
        return etudiantDAO.findByFiliere(idFiliere);
    }

    public void exporterDonneesExcel() {
        // Exporter toutes les données en Excel
        // Utiliser Apache POI
    }

    public void validerCandidatures(int idSemestre) {
        // Valider les candidatures pour un semestre
        // Cette méthode nécessiterait une table de candidatures
    }

    public void affecterEtudiantsFiliere(int idFiliere, List<Integer> idsEtudiants) {
        if (idsEtudiants == null) {
            return;
        }
        
        for (Integer idEtudiant : idsEtudiants) {
            Etudiant etudiant = etudiantDAO.findById(idEtudiant);
            if (etudiant != null) {
                etudiant.setIdFiliere(idFiliere);
                etudiantDAO.update(etudiant);
            }
        }
    }

    public void ajouterFiliere(Filiere filiere) {
        if (filiere != null) {
            filiereDAO.save(filiere);
        }
    }
}
