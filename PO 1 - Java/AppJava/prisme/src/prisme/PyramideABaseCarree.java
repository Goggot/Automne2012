package prisme;

public class PyramideABaseCarree extends Prisme
{
  public PyramideABaseCarree()
  {
    super();
  }

  public PyramideABaseCarree(double coteBase, double hauteur)
  {
    super(coteBase, coteBase, hauteur);
  }

  public double airePyramide()
  {
    double hypothenuse = (Math.pow(getHauteur(),2) + Math.pow(getLargeur()/2,2));
    return (((getLargeur()/2)*Math.sqrt(hypothenuse))*4)+(getLargeur()*getLargeur());
  }
  
  public double volume()
  {
    return super.volume()/3;
  }
}