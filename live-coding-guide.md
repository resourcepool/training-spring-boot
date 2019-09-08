# Live Coding Guide
Ce guide est fait pour l'enseignant

## Le CLI

### Startup

 * Aller sur [https://start.spring.io/](https://start.spring.io/) et faire un projet avec Spring Boot, Spring MVC, et Spring Data JPA, en Kotlin
 * Lancer le projet avec Intellij, supprimer la classe Application et renommer le package kotlin en java
 * Leur faire faire cette partie de suite (DL assets)
 * Présenter rapidement maven et commenter les dépendances spring web, spring data et thymeleaf pour plus tard
 * Créer une classe App avec un main et un Hello World
 
### Afficher des utilisateurs
 * Créer une classe User (firstName, lastName, age), et créer les trucs de base (constructeur etc...)
 * Dans le main, faire une liste de User, en ajouter, et les afficher.

### Le CLI
 * Créer une classe CLI, et bouger le code à l'intérieur (dans une méthode run). La DB est passée en argument dans le constructeur
 * Créer un CLI simple avec un Scanner
 * Implémenter le list et le quit (et le default: Unknown Command)
 * Implémenter la création de user
 
### Refactoring 
 * On doit toujours séparer la donnée. Créer une classe UserDAO
 * Porter attention aux méthodes > 10L. On peut les optimiser en disant "que fait ce code?"
 * Sortir les commandes dans des méthodes
 
### Spring
 * La création d'objets est chiante. Ce serait top de l'automatiser. Spring! (pom.xml)
 * Transformer App en SpringBootApplication, et le bean CLI en CommandLineRunner (attention, on disable le web pour l'instant)
 `new SpringApplicationBuilder(App.class).web(NONE).run(args);`
 
## Le Web

### Spring Web MVC
 * Si on remplaçait notre CLI par une page web?
 * Supprimer le CLI, créer une classe UserLibraryController
 * Faire un HelloWorld avec getMapping et responsebody
 * Ajouter le DAO et faire la liste d'utilisateurs (juste en toString())
 * Faire une boucle pour afficher ça de manière jolie (en écrivant de l'HTML dans le controller)
 
### Thymeleaf
 * Ajouter Thymeleaf et faire une belle page dynamique (app.props : spring.thymeleaf.cache=false)
 * La rendre jolie avec Boostrap  
`<body style="background-color: darkslategrey; color: floralwhite;">`  
`<table class="table table-striped table-dark">`  
 `<thead class="thead-light">`  
 `<th scope="col">`  
 `<td scope="row">` (pour chaque première colonne de row))

### Ajouter un user
 * Ajouter une barre de boutons au dessus à droite du tableau
 * Créer la page new avec un form bootstrap
 * Créer la méthode GET dans le controller
 * Ajouter la partie thymeleaf `<form action="#" th:action="@{/new}" th:object="${user}" method="post">` et `th:field="*{firstName}"` sur chaque input
 * Ajouter la méthode `public RedirectView createNewUser(@ModelAttribute User user, RedirectAttributes attrs)`
 * Utiliser un flash attribute

## La DB

### Simple JDBC
 * Ajouter le driver JDBC
 * Lancer le container
 * Le connecter à IntelliJ
 * Remplacer l'ancien DAO par un DAO avec JDBC + mapping
 * Voir que cela marche
 
### Hibernate 
 * Ajouter hibernate (mvn dependency + spring data JPA)
 * Constater que le chargement ne fonctionne plus
 * Ajouter les paramètres manquant dans application.properties  
```
spring.datasource.url=jdbc:mariadb://localhost/defaultdb
spring.datasource.username=root
spring.datasource.password=toor
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
```
 * Migrer vers Spring Data JPA

