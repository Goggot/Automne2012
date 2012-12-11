package projetmaison;

public class Chalet extends Maison
{
  private boolean electricite;
  private boolean AccesLac;
  public Chalet(boolean electricite, boolean AccesLac, int nbrePieces, double superficieTerrain, String noAdresse, String nomRue,  double prixVente)
  {
    super(nbrePieces, superficieTerrain, noAdresse, nomRue, prixVente);
    this.electricite = electricite;
    this.AccesLac = AccesLac;
  }
  
  public boolean getElectricite()
  {
    return electricite;
  }
  
  public boolean getAccesLac()
  {
    return AccesLac;
  }
  
  public double valeur()
  {
    double valeur = super.valeur()*0.75;
    if (this.getElectricite()==true)
      valeur*=1.10;
    if (this.getAccesLac() == true)
      valeur += 5000; 
    return valeur;
  }
}
