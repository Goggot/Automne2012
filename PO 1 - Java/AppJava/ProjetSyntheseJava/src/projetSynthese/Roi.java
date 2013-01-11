package projetSynthese;

public class Roi extends Piece
{
  public Roi(String nom, String couleur)
  {
    super(nom, couleur);
  }
  
  public boolean estValide(Position depart, Position arrive)
  {
    if (norme(depart,arrive) <= 2)
      return true;
    else 
      return false;
  }
}

