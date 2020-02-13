package fr.umontpellier.iut;

public class IBaille {
    public static void main(String[] args) {

        Produit.setPasEnchere(2);
        Produit p = new Produit("eponge",1, 5); //1 coût participation, 5
        //va aller dans prix courant, ça sera donc le prix initial
        Compte c1 = new Compte("marin", 11); //11 : solde initial
        Compte c2 = new Compte("bob", 15);
        p.demarrerEnchere();
        boolean b = c1.creerOffre(p,3,4);
        int solde = c1.getSolde(); // 10
        b = c1.creerOffre(p,5,10);// -> débite 1, retourne true (gagnant)

        //si on avait fait c1.creerOffre(p,6,10) : prix courant de p passerait à 6
        //si on avait fait c1.creerOffre(p,4,7) : prix courant de p passerait à 5

        solde = c1.getSolde();//9
        b =  c2.creerOffre(p,7,20); //ne crée pas l'offre (et ret false car 20 > solde), et ne débite pas non plus
        c2.crediter(100);
        b =  c2.creerOffre(p,7,20); //ok, solde = 114

        int encours = p.getPrixEnCours(); //12
        p.arreterEnchere(); //rend impossible futurs tentatives et debite le gagnant
        OffreEnchere ogagnante = p.getOffreGagnante();
        Compte cgagnant = ogagnante.getCompte();
        String nom = cgagnant.getNom(); //bob
        solde = cgagnant.getSolde(); // 114 - 12
    }
}
