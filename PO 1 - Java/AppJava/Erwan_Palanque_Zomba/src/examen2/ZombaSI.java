package examen2;

import java.util.GregorianCalendar;

public class ZombaSI extends Zomba
{
  public ZombaSI(String couleur, boolean airClimatise, GregorianCalendar date)
  {
    super(2,couleur, airClimatise, false, date);
  }
  
  public double calculerPrix()
  {
    return 25000.00;
  }
  
  
}
