package exercices;
import java.util.Stack;

public class ClasseExerciceStack 
{
 
  public static void main(String[] args)
  {   
  // cr�er une pile 
  Stack pile = new Stack();
   
   // ajouter une cravate de code 718 dans la pile
  pile.push(new Cravate("718"));
   
   // ajouter une cravate de code 22 dans la pile
  pile.push(new Cravate("22"));
   
   // ajouter un maillot de code 123 et de grandeur moyenne
  pile.push(new Maillot("123", "moyenne"));
  
  //afficher le nombre d'objets dans la pile � l'aide d'une m�thode
  System.out.println(pile.size());

  // cr�ez une deuxi�me pile identique � la premi�re et contenant les m�mes articles, peut-on faire �a en une ligne de code ?
  Stack pile2 = (Stack) pile.clone();
  
  // en les retirant un � un de la pile originale, calculer le total des prix des articles contenus dans la pile
  double prixTotal=0;
  for (int i=pile.size(); i > 0; i--){
    Article a = (Article) pile.pop();
    prixTotal += a.getPrix();
  }
  
  Stack test = new Stack();
  test.push("test");
  System.out.println(test.pop());
  
  // Cr�ez maintenant une Pile qui ne pourra contenir que des Articles ( nouveau JDK 1.5 )
        // generique : 
                Stack <Article> article = new Stack <Article> ();
 
  // ajouter un objet Cravate, code 565 � cette pile, est-ce possible ?
  article.push(new Cravate("565"));   // possible
  
  // ajouter un objet String � cette pile , est-ce possible ?
        // article.push(new String("Test"));
  
  // ajouter deux autres cravates � cette pile, code 456 et 242
  article.push(new Cravate("456"));
  article.push(new Cravate("242"));
  
  // // en les retirant un � un de cette pile , calculer le total des prix des articles contenus dans cette pile
  double prix=0;
  for (int i=article.size(); i > 0; i--)
    prixTotal += article.pop().getPrix();

  // en utilisant la m�thode search, retrouver l'ordre de sortie de la cravate avec le code 22 dans la deuxi�me pile
  System.out.println(pile2.equals(new Cravate("22")));
  }

 
  
}