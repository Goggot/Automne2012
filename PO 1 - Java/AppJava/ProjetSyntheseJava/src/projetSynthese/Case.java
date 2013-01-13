package projetSynthese;

public class Case
{
  private Piece LaPiece;
  
  public Case()
  {
    LaPiece=null;
  }
  
  public boolean estOccupe()
  {
    boolean valid=false;
    if (LaPiece != null)
      valid = true;
    return valid;
  }
  
  public Piece enleverPiece()
  {
    LaPiece=null;
    return LaPiece;
  }
  
  public void setPiece(Piece piece)
  {
    this.LaPiece = piece;
  }
  
  public Piece getPiece()
  {
    return LaPiece;
  }
}
