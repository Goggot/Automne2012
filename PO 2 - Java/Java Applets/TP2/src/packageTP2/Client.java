package packageTP2;

import java.util.GregorianCalendar;


public class Client
{

  private String noCarteMembre;
  private String nom;
  private int nbPointsBonis;
  private String coordonnees;
  private GregorianCalendar dateNaissance;

  public Client(String noCarteMembre, String nom, String coordonnees,
                GregorianCalendar dateNaissance)
  {
    this.noCarteMembre = noCarteMembre;
    this.nbPointsBonis = 0;
    this.nom = nom;
    this.coordonnees = coordonnees;
    this.dateNaissance = dateNaissance;
  }

  public String getNoCarte()
  {
    return noCarteMembre;
  }

  public String getNom()
  {
    return nom;
  }

  public int getNbPointsBonis()
  {
    return nbPointsBonis;
  }

  public void modifierPointsBonis(int nbPoints)
  {
    this.nbPointsBonis += nbPoints;
  }


  public boolean assezArgent(Commande c, double montant,
                             int nbPointsBonisPourPayer)
  {
    double total = c.calculerGrandTotal(nbPointsBonisPourPayer);
    if (montant >= total)
      return true;
    else
      return false;
  }

  public double paieCommande(Commande c, double montant,
                             int nbPointsBonisPourPayer)
  {
    double total = c.calculerGrandTotal(nbPointsBonisPourPayer);
    double change = montant - total;
    int nbPoints = c.calculerPointsBonis();
    if (change > 0)
      modifierPointsBonis(nbPoints);


    return change;
  }

  public void setNbPointsBonis(int nbPointsBonis)
  {
    this.nbPointsBonis = nbPointsBonis;
  }

  public void setCoordonnees(String coordonnees)
  {
    this.coordonnees = coordonnees;
  }

  public String getCoordonnees()
  {
    return coordonnees;
  }

  public void setDateNaissance(GregorianCalendar dateNaissance)
  {
    this.dateNaissance = dateNaissance;
  }

  public GregorianCalendar getDateNaissance()
  {
    return dateNaissance;
  }
}
