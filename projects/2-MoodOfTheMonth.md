# Mood of the Month

Le but de ce projet est de créer un site qui pourra récolter le mood des utilisateurs. 

# The Project
Votre but est de créer à la fois une plateforme d'administration et une plateforme utilisateur pour connaître l'humeur des employés sur le dernier mois.
Tous les derniers vendredi du mois, aux alentours de 10:00 par exemple, l'application mood of the mont enverra un email à chaque employé avec un lien. En suivant le lien, chaque employé pourra donner une note (1 à 5) correspondant à son ressenti sur le mois qu'il a passé, et s'il le souhaite, permettra de laisser un commentaire anonyme.

Les fonctionnalités ci-dessous doivent être implémentées :  

**Admin panel:**
  * Créer un nouvel utilisateur : nom, email, date de naissance, id.
  * Créer une nouvelle template MOTM (Mood Of The Month) : titre, message, id.
  * Voir les statistiques MOTM.

**Client panel:**
  * Répondre au MOTM.
  * Modifier une réponse précédente.

Un **employé** peut être édité. Il a un nom, un email et une date de naissance. Chaque utilisateur a également un identifiant unique (uuid).
Un **MOTM** contient un titre, un message et un identifiant unique.
A **MOTM** contains a title, a message template, and a page template.

Pas besoin d'implémenter de procédure de sécurité ou de système de connexion pour le moment.

# Bonus
Vous avez fini?
Voici quelques features que vous devriez faire:
 * Ajouter un dashboard fullscreen avec l'évolution du Mood Of The Month global correspondant aux **n** derniers mois. 
 * Fonctionnalité permettant d'imprimer un rapport du MOTM.
 * Export au format CSV. 
 * Ajouter plusieurs questions sur les MOTM.
 * Envoyer un rapport aux utilisateurs tous les mois, de manière automatique.
 * Envouyer plusieurs mails de notification (reminders).
 * Implémenter des tests unitaires côté backend.
