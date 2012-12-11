package examen3;

public class Ordinateur
{
  private double prix;
  private String modele;
  private int go;
  private double ghz;
  
  public Ordinateur(double prix, String modele, int go, double ghz)
  {
    this.prix = prix;
    this.modele = modele;
    this.go = go;
    this.ghz = ghz;
  }
  
  public double getPrix()
  {
    return prix;
  }
  
  public String getModele()
  {
    return modele;
  }
  
  public int getGo()
  {
    return go;
  }
  
  public double getGhz()
  {
    return ghz;
  }
}
