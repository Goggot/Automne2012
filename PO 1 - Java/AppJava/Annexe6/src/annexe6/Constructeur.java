package annexe6;

public class Constructeur
{
  public static void main(String[] args)
  {
    CompteBancaire P1 = new CompteBancaire("Flavien Larrivée", 100);
    CompteBancaire P2 = new CompteBancaire("Denise Lachance", 36.78);
    System.out.println(P1.getNom());
    P2.Retire(20);
    System.out.println(P1.getNum());
    CompteBancaire P3 = new CompteBancaire("Martial Maurice", 40);
    System.out.println(P3.getNum());
    System.out.println(P2.getSolde());
  }
}