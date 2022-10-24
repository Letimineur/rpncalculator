#ToDo
* Tests
  - finition du tests de calcul
  - couverture complete
    - controller
    - rpnservice
* Amélioration de la gestion des opérateurs de calcul
  - gérer aussi les mots clé (add , subtract, multiply)
  - chercher une solution pour avoir directement l'opérateur "/" (invalide dans une requête http)
* Remplacer la dépendance H2 par une vraie base de donnée pour sortir du cadre d'un poke
* Enrichir la configuration du swagger pour améliorer l'usage
* Ajouter @Operation aux méthodes du controller pour une meilleure lisibilité

#Raccourcis utilisés
* Utilisation de Spring Initilizer pour avoir une structure toute faite et quelques dépendances de base
* Développement commencé directement sur le calculateur plutôt que par le squelette des tests.
  Je préfère quand c'est possible préparer les tests avant le code
