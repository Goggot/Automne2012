package tp1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Borne
{
  GregorianCalendar present = new GregorianCalendar();
  
  private String numParking;
  private int heure;
  private String dateExp;
  private double tarif = 0;
  private double temps = 0;
  private double tempsMax = temps+120;
  private double tarifMax = 0;
  private String modePaiement;
  
          // constantes...
  public static final double PRIX = 3.00;
  public static final int HEURESEMSAMDEBUT = 9;
  public static final int HEUREDIMDEBUT = 13;
  public static final int HEURESEMFIN = 21;
  public static final int HEURESAMDIMFIN = 18;
  
  
  CarteCredit carte = new CarteCredit();
  
  public Borne (String numParking, int heure)
  {
    this.numParking = numParking;
    this.heure = heure;
  }
  
  public boolean VerificationDate()
  {
    boolean validDate = false;
    
    if (present.get(Calendar.DAY_OF_WEEK) == present.MONDAY                  // Verification du jour de la semaine (lundi-vendredi)
        || present.get(Calendar.DAY_OF_WEEK) == present.TUESDAY
        || present.get(Calendar.DAY_OF_WEEK) == present.WEDNESDAY
        || present.get(Calendar.DAY_OF_WEEK) == present.THURSDAY
        || present.get(Calendar.DAY_OF_WEEK) == present.FRIDAY)
      if(present.get(Calendar.HOUR) > HEURESEMSAMDEBUT 
         && present.get(Calendar.HOUR) < HEURESEMFIN)                        // Verification de l'heure
        validDate = true;
    
    if (present.get(Calendar.DAY_OF_WEEK) == present.SATURDAY)               // Verification du jour de la semaine (samedi)
      if (present.get(Calendar.HOUR) > HEURESEMSAMDEBUT 
          && present.get(Calendar.HOUR) < HEURESAMDIMFIN)                    // Verification de l'heure
        validDate = true;
    
    if (present.get(Calendar.DAY_OF_WEEK) == present.SUNDAY)                 // Verification du jour de la semaine (dimanche)
      if (present.get(Calendar.HOUR) > HEUREDIMDEBUT 
          && present.get(Calendar.HOUR) < HEURESAMDIMFIN)                    // Verification de l'heure
        validDate = true;
    
    return validDate;
  }
  
  boolean VerificationNumParking()
  {
    boolean validNum = false;
    
    if (this.numParking.matches("[A-Z]\\d{3}"))
      validNum = true;
    
    return validNum;
  }
  
  public void RecevoirPiece(Piece p)
  {
    if (this.tarif < 6 && this.temps < 120)
    {
      if (p.getValeur() == 0.25 && this.temps <= )
      {
        this.temps += 5;
        this.tarif += 0.25;
      }
      if (p.getValeur() == 1)
      {
        this.temps += 20;
        this.tarif += 1;
      }
      if (p.getValeur() == 2)
      {
        this.temps += 40;
        this.tarif += 2;
      }
    }
    modePaiement = "Comptant";
  }
  
  public void Recevoir25cCarteCredit()
  {
    if (carte.verifierDate(present)==true)
    {
      this.temps += 5;
      this.tarif += 0.25;
      modePaiement = "Credit";
    }
  }
  
  public void AjouterMaxCredit()
  {
    if (carte.verifierDate(present)==true)
    {
      this.tempsMax = 360 - this.temps;
      this.tarifMax = 6 - this.tarif;
      this.temps = 360;
      this.tarif = 6;
      modePaiement = "Credit";
    }
  }
  
  public Transaction ProduireCoupon(String modePaiement, double cout, )
  {
    
  }
  
  public void setNum(String numParking)
  {
    this.numParking = numParking;
  }
  
  public void setHeure(int heure)
  {
    this.heure = heure;
  }
}


