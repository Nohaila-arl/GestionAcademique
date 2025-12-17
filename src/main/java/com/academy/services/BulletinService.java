package com.academy.services;

import java.util.List;

import com.academy.dao.BulletinDAO;
import com.academy.dao.ModuleDAO;
import com.academy.dao.NoteDAO;
import com.academy.models.Bulletin;
import com.academy.models.Module;
import com.academy.models.Note;

public class BulletinService {
    private BulletinDAO bulletinDAO;
    private NoteDAO noteDAO;
    private ModuleDAO moduleDAO;

    public BulletinService() {
        // Les DAO seront injectés via constructeur ou setters dans une implémentation réelle
    }

    public float calculerMoyenne(int idBulletin) {
        Bulletin bulletin = bulletinDAO.findById(idBulletin);
        if (bulletin == null) {
            return 0f;
        }
        
        List<Note> notes = listerNotes(idBulletin);
        if (notes == null || notes.isEmpty()) {
            return 0f;
        }
        
        float somme = 0f;
        int totalCredits = 0;
        
        for (Note note : notes) {
            Module module = moduleDAO.findById(note.getIdModule());
            if (module != null) {
                int credits = module.getCredits();
                somme += note.getMoyenneFinale() * credits;
                totalCredits += credits;
            }
        }
        
        return totalCredits > 0 ? somme / totalCredits : 0f;
    }

    public String genererDecision(int idBulletin) {
        float moyenne = calculerMoyenne(idBulletin);
        
        if (moyenne >= 10.0f) {
            return Bulletin.Decision.Valide.name();
        } else if (moyenne >= 7.0f) {
            return Bulletin.Decision.Rattrapage.name();
        } else {
            return Bulletin.Decision.NonValide.name();
        }
    }

    public String attribuerMention(int idBulletin) {
        float moyenne = calculerMoyenne(idBulletin);
        
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

    public int calculerCreditsValides(int idBulletin) {
        Bulletin bulletin = bulletinDAO.findById(idBulletin);
        if (bulletin == null) {
            return 0;
        }
        
        List<Note> notes = listerNotes(idBulletin);
        if (notes == null) {
            return 0;
        }
        
        int creditsValides = 0;
        for (Note note : notes) {
            if (note.getMoyenneFinale() >= 10.0) {
                Module module = moduleDAO.findById(note.getIdModule());
                if (module != null) {
                    creditsValides += module.getCredits();
                }
            }
        }
        
        return creditsValides;
    }

    public int calculerCreditsObtenus(int idBulletin) {
        Bulletin bulletin = bulletinDAO.findById(idBulletin);
        if (bulletin == null) {
            return 0;
        }
        
        List<Note> notes = listerNotes(idBulletin);
        if (notes == null) {
            return 0;
        }
        
        int creditsObtenus = 0;
        for (Note note : notes) {
            Module module = moduleDAO.findById(note.getIdModule());
            if (module != null) {
                creditsObtenus += module.getCredits();
            }
        }
        
        return creditsObtenus;
    }

    public void genererBulletin(int idBulletin) {
        Bulletin bulletin = bulletinDAO.findById(idBulletin);
        if (bulletin != null) {
            // Calculer et mettre à jour la moyenne
            float moyenne = calculerMoyenne(idBulletin);
            bulletin.setMoyenneGenerale(moyenne);
            
            // Générer la décision
            String decisionStr = genererDecision(idBulletin);
            bulletin.setDecision(Bulletin.Decision.valueOf(decisionStr));
            
            // Attribuer la mention
            String mention = attribuerMention(idBulletin);
            bulletin.setMention(mention);
            
            // Mettre à jour le bulletin
            bulletinDAO.update(bulletin);
        }
    }

    public void afficherBulletin(int idBulletin) {
        Bulletin bulletin = bulletinDAO.findById(idBulletin);
        if (bulletin != null) {
            // Logique d'affichage du bulletin
            // Dans une implémentation réelle, cela pourrait retourner un objet DTO ou une vue
        }
    }

    public void exporterPDF(int idBulletin) {
        Bulletin bulletin = bulletinDAO.findById(idBulletin);
        if (bulletin != null) {
            // Logique d'exportation en PDF
            // Dans une implémentation réelle, utiliserait une bibliothèque comme iText ou Apache PDFBox
        }
    }

    public void envoyerParEmail(int idBulletin) {
        Bulletin bulletin = bulletinDAO.findById(idBulletin);
        if (bulletin != null) {
            // Logique d'envoi par email
            // Dans une implémentation réelle, utiliserait un service d'email
        }
    }

    public List<Note> listerNotes(int idBulletin) {
        Bulletin bulletin = bulletinDAO.findById(idBulletin);
        if (bulletin == null) {
            return null;
        }
        
        // Récupérer toutes les notes de l'étudiant pour le semestre
        return noteDAO.findByEtudiant(bulletin.getIdEtudiant());
    }

    public String getObservations(int idBulletin) {
        Bulletin bulletin = bulletinDAO.findById(idBulletin);
        if (bulletin != null) {
            // Les observations pourraient être stockées dans le bulletin ou calculées
            float moyenne = calculerMoyenne(idBulletin);
            String decision = genererDecision(idBulletin);
            return "Moyenne: " + moyenne + " - Décision: " + decision;
        }
        return null;
    }
}

