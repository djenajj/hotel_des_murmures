import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Djena
 * @version 1.2
 * Tests Unitaires
 */
public class HotelTest {

    private Hotel hotel;
    private Repas petitDej;
    private Repas diner;

    @Before
    public void setup() {
        hotel = new Hotel(10, 100.0);
        petitDej = new Repas("Petit-Déjeuner", 20.0);
        diner = new Repas("Dîner", 50.0);
    }

    @Test
    public void testRenovation_DoitAugmenterCapaciteEtTarif() {
        hotel.renover(5);
        assertEquals(15, hotel.getNombreChambres());
        // Vérification de l'effet sur l'état (Point 27)
        assertTrue(hotel.getTarifNuit() > 100.0);
    }

    @Test
    public void testCalculPrix_SansRepas() {
        double prix = hotel.calculerPrixSejour(2);
        assertEquals(200.0, prix, 0.01);
    }


    @Test
    public void testAssociationBidirectionnelle_DoitEtreCoherente() {
        hotel.ajouterRepas(petitDej);
        
        // L'hôtel propose le repas
        assertTrue(hotel.getRepasProposes().contains(petitDej));
        // Le repas est proposé dans l'hôtel
        assertEquals(hotel, petitDej.getHotel());
    }


    @Test
    public void testCalculPrix_AvecPlusieursRepas() {
        hotel.ajouterRepas(petitDej); 
        hotel.ajouterRepas(diner);    
        

        double prixTotal = hotel.calculerPrixSejour(2);
        assertEquals(340.0, prixTotal, 0.01);
    }

    /**
     *Test Infected : Vérifier qu'un doublon n'est pas ajouté.
     */
    @Test
    public void testRobustesse_AjoutDoublonRepas_NeChangeRien() {
        hotel.ajouterRepas(petitDej);
        hotel.ajouterRepas(petitDej);

        assertEquals(1, hotel.getRepasProposes().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculPrix_DureeNegative_DoitEchouer() {
        hotel.calculerPrixSejour(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculPrix_DureeNulle_DoitEchouer() {
        hotel.calculerPrixSejour(0);
    }

    @Test
    public void testSecurite_TarifNegatif_Refuse() {
        try {
            hotel.setTarifNuit(-50.0);
            fail("Une exception aurait dû être levée pour un tarif négatif");
        } catch (IllegalArgumentException e) {
            assertEquals("Tarif négatif", e.getMessage());
        }
    }
}