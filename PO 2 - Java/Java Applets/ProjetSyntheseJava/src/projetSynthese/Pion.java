package projetSynthese;

public class Pion extends Piece
{
  public Pion(String nom, String couleur)
  {
    super(nom, couleur);
  }
  
  public boolean estValide(Position depart, Position arrive)
  {
    boolean valid = false;
    if (super.getCouleur() == "NOIR")
    {
      if (depart.getLigne() == 1)
      {
          if ((arrive.getLigne() == depart.getLigne()+2) || (arrive.getLigne() == depart.getLigne()+1))
            valid = true;
      }
      else 
      {
          if (arrive.getLigne() - depart.getLigne() == 1)
            valid = true;
      }
    }
    else if (super.getCouleur() == "BLANC")
    {
      if (depart.getLigne() == 6)
      {
          if ((arrive.getLigne() == depart.getLigne()-2) || (arrive.getLigne() == depart.getLigne()-1))
            valid = true;
      }
      else 
      {
          if (arrive.getLigne() - depart.getLigne() == -1)
            valid = true;
      }
    }
   return valid; 
  }
}
