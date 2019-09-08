# Installation de l'environnement pour la formation Spring Boot

## Windows

### Installer le JDK
Téléchargement du JDK :
* Télécharger le jdk 11.0.2 (build 11.0.2+9) pour Windows : https://jdk.java.net/archive/
* Créer le dossier qui va contenir le jdk :   
* Extraire le jdk dans le dossier créé:     

Ajout de JAVA_HOME au Path : 
* Ouvrir le gestionnaire de variable d'environnements
    * rechercher système dans le menu démarrer
    * onglet "Paramètres système avancés" => bouton "Variables d'environnement"
* Créer une variable JAVA_HOME pour l'utilisateur courant ayant pour valeur le chemin vers votre dossier "jdk-11.0.2"
* Sélectionner la variable Path
* Cliquer sur "Modifier..."
* Cliquer sur "Nouveau"
* Ajouter "JAVA_HOME/bin"

### Installer Maven
Téléchargement :
* Télécharger Maven 3.6.2 avec les binaries au format zip: https://maven.apache.org/download.cgi
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
* Ajouter "M2_HOME/bin"

## Intellij IDEA
Télécharger Intellij IDEA Ultimate 
* Télécharger et extraire la ToolBox : https://www.jetbrains.com/toolbox/app/
* Lancer l'éxecutable et installer Intelliji IDEA Ultimate
* Récupérer votre licence Education ici : https://jetbrains.com/shop/eform/students

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

* Aller sur : https://hub.docker.com/?overlay=onboarding
* S'inscrire puis télécharger Docker Desktop Installer.exe
* Exécuter Docker Desktop Installer.exe et suivre les instructions d'installation
* Une fois installé, lancer Docker Desktop.
* Une fois que l'icone de Docker (une balaine avec des carrés empilés dessus) est visible dans la barre des status (en bas à droite de l'écran), Docker est pret à etre utilisé
* Pour tester le succès de l'installation, ouvrir un terminal de commande et entrer : `docker run hello-world`

* Télécharger l'image de mariadb dont vous aurez besoin plus tard : `docker pull mariadb`


