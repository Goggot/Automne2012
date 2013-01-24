package projetexceptions;
import javax.swing.*;
public class Placement 
{


private double montant;
private int nbMois;

private static final double INTERET = 0.0037;

  public Placement( double montant, int nbMois) throws NegatifException
  {
    if (montant < 0)
        throw new NegatifException("Montant");
    this.montant = montant;
    this.nbMois = nbMois;
  }

  public double calculerMontantFinal ()
  {
  double total = montant;
  for ( int i = 0; i < nbMois ; i ++ )
    total = total + total * INTERET;
  return total;
  }
  
}