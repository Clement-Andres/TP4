package fr.umontpellier.iut;

public class Produit {
    private String nom;
    private int prixCourant;
    private int coutOffre;
    private static int pasEnchere;
    private OffreEnchere offreGagnante;
    private boolean ouvert;

    public Produit(String nom, int prixCourant, int coutOffre) {
        this.nom = nom;
        this.prixCourant = prixCourant;
        this.coutOffre = coutOffre;
    }

    public int getCoutOffre() {
        return coutOffre;
    }

    public static void setPasEnchere(int pas) {
        pasEnchere = pas;
    }

    public int getPrixEnCours() {
        return prixCourant;
    }

    public OffreEnchere getOffreGagnante() {
        return offreGagnante;
    }

    public boolean isOuvert() {
        return ouvert;
    }

    public void demarrerEnchere(){
        ouvert=true;
    }
    public void arreterEnchere(){
        offreGagnante.getCompte().debiter(prixCourant);
        ouvert=false;
    }

    public boolean ajouterOfrre(OffreEnchere o){
       /* modifie l'OffreEnchere gagnante et le prix courant du produit selon
        les indications du tableau
        - retourne vrai ssi o est gagante
     */
       while (ouvert){
           if (offreGagnante ==null){
               offreGagnante = o;
           }
           else{
               int m1 = offreGagnante.getPrixMax();
               int m2 = o.getPrixMax();

               if (m1>m2+pasEnchere){
                   prixCourant=m2+pasEnchere;
                   return false;
               }
               if (m1>m2){
                   if (m1-pasEnchere>= pasEnchere){
                       prixCourant=m1;
                       return false;
                   }
                   else {
                       return false;
                   }
               }
               if (m1<m2 && m2-m1<=pasEnchere){
                   if (m1-prixCourant >= pasEnchere){
                       prixCourant=m1;
                       return false;
                   }
                   else{
                       return false;
                   }
               }

           }
       }
    }
}
