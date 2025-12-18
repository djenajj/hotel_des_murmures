
/**
 * * @author Djena
 * @version 1.0
 */

public class Repas {
    private String typeRepas; 
    private double prix;       

    public Repas(String type, double prix) {
        if (prix < 0) {
            throw new IllegalArgumentException("Le prix du repas ne peut pas être négatif");
        }
        this.typeRepas = type;
        this.prix = prix;
    }

    public String getTypeRepas() {
        return typeRepas;
    }

    public void setTypeRepas(String type) {
        this.typeRepas = type;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        if (prix < 0) {
            throw new IllegalArgumentException("Le prix ne peut pas être négatif");
        }
        this.prix = prix;
    }
}