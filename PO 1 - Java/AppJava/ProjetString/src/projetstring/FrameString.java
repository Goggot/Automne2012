package projetstring;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrameString
  extends JFrame
{
  private JPanel jPanel1 = new JPanel();
  private JLabel jLabel1 = new JLabel();
  private JTextArea champString = new JTextArea();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private JLabel jLabel5 = new JLabel();
  private JLabel jLabel6 = new JLabel();
  private JLabel jLabel7 = new JLabel();
  private JTextField champMot = new JTextField();
  private JLabel reponse1 = new JLabel();
  private JLabel reponse2 = new JLabel();
  private JLabel reponse3 = new JLabel();
  private JLabel reponse4 = new JLabel();
  private JLabel reponse5 = new JLabel();
  private JLabel reponse6 = new JLabel();
  private JButton bouton = new JButton();

  public FrameString()
  {
    try
    {
      jbInit();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private void jbInit()
    throws Exception
  {
    this.getContentPane().setLayout( null );
    this.setSize(new Dimension(847, 453));
    this.setTitle( "Tests sur des chaînes de caractères" );
    jPanel1.setBounds(new Rectangle(10, 20, 800, 385));
    jPanel1.setBorder(BorderFactory.createTitledBorder("Strings"));
    jPanel1.setLayout(null);
    jLabel1.setText("Entrez une chaîne de caractères ( une phrase de préférence ) :");
    jLabel1.setBounds(new Rectangle(15, 30, 415, 20));
    champString.setBounds(new Rectangle(470, 20, 315, 55));
    jLabel2.setText("1. caractère à l'indice 8 :");
    jLabel2.setBounds(new Rectangle(45, 125, 215, 25));
    jLabel3.setText("2. indice du premier 'e' de la chaîne :");
    jLabel3.setBounds(new Rectangle(45, 165, 215, 25));
    jLabel4.setText("3. indice du dernier 'e' de la chaîne :");
    jLabel4.setBounds(new Rectangle(45, 200, 215, 25));
    jLabel5.setText("4. le nombre de cararctères du texte :");
    jLabel5.setBounds(new Rectangle(45, 235, 215, 25));
    jLabel6.setText("5. Est-ce que la phrase commence par une majuscule ?  :");
    jLabel6.setBounds(new Rectangle(45, 270, 380, 25));
    jLabel7.setText("6. Nombre d'occurences du mot   :");
    jLabel7.setBounds(new Rectangle(45, 305, 215, 25));
    champMot.setBounds(new Rectangle(255, 305, 105, 25));
    reponse1.setBounds(new Rectangle(505, 125, 185, 25));
    reponse1.setOpaque(true);
    reponse1.setBackground(new Color(255, 181, 181));
    reponse2.setBounds(new Rectangle(505, 160, 185, 25));
    reponse2.setOpaque(true);
    reponse2.setBackground(new Color(255, 181, 181));
    reponse3.setBounds(new Rectangle(505, 200, 185, 25));
    reponse3.setOpaque(true);
    reponse3.setBackground(new Color(255, 181, 181));
    reponse4.setBounds(new Rectangle(505, 235, 185, 25));
    reponse4.setOpaque(true);
    reponse4.setBackground(new Color(255, 181, 181));
    reponse5.setBounds(new Rectangle(505, 270, 185, 25));
    reponse5.setOpaque(true);
    reponse5.setBackground(new Color(255, 181, 181));
    reponse6.setBounds(new Rectangle(505, 305, 185, 25));
    reponse6.setOpaque(true);
    reponse6.setBackground(new Color(255, 181, 181));
    bouton.setText("trouvez");
    bouton.setBounds(new Rectangle(65, 90, 685, 25));
    jPanel1.add(bouton, null);
    jPanel1.add(reponse6, null);
    jPanel1.add(reponse5, null);
    jPanel1.add(reponse4, null);
    jPanel1.add(reponse3, null);
    jPanel1.add(reponse2, null);
    jPanel1.add(reponse1, null);
    jPanel1.add(champMot, null);
    jPanel1.add(jLabel7, null);
    jPanel1.add(jLabel6, null);
    jPanel1.add(jLabel5, null);
    jPanel1.add(jLabel4, null);
    jPanel1.add(jLabel3, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(champString, null);
    jPanel1.add(jLabel1, null);
    this.getContentPane().add(jPanel1, null);
    
    Ecouteur ec = new Ecouteur ();
    bouton.addActionListener(ec);
    
  }
  
  private class Ecouteur implements ActionListener
  {

    @Override
    public void actionPerformed(ActionEvent e)
    {
      //contenu du champ texte
      String texte = champString.getText();
      
      // codez ici question 1 ( caractère à l'indice 8 ) 
      // setText est une String, il y aura erreur si le 1er char sort seul
      reponse1.setText("Reponse : " + texte.charAt(8));  
      
      // codez ici question 2 ( indice du premier e )
      
      reponse2.setText("Reponse : " + texte.indexOf('e'));
      
      // codez ici question 3 ( indice du dernier e )
      
      reponse3.setText("Reponse : " + texte.lastIndexOf('e'));
      
      // codez ici question 4 ( nombre de caractère de la phrase )
      
      reponse4.setText("Reponse : " + texte.length());
      
      // codez ici question 5 ( commence par une majuscule ) ( chercher dans classe Character ) 
      char lettre = (texte.charAt(0));
      reponse5.setText("Reponse : " + Character.isUpperCase(lettre));
      
      // codez ici question 6 ( nombre d'occurences d'un mot )
      String mot = champMot.getText();
      int compteur=0, index=0;
      index = texte.indexOf(mot);
      while (index!=-1)
      {
        compteur++;
        index = texte.indexOf(mot, index+mot.length());
      }
      reponse6.setText("Reponse : " + compteur);
    }
  }
  
  public static void main(String[] args)
  {
    FrameString fr = new FrameString ();
    fr.setVisible(true);
    fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}
