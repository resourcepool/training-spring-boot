# Installation de l'environnement pour la formation Spring Boot

## Avec Clé USB

### Copie

Copier tout le folder macos de votre clé USB sur votre Bureau, et ouvrez un terminal dans ce dossier.

### Installer le JDK

Dans le dossier macos, exécuter la commande suivante :  
`sudo tar -xzvf openjdk-12.0.2_osx-x64_bin.tar.gz -C /Library/Java/JavaVirtualMachines/`

Ajouter la ligne suivante à votre fichier `~/.profile` :  
`export JAVA_HOME=$(/usr/libexec/java_home -v 12.0.2)`

Fermer et relancer votre terminal

### Installer Maven

Dans le dossier macos, exécuter les commande suivante en tant qu'utilisateur (non root!) :  
`mkdir -p ~/opt`  
`tar -xzvf apache-maven-3.6.2-bin.tar.gz -C ~/opt/`
`ln -s ~/opt/apache-maven-3.6.2 ~/opt/apache-maven`

Ajouter les lignes suivante à votre fichier `~/.profile` :  
`export PATH=$PATH:~/opt/apache-maven/bin`
`export M2_HOME=~/opt/apache-maven`

### Installer Docker Desktop

Dans le dossier macos, exécuter le fichier `Docker.dmg`

Télécharger l'image de mariadb dont vous aurez besoin plus tard :  
`docker pull mariadb`

### Installer Intellij IDEA

Dans le dossier macos, exécuter le fichier `ideaIU-2019.2.2.dmg`

Récupérer votre licence Education ici : [https://jetbrains.com/shop/eform/students](https://jetbrains.com/shop/eform/students)  

-----

## Mac OSX avec Homebrew

### Installer Homebrew
`/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`

### Installer OpenJDK 12

`brew tap AdoptOpenJDK/openjdk`

`brew cask install adoptopenjdk12`

### Installer Maven

`brew install maven`

### Installer Docker desktop

Télécharger docker desktop ici :  
[https://hub.docker.com/editions/community/docker-ce-desktop-mac](https://hub.docker.com/editions/community/docker-ce-desktop-mac)

Télécharger l'image de mariadb dont vous aurez besoin plus tard :  
`docker pull mariadb`

#### Installer IntelliJ Idea

[https://www.jetbrains.com/idea/](https://www.jetbrains.com/idea/)

Récupérer votre licence Education ici : [https://jetbrains.com/shop/eform/students](https://jetbrains.com/shop/eform/students)  

-----


## Troubleshoot

* Après la création d'un projet Java, vérifier que le projet utilise bien le JDK ajouté précédemment :
    * Ouvrir les Settings du projet sous "File > Project Structure"
    * Vérifier que le JDK utilisé est le bon dans la partie "Project"
    * Si ce n'est pas le cas
        * Cliquer sur "New
        * Sélectionner "JDK"
        * Rechercher le dossier "jdk12" dans votre architecture (/Library/Java/JavaVirtualMachines)

* Après la création du projet, si l'IDE ne trouve pas le Maven ajouté précédemment : 
    * Ouvrir les Settings
        * Dans "Intellij IDEA > Preferences" ou "Command + ," sur OSX 
    * Taper Maven dans la recherche
    * Cliquer sur les points à droite de l'option  "Maven home directory"
    * Rechercher le dossier "maven" ajouté précédemment (~/opt/apache-maven)
    
