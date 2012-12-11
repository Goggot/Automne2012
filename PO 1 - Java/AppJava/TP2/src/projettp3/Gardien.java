package projettp3;

public class Gardien extends Joueur
{
  private int nbVictoire;
  private int nbBlanc;
  
  public Gardien(String nom, double salaire, int nbVictoire, int nbBlanc)
  {
    super(nom, salaire, "Gardien", (nbVictoire+(nbBlanc*3)));
    this.nbVictoire = nbVictoire;
    this.nbBlanc = nbBlanc;
  }
  
  public int getNbVictoire()
  {
    return nbVictoire;
  }
  
  public int getNbBlanc()
  {
    return nbBlanc;
  }
}
