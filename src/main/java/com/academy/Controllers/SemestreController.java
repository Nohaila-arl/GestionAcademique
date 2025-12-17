package controllers;

import services.SemestreService;
import java.util.List;
import models.Etudiant;
import models.Inscription;
import models.Module;
import models.Rapport;

public class SemestreController {
    private SemestreService semestreService;

    public SemestreController() {
        this.semestreService = new SemestreService();
    }

    // POST /semestres/{id}/generer-bulletins
    public void genererBulletins(int idSemestre) {
        semestreService.genererBulletins(idSemestre);
    }

    // POST /semestres/{id}/generer-statistiques
    public void genererStatistiques(int idSemestre) {
        semestreService.genererStatistiques(idSemestre);
    }

    // GET /semestres/{id}/rapport
    public Rapport getRapport(int idSemestre) {
        return semestreService.genererRapport(idSemestre);
    }

    // GET /semestres/{id}/est-actif
    public boolean estActif(int idSemestre) {
        return semestreService.estActif(idSemestre);
    }

    // GET /semestres/{id}/est-cloture
    public boolean estCloture(int idSemestre) {
        return semestreService.estCloture(idSemestre);
    }

    // GET /semestres/{id}/duree-semaines
    public int getDureeEnSemaines(int idSemestre) {
        return semestreService.getDureeEnSemaines(idSemestre);
    }

    // GET /semestres/{id}/modules
    public List<Module> listerModules(int idSemestre) {
        return semestreService.listerModules(idSemestre);
    }

    // GET /semestres/{id}/etudiants
    public List<Etudiant> listerEtudiants(int idSemestre) {
        return semestreService.listerEtudiants(idSemestre);
    }

    // GET /semestres/{id}/inscriptions
    public List<Inscription> listerInscriptions(int idSemestre) {
        return semestreService.listerInscriptions(idSemestre);
    }
}

