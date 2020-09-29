# Problèmes rencontrés pendant la formation Spring Boot


## Docker Quick Strart 

* `Looks like something went wrong in step 'Looking for vboxmanage.exe' ... Press any key to continue...`
Désinstaller Docker et Virtual Box. Dans l'explorateur de fichier, à la racine de votre utilisateur (C:/utilisateurs/%user%/), supprimer les dossiers .docker et .virtualBox.
Réinstaller Docker


## IP Hote Docker pour Windows 

Si vous êtes sur Windows Home ou Family, Docker utilisera une VM Virtualbox pour faire fonctionner vos containers.
Du coup, l'adresse de tous les services (càd la DB) ne sera pas `localhost` mais `192.168.99.100`

