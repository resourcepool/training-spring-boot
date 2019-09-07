# Installation de l'environnement pour la formation Spring Boot
## Ubuntu

### Installer le JDK

* Télécharger le jdk 11.0.2 (build 11.0.2+9) pour Linux : https://jdk.java.net/archive/
* Créer et se placer dans le dossier qui va contenir le jdk : 
> sudo mkdir /usr/lib/jvm

> cd /usr/lib/jvm

* Extraire le jdk : 
> sudo tar -xvzf [Chemin vers le dossier de téléchargement]/openjdk-11.0.2_linux-x64_bin.tar.gz
* Ouvrir et éditer le fichier .bashrc : 
> gedit ~/.bashrc
* Ajouter la ligne : export JAVA_HOME=/usr/lib/jvm/jdk-11.0.2
* Ajouter la variable JAVA_HOME au PATH (laisser les éventuelles précédentes variables, ajouter simplement JAVA_HOME et séparer par ":" )
export PATH=[précedentes variables d'environnement]:$JAVA_HOME/bin:$PATH
* Fermer et ré ouvrir le terminal et vérifier le succès de l'installation et la version de java :
> java --version

### Installer Maven

* Télécharger le repo : https://maven.apache.org/download.cgi
* Ouvrir le terminal et se placer dans le dossier /opt :
> cd /opt
* Extraire apache-maven dans le dossier /opt :
> sudo tar -xvzf [Chemin vers le dossier de téléchargement]/apache-maven-3.6.2-bin.tar.gz
* Editer le fichier .bashrc :
> gedit ~/.bashrc
* Ajouter les lignes :
export M2_HOME=/opt/apache-maven-3.6.2
export PATH=[précedentes variables d'environnement]:$JAVA_HOME/bin:$M2_HOME/bin:$PATH
* Fermer et ré ouvrir le terminal et vérifier le succès de l'installation et la version de maven :
> mvn --version

### Intellij Idea

Créer un nouveau projet Java

* Après la création d'un projet Java, vérifier que le projet utilise bien le JDK ajouté précédemment :
    * Ouvrir les Settings du projet sous "File > Project Structure"
    * Vérifier que le JDK utilisé est le bon dans la partie "Project"
    * Si ce n'est pas le cas
        * Cliquer sur "New
        * Sélectionner "JDK"
        * Rechercher le dossier "jdk10" dans votre architecture

* Après la création du projet, si l'IDE ne trouve pas le Maven ajouté précédemment : 
    * Ouvrir les Settings
        * Dans "Intellij IDEA > Preferences" ou "Command + ," sur OSX 
        * Dans "File > Settings" ou "Ctrl + Shift + S" sur Ubuntu et Windows
    * Taper Maven dans la recherche
    * Cliquer sur les points à droite de l'option  "Maven home directory"
    * Rechercher le dossier "maven" ajouté précédemment
    
**TODO** Ajouter instructions pour licence    
    
### Docker

**TODO**
