package projetSynthese;

public class Reine extends Piece
{
  public Reine(String nom, String couleur)
  {
    super(nom, couleur);
  }
  
  public boolean estValide(Position depart, Position arrive)
  {
    if (Math.abs(arrive.getLigne()-depart.getLigne()) ==  Math.abs(arrive.getColonne()-depart.getColonne()))
      return true;
    else if (depart.getLigne() == arrive.getLigne() || depart.getColonne() == arrive.getColonne())
      return true;
    else
      return false;
  }
}
