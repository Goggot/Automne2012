package projetSynthese;

/**
 * Classe de fou...
 * @author Erwan Palanque
 * @version 0.1
 */

public class Fou extends Piece
{
  public Fou(String nom, String couleur)
  {
    super(nom, couleur);
  }
  
  /**
   * Méthode de vérification du déplacement des fous...
   * @param depart {@link Position} de départ
   * @param arrive Position d'arrivée
   * @return Déplacement valide ou non
   * @see <a href="http://www.cvm.qc.ca/">Site web </a>
   */
  
  public boolean estValide(Position depart, Position arrive)
  {
    if (Math.abs(arrive.getLigne()-depart.getLigne()) ==  Math.abs(arrive.getColonne()-depart.getColonne()))
      return true;
    else
      return false;
  }
}
