* Enrichir la liste des opérateurs disponible
* Ajouter d'autres façons d'effectuer un calcul
  - Ajouter un parent générique à l'interface RpnService
  - Ajouter des entity et repository correspondantes
  - Créer un Controller parent générique
    - Utilise l'interface service générique
    - les childs se differentiants avec @RequestMapping("/XXXX") et le serviceImpl correspondant
  - Refactor le RpnController
    - changer les noms des méthodes pour ne plus utiliser le mot stack dans les paths
* Sécuriser les appels vers les controller (OAuth2 par exemple)
  - sécuriser le swagger