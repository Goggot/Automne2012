package examen3;

import java.util.Vector;

public class Test
{
  public static void main(String[] args)
  {
    GammeProduits g = new GammeProduits(new Vector<Ordinateur>());
    g.ajouterOrdi(new Ordinateur(799.99, "Inspiron", 400, 3));
    g.ajouterOrdi(new Ordinateur(899.99, "Vaio", 500, 2.57));
    g.ajouterOrdi(new Ordinateur(959.99, "Pavillion", 600, 2.3));
    g.ajouterOrdi(new Ordinateur(639.99, "Acer", 500, 2.7));
    
    System.out.println(g.moyenneCout());
    Ordinateur o = g.plusPerformant();
    System.out.println(o.getModele());
  }
}
