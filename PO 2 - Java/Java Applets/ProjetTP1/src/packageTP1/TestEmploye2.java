package packageTP1;

import junit.extensions.*;
import junit.framework.*;

public class TestEmploye2 extends TestCase
{

Employe unEmploye;
  public TestEmploye2(String nom)
  {
  super ( nom );
  }

  protected void setUp ()
  {
                                                  //nom,     numero,  salaireHoraire, nbreHeures, ancienneté
  unEmploye = new Employe ( "Cloutier", "323",       12.60,               32,                   4);
  }

  public void testSalaireBrut ()
  {
  assertEquals ( 403.20, unEmploye.salaireBrut(), 0.02 );
  }

  public static Test suite () {
  return new TestSuite ( TestEmploye2.class );
  }

  public static void main ( String [] args ){
  String [] testCaseName = { TestEmploye2.class.getName()};
  junit.swingui.TestRunner.main ( testCaseName );
  }
  
}