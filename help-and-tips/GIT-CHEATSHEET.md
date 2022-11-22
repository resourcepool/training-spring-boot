# GIT CHEAT SHEET
Quelques informations pratiques pour la mise en place d'un projet de petite envergure avec git.

## Démarrer un projet
Initialiser votre git en ouvrant une console à la racine de votre projet:
```
> git init
```
Si ce n'est pas déjà le cas, configurer votre clé ssh avec votre compte en ligne : [Clé SSH sur Gitlab](https://gitlab.com/-/profile/keys).

Établir le lien entre votre dossier local et le repository que vous avez créé en ligne (récupérer l'**url** en cliquant sur "clone" sur GitLab):
```
> git remote add origin <url>
```
Créer votre première branche (qui sera la branche principale pour la suite du projet):
```
> git checkout -b master
```
Ajouter dans *.gitignore* les fichiers/dossiers qu'on ne veut pas pousser avec le projet.
Une fois fait, créer un premier commit qui englobe l'ensemble des sources sur la branche principale :
```
> git commit -am "[CHORE] First commit"
```
Pousser le commit tout juste créé tout en liant la branche locale à son équivalent sur le repository.
```
> git push --set-upstream origin master
```
Vérifier l'état du repository sur Gitlab. Les autres contributeurs pourront cloner le projet :
```
> git clone <url>
```


## Au quotidien
Toujours *pull* la dernière version de la branche principale avant d'en créer une nouvelle:
```
> git checkout master
> git pull origin master
> git checkout -b ma-super-branche
```
Toujours sauvegarder mes modifications dans un *commit* quand je finis une étape importante de mon développement ou que je dois fermer mon ordinateur:
```
> git add .
> git commit -m "Une description de mon avancement"
> git push origin ma-super-branche
```
Toujours *rebaser* ma branche sur la branche principale si des changements y ont été ajoutés depuis la dernière fois:
```
> git checkout master
> git pull
> git checkout ma-super-branche
> git rebase master
```
Et résoudre les conflits dans IntelliJ si besoin.

## Pratique
Pour voir l'historique des derniers commits de la branche sur laquelle je suis:
```
> git log
```
Pour voir tous les fichiers modifiés depuis le dernier commit, ou carrément toutes les modifications:
```
> git status
> git diff
```
Pour récupérer les informations des nouvelles branches créées sur le repository:
```
> git fetch origin
```
Lorsque j'ai des modifications en attente que je ne veux pas commiter, je peux les ajouter à la pile des brouillons:
```
> git stash
```
Pour ajouter mes modifications au sein du dernier commit, plutôt que dans un nouveau:
```
> git commit --amend
```
Pour pousser ma branche après avoir modifié son historique (après un *rebase* ou un *amend* par exemple):
```
> git push --force
```
Lorsque je suis au bout de ma vie:
```
> git --help
```
N'oubliez pas de jeter un coup d'oeil à l'arbre git de votre repository, il contient toutes les informations dont vous avez besoin pour comprendre ce qu'il se passe !
