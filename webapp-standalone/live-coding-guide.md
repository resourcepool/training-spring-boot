# Live Coding Guide
Ce guide est fait pour l'enseignant

## Le CLI

### Startup

 * Aller sur [https://start.spring.io/](https://start.spring.io/) et faire un projet avec Spring Boot, Spring Web, Thymeleaf, et Spring Data JPA, en Java
 * Lancer le projet avec Intellij, supprimer la classe Application
 * Leur faire faire cette partie de suite (DL assets)
 * Présenter rapidement maven et **commenter les dépendances** spring web, spring data et thymeleaf pour plus tard
 * Créer une classe App avec un main et un Hello World
 
### Afficher des utilisateurs
 * Créer une classe User (firstName, lastName, age), et créer les trucs de base (constructeur etc...)
 * Montrer qu'on peut aller plus vite avec Record depuis java 17
 * Dans le main, faire une liste de User, en ajouter, et les afficher.

### Afficher des utilisateurs en CLI
 * Dans le main, créer un petit CLI avec un simple Scanner pour lister les usagers (et le default: Unknown Command)

### Le CLI
 * Créer une classe CLI, et bouger le code à l'intérieur (dans une méthode run). La DB est passée en argument dans le constructeur
 * Implémenter le quit
 * Implémenter la création de user (privilégier `Interger.parseInt(sc.next())` à la méthode `sc.nextInt()` pour la gestion de l'exception)
 
### Refactoring 
 * On doit toujours séparer la donnée. Créer une classe UserDAO
 * Porter attention aux méthodes > 10L. On peut les optimiser en disant "que fait ce code?"
 * Sortir les commandes dans des méthodes
 
### Spring
 * La création d'objets est chiante. Ce serait top de l'automatiser. Spring! (pom.xml)
 * Annoter App en `@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })`
 * On disable le web pour l'instant : psvm `new SpringApplicationBuilder(App.class).web(NONE).run(args);` (ou `spnoweb`)
 * Implémenter le bean CLI en CommandLineRunner
 
## Le Web

### Spring Web MVC
 * Si on remplaçait notre CLI par une page web?
 * Supprimer le CLI, créer une classe UserLibraryController
 * Faire un HelloWorld avec GetMapping et ResponseBody
 * Ajouter le DAO et faire la liste d'utilisateurs (juste en toString())
 * Faire une boucle pour afficher ça de manière jolie (en écrivant de l'HTML dans le controller)
 
### Thymeleaf
 * Ajouter Thymeleaf et faire une belle page HelloWorld dynamique (app.props : spring.thymeleaf.cache=false)
 * Ajouter un `Model m` dans les arguments de la méthode
 * Faire un petit template rapide en html  
`<body>`  
 * Implémenter le template Thymeleaf (`tlhtml`)
```html
 <html xmlns:th="http://www.thymeleaf.org" lang="fr">
    <head>
      <title>Library</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    </head>
  </html>
```
 * Ajouter le tableau dynamique (`tltable`)
```html
<body>
<h1><strong>Bienvenue sur mon app de ouf</strong></h1>
<hr class="my-5"/>
<div>
    <table>
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
        </tr>
        </thead>
        <tbody>
        <tr th:each="u : ${users}">
            <td th:text="${u.firstName()}"></td>
            <td th:text="${u.lastName()}"></td>
            <td th:text="${u.age()}"></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
```
  * Appliquer la magie avec Bootstrap et un peu de CSS (`tlbootstrap`)
```html
<html xmlns:th="http://www.thymeleaf.org" lang="fr">
<head>
    <title>Library</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <style>
        body {
            background: #18282c;
            color: #eee;
        }
        th {
            font-weight: bold;
            color: #45CFCC;
        }
    </style>
</head>
<body>

<div class="container my-5">
    <section>
        <h1 class="text-center"><strong>Bienvenue sur mon app de ouf</strong></h1>
        <hr class="my-5"/>
    </section>
</div>
<div class="container d-flex flex-column align-items-center justify-content-center">
    <table class="table table-dark table-striped table-group-divider">
        <thead>
        <tr>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Age</th>
        </tr>
        </thead>
        <tbody>
        <tr th:each="u : ${users}">
            <td th:text="${u.firstName()}"></td>
            <td th:text="${u.lastName()}"></td>
            <td th:text="${u.age()}"></td>
        </tr>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
</body>
</html>
```

### Ajouter un user
 * Ajouter une barre de boutons au dessus à droite du tableau
 * Créer la page new avec un form bootstrap (`tlform`)
 * Créer la méthode GET dans le controller
 * Ajouter la partie thymeleaf `<form action="#" th:action="@{/new}" th:object="${user}" method="post">` et `th:field="*{firstName}"` sur chaque input (`tlfieldtext`)
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
 * Ajouter les paramètres manquant dans application.properties (`propsjpa`) 
```
spring.datasource.url=jdbc:mariadb://localhost/defaultdb
spring.datasource.username=root
spring.datasource.password=toor
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
```
 * Migrer vers Spring Data JPA

