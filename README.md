# tpsirZS - Projet SIR 2022-2023
Ce projet s'incrit dans le cadre des travaux à rendre pour l'UE SIR, l'objectif etant de mettre application les différentes notions aborées au cours l'années académique. 
Pour ce faire, il a été question pour nous de réaliser un application web de gestion de tickets aidé des technologies : 
- OpenAPI 
- JAXRS
- React (pour le repos front associé : https://github.com/Enygeek/todozs.git)

Ce programme fournit donc une API basé sur le model tel que présenté dans le diagramme de classe au point suivant.
Vous pouvez après avoir suivis ce guide de prise en main le tester à l'aide de POSTMAN par exemple, ou notre repos front fait en React (réf.# PRISE EN MAIN ) et ne sais-ton jamais, peux être l'utiliserez-vous pour l'un de vos projets à venir.

# DIAGRAMME DE CLASSE
Le diagramme de class est accessible depuis les liens suivant. 
 
[ https://lucid.app/lucidchart/61e87889-7f1b-4b8b-9e8a-27a2e844ef37/edit?invitationId=inv_3954b54d-aba1-4bdb-9f7b-0955bc6f0b9a ] 
[ https://lucid.app/lucidchart/61e87889-7f1b-4b8b-9e8a-27a2e844ef37/edit?viewport_loc=-26%2C62%2C2220%2C1010%2C0_0&invitationId=inv_3954b54d-aba1-4bdb-9f7b-0955bc6f0b9a ]

Note : Il ne comprends pas les attributs mais ne mets en exérgues que l'approche conceptuel pour la réalisation de ce projet.
Pour en savoir plus sur les attributs, nous vous invitons à prendre connaissance des differentes classe documenté à cet effet.

# PRISE EN MAIN 
Pour démarrer ce projet qui contient le back, il vous suffit de le télécharger et de l'ouvrir dans votre éditeur préféré (ex. le notre c'est Eclipse et VSCode pour le front). Ensuite, vous pouvez tester l'API via POSTMAN ou Swagger. (vous trouverez notre collection Postman au format JSON dans le repertoire). 

Si vous souhaitez tester le backend depuis une interface graphique, nous vous forunisson dans le repertoire (https://github.com/Enygeek/todozs.git) une application web réalisé en React. Son utilissation est simple. Il vous faudra télécharger le projet en vous assurant que les prérequis NodeJS, npm ou yarn sont déjà installés  sur votre machine. 
La prochaine étape est d'éxécuter depuis votre terminale les commandes suivantes : 

### `npm install all`    -  pour installer tous les module nécéssaire au démarage de notre application.
### `npm start`   - pour démarrer l'application.

Note : 
   - L'accès à la base de donnée est le même que celui fournit par le profésseur lors des tp. (voir fichiers : run-hsqldb-server.bat et show-hsqldb.bat)
   - Si vous souhaitez tester depuis 
