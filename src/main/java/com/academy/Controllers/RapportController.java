package controllers;

import services.RapportService;

public class RapportController {
    private RapportService rapportService;

    public RapportController() {
        this.rapportService = new RapportService();
    }

    // POST /rapports/{id}/generer
    public void genererRapport(int idRapport) {
        rapportService.genererRapport(idRapport);
    }

    // POST /rapports/generer-filiere/{idFiliere}
    public void genererRapportFiliere(int idFiliere) {
        rapportService.genererRapportFiliere(idFiliere);
    }

    // POST /rapports/generer-departement/{idDepartement}
    public void genererRapportDepartement(int idDepartement) {
        rapportService.genererRapportDepartement(idDepartement);
    }

    // POST /rapports/generer-enseignant/{idEnseignant}
    public void genererRapportEnseignant(int idEnseignant) {
        rapportService.genererRapportEnseignant(idEnseignant);
    }

    // GET /rapports/{id}/generer-pdf
    public void genererPDF(int idRapport) {
        rapportService.genererPDF(idRapport);
    }

    // GET /rapports/{id}/exporter-excel
    public void exporterExcel(int idRapport) {
        rapportService.exporterExcel(idRapport);
    }

    // GET /rapports/{id}/exporter-csv
    public void exporterCSV(int idRapport) {
        rapportService.exporterCSV(idRapport);
    }

    // POST /rapports/{id}/envoyer-email
    public void envoyerParEmail(int idRapport, String destinataire) {
        rapportService.envoyerParEmail(idRapport, destinataire);
    }

    // GET /rapports/{id}/contenu
    public String consulterContenu(int idRapport) {
        return rapportService.consulterContenu(idRapport);
    }

    // POST /rapports/{id}/ajouter-section
    public void ajouterSection(int idRapport, String section) {
        rapportService.ajouterSection(idRapport, section);
    }

    // POST /rapports/{id}/archiver
    public void archiver(int idRapport) {
        rapportService.archiver(idRapport);
    }

    // POST /rapports/{id}/restaurer
    public void restaurer(int idRapport) {
        rapportService.restaurer(idRapport);
    }
}

