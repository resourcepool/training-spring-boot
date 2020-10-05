# Troubleshooting

Ici, nous avons consigné la plupart des choses que vous pouvez rencontrer sur votre chemin avant d'avoir un projet qui **run**.

## VT-x/AMD-V hardware acceleration is not available on your system
Installer la **dernière version** (6.X) de VirtualBox

Si cela ne fonctionne toujours pas, vérifier :
 * Qu'il soit activé dans le BIOS (c'est généralement le cas)
 * Que Hyper-V est désactivé dans Windows (dans un invite de commande admin : `dism.exe /Online /Disable-Feature:Microsoft-Hyper-V`

## Docker

`Looks like something went wrong in step 'Looking for vboxmanage.exe' ... Press any key to continue...`  
Désinstaller Docker et Virtual Box. Dans l'explorateur de fichier, à la racine de votre utilisateur (C:/utilisateurs/%user%/), supprimer les dossiers .docker et .virtualBox.
Réinstaller Docker


## IP Hote Docker pour Windows 

Si vous êtes sur Windows Home ou Family, Docker utilisera une VM Virtualbox pour faire fonctionner vos containers.
Du coup, l'adresse de tous les services (càd la DB) ne sera pas `localhost` mais `192.168.99.100`

## Application qui ne démarre pas

Si quand vous lancez votre application Spring Boot, vous avez des messages d'erreur qui ressemblent à cela (quand vous fouillez dans la Stacktrace) :  
`Caused by: java.net.ConnectException: Connection refused (Connection refused)`

ou

`Caused by: java.sql.SQLNonTransientConnectionException: Socket fail to connect to host:localhost, port:3306. Connection refused (Connection refused)`

C'est que vous avez un soucis de connexion entre votre application et votre DB.

1. Vérifiez que votre DB est bien lancée et que vous pouvez y accéder via votre client SQL (Intellij IDEA, PhpMyAdmin, Adminer, MySQLWorkbench, etc...)
2. Vérifiez que le host, le login / password, et le port sont bien indiqués et sont les bons (si vous êtes sur windows ou pas, cela peut changer !!!) dans `src/main/resources/application.properties`

## Dépendances externes qui ne compilent pas (Spring, ou autre)

Vous pouvez réimporter le projet maven, en cliquant sur l'onglet "Maven" tout à droite de votre écran.
