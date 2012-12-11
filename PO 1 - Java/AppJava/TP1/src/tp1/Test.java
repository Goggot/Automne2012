package tp1;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test
{
  public static void main(String[] args)
  {
    GregorianCalendar present = new GregorianCalendar();
    System.out.println(present.get(Calendar.MINUTE));
    present.add(Calendar.HOUR, 2);
    System.out.println(present.get(Calendar.HOUR_OF_DAY));
    
    GregorianCalendar passe = new GregorianCalendar(1989,0,19);
    System.out.println(!passe.before(present));
    
    SimpleDateFormat format = new SimpleDateFormat("MMMM");
    System.out.println(format.format(present.getTime()));
  }
}