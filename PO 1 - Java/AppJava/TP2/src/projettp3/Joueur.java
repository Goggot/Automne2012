package projettp3;

public class Joueur
{
  private String nom;
  private double salaire;
  private String poste;
  private int points;
  
  public Joueur (String nom, double salaire, String poste, int points)
  {
    this.nom = nom;
    this.salaire = salaire;
    this.poste = poste;
    this.points = points;
  }
  
  public String getNom()
  {
    return nom;
  }
  
  public double getSalaire()
  {
    return salaire;
  }
  
  public int getPoints()
  {
    return points;
  }
}
