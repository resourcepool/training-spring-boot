Projet gestion des codes reviews
===================
L'objectif de ce projet est de créer une outil de gestion des code reviews

# Le projet      
L'objectif est de créer une application pour gérer et programmer des relectures de code. 
En particulier, les fonctionnalités suivantes seront requises :
  * Créer un nouveau membre : nom, email, date de naissance, groupe
  * Créer un groupe: nom, membres
  * Programmer une code review: nom, description, date / heure, groupe

Un **membre** peut être éditer et appartient à un groupe. Il a un nom, un email et une date de naissance.

Un **groupe** est un ensemble de membres. Il lui faut un nom et a entre 0 et une infinité de membres. Les utilisateurs sont membres d'un groupe au maximum.  

Une **code review** est une réunion de membres d'un groupe. Elle **doit** avoir une date & heure, une description et le groupe qui sera présent.  

Vous ne devez pas implémenter de sécurité comme le login ou les comptes utilisateurs pour le moment. 

# Bonus
Vous avez déjà **tout terminé** ?
Voici quelques features qui rendront votre plateforme encore plus attrayante :
 * Ajouter un timer en plein écran qui donne le compte à rebours avant la prochaine code review, pour chaque groupe (à afficher sur une télévision) 
 * Ajouter une barre de recherche
 * Gérer plusieurs compte à rebours
 * Ajouter la personne qui s'occupera de relire le code à une code review
 * Se connecter à l'API Google Agenda
 * Envoyer des notifications par e-mail (des rappels)
 * Implémenter les tests du backend

