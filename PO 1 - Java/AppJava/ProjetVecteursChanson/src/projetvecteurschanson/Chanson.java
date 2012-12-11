package projetvecteurschanson;

public class Chanson 
{

private String nom;
private String nomArtiste;
private String duree;
private String genre;

  public Chanson()
  {
  }

  public Chanson ( String nom, String nomArtiste, String duree, String genre )
  {
  this.nom = nom;
  this.nomArtiste = nomArtiste;
  this.duree = duree;
  this.genre = genre; 
  }

  public String getNom (){
    return nom;
  }

  public String getNomArtiste (){
    return nomArtiste;
  }

  public String getDuree(){
    return duree;
  }

  public String getGenre(){
    return genre;
  }


  public void setNom ( String nom ){
    this.nom = nom;
  }

  public void setNomArtiste ( String nomArtiste ){
    this.nomArtiste = nomArtiste;
  }

  public void setDuree ( String duree ){
    this.duree = duree;
  }

  public void setGenre( String genre ){
    this.genre = genre;
  }
  
  public int dureeSeconde()
  {
    String tab[] = duree.split(" :");
    int min = Integer.parseInt(tab[0]);
    int sec = Integer.parseInt(tab[1]);
    return sec+(min*60);
  }
  
  public boolean equals(Object o)
  {
    Chanson aComparer;
    if (o instanceof Chanson)
      aComparer = (Chanson) o;
    else
      return false;
    
    if (aComparer.getNom().equals(getNom()))
      return true;
    else 
      return false;                        
  }

}
