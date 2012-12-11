package examen2;

import java.util.GregorianCalendar;

public class Zomba
{
  private int nbPorte;
  private String couleur;
  private boolean airClimatise = false;
  private boolean transmissionAuto = false;
  private GregorianCalendar dateReception;
  //GregorianCalendar dateReception = new GregorianCalendar();
  
  public Zomba (int nbPorte, String couleur, boolean airClim, boolean transmissionAuto, GregorianCalendar date)
  {
    if (nbPorte == 2 || nbPorte == 4)
    {
      this.nbPorte = nbPorte;
      this.couleur = couleur;
      this.airClimatise = airClim;
      this.transmissionAuto = transmissionAuto;
      this.dateReception = date;
    }
  }
  
  public int getNbPorte()
  {
    return this.nbPorte;
  }
  
  public String getCouleur()
  {
    return this.couleur;
  }
  
  public boolean getAirClim()
  {
    return this.airClimatise;
  }
  
  public boolean getTransmission()
  {
    return this.transmissionAuto;
  }
  
  public GregorianCalendar getDate()
  {
    return this.dateReception;
  }
  
  public void setCouleur(String couleur)
  {
    this.couleur = couleur;
  }
  
  public void setAirClim(boolean airClim)
  {
    this.airClimatise = airClim;
  }
  
  public void setDate(GregorianCalendar date)
  {
    this.dateReception = date;
  }
  
  public double calculerPrix()
  {
    double prix = 0;
    
    if (this.nbPorte == 2)
      prix += 19100;
    else if (this.nbPorte == 4)
      prix += 20500;
    
    if (this.transmissionAuto == true)
      prix += 1200;
    
    if (this.airClimatise == true)
      prix += 1000;
    
    return prix;
  }
  
  
}
