package projetvecteurschanson;
import java.util.*;

public class Compte 
{
  private Vector<Chanson> chansonsChoisies;
  
  public Compte()
  {
  chansonsChoisies = new Vector<Chanson> ();
  }

  public Chanson getChanson(int index)
  {
    return chansonsChoisies.get(index);
  }
  
  public void ajouterChanson(Chanson ch)
  {
    chansonsChoisies.add(ch);
  }
  
  public void enleverChanson(Chanson ch)
  {
    if (chansonsChoisies.equals(ch))
      chansonsChoisies.remove(ch);
  }
  
  public int nombreDeChansons()
  {
    return chansonsChoisies.size();
  }
  
  public Vector<Chanson> grouperChansons(String style)
  {
    Vector<Chanson> newChanson;
    newChanson = new Vector<Chanson>();
    for (int i=0; i < chansonsChoisies.size(); i++)
      if (chansonsChoisies.get(i).getGenre() == style)
        newChanson.add(chansonsChoisies.get(i));
    return newChanson;
  }
}
