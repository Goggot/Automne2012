package examenfinal;

import org.junit.*;
import static org.junit.Assert.*;

public class TestJUnit
{
  Portefeuille p1 = new Portefeuille("toto", 1, 3000);
  
  @Test
  public void acheterInvestissement()
  {
    assertEquals (true, p1.acheterInvestissement(new Investissement(50, "Bell", 20)));
  }
  
  @Test
  public void testValeurTotalPortefeuille()
  {
    assertEquals (3000.00, p1.calculerTotal(), 0.02);
  }
  
  @Test 
  public void testValeurMarchande()
  {
    p1.investissement.get(0).setPrix(60);
    assertEquals (1200.00, p1.investissement.get(0).valeurTotal(), 0.02);
  }
  
  public static void main ( String [] args ){
    org.junit.runner.JUnitCore.main("examenfinal.TestJUnit");
  }
}