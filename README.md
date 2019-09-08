# Training Spring Boot
=====

1. Cloner le projet en utilisant la commande `git clone https://github.com/resourcepool/formation-spring-boot`

2. Importer le projet dans IntelliJ IDEA en important le fichier "pom.xml" à la racine de ce repository.

3. Exécuter votre DB mysql. Si vous avez docker, vous pouvez utiliser la commande suivante:
```
docker run --name mariadb --rm -e MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=defaultdb -p 3306:3306 -v "`pwd`/initdb:/docker-entrypoint-initdb.d" mariadb
```

4. Tous les scripts sql contenus dans le dossier initdb seront exécutés automatiquement lors du premier chargement de la DB.
