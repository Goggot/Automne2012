package exerciceVecteur;

import java.util.*;

import java.awt.*;

public class exercice
{
  public static void main(String[] args)
  {
    // Création d'un vecteur sans générique
    Vector v = new Vector(3);

    // insertion ds le vecteur en une étape

    v.add(new Point(3, 3));

    // insertion ds le vecteur en deux étapes

    Point p = new Point(2, 4);
    v.add(p);


    v.add(new Point(5, 5));
    v.insertElementAt(new Point(8, 5), 0);
    v.insertElementAt(new Point(4, 7), 2);

    v.removeElementAt(4);

    // afficher la capacité du vecteur

    System.out.println(v.capacity());

    // afficher la grandeur du vecteur
     
    System.out.println(v.size());

    // afficher la valeur de la donnée x du premier élément du vecteur
    // sans enlever l'élément du vecteur

    Point x = (Point)v.get(0);
    System.out.println(x.getX());
  
    // afficher la valeur de la donnée y du deuxime élément du vecteur
    // sans enlever l'élément du vecteur
    
    Point y = (Point)v.get(1);
    System.out.println(y.getY());

    // afficher la valeur de la donnée x du troisième élément du vecteur
    // sans enlever l'élément du vecteur
    // (essayer de le faire en une étape)
  
    System.out.println(((Point) v.get(2)).getX());
    
    // à l'aide d'une boucle, faire le total des valeurs des données x de tous les
    // éléments du vecteur et l'afficher
    double total = 0;
    for (int i=0; i<v.size(); i++)
    {
      Point z = (Point) v.get(i);
      total += z.getX();
    }
    System.out.println(total);
  }
}
