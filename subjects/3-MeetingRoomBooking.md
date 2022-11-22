Réservation de salles de réunion
===========
L'objectif de ce projet est de créer une application de réservation de salles. 
# Le projet 
Vous devez créer à la fois une section `publique` et une section `administration`.
N'importe quel utilisateur doit pouvoir réserver une salle pour une durée spécifique à la date et l'heure qu'il veut, ou bien dès que la salle est disponible. 
Chaque salle de réunion a un dashboard où tout le monde peut voir les disponibilités et réserver la salle (on peut imaginer placer une tablette devant chaque salle avec ce dashboard).

En particulier, les fonctionnalités suivantes seront requises :

**Panneau d'administration:**
  * Créer et éditer un membre: nom, e-mail, date de naissance, id
  * Créer et éditer une salle : nom, photo, capacité (X personnes), équipement (écran, tableau, ...), id
  * Réserver une salle à une date et heure spécifique avec des contraintes
  * Voir quelles salles sont libres
  * Inviter des membres à la salle de réunion
  * Envoyer des e-mails aux membres invités (avec une carte ICS pouvant être lier à un calendrier)

**Partie publique:**
  * Voir le calendrier d'une salle de réunion
  * Voir les membres d'une réunion
  * Réserver une salle

Un **membre** peut être éditer. Il a un nom, un email, une date de naissance. Chaque utilisateur a un identifiant unique (uuid). 

Une **salle de réunion** a un nom, une photo, une capacité et un identifiant unique. Elle peut avoir plus d'attributs ;).

Vous devrez implémenter un ensemble de règles de réservation et de contraintes pour réserver une salle comme : 
 - J'ai besoin d'un salle pour X personnes
 - J'en ai besoin pour Y heures et Z minutes
 - J'ai besoin d'une télévision pour afficher mes diapos
 - J'ai besoin d'un tableau
 - De préférence le matin
 - Dès que possible / la semaine prochaine / le mois prochain
 - De préférence dans la salle 1 / salle 1 ou 3

Certaines contraintes ou combinaisons de contraintes ne seront pas possible, il faudra en informer l'utilisateur et proposer une meilleur solution ou une alternative...

Vous n'avez pas à implémenter la sécurité comme la connexion ou le compte utilisateur pour le moment.

# Bonus
Vous avez déjà **tout terminé** ?
Voici quelques features qui rendront votre plateforme encore plus attrayante :

 * Faire un lien avec Google Calendar
 * Ajouter un moteur de recommandations dans le cas où une salle n'est pas disponible
 * Envoyer des rappels de réunion par e-mail 
 * Implémenter les tests de votre backend. 
