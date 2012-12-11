package restaurant;

public class Table
{
  private int nbrPlace;
  private int id;
  private boolean banquette;
  private boolean occupe = false;
    
  public Table(int nbrPlace, int id, boolean banquette)
  {
    this.nbrPlace = nbrPlace;
    this.id = id;
    this.banquette = banquette;
    occupe = false;
  }

  public int getNbrPlace()
  {
    return nbrPlace;
  }

  public int getId()
  {
    return id;
  }

  public boolean getBanquette()
  {
    return banquette;
  }

  public boolean getOccupe()
  {
    return occupe;
  }

  public void setOccupe(boolean occupe)
  {
    this.occupe = occupe;
  }
  
  
}
