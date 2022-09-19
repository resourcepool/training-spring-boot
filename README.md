# Training Spring Boot

## I. Installation
**2 méthodes d'installation sont possibles : par téléchargements Internet ou par Clé USB**
### Windows
#### Par téléchargements Internet : 
- Docker : https://docs.docker.com/desktop/install/windows-install/
- Intellij : https://www.jetbrains.com/fr-fr/idea/download/#section=windows

#### Par clé : 
- Récupérer le fichier **Windows** et exécuter les .exe

### Mac 
Pour les puces M1 ou M2 choisir *Apple Chip* & *(Apple Silicone)*
Pour les puces Intel choisir *Intel Chip* & *(Intel)*

#### Par téléchargements Internet :
- Docker  : https://docs.docker.com/desktop/install/mac-install/
- Intellij : https://www.jetbrains.com/fr-fr/idea/download/#section=mac

#### Par clé : 
- Récupérer le fichier **Mac** correspondant à la bonne puce et exécuter les .exe

### Linux 
#### Commandes pour les installations : 
- Docker : <br>
  - `curl -fsSL https://get.docker.com -o get-docker.sh` <br>
  - `sudo sh get-docker.sh`
  - `sudo usermod -aG docker $USER` 
- Intellij : <br>
  - `sudo snap install intellij-idea-ultimate --classic`

#### Par clé : 
- Récupérer les lignes de commandes dans le fichier du dossier Linux

## II. SetUp Intellij 
### 1. Création compte 
Intellij est un IDE super complet et est devenu un indispensable pour le dévelopement de projet Java. <br> 

Avec ses recherches de fichiers optimisées, auto-complétions et raccourcis à gogo, Intellij améliore grandement l'expérience de développement. Le Graal étant que maven est intégré de base et que tu peux
télécharger n'importe quelle version de Java depuis IntelliJ (non ce n'est pas un rêve !)<br>

Cerise sur le gateaux grâce à ton compte EPF, tu peux gratuitement obtenir une licence de la version payante (ultimate). <br>
Elle est essentielle au bon déroulement du TP car avec cette derniere tu pourras notamment visualiser ta base de donnée et intéragire avec elle directement depuis IntelliJ. <br>
Pour te créer un compte, suis ce lien et effectue les actions détaillées ci-dessous : https://www.jetbrains.com/fr-fr/idea/
![img.png](img-readme/img.png)
![img.png](img-readme/img2.png)

### 2. Licence Intellij
Pour récupérer une licence gratuite utilise ce lien : https://jetbrains.com/shop/eform/students

### 3. Lancer Intellij 
Une fois ta licence récupérer, lance l'IDE et relie ton compte
![img.png](img-readme/img3.png)
![img.png](img-readme/img4.png)

### 4. Clonage du projet 
Pour récupérer le repository GitHub du TP lance `git clone https://github.com/resourcepool/training-spring-boot.git`

Tu y trouveras toutes les ressources nécessaire à la suite du TP.

Dans Intellij, effectue ensuite les actions suivantes : 
![img.png](img-readme/img5.png)
![img_1.png](img-readme/img6.png)

### 5. Téléchargement de Java 17
Depuis Intellij, tu peux directement télécharger Java 17 :
![img.png](img-readme/img7.png)
![img_1.png](img-readme/img8.png)
![img_2.png](img-readme/img9.png)
![img_3.png](img-readme/img10.png)

### 6. Ouvrir un terminal dans Intellij 
![img.png](img-readme/img11.png)
<br>
Tu peux également changer de Shell (Surtout utile pour les Windows)
<br>
![img.png](img-readme/img12.png)

<br>
Sélectionner *Git Bash*
<br>


![img_1.png](img-readme/img13.png)

## III. SetUp de la BDD via Docker
### 1. Docker
Lance le Docker Desktop en cliquant sur l'icône, tu dois obtenir l'écran suivant :
![img.png](img-readme/img14.png)
Ferme et ré-ouvre ton application IntelliJ pour que les changements effectués par l'installation de docker soit pris en compte.<br>
Pour s'assurer que ton install Docker a bien fonctionné lance la commande suivante dans ton terminal :  <br>
`docker run hello-world` <br>
Tu dois obtenir ce résultat : 
![img.png](img-readme/img15.png)

Tu peux alors lancer la base de données MariaDB qui sera utilisé tout au long du TP :<br>
`docker run --name mariadb --rm -e MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=defaultdb -p 3306:3306 mariadb`

### 2. Afficher la BDD dans Intellij 
Effectue les étapes suivantes : 
![img.png](img-readme/img16.png)
![img_1.png](img-readme/img17.png)

Installe les drivers si besoin : 
![img_2.png](img-readme/img18.png)

Saisie les infos (1-3), puis test la connexion à la bdd (4) 
![img_3.png](img-readme/img19.png)
![img_4.png](img-readme/img20.png) <br> 
Si c'est valide, clique sur *OK* (5)

### 3. Initialisation de la BDD
C'est cool d'avoir une BDD qui fonctionne mais c'est encore plus cool quand on peut lui insérer des données en 2 clics :
![img_5.png](img-readme/img21.png)
Clic droit + run : 
![img_6.png](img-readme/img22.png)
![img_7.png](img-readme/img23.png)

Tadaaaam (j'avoue un peu plus que 2 clics)
![img_8.png](img-readme/img24.png)

## IV. Run du projet (c'est bientôt fini promis !)
**Deux** façons de faire : 
![img.png](img-readme/img25.png)

**OU**
![img_1.png](img-readme/img26.png)

Ca ouvre : 
![img_2.png](img-readme/img27.png)
Sélectionne le Java 17 préalablement téléchargé et ajoute l'option `-Xms256m -Xmx256m` (c'est pour éviter que Intellij mange toute ta RAM)
![img_3.png](img-readme/img28.png)
![img_4.png](img-readme/img29.png)
![img_5.png](img-readme/img30.png)

Enfin : 
![img_6.png](img-readme/img31.png)
Alors ça marche ?
![img.png](img-readme/img32.png)


