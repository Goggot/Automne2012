package projetSynthese;

import org.junit.*;
import static org.junit.Assert.*;

public class TESTP1
{
  @Test 
  public void testTour ()
  {
    Tour t1 = new Tour("Tour1", "blanc");
    Position depart = new Position(2,4);
    Position arrive = new Position(4,4);
    assertEquals (true, t1.estValide(depart, arrive));
  }
  
  @Test 
  public void testTour2() 
  {
    Tour t2 = new Tour("Tour2", "noir");
    Position depart = new Position(7,4);
    Position arrive = new Position(2,4);
    assertEquals (true, t2.estValide(depart, arrive));
  }
  
  @Test 
  public void testTour3() 
  {
    Tour t3 = new Tour("Tour3", "blanc");
    Position depart = new Position(1,7);
    Position arrive = new Position(3,4);
    assertEquals (false, t3.estValide(depart, arrive));
  }
  
  @Test 
  public void testTour4() 
  {
    Tour t4 = new Tour("Tour4", "noir");
    Position depart = new Position(0,0);
    Position arrive = new Position(7,5);
    assertEquals (false, t4.estValide(depart, arrive));
  }
  
  @Test 
  public void testTour5() 
  {
    Tour t5 = new Tour("Tour5", "blanc");
    Position depart = new Position(9,9);
    Position arrive = new Position(9,5);
    assertEquals (true, t5.estValide(depart, arrive));
  }
  
  @Test 
  public void testTour6() 
  {
    Tour t6 = new Tour("Tour6", "noir");
    Position depart = new Position(3,8);
    Position arrive = new Position(2,4);
    assertEquals (false, t6.estValide(depart, arrive));
  }
  
  @Test 
  public void testTour7() 
  {
    Tour t7 = new Tour("Tour7", "blanc");
    Position depart = new Position(4,4);
    Position arrive = new Position(5,4);
    assertEquals (true, t7.estValide(depart, arrive));
  }
  
  @Test 
  public void testTour8() 
  {
    Tour t8 = new Tour("Tour8", "blanc");
    Position depart = new Position(6,9);
    Position arrive = new Position(9,6);
    assertEquals (false, t8.estValide(depart, arrive));
  }
  
  @Test 
  public void testTour9() 
  {
    Tour t9 = new Tour("Tour9", "noir");
    Position depart = new Position(12,4);
    Position arrive = new Position(12,4);
    assertEquals (true, t9.estValide(depart, arrive));
  }
  
  @Test 
  public void testTour10() 
  {
    Tour t10 = new Tour("Tour10", "noir");
    Position depart = new Position(2,1);
    Position arrive = new Position(2,0);
    assertEquals (true, t10.estValide(depart, arrive));
  }
  
  public static void main ( String [] args ){
    org.junit.runner.JUnitCore.main("projetSynthese.TESTP1");
  }
}
