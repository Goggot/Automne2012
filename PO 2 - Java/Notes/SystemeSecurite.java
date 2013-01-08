package projetannexe5;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JPasswordField;
public class SystemeSecurite extends JFrame 
{
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  // je choisis de réaliser un tableau de JButton : je ne peux pas utiliser le design
  JButton [] tab = new JButton [10];
  
  JTextField champTexte = new JTextField();
  int compteur = 0;

    public SystemeSecurite()
  {
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

  }

  private void jbInit() throws Exception
  {
  // j'ai créé le tableau, je dois créer les éléments du tableau
  for ( int i = 0; i<10; i++ )
    tab[i] = new JButton();
  
  
  
    this.getContentPane().setLayout(null);
    this.setSize(new Dimension(400, 324));
    this.setTitle("Systeme de securite");
    jPanel1.setBounds(new Rectangle(45, 15, 300, 175));
    jPanel1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    jPanel1.setLayout(gridLayout1);
    jPanel2.setBounds(new Rectangle(20, 205, 350, 65));
    jPanel2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    gridLayout1.setColumns(4);
    champTexte.setColumns(20);
    jPanel2.add(champTexte, null);
        this.getContentPane().add(jPanel2, null);
    this.getContentPane().add(jPanel1, null);
    gridLayout1.setRows(3);
    
    // je dois ajouter les boutons au panel
    for ( int i = 0; i<10;i++)
      {
      jPanel1.add(tab[i]);
      tab[i].setText(String.valueOf(i));
      }

    // 1.addition d'un ecouteur
    Gest g = new Gest ();
    

    // 2.inscription des sources 
    for ( int i = 0; i<10;i++)
    {
      tab[i].addActionListener(g);
     
    }
  }



  private class Gest implements ActionListener
  {
  String rep = new String ();
  
  public void actionPerformed ( ActionEvent e )
  {
   
  //trouve le texte sur la source de l'événement
   JButton source = ( JButton )  e.getSource();
  
      // j'ajoute le numéro à la string contenant le code
      rep += String.valueOf(source.getText());
      champTexte.setText(rep);
      compteur++;
      
    // code terminé
    if ( compteur == 3 )
      {
      if ( rep.equals("454")) // bon code simulé
        {
        jPanel2.setBackground(Color.green);
        rep = "";
        }
      else
        {
        jPanel2.setBackground(Color.red);
        rep = "";
        }
      // on recommence
      compteur = 0;
      }
  
   }
  }
   public static void main ( String [] args )
    {
    SystemeSecurite s = new SystemeSecurite();
    s.setVisible(true);
    s.setDefaultCloseOperation(EXIT_ON_CLOSE);
    } 
    
}