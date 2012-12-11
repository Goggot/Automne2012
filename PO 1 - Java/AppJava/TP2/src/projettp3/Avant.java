package projettp3;

public class Avant extends Joueur
{
  private int nbBut;
  private int nbPasse;
  
  public Avant(String nom, double salaire, int nbBut, int nbPasse)
  {
    super(nom, salaire, "Avant", (nbBut+nbPasse));
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
