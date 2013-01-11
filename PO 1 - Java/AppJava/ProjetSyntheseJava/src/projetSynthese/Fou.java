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
   * M�thode de v�rification du d�placement des fous...
   * @param depart {@link Position} de d�part
   * @param arrive Position d'arriv�e
   * @return D�placement valide ou non
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
