import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class StepDefsHotel {
    private Hotel hotel;
    private double prixCalcule;

    // Scénario simple

    @Given("un nouvel hôtel prêt à ouvrir")
    public void un_nouvel_hotel_pret_a_ouvrir() {
        hotel = new Hotel(10, 80.0);
    }

    @Then("l'hôtel doit avoir des chambres disponibles")
    public void l_hotel_doit_avoir_des_chambres_disponibles() {
        assertTrue(hotel.getNombreChambres() > 0);
    }

    @Then("le tarif de base ne doit pas être gratuit")
    public void le_tarif_de_base_ne_doit_pas_etre_gratuit() {
        assertTrue(hotel.getTarifNuit() > 0);
    }


    @Given("un hôtel configuré avec {string} chambres et {string} euros")
    public void un_hotel_configure(String chambres, String prix) {
        hotel = new Hotel(Integer.parseInt(chambres), Double.parseDouble(prix));
    }

    @Given("le client réserve pour {string} nuits")
    public void le_client_reserve(String nuits) {
        this.prixCalcule = hotel.calculerPrixSejour(Integer.parseInt(nuits));
    }

    @When("le système calcule le prix total")
    public void le_systeme_calcule_le_prix_total() {
    }

    @Then("le montant affiché doit être de {string} euros")
    public void le_montant_affiche_doit_etre(String totalAttendu) {
        assertEquals(Double.parseDouble(totalAttendu), prixCalcule, 0.01);
    }
}