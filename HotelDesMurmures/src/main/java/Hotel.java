/**
 * * @author Djena
 * @version 1.0
 */

public class Hotel {
    

    private int nombreChambres;
    private double tarifNuit;
    private Repas repas;


    public Hotel(int nombreChambres, double tarifNuit) {
        this.nombreChambres = nombreChambres;
        this.tarifNuit = tarifNuit;
    }

    public double calculerPrixSejour(int nombreNuits) {
        if (nombreNuits < 0) throw new IllegalArgumentException("Durée négative");
        
        double total = this.tarifNuit * nombreNuits;
        if (this.repas != null) {
            total += this.repas.getPrix() * nombreNuits;
        }
        return total;
    }

    /* Extension de l'hôtel
     Chaque nouvelle chambre augmente le tarif global de 2%.
    */
    public void renoverHotel(int nouvellesChambres) {
        if (nouvellesChambres > 0) {
            this.nombreChambres += nouvellesChambres;
            this.tarifNuit *= Math.pow(1.02, nouvellesChambres);
        }
    }

    public int getNombreChambres() { return nombreChambres; }

    public void setNombreChambres(int nombre) {
        if (nombre < 0) throw new IllegalArgumentException("Nombre de chambres négatif");
        this.nombreChambres = nombre;
    }

    public double getTarifNuit() { return tarifNuit; }

    public void setTarifNuit(double tarif) {
        if (tarif < 0) throw new IllegalArgumentException("Tarif négatif");
        this.tarifNuit = tarif;
    }

    public Repas getRepas() { return repas; }

    public void setRepas(Repas repas) { this.repas = repas; }
}