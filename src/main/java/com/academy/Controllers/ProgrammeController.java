package controllers;

import services.ProgrammeService;
import models.Rapport;

public class ProgrammeController {
    private ProgrammeService programmeService;

    public ProgrammeController() {
        this.programmeService = new ProgrammeService();
    }

    // GET /programmes/{id}/verifier-coherence
    public boolean verifierCoherence(int idProgramme) {
        return programmeService.verifierCoherence(idProgramme);
    }

    // GET /programmes/{id}/total-credits
    public int getTotalCredits(int idProgramme) {
        return programmeService.calculerTotalCredits(idProgramme);
    }

    // GET /programmes/{id}/respecte-contraintes
    public boolean respecteConstraintes(int idProgramme) {
        return programmeService.respecteConstraintes(idProgramme);
    }

    // GET /programmes/{id}/rapport
    public Rapport getRapport(int idProgramme) {
        return programmeService.genererRapport(idProgramme);
    }

    // GET /programmes/{id}/exporter
    public void exporterProgramme(int idProgramme) {
        programmeService.exporterProgramme(idProgramme);
    }
}

