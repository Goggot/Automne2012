package exercices;

public class Article 
{

private double prix;
private String code;

public Article ()
{
}

public double getPrix()
  {
  return prix;
  } 

public String getCode()
  {
  return code;
  }

public void setPrix(double prix )
  {
  this.prix = prix;
  }

public void setCode( String  code )
  {
  this.code = code;
  }

public boolean equals(Object o)
{
  Cravate aComparer;
  if (o instanceof Cravate)
    aComparer = (Cravate) o;
  else
    return false;
  
  if (aComparer.getCode().equals(this.getCode()))
    return true;
  else 
    return false;                        
}

  
  


}