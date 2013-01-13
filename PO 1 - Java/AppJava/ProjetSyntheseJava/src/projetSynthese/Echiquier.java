package projetSynthese;

public class Echiquier
{
  private Case[][] location;
  
  public Echiquier()
  {
    location = new Case[8][8];
    for (int i=0; i< 8; i++)
      for(int j=0; j< 8; j++)
        location[i][j] = new Case();
  }
  
  public Case getCase(int i, int j)
  {
    return location[i][j];
  }
  
  public void debuter()
  {
    for (int i=0; i<8; i++)
    {
      location[1][i].setPiece(new Pion("Pion", "noir"));
      location[6][i].setPiece(new Pion("Pion", "blanc"));
    }
    
    location[0][0].setPiece(new Tour("Tour", "noir"));
    location[0][7].setPiece(new Tour("Tour", "noir"));
    location[7][0].setPiece(new Tour("Tour", "blanc"));
    location[7][7].setPiece(new Tour("Tour", "blanc"));
    
    location[0][1].setPiece(new Cavalier("Cavalier", "noir"));
    location[0][6].setPiece(new Cavalier("Cavalier", "noir"));
    location[7][1].setPiece(new Cavalier("Cavalier", "blanc"));
    location[7][6].setPiece(new Cavalier("Cavalier", "blanc"));
    
    location[0][2].setPiece(new Fou("Fou", "noir"));
    location[0][5].setPiece(new Fou("Fou", "noir"));
    location[7][2].setPiece(new Fou("Fou", "blanc"));
    location[7][5].setPiece(new Fou("Fou", "blanc"));
    
    location[0][3].setPiece(new Roi("Roi", "noir"));
    location[0][4].setPiece(new Reine("Reine", "noir"));
    location[7][3].setPiece(new Reine("Reine", "blanc"));
    location[7][4].setPiece(new Roi("Roi", "blanc"));
  }
  
    public boolean cheminPossible(Position depart, Position arrive)    // DÉFINITION DES DÉPLACEMENTS POSSIBLE EN TOUT, PAS PAR PIÈCE
    {
        boolean valid = true;
        
        int arriveLigne = arrive.getLigne();
        int arriveColonne = arrive.getColonne();
        
        if (arrive.getLigne() == 0)
          arriveLigne = depart.getLigne();
        if (arrive.getColonne() == 0)
         arriveColonne = depart.getColonne();
        
        if (depart.getLigne() - arriveLigne > 0 && depart.getColonne() == arrive.getColonne())                      // Vérification du chemin vers le haut sur les lignes
        {
            for (int i=depart.getLigne()-1; i>depart.getLigne(); i--)
                if (location[i][arrive.getColonne()].estOccupe())
                    valid = false;
        }
        
        if (depart.getLigne() - arriveLigne < 0 && depart.getColonne() == arrive.getColonne())                      // Vérification du chemin vers le bas sur les lignes
        {
            for (int i=depart.getLigne()+1; i<depart.getLigne(); i++)
                if (location[i][arrive.getColonne()].estOccupe())
                    valid = false;
        }
        
        if (depart.getColonne() - arriveColonne > 0 && depart.getLigne() == arrive.getLigne())                  // Vérification du chemin vers le haut sur les colonnes
        {
            for (int i=depart.getColonne()-1; i>arrive.getColonne(); i--)
                if (location[arrive.getLigne()][i].estOccupe())
                    valid = false;
        }
        
        if (depart.getColonne() - arriveColonne < 0 && depart.getLigne() == arrive.getLigne())                  // Vérification du chemin vers le bas sur les colonnes
        {
            for (int i=depart.getColonne()+1; i<arrive.getColonne(); i++)
                if (location[depart.getLigne()][i].estOccupe())
                    valid = false;
        }
        
        if (depart.getColonne() - arrive.getColonne() > 0 && depart.getLigne() != arrive.getLigne())                  // Vérification de la diagonale gauche
        {
            if (depart.getLigne() - arriveLigne > 0)                      // Vérification du chemin vers le haut
            {
                int ligne = depart.getLigne();
                for (int i=depart.getColonne()-1; i>arrive.getColonne(); i--)
                    if (location[ligne--][i].estOccupe())
                        if (location[ligne--][i].getPiece().getCouleur()== location[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())
                            valid = false;
            }
            else if (depart.getLigne() - arriveLigne < 0)                 // Vérification du chemin vers le bas
            {
                int ligne = depart.getLigne();
                for (int i=depart.getColonne()+1; i<arrive.getColonne(); i++)
                    if (location[ligne++][i].estOccupe())
                        if (location[ligne++][i].getPiece().getCouleur()== location[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())
                            valid = false;
            }
        }
        
        if (depart.getColonne() - arrive.getColonne() < 0 && depart.getLigne() != arrive.getLigne())                  // Vérification de la diagonale droite
        {
            if (depart.getLigne() - arriveLigne > 0)                      // Vérification du chemin vers le haut
            {
                int ligne = depart.getLigne();
                for (int i=depart.getColonne()-1; i>arrive.getColonne(); i--)
                    if (location[ligne--][i].estOccupe())
                        if (location[ligne--][i].getPiece().getCouleur()== location[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())
                            valid = false;
            }
            else if (depart.getLigne() - arriveLigne < 0)                 // Vérification du chemin vers le bas
            {
                int ligne = depart.getLigne();
                for (int i=depart.getColonne()+1; i<arrive.getColonne(); i++)
                    if (location[ligne++][i].estOccupe())
                        if (location[ligne++][i].getPiece().getCouleur()== location[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())
                            valid = false;
            }
        }
        return valid;
    }
  
    public boolean captureParUnPionPossible(Position depart, Position arrive)
    {
        if (depart.getLigne() - arrive.getLigne() < 0 && location[depart.getLigne()][depart.getColonne()].getPiece().getCouleur() == "blanc")
          return false;
        
        else if (depart.getLigne() - arrive.getLigne() > 0 && location[depart.getLigne()][depart.getColonne()].getPiece().getCouleur() == "noir")
          return false;
      
        else {
          if (location[arrive.getLigne()][arrive.getColonne()].estOccupe())       // Si la case d'arrivée est occupé
            if (location[depart.getLigne()][depart.getColonne()].getPiece().getCouleur() != 
                  location[arrive.getLigne()][arrive.getColonne()].getPiece().getCouleur()) // Si la piece présente sur la case d'arrivée est de couleur différente
                return true;
            else
                return false;
          else
            return false;
        }
    }
}
