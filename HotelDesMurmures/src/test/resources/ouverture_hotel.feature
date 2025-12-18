Feature: Gestion de l'ouverture et des tarifs
  En tant que gérant de l'Hôtel des Murmures
  Je veux m'assurer que l'hôtel est correctement configuré
  Afin d'éviter des erreurs de tarification dès l'ouverture

  # Scénario simple
  Scenario: Initialisation légitime de l'hôtel
    Given un nouvel hôtel prêt à ouvrir
    Then l'hôtel doit avoir des chambres disponibles
    And le tarif de base ne doit pas être gratuit

  # Scénario avec paramètres
  Scenario Outline: Calcul du prix avec différentes options
    Given un hôtel configuré avec "<chambres>" chambres et "<prix_nuit>" euros
    And le client réserve pour "<nuits>" nuits
    When le système calcule le prix total
    Then le montant affiché doit être de "<total>" euros

    Examples:
      | chambres | prix_nuit | nuits | total |
      | 10       | 100.0     | 2     | 200.0 |
      | 5        | 50.0      | 3     | 150.0 |