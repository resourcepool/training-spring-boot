# Training Spring Boot
=====

1. Importer le projet dans IntelliJ IDEA en important le fichier "pom.xml" à la racine de ce répertoire

2. Exécuter votre DB mysql. Si vous avez docker, vous pouvez utiliser la commande suivante:
```
docker run --name mariadb --rm -e MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=defaultdb -p 3306:3306 -v "`pwd`/initdb:/docker-entrypoint-initdb.d" mariadb
```

3. Si vous n'avez pas Docker, et que vous avez un serveur MariaDB custom, vérifiez bien que vos utilisateurs / mdp sont les bons par rapport au fichier de configuration (src/main/resources/application.properties), et exécutez les scripts présents dans le dossier `initdb`

4. Tous les scripts sql contenus dans le dossier initdb seront exécutés automatiquement lors du premier chargement de la DB.

5. Lancez l'application via IntelliJ, et vérifiez qu'elle fonctionne sur http://localhost:8080 (par défaut)
