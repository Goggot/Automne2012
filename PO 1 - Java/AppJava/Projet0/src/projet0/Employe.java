package projetTP0;

public class Employe 
{
  // donn?es
  private String nom;
  private String numero;
  private double salaireHoraire;
  private double nbreHeuresSemaine;
  private int anciennete;
  private double nbreHeureSup;


  // constantes

  public static final double ASSEMP = 11.1;
  public static final double FONDP = 1.36;
  public static final int COTSOC = 20;
  public static final int FED = 19;
  public static final int PROV = 20;

  // m?thode constructeur
  
  public Employe(String nom, String numero, double salaireHoraire, double nbreHeuresSemaine, int anciennete){
      this.nom = nom;
      this.numero = numero;
      this.salaireHoraire = salaireHoraire;
      this.nbreHeuresSemaine = nbreHeuresSemaine;
      this.anciennete = anciennete;
  }
  
  public double salaireBrut(){
      return nbreHeuresSemaine*salaireHoraire;
  }
 
  public double salaireNetAvantImpot() {
     double salaireBrut, salaireNet;
     salaireNet = (salaireBrut()/100)*ASSEMP;
     salaireBrut = (salaireBrut()/100)*FONDP;
     return salaireNet = (salaireBrut-salaireNet) - COTSOC;
  }
  
  public double impotFederal(){
      double salaireNetAvantImpot = (salaireNetAvantImpot()/100)*FED;
      return salaireNetAvantImpot;
  }
  
  public double impotProvincial(){
      double salaireNetAvantImpot = (salaireNetAvantImpot()/100)*PROV;
      return salaireNetAvantImpot;
  }
    
  public double salaireNetApresImpot(){
      double salaireNetApresImpot = salaireBrut() -(impotFederal()+impotProvincial());
      return salaireNetApresImpot;
  }
  public int joursVacances(){
      int vacance = 0;
      if(numero.charAt(vacance)=='1')
        vacance = anciennete+5;
      else if (numero.charAt(vacance)=='2')
        vacance = anciennete+10;
      else if (numero.charAt(vacance)=='3')
        vacance = anciennete+15;
      else if (numero.charAt(vacance)=='4')
        vacance = anciennete+20;
      return vacance;
  }
  public void heureSup(double nbreHeureSup){
    nbreHeuresSemaine += nbreHeureSup;
  }
}

