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

Avec ses recherches de fichiers optimisées, auto-complétions et raccourcis à gogo, Intellij améliore grandement l'expérience de développement. 
Le Graal étant que maven y est de base intégré et que tu puisses
télécharger n'importe quelle version de Java directement depuis ton IDE (non ce n'est pas un rêve !)<br>

Cerise sur le gateaux grâce à ton compte EPF, tu peux gratuitement obtenir une licence de la version payante (ultimate).
Elle est essentielle au bon déroulement du TP car avec cette derniere tu pourras notamment visualiser ta base de donnée et intéragire avec elle directement depuis IntelliJ. <br>
Pour te créer un compte, suis ce lien et effectue les actions détaillées ci-dessous : https://www.jetbrains.com/fr-fr/idea/

<p align="center">
<img src="img-readme/img.png" width="500"/>
<img src="img-readme/img2.png" width="500"/>
</p>

### 2. Licence Intellij
Pour récupérer une licence gratuite utilise ce lien : https://jetbrains.com/shop/eform/students

### 3. Lancer Intellij 
Une fois ta licence récupérer, lance l'IDE et relie ton compte
<p align="center">
<img src="img-readme/img3.png" width="600"/>
<img src="img-readme/img4.png" width="600"/>
</p>

### 4. Clonage du projet 
Pour récupérer le repository GitHub du TP lance `git clone https://github.com/resourcepool/training-spring-boot.git`

Tu y trouveras toutes les ressources nécessaires à la suite du TP.

Dans Intellij, effectue ensuite les actions suivantes :
<p align="center">
<img src="img-readme/img5.png" width="400"/>
<img src="img-readme/img6.png" width="400"/>
</p>

### 5. Téléchargement de Java 17
Depuis Intellij, tu peux directement télécharger Java 17 : <br>
<p align="center">
<img src="img-readme/img7.png"/>
<img src="img-readme/img8.png" width="600"/>
<img src="img-readme/img9.png" width="600"/>
<img src="img-readme/img10.png" width="600"/>
</p>

### 6. Ouvrir un terminal dans Intellij 
<p align="center">
<img src="img-readme/img11.png" width="600"/>
</p>
<br>
Tu peux également changer de Shell (Surtout utile pour les Windows)<br>
<p align="center">
<img src="img-readme/img12.png" width="500"/>
</p>
<br>

Sélectionne *Git Bash*
<p align="center">
<img src="img-readme/img13.png" width="500"/>
</p>

## III. SetUp de la BDD via Docker
### 1. Docker
Lance le Docker Desktop en cliquant sur l'icône, tu dois obtenir l'écran suivant :
<p align="center">
<img src="img-readme/img14.png" width="800"/>
</p>
Ferme et ré-ouvre ton application IntelliJ pour que les changements effectués par l'installation de docker soit pris en compte.<br>
Pour s'assurer que ton install Docker a bien fonctionné lance la commande suivante dans ton terminal :  <br>
`docker run hello-world` <br>
Tu dois obtenir ce résultat : <br>
<p align="center">
<img src="img-readme/img15.png" width="600"/>
</p>

Tu peux alors lancer la base de données MariaDB qui sera utilisé tout au long du TP :<br>
`docker run --name mariadb --rm -e MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=defaultdb -p 3306:3306 mariadb`

### 2. Afficher la BDD dans Intellij 
Effectue les étapes suivantes : 
<p align="center">
<img src="img-readme/img16.png" width="700"/>
<img src="img-readme/img17.png" width="700"/>
</p>

Installe les drivers si besoin : 
<p align="center">
<img src="img-readme/img18.png" width="500"/>
</p>

Saisie les infos (1-3), puis test la connexion à la bdd (4)
<p align="center">
<img src="img-readme/img19.png" width="500"/>
<img src="img-readme/img20.png"/>
</p><br> 
Si c'est valide, clique sur *OK* (5)

### 3. Initialisation de la BDD
C'est cool d'avoir une BDD qui fonctionne mais c'est encore plus cool quand on peut lui insérer des données en 2 clics :
<p align="center">
<img src="img-readme/img21.png" width="500"/>
</p>
Clic droit + run : 
<p align="center">
<img src="img-readme/img22.png" width="400"/>
<img src="img-readme/img23.png" width="500"/>
</p>

Tadaaaam (j'avoue un peu plus que 2 clics)
<p align="center">
<img src="img-readme/img24.png" width="500"/>
</p>

## IV. Run du projet (c'est bientôt fini promis !)
**Deux** façons de faire : 
<p align="center">
<img src="img-readme/img25.png" width="600"/>
</p>

**OU**
<p align="center">
<img src="img-readme/img26.png" width="600"/>
</p>

Ca ouvre : 
<p align="center">
<img src="img-readme/img27.png" width="600"/>
</p>
Sélectionne le Java 17 préalablement téléchargé et ajoute l'option `-Xms256m -Xmx256m` (c'est pour éviter que Intellij mange toute ta RAM)<br>
<p align="center">
<img src="img-readme/img28.png" width="600"/>
<img src="img-readme/img29.png" />
<img src="img-readme/img30.png" width="500"/>
</p>
Enfin :<br>
<p align="center"><img src="img-readme/img31.png" width="800"/></p>

Alors ça marche ?
<p align="center"><img src="img-readme/img32.png" width="900"/></p>


