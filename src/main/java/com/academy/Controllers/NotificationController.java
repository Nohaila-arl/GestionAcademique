package controllers;

import services.NotificationService;
import java.util.List;

public class NotificationController {
    private NotificationService notificationService;

    public NotificationController() {
        this.notificationService = new NotificationService();
    }

    // POST /notifications/{id}/envoyer
    public void envoyerNotification(int idNotification) {
        notificationService.envoyerNotification(idNotification);
    }

    // POST /notifications/envoyer-groupe
    public void envoyerNotificationGroupe(List<Integer> idsEtudiants) {
        notificationService.envoyerNotificationGroupe(idsEtudiants);
    }

    // POST /notifications/envoyer-filiere/{idFiliere}
    public void envoyerNotificationFiliere(int idFiliere) {
        notificationService.envoyerNotificationFiliere(idFiliere);
    }

    // GET /notifications/{id}/est-lu
    public boolean estLu(int idNotification) {
        return notificationService.estLu(idNotification);
    }

    // GET /notifications/{id}/apercu
    public String getApercu(int idNotification) {
        return notificationService.getApercu(idNotification);
    }
}

