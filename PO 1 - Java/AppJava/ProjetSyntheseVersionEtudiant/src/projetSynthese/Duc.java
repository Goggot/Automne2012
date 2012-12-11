package projetSynthese;

public class Duc extends Piece
{
  public Duc(String nom, String couleur)
  {
    super(nom, couleur);
  }
  
  public boolean estValide(Position depart, Position arrive)
  {
    if (depart.getColonne() == arrive.getColonne())
      if (arrive.getLigne() - depart.getLigne() == 2 && super.getCouleur() == "noir")
        return true;
      else if (arrive.getLigne() - depart.getLigne() == -2 && super.getCouleur() == "blanc")
        return true;
    
    else if (depart.getLigne() == arrive.getLigne())
      if (arrive.getColonne() - depart.getColonne() == -2 && super.getCouleur() == "noir")
        return true;
      else if (arrive.getColonne() - depart.getColonne() == 2 && super.getCouleur() == "blanc")
        return true;
    
    else if (depart.getLigne() == arrive.getLigne() && depart.getColonne() == arrive.getColonne())
        return true;
    else 
        return false;
  }
}
