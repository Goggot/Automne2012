package examen;

public class Constructeur
{
  public static void main(String[] args)
  {
    Vol V1 = new Vol("Sofia", "Montreal", 546);
    Vol V2 = new Vol("Plovdiv","Vienne", 100);
    
    V1.setDuree(V1, 14);
    System.out.println(V1.plusLong(V2));
  }
}
