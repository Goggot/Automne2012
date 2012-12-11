package projetmaison;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Roulotte extends Chalet
{
  private int anneeFabrication;
  public Roulotte(int anneeFabrication, boolean electricite, boolean AccesLac, double prixVente, int nbrePieces)
  {
    super(electricite, AccesLac, nbrePieces, 0, null, null, prixVente);
    this.anneeFabrication = anneeFabrication;
  }
  
  public int getAnneeFabrication()
  {
    return anneeFabrication;
  }
  
  public double valeur()
  {
    GregorianCalendar date = new GregorianCalendar();
    int age = date.get(Calendar.YEAR) - this.getAnneeFabrication();
    double valeur = super.valeur();
    
    if (age > 10 && age < 19)
      valeur *= 0.60;
    if (age > 20)
      valeur *= 0.50;
    
    return valeur;
  }
}
