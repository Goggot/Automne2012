package examen2;

import java.util.GregorianCalendar;

public class Test
{
  
  public static void main(String[] args)
  {
    GregorianCalendar date1 = new GregorianCalendar(2010, 20, 1);
    GregorianCalendar date2 = new GregorianCalendar(2010, 14, 3);
    GregorianCalendar date3 = new GregorianCalendar(2010, 29, 6);
    GregorianCalendar date4 = new GregorianCalendar(2010, 4, 9);
    
    Zomba[] inventaire = new Zomba[4];
    inventaire[0] = new Zomba(2, "Rouge", true, true, date1);
    inventaire[1] = new Zomba(2, "Bleu", true, false, date2);
    inventaire[2] = new ZombaSI("Rouge", true, date3);
    inventaire[3] = new ZombaSI("Noir", false, date4);
    
    Concessionnaire Concessionnaire = new Concessionnaire(inventaire);

    System.out.println(Concessionnaire.calculerInventaire("Rouge"));
    System.out.println(Concessionnaire.retourAuFabriquant());
    
  }
}
