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
 * Dans le main, faire une liste de User, en ajouter, et les afficher.

### Afficher des utilisateurs en CLI
 * Dans le main, créer un petit CLI avec un simple Scanner pour lister les usagers (et le default: Unknown Command) `Scanner sc = new Scanner(System.in);`

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
 * Ajouter lombok (pom.xml)
 * Ajouter @RequiredArgsConstructor, @ToString, @HashCode, @Equals sur le pojo
 * Ajouter @RequiredArgsConstructor sur le CLI
 * Injecter le DAO (annoté avec @Service ou @Component)
 * Initialiser la DB avec @PostConstruct
 
## Le Web

### Spring Web MVC
 * Si on remplaçait notre CLI par une page web ?
 * Supprimer le CLI, créer une classe UserController avec Controller et RequestMapping
 * Faire un HelloWorld avec GetMapping et ResponseBody (pour lui forcer à écrire du text/plain)
 * Injecter le DAO et faire le GET /users (juste en toString())
 * Faire une boucle pour afficher ça de manière jolie (en écrivant de l'HTML dans le controller)

### Ma première API
 * C'est moche. Surtout, dur à interpréter pour un ordi. On va utiliser du JSON
 * Changer Controller en RestController, enlever ResponseBody
 * Rajouter @Data et @Builder dans la classe User (pour que Jackson puisse sérialiser / deserialiser)
 * Waouh !

### Ajouter add-users
 * On fait le POST
 * Dur à tester, rajouter swagger
 * Aller voir dans /v3/api-docs et /swagger-ui/index.html
 * Jouer avec Swagger

### Simple JDBC
 * Ajouter le driver JDBC
 * Lancer le container
 * Ajouter un ID à l'Utilisateur
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

