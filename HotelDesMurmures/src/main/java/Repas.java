/**
 * @author Djena
 * @version 1.2
 */
public class Repas {

    private String nom;
    private double prix;
    private Hotel hotel;

    public Repas(String nom, double prix) {
        if (prix < 0) {
            throw new IllegalArgumentException("Le prix du repas ne peut pas être négatif.");
        }
        this.nom = nom;
        this.prix = prix;
    }

    public void lierAHotel(Hotel nouvelHotel) {
        
        if (this.hotel == nouvelHotel) {
            return;
        }

        this.hotel = nouvelHotel;

        if (nouvelHotel != null) {
            nouvelHotel.ajouterRepas(this);
        }
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setNom(String nom) {
    if (nom == null || nom.trim().isEmpty()) {
        throw new IllegalArgumentException(
            "Le nom du repas ne peut pas être nul ou vide"
        );
    }
    
    this.nom = nom;
    }

    public void setPrix(double prix) {
        if (prix < 0) {
            throw new IllegalArgumentException(
                "Le prix du repas ne peut pas être négatif"
            );
        }
        this.prix = prix;
    }

}