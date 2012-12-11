package packageVecteur;

import java.util.*;

import java.awt.*;

public class ExempleVecteur
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

    

    // afficher la grandeur du vecteur
     


    // afficher la valeur de la donnée x du premier élément du vecteur
    // sans enlever l'élément du vecteur

  
    // afficher la valeur de la donnée y du deuxime élément du vecteur
    // sans enlever l'élément du vecteur


    // afficher la valeur de la donnée x du troisième élément du vecteur
    // sans enlever l'élément du vecteur
    // ( essayer de le faire en une étape une ligne )


    // à l'aide d'une boucle, faire le total des valeurs des données x de tous les
    // éléments du vecteur et l'afficher


  }
}
