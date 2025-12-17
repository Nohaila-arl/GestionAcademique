package com.academy.services;

import com.academy.dao.EtudiantDAO;
import com.academy.dao.PrerequisFiliereDAO;
import com.academy.models.Etudiant;
import com.academy.models.PrerequisFiliere;

public class PrerequisService {
    private PrerequisFiliereDAO prerequisFiliereDAO;
    private EtudiantDAO etudiantDAO;

    public PrerequisService() {
        // Les DAO seront injectés via constructeur ou setters dans une implémentation réelle
    }

    public boolean verifierAdmissibilite(PrerequisFiliere prerequis, Etudiant etudiant) {
        if (prerequis == null || etudiant == null) {
            return false;
        }
        
        // Vérifier l'admissibilité selon le type de prérequis
        switch (prerequis.getTypePrerequis()) {
            case Academique:
                return verifierNiveauAcademique(prerequis, etudiant);
            case Competence:
                return verifierCompetences(prerequis, etudiant);
            case Diplomatique:
                // Vérifier le diplôme de l'étudiant
                return true; // Simplifié
            default:
                return false;
        }
    }

    public boolean verifierNiveauAcademique(PrerequisFiliere prerequis, Etudiant etudiant) {
        if (prerequis == null || etudiant == null) {
            return false;
        }
        
        // Vérifier le niveau académique minimal requis
        String niveauMinimal = prerequis.getNiveauMinimal();
        if (niveauMinimal == null || niveauMinimal.isEmpty()) {
            return true;
        }
        
        // Comparer le niveau de l'étudiant avec le niveau minimal requis
        // Cette logique dépendrait de la structure des données de l'étudiant
        return true; // Simplifié
    }

    public boolean verifierCompetences(PrerequisFiliere prerequis, Etudiant etudiant) {
        if (prerequis == null || etudiant == null) {
            return false;
        }
        
        // Vérifier les compétences requises
        // Cette méthode nécessiterait une table de compétences pour les étudiants
        return true; // Simplifié
    }
}
