# Installation de l'environnement pour la formation Spring Boot

## Windows

### Installer le JDK

Choisir une des deux méthodes d'installation : Téléchargement du JDK ou via clef USB :

Téléchargement du JDK :
* Télécharger le jdk 11.0.2 (build 11.0.2+9) pour Windows : https://jdk.java.net/archive/
* Créer le dossier qui va contenir le jdk    
* Extraire le jdk dans le dossier créé    
 
Depuis la clef USB :
* Récupérer le jdk au format zip : openjdk-11.0.2_windows-x64_bin.zip
* Créer le dossier qui va contenir le jdk    
* Extraire le jdk dans le dossier créé  

Ajout de JAVA_HOME au Path : 
* Ouvrir le gestionnaire de variable d'environnements
    * rechercher système dans le menu démarrer
    * onglet "Paramètres système avancés" => bouton "Variables d'environnement"
* Créer une variable JAVA_HOME pour l'utilisateur courant ayant pour valeur le chemin vers votre dossier "jdk-11.0.2"
* Sélectionner la variable Path
* Cliquer sur "Modifier..."
* Cliquer sur "Nouveau"
* Ajouter "JAVA_HOME\bin"

### Installer Maven

Choisir une des deux méthodes d'installation : Téléchargement de Maven ou via clef USB :

Téléchargement :
* Télécharger Maven 3.6.2 avec les binaries au format zip: https://maven.apache.org/download.cgi
* Créer le dossier qui va contenir Maven    
* Extraire Maven dans le dossier créé     

Depuis la clef USB :
* Récupérer Maven au format zip : apache-maven-3.6.2-bin.zip
* Créer le dossier qui va contenir Maven :   
* Extraire Maven dans le dossier créé:  

Ajout de M2_HOME au Path : 
* Ouvrir le gestionnaire de variable d'environnements
    * rechercher système dans le menu démarrer
    * onglet "Paramètres système avancés" => bouton "Variables d'environnement"
* Créer une variable M2_HOME pour l'utilisateur courant ayant pour valeur le chemin vers votre dossier "apache-maven-3.6.2"
* Sélectionner la variable Path
* Cliquer sur "Modifier..."
* Cliquer sur "Nouveau"
* Ajouter "M2_HOME\bin"

## Intellij IDEA

Choisir une des deux méthodes d'installation : Téléchargement d'Intellij IDEA Ultimate ou via clef USB :

Télécharger Intellij IDEA Ultimate 
* Télécharger et extraire la ToolBox : https://www.jetbrains.com/toolbox/app/
* Lancer l'éxecutable et installer Intelliji IDEA Ultimate
* Récupérer votre licence Education ici : https://jetbrains.com/shop/eform/students

Depuis la clef USB :
* Récupérer Intellij Idea Ultimate : ideaIU-2019.2.2.exe
* Exécuter le .exe et suivre les instructions d'installation 

Créer un nouveau projet :
* Après la création d'un projet Java, vérifier que le projet utilise bien le JDK ajouté précédemment :

* Ouvrir les Settings du projet :
    * Dans "File > Project Structure" (ou "Ctrl + Alt + Maj + S")
* Vérifier que le JDK utilisé est le bon dans la partie "Project"
* Si ce n'est pas le cas :
    * Cliquer sur "New
    * Sélectionner "JDK"
    * Rechercher le dossier d'installation du jdk
* Après la création du projet, si l'IDE ne trouve pas le Maven ajouté précédemment :

* Ouvrir les Settings :
    * Dans "File > Settings" (ou "Ctrl + Alt + S")
    * Taper Maven dans la recherche
    * Cliquer sur les points à droite de l'option "Maven home directory"
    * Rechercher le dossier "maven" ajouté précédemment

## Docker for Windows

Choisir une des deux méthodes d'installation : Téléchargement de Docker For Windows ou via clef USB :

Téléchargement :
* Aller sur https://github.com/docker/toolbox/releases
* Télécharger et exécuter : DockerToolbox-19.03.1.exe

Depuis la clef USB :
* Récupérer Docker For Windows : DockerToolbox-19.03.1.exe
* Exécuter le .exe et suivre les instructions d'installation 

* Choisir 'full installation' et cocher :
    * Docker Compose for Windows
    * Virtual Box
    * Kinematic for Windows
* Cocher :
    * Add Docker Binaries to PATH
    * Upgrade Boot2Docker VM
* Exécuter : Docker Quickstart Terminal
* Une fois l'installation terminée et afin de s'assurer de son succès, saisir `docker run hello-world` dans le terminal de commande
* Télécharger l'image de mariadb dont vous aurez besoin plus tard : `docker pull mariadb`


