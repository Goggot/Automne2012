package projetmaison;

import java.text.DecimalFormat;

public class Test
{
  public static void main(String[] args)
  {
    Maison M1 = new Maison(5, 400, "12", "Roy", 180000);
    Maison M2 = new Maison(6, 230, "13", "Roy", 195000);
    Chalet C1 = new Chalet(true, true, 4, 600, "33", "Desilets", 120000);
    Roulotte R1 = new Roulotte(1994, true, true, 80500, 5);
    DecimalFormat modele = new DecimalFormat("0.00$");
    
    System.out.println(modele.format(M1.valeur()));
    C1.ajouterPieces(2);
    System.out.println(modele.format(C1.valeur()));
    M1.setSuperficie(500);
    System.out.println(M1.meilleureAffaire(M2));
  }
}