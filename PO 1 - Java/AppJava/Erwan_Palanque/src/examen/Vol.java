package examen;

public class Vol
{
  private String vDepart;
  private String vArrive;
  private int temps;
  
  public Vol(String vDepart, String vArrive, int temps)
  {
    this.vDepart = vDepart;
    this.vArrive = vArrive;
    this.temps = temps;
  }
  
  public String getDepart()
  {
    return vDepart;
  }
  
  public String getArrive()
  {
    return vArrive;
  }
  
  public int getTemps()
  {
    return temps;
  }
  
  public void setDuree(int tempsModif)
  {
    temps=tempsModif;
  }
  
  public boolean plusLong(Vol autreVol)
  {
    if (autreVol.temps > temps)
      return false;
    else
      return true;
  }
}
