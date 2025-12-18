
/**
 * * @author Djena
 * @version 1.0
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HotelTest {

    private Hotel hotel;
    private Repas repas;

    // Fixture (étape demandée dans le TP)
    @Before
    public void setUp() {
        hotel = new Hotel(10, 100.0);
        repas = new Repas("Dîner", 50.0);
    }

    @Test
    public void calculPrixSejour_avecRepas() {
        hotel.setRepas(repas);

        double prix = hotel.calculerPrixSejour(2);

        assertEquals(300.0, prix, 0.01);
    }

    @Test
    public void calculPrixSejour_sansRepas() {
        double prix = hotel.calculerPrixSejour(2);

        assertEquals(200.0, prix, 0.01);
    }

    @Test
    public void calculPrixSejour_dureeNegative_declencheException() {
        try {
            hotel.calculerPrixSejour(-1);
            fail("Une exception aurait dû être levée");
        } catch (IllegalArgumentException e) {
            assertEquals("Durée négative", e.getMessage());
        }
    }

    @Test
    public void renoverHotel_augmenteTarifEtChambres() {
        hotel.renoverHotel(1);

        assertEquals(11, hotel.getNombreChambres());
        assertEquals(102.0, hotel.getTarifNuit(), 0.01);
    }


    @Test
    public void setTarifNuit_negatif_refuse() {
        try {
            hotel.setTarifNuit(-50.0);
            fail("Une exception aurait dû être levée");
        } catch (IllegalArgumentException e) {
            assertEquals("Tarif négatif", e.getMessage());
        }
    }
}
