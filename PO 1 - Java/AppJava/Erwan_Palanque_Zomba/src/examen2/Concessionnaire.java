package examen2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Concessionnaire
{
  Zomba[] inventaire = new Zomba[2];
  
  public Concessionnaire(Zomba[] inventaire)
  {
    this.inventaire = inventaire;
  }
  
  public double calculerInventaire(String couleur)
  {
    double prix = 0;
    
    for (int i=0; i<inventaire.length; i++)
      if (inventaire[i].getCouleur() == couleur)
        prix += inventaire[i].calculerPrix();
    
    return prix;
  }
  
  public int retourAuFabriquant()
  {
    GregorianCalendar present = new GregorianCalendar();
    int nbVoiture = 0;
    
    for (int i=0; i<inventaire.length; i++)
    {
      GregorianCalendar date = inventaire[i].getDate();
      if ((present.get(Calendar.MONTH) - date.get(Calendar.MONTH)) > 4 
              || (present.get(Calendar.YEAR) != date.get(Calendar.YEAR)))
        nbVoiture++;
    }
    
    return nbVoiture;
  }
}
