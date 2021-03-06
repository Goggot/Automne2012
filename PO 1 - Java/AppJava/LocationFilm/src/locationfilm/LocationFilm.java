package LocationFilm;

public class LocationFilm
{
  private double prix;
  private int duree;
  private String nom;

  public LocationFilm (String nom)
  {
    prix = 3.75;
    duree = 1;
    this.nom = nom;
  }
  
  public LocationFilm (int duree, String nom)
  {
    this.nom = nom;
    this.duree = duree;
    prix = 1.75*this.duree;
  }
  
  public LocationFilm (double prix, int duree, String nom)
  {
    this.prix = prix;
    this.duree = duree;
    this.nom = nom;
  }
  
  public double getPrix()
  {
    return prix;
  }
  
  public void setPrix(double prix)
  {
    this.prix = prix;
  }
}