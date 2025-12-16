/**
 * Classe Repas - Représente un repas proposé par l'hôtel
 * 
 * @author Djena
 * @version 1.0
 */
public class Repas
{
    private String typeRepas;  // Ex: "Petit-déjeuner", "Dîner"
    private double prix;
    
    /**
     * Constructeur
     */
    public Repas(String type, double prix)
    {
        this.typeRepas = type;
        this.prix = prix;
    }
    
    // Getters
    public String getTypeRepas()
    {
        return typeRepas;
    }
    
    public double getPrix()
    {
        return prix;
    }
    
    // Setters
    public void setTypeRepas(String type)
    {
        this.typeRepas = type;
    }
    
    public void setPrix(double prix)
    {
        this.prix = prix;
    }
    
    /**
     * Affiche les infos du repas
     */
    public void afficherRepas()
    {
        System.out.println("Type de repas: " + typeRepas);
        System.out.println("Prix: " + prix + "€");
    }
}