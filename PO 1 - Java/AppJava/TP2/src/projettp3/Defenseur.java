package projettp3;

public class Defenseur extends Joueur
{
  private int nbBut;
  private int nbPasse;
  
  public Defenseur(String nom, double salaire, int nbBut, int nbPasse)
  {
    super(nom, salaire, "Defense", (nbBut+nbPasse));
    this.nbBut = nbBut;
    this.nbPasse = nbPasse;
  }
  
  public int getNbBut()
  {
    return nbBut;
  }
  
  public int getNbPasse()
  {
    return nbPasse;
  }
}
