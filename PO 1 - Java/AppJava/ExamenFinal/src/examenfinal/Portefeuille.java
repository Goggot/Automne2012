package examenfinal;

import java.util.Iterator;
import java.util.Vector;

public class Portefeuille
{
  private String nomClient;
  private int numClient;
  private double encaisse;
  
  Vector <Investissement> investissement;
  
  public Portefeuille(String nom, int num, double encaisse)
  {
    this.nomClient = nom;
    this.numClient = num;
    this.encaisse = encaisse;
    
    this.investissement = new Vector <Investissement>();
  }
  
  public boolean acheterInvestissement(Investissement inv)
  {
    if (inv.valeurTotal() <= encaisse)
    {
      encaisse -= inv.valeurTotal();
      investissement.add(inv);
      return true;
    }
    else
      return false;
  }
  
  public void vendreInvestissement(String nom)
  {
    for (int i=0; i<investissement.size(); i++)
      if (investissement.get(i).getNom().equals(nom))
      {
        encaisse += investissement.get(i).valeurTotal();
        investissement.remove(i);
      }
  }
  
  public double calculerTotal()
  {
    double total=0;
    
    for (int i=0; i<investissement.size(); i++)
      total += investissement.get(i).valeurTotal();
        
    return total+encaisse;
  }
  
  public void trierOrdreValeur()
  {
    double plusGrand;
    int indice=0;
    
    Vector <Investissement> investissementTrier = new Vector <Investissement>();
    Iterator <Investissement> i = investissement.iterator();
    
    while (i.hasNext())
    {
      plusGrand = 0;
      for (int j=0; j<investissement.size(); j++)
        if (investissement.get(j).valeurTotal() > plusGrand)
        {
          plusGrand = investissement.get(j).valeurTotal();
          indice = j;
        }
      
      investissementTrier.add(investissement.get(indice));
      investissement.remove(indice);
    }
    
    investissement = investissementTrier;
  }
}



