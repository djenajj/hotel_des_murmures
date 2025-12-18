Feature: Gestion de l'hébergement et de la restauration
  En tant que gérant de l'Hôtel des Murmures
  Je veux proposer une tarification claire incluant les services de restauration
  Afin d'offrir une expérience client fluide et sans erreur de facturation

  Background:
    Given un hôtel nommé "Hôtel des Murmures"
    And l'hôtel est configuré avec 10 chambres
    And le tarif par nuit est fixé à 100.0 euros


  Scenario: Initialisation conforme de l'hôtel
    Then l'hôtel doit disposer de 10 chambres
    And le tarif par nuit doit être strictement supérieur à 0
    And aucun repas ne doit être enregistré dans le catalogue de l'hôtel


  Scenario Outline: Calcul du prix total du séjour incluant la restauration
    Given un repas nommé "<nom_repas>" est proposé au prix de <prix_repas> euros
    And le repas est ajouté au catalogue de l'hôtel
    And le client effectue une réservation de <nuits> nuits
    When le gérant calcule le prix total du séjour
    Then le montant total doit être égal à <total> euros

    Examples:
      | nom_repas   | prix_repas | nuits | total |
      | Dîner       | 50.0       | 2     | 300.0 |
      | Petit-déj   | 10.0       | 2     | 220.0 |
      | Aucun       | 0.0        | 3     | 300.0 |

  Scenario: Cohérence de l'association entre l'hôtel et les repas
    When un repas nommé "Dîner de Gala" est ajouté au catalogue de l'hôtel
    Then le repas "Dîner de Gala" doit apparaître dans la liste des services de l'hôtel
    And l'hôtel doit être identifié comme le prestataire du repas "Dîner de Gala"
