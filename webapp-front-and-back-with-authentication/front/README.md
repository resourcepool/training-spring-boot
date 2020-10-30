# Site web - Front

## Processus d'installation (NodeJs, npm, Angular CLI):

* Télécharger Node.js (npm est inclus avec)
* Ouvrir un terminal et entrer la commande afin de télécharger le CLI Angular: `npm install -g @angular/cli`

## Configurer le projet

* Ouvrir un terminal et entrer `npm install`
* Ouvrir votre console firebase et mettre à jour votre `environment.ts` et `environment.prod.ts` avec la configuration projet firebase.

```javascript
firebase: {
    apiKey: "xxxxxxxx-xxxxxxxx",
    authDomain: "xxxxxxxxxxxxxxxxxxxxxxxx",
    databaseURL: "xxxxxxxxxxxxxxxxxxxxxxxx",
    projectId: "xxxxxxxx",
    storageBucket: "xxxxxxxx",
    messagingSenderId: "xxxxxx",
    appId: "xxxxx",
    measurementId: "xxxxxxxxxxxxxxxx"
  }
```

## Démarrer le serveur
* Pour démarrer le serveur, entrer la commande : `ng serve`
