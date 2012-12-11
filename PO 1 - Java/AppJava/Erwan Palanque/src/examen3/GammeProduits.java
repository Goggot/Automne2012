package examen3;

import java.util.Vector;

public class GammeProduits
{
  Vector <Ordinateur> gamme = new Vector <Ordinateur>(5);
  
  public GammeProduits(Vector<Ordinateur> gamme)
  {
    this.gamme = gamme;
  }
  
  public void ajouterOrdi(Ordinateur o)
  {
    gamme.add(o);
  }
  
  public double moyenneCout()
  {
    double prixMoyen = 0;
    
    for (int i=0; i<gamme.size(); i++)
      prixMoyen+= gamme.get(i).getPrix();
    
    prixMoyen /= gamme.size();
    
    return prixMoyen;
  }
  
  public Ordinateur plusPerformant()
  {
    double vitesse = 0;
    int num = 0;
    
    for (int i=0; i<gamme.size(); i++)
      if (gamme.get(i).getGhz() > vitesse)
      {
        vitesse = gamme.get(i).getGhz();
        num = i;
      }
    
    return gamme.get(num);
  }
}
