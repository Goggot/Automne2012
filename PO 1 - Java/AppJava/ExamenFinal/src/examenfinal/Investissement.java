package examenfinal;

public class Investissement
{
  private int nbActions;
  private String nomAction;
  private String symbole;
  private double prixUnitaire;
  
  public Investissement(int nbActions, String nom, double prix)
  {
    this.nbActions = nbActions;
    this.nomAction = nom; 
    this.prixUnitaire = prix;
    //this.symbole = nom.matches("[*a-z]");
  }
  
  public int getNbActions()
  {
    return nbActions;
  }
  
  public String getNom()
  {
    return nomAction;
  }
  
  public String getSymbole()
  {
    return symbole;
  }
  
  public double getPrix()
  {
    return prixUnitaire;
  }
  
  public void setPrix(double prix)
  {
    this.prixUnitaire = prix;
  }
  
  public double valeurTotal()
  {
    return prixUnitaire*nbActions;
  }
}
