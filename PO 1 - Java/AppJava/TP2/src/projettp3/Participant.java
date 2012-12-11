package projettp3;


import java.util.Vector;
import javax.swing.JOptionPane;

public class Participant
{
  private String nom;
  private String email;
  private int maxJoueur = 0;
  private double Salaire = 0;
  private int nbGardien = 0;
  private int nbAvant = 0;
  private int nbDef = 0;
  private int nbPointsTotal = 0;
  
  public static final int MAXGARD = 2;
  public static final int MAXAV = 7;
  public static final int MAXDEF = 2;
  public static final int MAXSALAIRE = 4000000;
  
  private ListeJoueurs j = new ListeJoueurs();
  
  Vector <Joueur> joueurChoisit = new Vector <Joueur>(11);
  
  public Participant(String nom, String email)
  {
    this.nom = nom;
    this.email = email;
  }
  
  public void choixJoueur(String nom)
  {
    Joueur jc = j.rechercheJoueur(nom);
    if (jc instanceof Gardien)
      if (nbGardien < MAXGARD)
        if ((Salaire += jc.getSalaire()) < MAXSALAIRE)
        {
          maxJoueur ++;
          JOptionPane.showMessageDialog(null, "Choisi !");
          joueurChoisit.add(jc);
        }
    else if (jc instanceof Defenseur)
      if (nbDef < MAXDEF)
        if ((Salaire += jc.getSalaire()) < MAXSALAIRE)
        {
          maxJoueur ++;
          JOptionPane.showMessageDialog(null, "Choisi !");
          joueurChoisit.add(jc);
        }
    else if (jc instanceof Avant)
      if (nbAvant < MAXAV)
        if ((Salaire += jc.getSalaire()) < MAXSALAIRE)
        {
          maxJoueur ++;
          JOptionPane.showMessageDialog(null, "Choisi !");
          joueurChoisit.add(jc);
        }
  }
  
  public int getPointsTotaux()
  {
    for (int i=0; i<joueurChoisit.size(); i++)
      nbPointsTotal += joueurChoisit.get(i).getPoints();
    
    return nbPointsTotal;
  }
}


