# Training Spring Boot

1. Importe le projet dans IntelliJ IDEA en important le fichier "pom.xml" à la racine de ce répertoire


2. Lance et init la bdd avant de run le projet<br>
   (besoin du coup de pouce ?  [III. SetUp de la BDD via Docker](https://github.com/resourcepool/training-spring-boot/tree/readme-setup#iii-setup-de-la-bdd-via-docker))

```
docker run --name mariadb --rm -e MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=defaultdb -p 3306:3306 mariadb
```

3. Connecte la bdd à IntelliJ via l'onglet Database épinglé à droite.<br>
   (besoin du coup de pouce ?  [III.2. Afficher la BDD dans Intellij](https://github.com/resourcepool/training-spring-boot/tree/readme-setup#2-afficher-la-bdd-dans-intellij))


4. Lance les scripts sql contenus dans le dossier `/initdb` : Sélectionne les fichiers .sql, clique droit puis 'Run'.<br>
   (besoin du coup de pouce ?  [III.3. Initialisation de la BDD](https://github.com/resourcepool/training-spring-boot/tree/readme-setup#3-initialisation-de-la-bdd))


5. Lance l'application via IntelliJ, et vérifie qu'elle fonctionne ! (sur http://localhost:8080 par défaut).<br>
   (besoin du coup de pouce ?  [IV. Run du projet (c'est bientôt fini promis !)](https://github.com/resourcepool/training-spring-boot/tree/readme-setup#iv-run-du-projet-cest-bientôt-fini-promis-))
