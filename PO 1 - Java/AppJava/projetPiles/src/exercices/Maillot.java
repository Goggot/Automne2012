package exercices;

public class Maillot extends Article 
{
  private String  taille;

  public Maillot ( String code, String taille )
  {
  setCode(code);
  if ( code.equals( "123" ))
    setPrix(39.99);
  else if ( code.equals( "456" ))
    setPrix(49.99);
  else if ( code.equals ( "789"))
    setPrix (59.99);
  else
    setPrix(0);
  setTaille(taille );
  }

  public String  getTaille()
  {
  return taille;
  }

  public void setTaille (String  taille)
  {
  this.taille = taille;
  }


  
}