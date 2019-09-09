# Installation de l'environnement pour la formation Spring Boot
## Ubuntu

Cette procédure d'installation nécessite le téléchargement de : 
 * JDK 11.0.2
 * Maven 3.6.2
 * Intellij IDEA Toolbox App
 * script-db-linux.sh présent dans ce repository
  
Vous pouvez copier ces fichiers à partir de la clé USB fournie pendant cette formation (copier tous les éléments de la clé).

### Installer le JDK

* Télécharger le jdk 11.0.2 (build 11.0.2+9) pour Linux : https://jdk.java.net/archive/
* Créer et se placer dans le dossier qui va contenir le jdk :   
`sudo mkdir /usr/lib/jvm`   
`cd /usr/lib/jvm` 

* Extraire ici le jdk :     
`sudo tar -xvzf [Chemin vers le dossier de téléchargement]/openjdk-11.0.2_linux-x64_bin.tar.gz`
* Ouvrir et éditer le fichier .bashrc : 
`gedit ~/.bashrc`
* Ajouter la ligne : `export JAVA_HOME=/usr/lib/jvm/jdk-11.0.2`
* Ajouter la variable JAVA_HOME au PATH (laisser les éventuelles précédentes variables, ajouter simplement JAVA_HOME et séparer par ":" )   
`export PATH=[précedentes variables d'environnement]:$JAVA_HOME/bin:$PATH`
* Fermer et ré ouvrir le terminal et vérifier le succès de l'installation et la version de java :
`java --version`

### Installer Maven

* Télécharger le repo : https://maven.apache.org/download.cgi
* Ouvrir le terminal et se placer dans le dossier /opt :
`cd /opt`
* Extraire apache-maven dans le dossier /opt :  
`sudo tar -xvzf [Chemin vers le dossier de téléchargement]/apache-maven-3.6.2-bin.tar.gz`
* Editer le fichier .bashrc :
`gedit ~/.bashrc`
* Ajouter les lignes :  
`export M2_HOME=/opt/apache-maven-3.6.2`    
`export PATH=[précedentes variables d'environnement]:$JAVA_HOME/bin:$M2_HOME/bin:$PATH`
* Fermer et ré ouvrir le terminal et vérifier le succès de l'installation et la version de maven :
`mvn --version`

### Intellij IDEA

#### Installation via Toolbox App

* Télécharger et extraire la ToolBox : https://www.jetbrains.com/toolbox/app/
* Lancer l'éxecutable et installer Intelliji IDEA Ultimate
* Récupérer votre licence Education ici : https://jetbrains.com/shop/eform/students

#### Création du projet

* Créer un nouveau projet Java
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
    * Cliquer sur les points à droite de l'option  "Maven home directory"
    * Rechercher le dossier "maven" ajouté précédemment

### Docker Engine - Community

* Procédure d'installation complète ici : https://docs.docker.com/install/linux/docker-ce/ubuntu/, résumée ci-dessous :   
      
    * Mettre à jour les dépôts :    
    `sudo apt-get update` 
    * Autoriser l'utilisation de HTTPS :    
    `sudo apt-get install \
     apt-transport-https \      
     ca-certificates \
     curl \
     gnupg-agent \
     software-properties-common`    
     * Ajouter la clé GPG Docker :  
    `curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -`
    * Vérifer la présence de la clé `9DC8 5822 9FC7 DD38 854A E2D8 8D81 803C 0EBF CD88` :   
    `sudo apt-key fingerprint 0EBFCD88`
    * Ajouter le dépôt distant :    
    `sudo add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"`
     * Mettre à jour les dépôts :   
    `sudo apt-get update`   
     * Installer la dernière version de Docker Engine - Community et containerd :   
    `sudo apt-get install docker-ce docker-ce-cli containerd.io`  
     * Vérifier le succès de l'installation par un Hello World :    
    `sudo docker run hello-world`
    
    * Gérer les permissions :
        * Créer le groupe docker :  
        `sudo groupadd docker`
        * Ajouter votre utilisateur au groupe docker :  
        `sudo usermod -aG docker $USER`
        * Vérifier le succès de l'execution de Docker sans sudo (un redémarrage peut être nécéssaire) :   
        `docker run hello-world`
        
    * Télécharger l'image de mariadb dont vous aurez besoin plus tard : `docker pull mariadb`