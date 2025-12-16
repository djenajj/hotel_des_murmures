/**
 * Décrivez votre classe Hotel ici.
 *
 * @author Djena
 * @version 1.0
 */
public class Hotel
{
    private int nombreChambres;
    private double tarifNuit;
    private Repas repas;  //
    
    public Hotel()
    {
        this.nombreChambres = 0;
        this.tarifNuit = 0.0;
        this.repas = null;  //
    }
    
    public Hotel(int chambres, double tarif)
    {
        this.nombreChambres = chambres;
        this.tarifNuit = tarif;
        this.repas = null;  //
    }
    
    // Getters
    public int getNombreChambres()
    {
        return nombreChambres;
    }
    
    public double getTarifNuit()
    {
        return tarifNuit;
    }
    
    // ← AJOUTE CE GETTER
    public Repas getRepas()
    {
        return repas;
    }
    
    //Setters
    public void setNombreChambres(int nombre)
    {
        this.nombreChambres = nombre;
    }
    
    public void setTarifNuit(double tarif)
    {
        this.tarifNuit = tarif;
    }
    
    // ← AJOUTE CE SETTER
    public void setRepas(Repas repas)
    {
        this.repas = repas;
    }
    
    public void renoverHotel(int nouvellesChambres)
    {
        this.nombreChambres += nouvellesChambres;
        
        for (int i = 0; i < nouvellesChambres; i++) {
            this.tarifNuit = tarifNuit * 1.02;
        }
        System.out.println("Nouveau tarif: " + tarifNuit + "€");
        System.out.println("(+2% par chambre ajoutée)");
    }   
    

    public double calculerPrixSejour(int nombreNuits)
    {
        double total = tarifNuit * nombreNuits;
        
        if (repas != null) {
            total += repas.getPrix() * nombreNuits;
        }
        
        System.out.println("Prix hébergement: " + (tarifNuit * nombreNuits) + "€");
        
        if (repas != null) {
            System.out.println("Prix repas: " + (repas.getPrix() * nombreNuits) + "€");
        }
        
        System.out.println("TOTAL: " + total + "€");
        return total;
    }
}