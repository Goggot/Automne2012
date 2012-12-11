package annexe6;

public class CompteBancaire
{
  private String nom;
  private double solde;
  private String numCompte;

  private static int nombreCompte;
  
  public CompteBancaire(String nom, double solde)
  {
    this.nombreCompte++;
    this.nom = nom;
    this.solde = solde;
    numCompte = nom.charAt(0)+"-"+nombreCompte;
  }
  
  public String getNom()
  {
    return nom;
  }
  
  public String getNum()
  {
    return numCompte;
  }
  
  public double getSolde()
  {
    return solde;
  }
  
  public void Deposer(double sommeAjoute)
  {
    solde += sommeAjoute;
  }
  
  public void Retire(double sommeRetire)
  {
    solde -= sommeRetire;
  }
}