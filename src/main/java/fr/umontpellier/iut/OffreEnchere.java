package fr.umontpellier.iut;

public class OffreEnchere {
    private int prixMin;
    private int prixMax;
    private Compte compte;

    public OffreEnchere(int prixMin, int prixMax ,Compte c) {
        this.prixMin = prixMin;
        this.prixMax = prixMax;
        compte = c;
    }

    public Compte getCompte() {
        return compte;
    }

    public int getPrixMin() {
        return prixMin;
    }

    public int getPrixMax() {
        return prixMax;
    }
}
