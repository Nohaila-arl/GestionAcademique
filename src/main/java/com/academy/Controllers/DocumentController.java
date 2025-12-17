package controllers;

import services.DocumentService;

public class DocumentController {
    private DocumentService documentService;

    public DocumentController() {
        this.documentService = new DocumentService();
    }

    // GET /documents/{id}/telecharger
    public void telecharger(int idDocument) {
        documentService.telecharger(idDocument);
    }

    // POST /documents/{id}/partager
    public void partager(int idDocument) {
        documentService.partager(idDocument);
    }

    // POST /documents/{id}/notifier-etudiants
    public void notifierEtudiants(int idDocument) {
        documentService.notifierEtudiants(idDocument);
    }

    // GET /documents/{id}/chemin-fichier
    public String getCheminFichier(int idDocument) {
        return documentService.getCheminFichier(idDocument);
    }

    // GET /documents/{id}/taille-fichier
    public long getTailleFichier(int idDocument) {
        return documentService.getTailleFichier(idDocument);
    }

    // GET /documents/{id}/extension
    public String getExtension(int idDocument) {
        return documentService.getExtension(idDocument);
    }
}

