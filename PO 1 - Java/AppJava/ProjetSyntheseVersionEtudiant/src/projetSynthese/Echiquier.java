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
  
  public void cheminPossible(Position depart, Position arrive)    // DÉFINITION DES DÉPLACEMENTS POSSIBLE EN TOUT, PAS PAR PIÈCE
  {
    boolean valid = true;
    if (location[depart.getLigne()][depart.getColonne()] instanceof Pion)        // Si c'est un Pion
    {
      Piece pion = location[depart.getLigne()][depart.getColonne()].getPiece();
      
      if (depart.getColonne() == arrive.getColonne())             
      {                                                                          // Si la piece reste dans sa colonne pour avancer simplement
        if (!location[depart.getLigne()][depart.getColonne()].estOccupe())       // Si la case d'arrivée est occupé
        {
          location[arrive.getLigne()][arrive.getColonne()].setPiece(pion);
          location[depart.getLigne()][depart.getColonne()].enleverPiece();
        }
      }
      else 
      {                                                                         // Si la piece va en diagonale
        if (location[arrive.getLigne()][arrive.getColonne()].estOccupe())       // Si la case d'arrivée est occupé
          if (location[depart.getLigne()][depart.getColonne()].getPiece().getCouleur() != 
                location[arrive.getLigne()][arrive.getColonne()].getPiece().getCouleur())
          {                                                               // Si la piece présente sur la case d'arrivée est de couleur différente
            location[arrive.getLigne()][arrive.getColonne()].setPiece(pion);
            location[depart.getLigne()][depart.getColonne()].enleverPiece();
          }
      }
    }
    
    
    if (location[depart.getLigne()][depart.getColonne()] instanceof Tour)       // Si c'est une Tour
    {
      Piece tour = location[depart.getLigne()][depart.getColonne()].getPiece();
      
      if (depart.getLigne()!= arrive.getLigne())
        for (int i = depart.getLigne()-1; i < arrive.getLigne(); i++)             // Parcours de chaque case entre le départ et l'arrivée
          if (location[i][depart.getColonne()].estOccupe())                     // Si la case est occupée
            valid = false;
      
      if (depart.getLigne()!= arrive.getLigne())
        for (int i = depart.getColonne()-1; i < arrive.getColonne(); i++)         // Parcours de chaque case entre le départ et l'arrivée
          if (location[depart.getLigne()][i].estOccupe())                       // Si une case est occupée
            valid = false;
      
      if (valid == true)                                                          
      {                   // Vérification de la case finale
        if (location[arrive.getLigne()][arrive.getColonne()].estOccupe())
        {
          if (location[depart.getLigne()][depart.getColonne()].getPiece().getCouleur() != location[arrive.getLigne()][arrive.getColonne()].getPiece().getCouleur())
          {                                                           // Si la piece présente sur la case d'arrivée est de couleur différente
            location[arrive.getLigne()][arrive.getColonne()].setPiece(tour);
            location[depart.getLigne()][depart.getColonne()].enleverPiece();
          }
        }
        else
        {
          location[arrive.getLigne()][arrive.getColonne()].setPiece(tour);
          location[depart.getLigne()][depart.getColonne()].enleverPiece();
        }
      }
    }
    
    
    if (location[depart.getLigne()][depart.getColonne()] instanceof Fou)        // Si c'est un Fou
    {
      int compteur = arrive.getColonne();
      if (arrive.getLigne() < arrive.getColonne())
        compteur = arrive.getLigne()-1;
      
      Piece fou = location[depart.getLigne()][depart.getColonne()].getPiece();
      
      if (depart.getLigne() > arrive.getLigne() && depart.getColonne() > arrive.getColonne())
        for (int i = compteur; i < compteur; i++)
          if (location[depart.getLigne()+i][depart.getColonne()+i].estOccupe())
            valid = false;
            
      else if (depart.getLigne() > arrive.getLigne() && depart.getColonne() < arrive.getColonne())
        for (int j = compteur; j < compteur; j++)
          if (location[depart.getLigne()+j][depart.getColonne()-j].estOccupe())
            valid = false;
      
      else if (depart.getLigne() < arrive.getLigne() && depart.getColonne() > arrive.getColonne())
        for (int x = compteur; x < compteur; x++)
          if (location[depart.getLigne()-x][depart.getColonne()+x].estOccupe())
            valid = false;
            
      else if (depart.getLigne() < arrive.getLigne() && depart.getColonne() < arrive.getColonne())
        for (int y = compteur; y < compteur; y++)
          if (location[depart.getLigne()-y][depart.getColonne()-y].estOccupe())
            valid = false;
      
      if (valid == true)
      {                   // Vérification de la case finale
        if (location[arrive.getLigne()][arrive.getColonne()].estOccupe())         
        {
          if (location[depart.getLigne()][depart.getColonne()].getPiece().getCouleur() != location[arrive.getLigne()][arrive.getColonne()].getPiece().getCouleur())
          {                                                           // Si la piece présente sur la case d'arrivée est de couleur différente
            location[arrive.getLigne()][arrive.getColonne()].setPiece(fou);
            location[depart.getLigne()][depart.getColonne()].enleverPiece();
          }
        }
        else
        {
          location[arrive.getLigne()][arrive.getColonne()].setPiece(fou);
          location[depart.getLigne()][depart.getColonne()].enleverPiece();
        }
      }
    }
      
  }
  
  public boolean captureParPionPossible()
  {
    boolean valid;
    
    return valid;
  }
}
