package packageVecteur;

import java.util.*;

import java.awt.*;

public class ExempleVecteur
{
  public static void main(String[] args)
  {
    // Cr�ation d'un vecteur sans g�n�rique
    Vector v = new Vector(3);

    // insertion ds le vecteur en une �tape

    v.add(new Point(3, 3));

    // insertion ds le vecteur en deux �tapes

    Point p = new Point(2, 4);
    v.add(p);


    v.add(new Point(5, 5));
    v.insertElementAt(new Point(8, 5), 0);
    v.insertElementAt(new Point(4, 7), 2);

    v.removeElementAt(4);

    // afficher la capacit� du vecteur

    

    // afficher la grandeur du vecteur
     


    // afficher la valeur de la donn�e x du premier �l�ment du vecteur
    // sans enlever l'�l�ment du vecteur

  
    // afficher la valeur de la donn�e y du deuxime �l�ment du vecteur
    // sans enlever l'�l�ment du vecteur


    // afficher la valeur de la donn�e x du troisi�me �l�ment du vecteur
    // sans enlever l'�l�ment du vecteur
    // ( essayer de le faire en une �tape une ligne )


    // � l'aide d'une boucle, faire le total des valeurs des donn�es x de tous les
    // �l�ments du vecteur et l'afficher


  }
}
