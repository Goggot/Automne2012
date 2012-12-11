package projetmaison;
public class Maison {

// Donn�es d'instance : valeurs diff�rentes pour chaque objet Maison

  private int nbrePieces;
  private double superficieTerrain;
  private String noAdresse;
  private String nomRue;
  private double prixVente;


  /**
   * Constructeur : "initialise les objets"
   */

  public Maison(int nbrePieces, double superficieTerrain, String noAdresse, String nomRue,  double prixVente)

    {
    this.nbrePieces = nbrePieces;
    this.superficieTerrain = superficieTerrain;
    this.noAdresse = noAdresse;
    this.nomRue = nomRue;
    this.prixVente = prixVente;
    }


  // m�thode permettant d'acc�der � la donn�e priv�e nbrePieces

  public int getPieces ()
    {
    return nbrePieces;
    }

  // m�thode permettant d'ajouter un nombre de pi�ces � la maison

  public void ajouterPieces ( int nbreSupPieces )
    {
    nbrePieces = nbrePieces + nbreSupPieces;
    }


  public double getSuperficie ()
    {
    return superficieTerrain;
    }


  public  void setSuperficie (double superficieTerrain)
    {
    this.superficieTerrain = superficieTerrain;
    }


  public String getAdresse ()
    {
    return noAdresse;
    }


  public String getRue ()
    {
    return nomRue;
    }


  public double getPrixVente ()
    {
    return prixVente;
    }


  public void setPrixVente ( double prixVente )
    {
    this.prixVente = prixVente;
    }


  public double valeur ()
    {
    return 35000* nbrePieces + 4*superficieTerrain;
    }

  public boolean meilleureAffaire ( Maison autreMaison )
    {
    if (( valeur() - prixVente ) > (autreMaison.valeur() - autreMaison.prixVente))
      return true;
    else
      return false;
    }


}



 