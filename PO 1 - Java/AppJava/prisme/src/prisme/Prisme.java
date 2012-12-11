package prisme;

public class Prisme
{
  private double longueur;
  private double largeur;
  private double hauteur;
  
  public Prisme()
  {
    longueur=1;
    largeur=1;
    hauteur=1;
  }
  
  public Prisme(double longueur, double largeur, double hauteur)
  {
    this.longueur = longueur;
    this.largeur = largeur;
    this.hauteur = hauteur;
  }
  
  public double getLongueur()
  {
    return longueur;
  }
  
  public double getLargeur()
  {
    return largeur;
  }
  
  public double getHauteur()
  {
    return hauteur;
  }
  
  public void setLongueur(double longueur)
  {
    this.longueur = longueur;
  }
  
  public void setLargeur(double largeur)
  {
    this.largeur = largeur;
  }
  
  public void setHauteur(double hauteur)
  {
    this.hauteur = hauteur;
  }
  
  public double aire()
  {
    return (largeur*longueur*2)+(longueur*hauteur*2)+(hauteur*largeur*2);
  }
  
  public double volume()
  {
    return this.longueur*this.largeur*this.hauteur;
  }
}
