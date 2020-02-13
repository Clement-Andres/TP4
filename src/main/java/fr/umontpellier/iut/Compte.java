package fr.umontpellier.iut;

public class Compte {
    private String nom;
    private int solde;

    public Compte(String nom, int solde) {
        this.nom = nom;
        this.solde = solde;
    }

    public int getSolde() {
        return solde;
    }

    public String getNom() {
        return nom;
    }

    public void debiter(int montant){
        solde=solde-montant;
    }

    public void crediter(int montant){
        solde=solde+montant;
    }

    public boolean creerOffre(Produit p, int min, int max){
        if (max<solde-p.getCoutOffre()){
            return false;
        }
        else if (!p.isOuvert()){
            return false;
        }
        else {
            solde=solde-p.getCoutOffre();
            OffreEnchere offre = new OffreEnchere(min, max, this);
            return p.ajouterOfrre(offre); // retourne vrai ssi l'offre gagne
        }
    }
}