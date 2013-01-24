package packageTP2;

public class Billet
{

  private String type;
  private int numeroCommandeAssociee;
  private double prix;


  public Billet(String type, int numeroCommandeAssociee)
  {
    this.type = type;
    this.numeroCommandeAssociee = numeroCommandeAssociee;

    if (type.equals("Régulier"))
      prix = 199.99;
    else // personnes agés
      prix = 179.99;
  }


  public void setType(String type)
  {
    this.type = type;
  }

  public String getType()
  {
    return type;
  }

  public void setNumeroCommandeAssociee(int numeroCommandeAssociee)
  {
    this.numeroCommandeAssociee = numeroCommandeAssociee;
  }

  public int getNumeroCommandeAssociee()
  {
    return numeroCommandeAssociee;
  }

  public void setPrix(double prix)
  {
    this.prix = prix;
  }

  public double getPrix()
  {
    return prix;
  }


}
