# <img src="graphics/logo.svg" width="25"> Potato TV - Student Project
![Logo](graphics/banner.png)
## Contributors
- [Arnaud de Saint Méloir](http://github.com/arnaudsm/)
- [Coumba Ndiaye](https://github.com/slevine95)
- Marianne Strassburger

## Todo
### Databases
- [ ] `users` with `varchar user_name, varchar password_hash, int autoincrement user_id`
- [ ] `seen_episodes` with `long_Int show_id, int season_id, int episode_id, int duration_min, int user_id`
### Functions
- [ ] `Create_User(varchar user_name, varchar password)=Boolean success` 
- [ ] `Login_User(varchar user_name, varchar password)=Boolean success` 
- [ ] `Add_Episode(long_Int show_id, int season_id, int episode_id, int duration_min, int user_id)=Boolean success` 
- [ ] `Time_Spent(int user_id)=int total_duration` 
### Interface
- [ ] Latest Shows
- [ ] Show page
- [ ] Profile : Seen Shows and total time


## Launch
1. Cloner le projet en utilisant la commande `git clone https://github.com/resourcepool/formation-spring-boot`

2. Importer le projet dans IntelliJ IDEA en important le fichier "pom.xml" à la racine de ce repository.

3. Exécuter votre DB mysql. Si vous avez docker, vous pouvez utiliser la commande suivante:
```
docker run --name mariadb --rm -e MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=defaultdb -p 3306:3306 -v "`pwd`/initdb:/docker-entrypoint-initdb.d" mariadb
```

4. Tous les scripts sql contenus dans le dossier initdb seront exécutés automatiquement lors du premier chargement de la DB.
