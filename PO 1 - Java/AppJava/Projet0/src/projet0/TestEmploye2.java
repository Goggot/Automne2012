package projet0;


import org.junit.*;
import static org.junit.Assert.*;

public class TestEmploye2 
{

private Employe unEmploye;


@Before
  public void setUp ()
  {
                            //nom,     numero,  salaireHoraire, nbreHeures, ancienneté
  unEmploye = new Employe ( "Cloutier", "323",       12.60,               32,                   4);
  }
@Test
  public void testSalaireBrut ()
  {
  assertEquals ( 100, unEmploye.salaireBrut(), 0.02 );
  }

 

  public static void main ( String [] args ){
    org.junit.runner.JUnitCore.main("packageTP0.TestEmploye2");
  }
  
}