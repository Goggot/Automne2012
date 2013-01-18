package projetSynthese;

/** 
 * classe abstraite Piece servant de point de d�part pour tous les types de pi�ces d'un jeu d'�checs
 * @author �ric Labont�
 * @version 3
*/

public abstract class Piece {

/**
 * nom de la pi�ce selon les conventions
 */
private String nom;
/**
 * couleur de la pi�ce
 */
private String couleur;


// constructeur permettant d'initialiser le nom et la couleur d'un objet Piece

public Piece (String nom, String couleur)
{
  setNom(nom);
  setCouleur ( couleur );
}

public String getNom ()
  {
  return nom;
  }

public void setNom (String nom)
  {
  this.nom = nom;
  }

public String getCouleur ()
  {
  return couleur;
  }

public void setCouleur ( String couleur )
  {
  if (( couleur == "NOIR" ) || ( couleur == "BLANC" ))
    this.couleur = couleur;
  }
 
/** 
*m�thode permettant de calculer la norme math�matique entre deux Positions
* @param depart Position de d�part
* @param arrivee Position d'arriv�e de la Pi�ce
* @return la somme des carr�s des distances
* 
*/
public double norme (Position depart, Position arrivee)
  {
  return Math.pow((depart.getLigne()-arrivee.getLigne()), 2)+ Math.pow((depart.getColonne() - arrivee.getColonne()),2);
  }

/* methode abstraite a implementer dans chacune des sous - classes */

public abstract boolean estValide (Position depart,Position arrivee);
}
