package tp1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CarteCredit
{
  private int num;
  private int mois;
  private int annee;
  private int code;
  
  
  public void setCode(int code)
  {
    this.code = code;
  }
  
  public void setNum(int num)
  {
    if (num.length()==12)
      this.num = num;
    else
      
  }
  
  public void setDate(String date)
  {
    String[] exp = date.split("/");
    this.mois = Integer.parseInt(exp[0]);
    this.annee = Integer.parseInt(exp[1]);
  }
  
  public boolean verifierDate(GregorianCalendar auj)
  {
    boolean valid = false;
    
    if (auj.get(Calendar.YEAR) <= this.annee)
      if (auj.get(Calendar.MONTH) <= this.mois)
        valid = true;
    else
        valid = false;
    
    return valid;
  }
}