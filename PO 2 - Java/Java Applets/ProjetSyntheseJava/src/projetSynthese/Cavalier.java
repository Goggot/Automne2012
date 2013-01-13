package projetSynthese;

public class Cavalier extends Piece
{
  public Cavalier(String nom, String couleur)
  {
    super(nom, couleur);
  }
  
  public boolean estValide(Position depart, Position arrive)
  {
    if (norme(depart,arrive) == 5 || norme(depart,arrive) == 0)
      return true;
    else 
      return false;
  }
}
