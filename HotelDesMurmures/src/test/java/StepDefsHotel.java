import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefsHotel {

    private Hotel hotel;
    private Repas dernierRepas;
    private double prixCalcule;
    private int nuits;

    @Given("un hôtel nommé {string}")
    public void un_hotel_nomme(String nom) {
        hotel = new Hotel(0, 1.0); 
    }

    @Given("l'hôtel est configuré avec {int} chambres")
    public void hotel_configure(int chambres) {
        hotel.setNombreChambres(chambres);
    }

    @Given("le tarif par nuit est fixé à {double} euros")
    public void tarif_fixe(double tarif) {
        hotel.setTarifNuit(tarif);
    }

    @Then("l'hôtel doit disposer de {int} chambres")
    public void verifier_chambres(int attendu) {
        assertEquals(attendu, hotel.getNombreChambres());
    }

    @Then("le tarif par nuit doit être strictement supérieur à {int}")
    public void verifier_tarif(int zero) {
        assertTrue(hotel.getTarifNuit() > zero);
    }

    @Then("aucun repas ne doit être enregistré dans le catalogue de l'hôtel")
    public void aucun_repas() {
        assertTrue(hotel.getRepasProposes().isEmpty());
    }

    @Given("un repas nommé {string} est proposé au prix de {double} euros")
    public void repas_propose(String nom, double prix) {
        dernierRepas = new Repas(nom, prix);
    }

    @Given("le repas est ajouté au catalogue de l'hôtel")
    public void ajouter_repas() {
        if (dernierRepas.getPrix() > 0) {
            hotel.ajouterRepas(dernierRepas);
        }
    }

    @Given("le client effectue une réservation de {int} nuits")
    public void reserver(int nuits) {
        this.nuits = nuits;
    }

    @When("le gérant calcule le prix total du séjour")
    public void calculer_prix() {
        prixCalcule = hotel.calculerPrixSejour(nuits);
    }

    @Then("le montant total doit être égal à {double} euros")
    public void verifier_prix(double attendu) {
        assertEquals(attendu, prixCalcule, 0.01);
    }


    @When("un repas nommé {string} est ajouté au catalogue de l'hôtel")
    public void ajout_direct(String nom) {
        dernierRepas = new Repas(nom, 50.0);
        hotel.ajouterRepas(dernierRepas);
    }

    @Then("le repas {string} doit apparaître dans la liste des services de l'hôtel")
    public void repas_present(String nom) {
        assertTrue(hotel.getRepasProposes().contains(dernierRepas));
    }

    @Then("l'hôtel doit être identifié comme le prestataire du repas {string}")
    public void lien_bidirectionnel(String nom) {
        assertEquals(hotel, dernierRepas.getHotel());
    }
}
