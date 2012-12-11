package projettp3;

import java.util.Vector;

public class ListeJoueurs
{
  
  Vector <Joueur> joueur = new Vector <Joueur> (20);

  public Joueur rechercheJoueur(String nom)
  {
    for (int i=0; i < joueur.size(); i++)
      if (joueur.get(i).getNom().equals(nom))
        return joueur.get(i);
    return null;
  }
  
  public ListeJoueurs()
  {
    joueur.add(new Gardien("Read", 850000, 5, 15));
    joueur.add(new Defenseur("Stamkos", 1000000, 32, 156));
    joueur.add(new Avant("Malkin", 1000000, 50, 339));
    joueur.add(new Avant("Stamkos", 1000000, 45, 212));
    joueur.add(new Defenseur("Franzen", 2789000, 25, 321));
    joueur.add(new Avant("Vrbata", 1850000, 36, 167));
    joueur.add(new Avant("Sharp", 2600000, 54, 289));
    joueur.add(new Avant("Tavares", 3525000, 65, 300));
    joueur.add(new Avant("Norris", 40000000, 420, 420));
    joueur.add(new Defenseur("Marleau", 3200000, 32, 156));
    joueur.add(new Avant("Gaborik", 1289800, 22, 203));
    joueur.add(new Avant("Benn", 2653000, 55, 422));
    joueur.add(new Gardien("Sedin", 2350000, 26, 9));
    joueur.add(new Defenseur("Hartnell", 1678000, 34, 160));
    joueur.add(new Avant("Cole", 1234000, 65, 263));
    joueur.add(new Avant("Perry", 265000, 48, 230));
    joueur.add(new Gardien("Weiss", 2410000, 29, 16));
    joueur.add(new Defenseur("Brown", 2630000, 37, 123));
    joueur.add(new Gardien("Pietrangelo", 1321000, 18, 7));
    joueur.add(new Defenseur("Ladd", 2630000, 46, 176));
  }

  public void setJoueur(Vector<Joueur> joueur)
  {
    this.joueur = joueur;
  }

  public Vector<Joueur> getJoueur()
  {
    return joueur;
  }
}
