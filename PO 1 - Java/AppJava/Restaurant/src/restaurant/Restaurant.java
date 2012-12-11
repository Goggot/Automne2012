package restaurant;

public class Restaurant
{
  private Table[] Salle;
  public Restaurant()
  {
    Salle = new Table[75];
    
    for (int i=0; i<30; i++)
    {
      Salle[i] = new Table(4,i+1,true);
    }
    
    for (int j=30; j<60; j++)
    {
      Salle[j] = new Table(2,j+1,true);
    }
    
    for (int k=60; k<70; k++)
    {
      Salle[k] = new Table(4,k+1,false);
    }
    
    for (int l=70; l<75; l++)
      {
        Salle[l] = new Table(2,l+1,false);
      }
  }
  
  public int nbTableOccupees()
  {
    int total = 0;
    
    for (int x=1; x<=Salle.length; x++)
      if (Salle[x].getOccupe()==true)
        total = total+1;
    
    return total;
  }
  
  public int assignerTableDispo(int nbPersonne, boolean banquette)
  {
    boolean valid;
    int i;
    
    for (i=1; valid = false || i<=Salle.length ; i++)
      if (!Salle[i].getOccupe())
        if (Salle[i].getBanquette() == banquette)
          if (Salle[i].getNbrPlace() <= nbPersonne)
          {
            Salle[i].setOccupe(true);
            valid = true;
          }
    
    return Salle[i].getId();
  }
  
  public boolean verifierSiTableOccupee(int id)
  {
    return Salle[id-1].getOccupe();
  }
}
