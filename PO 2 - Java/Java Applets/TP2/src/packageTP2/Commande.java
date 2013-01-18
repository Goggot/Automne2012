package packageTP2;

import java.util.*;

public class Commande
{
  private int numero;
  private String noCarteMembre;
  private Vector<Billet> billets;
  private boolean nouveauClient;

  public static final double PRIX_FORMATION = 45.99;
  private static int compteur;

  public Commande(String noCarte, boolean nouveauClient)
  {
    this.numero = compteur++;
    this.noCarteMembre = noCarte;
    billets = new Vector<Billet>();
    this.nouveauClient = nouveauClient;

  }

  public int getNumero()
  {
    return numero;
  }

  public String getNoCarteMembre()
  {
    return noCarteMembre;
  }

  public Vector getBillets()
  {
    return billets;
  }

  public void ajouterBillet()
  {
    String typeClient;
    GregorianCalendar dateActuelle = new GregorianCalendar();
    Client c = EnsembleClients.getClient(noCarteMembre);
    c.getDateNaissance().add(Calendar.YEAR, 65);
    if (c.getDateNaissance().before(dateActuelle))
      typeClient = "AgeDor";
    else
      typeClient = "Régulier";
    c.getDateNaissance().add(Calendar.YEAR, -65);
    Billet b = new Billet(typeClient, numero);
    billets.add(b);
  }

  public double calculerSousTotal()
  {
    double total = 0;
    for (int i = 0; i < billets.size(); i++)
    {
      Billet billet = billets.get(i);
      double prix = billet.getPrix();
      total += prix;
    }
    if (nouveauClient)
      total += PRIX_FORMATION;
    return total;
  }

  public double calculerTPS()
  {
    double total = calculerSousTotal();
    return total * 0.05;
  }

  public double calculerTVQ()
  {
    double total = calculerSousTotal() + calculerTPS();
    return total * 0.095;
  }

  public double calculerGrandTotal(int nbPointsUtilises)
  {
    return calculerSousTotal() + calculerTPS() + calculerTVQ() -
      utiliserPointsBonis(nbPointsUtilises);
  }

  public int calculerPointsBonis()
  {
    int points = 0;
    for (int i = 0; i < billets.size(); i++)
    {
      Billet b = billets.get(i);
      if (b.getType().equals("Régulier"))
        points += 75;
      else
        points += 85;


    }


    return points;
  }

  public int utiliserPointsBonis(int nbPointsBonisUtilises)
  {


    int nbDollarsEconomises = nbPointsBonisUtilises / 100;
    EnsembleClients.getClient(noCarteMembre).modifierPointsBonis(-nbPointsBonisUtilises);
    return nbDollarsEconomises;
  }


  public boolean isNouveauClient()
  {
    return nouveauClient;
  }
}
