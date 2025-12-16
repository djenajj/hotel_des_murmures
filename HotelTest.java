import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test pour Hotel
 * 
 * @author Djena
 * @version 1.0
 */
public class HotelTest
{
    private Hotel hotel1;
    private Repas repas1;


    /**
     * Méthode exécutée avant chaque test
     */
    @Before
    public void setUp()
    {
        hotel1 = new Hotel(244, 60);
        repas1 = new Repas("Dîner", 1000);
        hotel1.setRepas(repas1);
        hotel1.calculerPrixSejour(2);
    }
        @Test
    public void tesuto()
    {
        assertEquals(244, hotel1.getNombreChambres());
    }

    /**
     * Test du constructeur par défaut
     */
    @Test
    public void testConstructeurParDefaut()
    {
        Hotel hotel = new Hotel();
        assertEquals(0, hotel.getNombreChambres());
        assertEquals(0.0, hotel.getTarifNuit(), 0.01);
    }

    /**
     * Test du constructeur avec paramètres
     */
    @Test
    public void testConstructeurAvecParametres()
    {
        Hotel hotel2 = new Hotel(50, 100.0);
        assertEquals(50, hotel2.getNombreChambres());
        assertEquals(100.0, hotel2.getTarifNuit(), 0.01);
    }

    /**
     * Test des setters
     */
    @Test
    public void testSetters()
    {
        hotel1.setNombreChambres(20);
        hotel1.setTarifNuit(85.50);

        assertEquals(20, hotel1.getNombreChambres());
        assertEquals(85.50, hotel1.getTarifNuit(), 0.01);
    }

    /**
     * Test de la méthode renoverHotel
     */
    @Test
    public void testRenoverHotel()
    {
        // On part d'un hôtel avec 10 chambres à 100€
        hotel1.setNombreChambres(10);
        hotel1.setTarifNuit(100.0);

        // On ajoute 3 chambres
        hotel1.renoverHotel(3);

        // Vérifications
        assertEquals(13, hotel1.getNombreChambres());
        // 100 * 1.02^3 = 106.1208
        assertEquals(106.12, hotel1.getTarifNuit(), 0.01);
    }

    /**
     * Test de renoverHotel avec 1 chambre
     */
    @Test
    public void testRenoverHotelUneChambre()
    {
        hotel1.setNombreChambres(5);
        hotel1.setTarifNuit(50.0);

        hotel1.renoverHotel(1);

        assertEquals(6, hotel1.getNombreChambres());
        assertEquals(51.0, hotel1.getTarifNuit(), 0.01);
    }

    /**
     * Test de renoverHotel avec 0 chambre
     */
    @Test
    public void testRenoverHotelZeroChambre()
    {
        hotel1.setNombreChambres(10);
        hotel1.setTarifNuit(100.0);

        hotel1.renoverHotel(0);

        assertEquals(10, hotel1.getNombreChambres());
        assertEquals(100.0, hotel1.getTarifNuit(), 0.01);
    }

    @Test
    public void Bipbip()
    {
    assertEquals(244, hotel1.getNombreChambres());
    }
}

