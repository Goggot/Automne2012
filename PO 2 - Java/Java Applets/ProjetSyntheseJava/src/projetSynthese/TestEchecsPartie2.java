package projetSynthese;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestEchecsPartie2 
{

// pr�sentation de variables, d'objets
Echiquier e;

 @Before
  public void setUp () {
  
  //cr�ation d'objets, initialisation de variables
    e = new Echiquier ();
    e.getCase(2,0).setPiece(new Reine("r","NOIR"));
    e.getCase(4,0).setPiece(new Pion ("p1", "BLANC"));
    e.getCase(5,0).setPiece(new Tour ("t1","BLANC"));
    e.getCase(0,1).setPiece(new Tour ("t2", "NOIR"));
    e.getCase(1,1).setPiece(new Pion ("p1", "NOIR"));
    e.getCase(5,2).setPiece(new Fou ("f1", "NOIR"));
    e.getCase(3,3).setPiece(new Cavalier("c1", "NOIR"));
    e.getCase(1,4).setPiece(new Pion ("p2", "BLANC"));
    e.getCase(4,4).setPiece(new Roi("k", "BLANC"));
    e.getCase(7,4).setPiece(new Cavalier("c2", "NOIR"));
    e.getCase(2,5).setPiece(new Pion("p3", "NOIR"));
    e.getCase(1,6).setPiece(new Pion("p3", "BLANC"));
    e.getCase(3,6).setPiece(new Pion ("p4", "BLANC"));
    e.getCase(4,6).setPiece(new Pion ("p4", "NOIR"));
    e.getCase(5,6).setPiece(new Reine("r", "BLANC"));
    e.getCase(7,7).setPiece(new Tour("t2", "BLANC"));
    }
 
  //test v�rifiant qu'un Pion peut se d�placer en ligne droite
  @Test
  public void test1 (){
    Position depart = new Position (4,0);
    Position arrivee = new Position (3,0);
    assertEquals( true,e.cheminPossible(depart, arrivee));
    }
  // test v�rifiant qu'une Reine peut capturer une pi�ce ennemie en ligne droite
  @Test
  public void test2(){
    Position depart = new Position (2,0);
    Position arrivee = new Position (4,0);
    assertEquals( true,e.cheminPossible(depart, arrivee));
    }
  // test v�rifiant qu'une Reine ne peut passer au-dessus d'une autre Pi�ce
  
  @Test
  public void test3(){
    Position depart = new Position (2,0);
    Position arrivee = new Position (5,0);
    assertEquals( false,e.cheminPossible(depart, arrivee));
    }
// test v�rifiant qu'une Tour  peut capturer une Pi�ce ennemie
  @Test
  public void test4(){
    Position depart = new Position (5,0);
    Position arrivee = new Position (5,2);
    assertEquals( true,e.cheminPossible(depart, arrivee));
    }

  // test v�rfiiant qu'un Fou peut se d�placer en diagonale vers une case libre
  @Test
   public void test5(){
    Position depart = new Position (5,2);
    Position arrivee = new Position (3,0);
    assertEquals( true,e.cheminPossible(depart, arrivee));
    } 

    // test v�rfiiant qu'un Fou ne peut capturer une pi�ce de m�me couleur
    @Test
   public void test6(){
    Position depart = new Position (5,2);
    Position arrivee = new Position (7,4);
    assertEquals( false,e.cheminPossible(depart, arrivee));
    } 

    // test v�rfiiant qu'un Pion  peut se d�placer en ligne droite
    @Test 
   public void test7(){
    Position depart = new Position (1,1);
    Position arrivee = new Position (2,1);
    assertEquals( true,e.cheminPossible(depart, arrivee));
    } 

    // test v�rfiiant qu'un Cavalier ne peut capturer une pi�ce de m�me couleur
    @Test
   public void test8(){
    Position depart = new Position (3,3);
    Position arrivee = new Position (5,2);
    assertEquals( false,e.cheminPossible(depart, arrivee));
    } 
    // test v�rfiiant qu'un Cavalier peut se d�placer vers une case vide
    @Test
  public void test9(){
    Position depart = new Position (3,3);
    Position arrivee = new Position (1,2);
    assertEquals( true,e.cheminPossible(depart, arrivee));
    } 

    // test v�rfiiant qu'un Cavalier peut capturer une pi�ce ennemie
    @Test
   public void test10(){
    Position depart = new Position (3,3);
    Position arrivee = new Position (1,4);
    assertEquals( true,e.cheminPossible(depart, arrivee));
    }

    // test v�rfiiant qu'un Roi peut capturer une Pi�ce ennemie
    @Test
   public void test11(){
    Position depart = new Position (4,4);
    Position arrivee = new Position (3,3);
    assertEquals( true,e.cheminPossible(depart, arrivee));
    } 

    // test v�rfiiant qu'un Roi peut se d�placer vers une case vide
    @Test
   public void test12(){
    Position depart = new Position (4,4);
    Position arrivee = new Position (4,5);
    assertEquals( true,e.cheminPossible(depart, arrivee));
    } 
    // test v�rfiiant qu'une Reine peut capturer une autre Piece en diagonale
    @Test
   public void test13(){
    Position depart = new Position (5,6);
    Position arrivee = new Position (0,1);
    assertEquals( true,e.cheminPossible(depart, arrivee));
    }

    // test v�rfiiant qu'une Reine ne peut pas passer au-dessus d'une autre Piece
    @Test
   public void test14(){
    Position depart = new Position (5,6);
    Position arrivee = new Position (5,1);
    assertEquals( false,e.cheminPossible(depart, arrivee));
    } 
    // test v�rfiiant qu'une Reine peut capturer une Piece ennemie � l'horizontale
    @Test
   public void test15(){
    Position depart = new Position (5,6);
    Position arrivee = new Position (5,2);
    assertEquals( true,e.cheminPossible(depart, arrivee));
    } 
    // test v�rfiiant qu'une Reine peut se d�placer vers une case libre
    @Test
   public void test16(){
    Position depart = new Position (5,6);
    Position arrivee = new Position (5,3);
    assertEquals( true,e.cheminPossible(depart, arrivee));
    } 
    // test v�rfiiant qu'un Pion ne peut pas capturer une Piece en ligne droite

    @Test
   public void test17(){
    Position depart = new Position (4,6);
    Position arrivee = new Position (5,6);
    assertEquals( false,e.cheminPossible(depart, arrivee));
    } 
    // test v�rfiiant qu'une Tour peut se d�placer vers une case vide
    
    @Test
   public void test18(){
    Position depart = new Position (7,7);
    Position arrivee = new Position (0,7);
    assertEquals( true,e.cheminPossible(depart, arrivee));
    } 
    // test v�rfiiant qu'une Tour peut se d�placer vers une case vide
    @Test
   public void test19(){
    Position depart = new Position (7,7);
    Position arrivee = new Position (5,7);
    assertEquals( true,e.cheminPossible(depart, arrivee));
    } 
    // test v�rfiiant qu'une Piece peut ne pas bouger
    @Test
   public void test20(){
    Position depart = new Position (2,0);
    Position arrivee = new Position (2,0);
    assertEquals( true,e.cheminPossible(depart, arrivee));
    } 
    // test v�rfiiant qu'une Pion ne peut pas se d�placer diagonalement vers une Case libre
    @Test
   public void testUn(){
    Position depart = new Position (1,4);
    Position arrivee = new Position (0,5);
    assertEquals( false,e.captureParUnPionPossible(depart, arrivee));
    } 

  // test v�rfiiant qu'une Pion ne peut pas se d�placer diagonalement en reculant
  @Test
   public void testDeux(){
    Position depart = new Position (1,4);
    Position arrivee = new Position (2,5);
    assertEquals( false,e.captureParUnPionPossible(depart, arrivee));
    }
    // test v�rfiiant qu'une Pion ne peut pas se d�placer diagonalement en reculant
    @Test
   public void testTrois(){
    Position depart = new Position (2,5);
    Position arrivee = new Position (1,6);
    assertEquals( false,e.captureParUnPionPossible(depart, arrivee));
    } 
    // test v�rfiiant qu'une Pion ne peut pas se d�placer diagonalement en reculant
    @Test
   public void testQuatre(){
    Position depart = new Position (1,6);
    Position arrivee = new Position (2,5);
    assertEquals( false,e.captureParUnPionPossible(depart, arrivee));
    } 
    // test v�rfiiant qu'une Pion ne peut pas se d�placer diagonalement en reculant
    @Test
   public void testCinq(){
    Position depart = new Position (1,6);
    Position arrivee = new Position (2,7);
    assertEquals( false,e.captureParUnPionPossible(depart, arrivee));
    } 
    // test v�rfiiant qu'une Pion peut capturer une piece ennemie en diagonale
    @Test
   public void testSix(){
    Position depart = new Position (2,5);
    Position arrivee = new Position (3,6);
    assertEquals( true,e.captureParUnPionPossible(depart, arrivee));
    }
    
    
    

    public static void main ( String [] args ){
      org.junit.runner.JUnitCore.main("projetSynthese.TestEchecsPartie2");
    }


}