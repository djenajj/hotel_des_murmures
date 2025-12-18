import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Djena
 * @version 1.2 
 */
public class Hotel {

    private static final double TAUX_REVALORISATION = 1.02;
    
    private int nombreChambres;
    private double tarifNuit;
    private final List<Repas> repasProposes;

    public Hotel(int nombreChambres, double tarifNuit) {
        if (nombreChambres < 0 || tarifNuit < 0) {
            throw new IllegalArgumentException("Le nombre de chambres de l'hôtel et le prix de la nuitée doivent être positifs.");
        }
        this.nombreChambres = nombreChambres;
        this.tarifNuit = tarifNuit;
        this.repasProposes = new ArrayList<>();
    }

    /**
     * Calcule le prix total du séjour incluant les repas.
     * Method Extract : Utilise la méthode calculerTotalRepas.
     */
    public double calculerPrixSejour(int nombreNuits) {
        if (nombreNuits <= 0) {
            throw new IllegalArgumentException("La durée du séjour doit être supérieure à 0.");
        }
        return (this.tarifNuit + calculerTotalRepas()) * nombreNuits;
    }

    private double calculerTotalRepas() {
        return repasProposes.stream()
                            .mapToDouble(Repas::getPrix)
                            .sum();
    }


    public void ajouterRepas(Repas nouveauRepas) {
        if (nouveauRepas != null && !repasProposes.contains(nouveauRepas)) {
            this.repasProposes.add(nouveauRepas);
            nouveauRepas.lierAHotel(this); // Maintien de la cohérence bidirectionnelle
        }
    }

    /**
     * Simule une rénovation :
     * - Augmente le nombre de chambres 
     * - Augmente le tarif de chaque chambre 
     */
    public void renover(int nouvellesChambres) {
        if (nouvellesChambres > 0) {
            this.nombreChambres += nouvellesChambres;
            this.tarifNuit *= Math.pow(TAUX_REVALORISATION, nouvellesChambres);
        }
    }


    public int getNombreChambres() { 
        return nombreChambres; 
    }

    public double getTarifNuit() { 
        return tarifNuit; 
    }

    public List<Repas> getRepasProposes() {
        return Collections.unmodifiableList(repasProposes);
    }

    public void setNombreChambres(int nombreChambres) {
    if (nombreChambres < 0) {
        throw new IllegalArgumentException(
            "Le nombre de chambres ne peut pas être négatif"
        );
    }
    this.nombreChambres = nombreChambres;
    }

    public void setTarifNuit(double tarifNuit) {
        if (tarifNuit <= 0) {
            throw new IllegalArgumentException(
                "Tarif négatif"
            );
        }
        this.tarifNuit = tarifNuit;
    }

}