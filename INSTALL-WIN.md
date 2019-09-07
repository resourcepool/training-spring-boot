# Installation de l'environnement pour la formation Spring Boot

## Windows

Ajout de JAVA_HOME au Path : 
* Ouvrir le gestionnaire de variable d'environnements 
    * rechercher variable dans le menu démarrer
    * onglet "Paramètres système avancés" => bouton "Variabls d'environnement"
* Créer une variable JAVA_HOME pour l'utilisateur courant ayant pour valeur le chemin vers votre dossier "jdk10"
* Sélectionner la variable Path
* Cliquer sur "Modifier..."
* Cliquer sur "Nouveau"
* Ajouter "JAVA_HOME/bin"

De la même façon, créer une variable MAVEN_HOME.


## Troubleshooting

Créer un nouveau projet Java

* Après la création d'un projet Java, vérifier que le projet utilise bien le JDK ajouté précédemment :
    * Ouvrir les Settings du projet sous "File > Project Structure"
    * Vérifier que le JDK utilisé est le bon dans la partie "Project"
    * Si ce n'est pas le cas
        * Cliquer sur "New
        * Sélectionner "JDK"
        * Rechercher le dossier "jdk12" dans votre architecture

* Après la création du projet, si l'IDE ne trouve pas le Maven ajouté précédemment : 
    * Ouvrir les Settings
        * Dans "File > Settings" ou "Ctrl + Shift + S" sur Windows
    * Taper Maven dans la recherche
    * Cliquer sur les points à droite de l'option  "Maven home directory"
    * Rechercher le dossier "maven" ajouté précédemment
    
