package projetSynthese;

public class Tour extends Piece
{
  public Tour(String nom, String couleur)
  {
    super(nom, couleur);
  }
  
  public boolean estValide(Position depart, Position arrive)
  {
    if (depart.getLigne() == arrive.getLigne() || depart.getColonne() == arrive.getColonne())
      return true;
    else 
      return false;
  }
}