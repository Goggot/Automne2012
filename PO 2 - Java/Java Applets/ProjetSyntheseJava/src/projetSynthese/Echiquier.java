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
      location[1][i].setPiece(new Pion("Pion", "NOIR"));
      location[6][i].setPiece(new Pion("Pion", "BLANC"));
    }
    
    location[0][0].setPiece(new Tour("Tour", "NOIR"));
    location[0][7].setPiece(new Tour("Tour", "NOIR"));
    location[7][0].setPiece(new Tour("Tour", "BLANC"));
    location[7][7].setPiece(new Tour("Tour", "BLANC"));
    
    location[0][1].setPiece(new Cavalier("Cavalier", "NOIR"));
    location[0][6].setPiece(new Cavalier("Cavalier", "NOIR"));
    location[7][1].setPiece(new Cavalier("Cavalier", "BLANC"));
    location[7][6].setPiece(new Cavalier("Cavalier", "BLANC"));
    
    location[0][2].setPiece(new Fou("Fou", "NOIR"));
    location[0][5].setPiece(new Fou("Fou", "NOIR"));
    location[7][2].setPiece(new Fou("Fou", "BLANC"));
    location[7][5].setPiece(new Fou("Fou", "BLANC"));
    
    location[0][3].setPiece(new Roi("Roi", "NOIR"));
    location[0][4].setPiece(new Reine("Reine", "NOIR"));
    location[7][3].setPiece(new Reine("Reine", "BLANC"));
    location[7][4].setPiece(new Roi("Roi", "BLANC"));
  }
  
    public boolean cheminPossible(Position depart, Position arrive)    // DEFINITION DES DEPLACEMENTS POSSIBLE
    {
        boolean valid = true;
        boolean pion = false;
        
        int arriveLigne = arrive.getLigne();
        int arriveColonne = arrive.getColonne();
        
        if (arrive.getLigne() == 0)
          arriveLigne = depart.getLigne();
        if (arrive.getColonne() == 0)
         arriveColonne = depart.getColonne();
        
        if (location[depart.getLigne()][depart.getColonne()].getPiece() instanceof Pion)
        {
            valid = this.captureParUnPionPossible(depart, arrive);
            pion = true;
        }
        
        if (location[arrive.getLigne()][arrive.getColonne()].estOccupe())
            if (location[arrive.getLigne()][arrive.getColonne()].getPiece().getCouleur() == location[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())
                valid = false;
        
        if (valid && !pion)
        {
            if (depart.getLigne() - arriveLigne >= 0 && depart.getColonne() == arrive.getColonne())   
            {                                                                                       // Verification du chemin vers le haut sur les lignes
                for (int i=depart.getLigne()-1; i>=arrive.getLigne(); i--){
                    if (location[i][arrive.getColonne()].estOccupe() && location[i][arrive.getColonne()] != location[arrive.getLigne()][arrive.getColonne()])
                        valid = false;
                }
            }
            
            else if (depart.getLigne() - arriveLigne < 0 && depart.getColonne() == arrive.getColonne())
            {                                                                                       // Verification du chemin vers le bas sur les lignes
                for (int i=depart.getLigne()+1; i<=arrive.getLigne(); i++){
                    if (location[i][arrive.getColonne()].estOccupe() && location[i][arrive.getColonne()] != location[arrive.getLigne()][arrive.getColonne()])
                        valid = false;
                }
            }
            
            else if (depart.getColonne() - arriveColonne > 0 && depart.getLigne() == arrive.getLigne())  
            {                                                                                       // Verification du chemin vers la gauche sur les colonnes
                for (int i=depart.getColonne()-1; i>=arrive.getColonne(); i--) {
                    if (location[arrive.getLigne()][i].estOccupe() && location[arrive.getLigne()][i] != location[arrive.getLigne()][arrive.getColonne()])
                        valid = false;
                }
            }
            
            else if (depart.getColonne() - arriveColonne < 0 && depart.getLigne() == arrive.getLigne())  
            {                                                                                       // Verification du chemin vers la droite sur les colonnes
                for (int i=depart.getColonne()+1; i<=arrive.getColonne(); i++) {
                    if (location[arrive.getLigne()][i].estOccupe() && location[arrive.getLigne()][i] != location[arrive.getLigne()][arrive.getColonne()])
                        valid = false;
                }
            }
            
            else if (depart.getColonne() - arrive.getColonne() > 0 && depart.getLigne() != arrive.getLigne())   // Verification de la diagonale gauche
            {
                if (depart.getLigne() - arriveLigne >= 0)        // Verification du chemin vers le haut
                {
                    int ligne = depart.getLigne();
                    for (int i=depart.getColonne()-1; i > arrive.getColonne(); i--){
                        if (location[ligne-=1][i].estOccupe() && location[ligne-=1][i] != location[arrive.getLigne()][arrive.getColonne()])
                            valid = false;
                    }
                }
                else                                            // Verification du chemin vers le bas
                {
                    int ligne = depart.getLigne();
                    for (int i = depart.getColonne() - 1; i > arrive.getColonne(); i--) {
                        if (location[ligne+=1][i].estOccupe() && location[ligne+=1][i] != location[arrive.getLigne()][arrive.getColonne()])
                            valid = false;
                    }
                }
            }
            
            else if (depart.getColonne() - arrive.getColonne() < 0 && depart.getLigne() != arrive.getLigne())   // Verification de la diagonale droite
            {
                if (depart.getLigne() - arriveLigne >= 0)        // Verification du chemin vers le haut
                {
                    int ligne = depart.getLigne();
                    for (int i = depart.getColonne() + 1; i < arrive.getColonne(); i++) {
                            if (location[ligne-=1][i].estOccupe() && location[ligne-=1][i] != location[arrive.getLigne()][arrive.getColonne()])
                                valid = false;
                    }
                }
                else                                            // Verification du chemin vers le bas
                {
                    int ligne = depart.getLigne();
                    for (int i = depart.getColonne() + 1; i < arrive.getColonne(); i++) {
                        if (location[ligne+=1][i].estOccupe() && location[ligne+=1][i] != location[arrive.getLigne()][arrive.getColonne()])
                            valid = false;
                    }
                }
            }
        }
        
        if (location[arrive.getLigne()][arrive.getColonne()].equals(location[depart.getLigne()][depart.getColonne()]))
            valid = true;
        
        return valid;
    }
  
    public boolean captureParUnPionPossible(Position depart, Position arrive)
    {
        boolean valid = true;
        
        if (depart.getLigne() - arrive.getLigne() < 0 && location[depart.getLigne()][depart.getColonne()].getPiece().getCouleur() == "BLANC")
          valid = false;
        
        else if (depart.getLigne() - arrive.getLigne() > 0 && location[depart.getLigne()][depart.getColonne()].getPiece().getCouleur() == "NOIR")
          valid = false;
      
        else {
            if (location[arrive.getLigne()][arrive.getColonne()].estOccupe())       // Si la case d'arrivee est occupe
            {
                if (depart.getColonne() == arrive.getColonne())
                    valid = false;
                else if (location[depart.getLigne()][depart.getColonne()].getPiece().getCouleur() == 
                        location[arrive.getLigne()][arrive.getColonne()].getPiece().getCouleur()) // Si la piece presente sur la case d'arrivee est de couleur differente
                    valid = false;
            }
            else {
                if (depart.getColonne() != arrive.getColonne())
                    valid = false;
            }
        }
        return valid;
    }
}
