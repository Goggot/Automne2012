package projetgui;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelCouleur
  extends JFrame
{
  private JPanel panel = new JPanel();
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JTextField tBleu = new JTextField();
  private JTextField tVert = new JTextField();
  private JLabel jLabel4 = new JLabel();
  private JLabel jLabel5 = new JLabel();
  private JTextField tRouge = new JTextField();
  private JButton bouton = new JButton();

  public PanelCouleur()
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
    this.setSize(new Dimension(450, 460));
    panel.setBounds(new Rectangle(40, 30, 355, 260));
    jLabel1.setText("Entrez un nombre entre 0 - 255 pour chaque couleur");
    jLabel1.setBounds(new Rectangle(70, 300, 315, 30));
    jLabel3.setText("Bleu :");
    jLabel3.setBounds(new Rectangle(280, 345, 45, 25));
    tBleu.setBounds(new Rectangle(320, 345, 40, 25));
    tVert.setBounds(new Rectangle(225, 345, 40, 25));
    jLabel4.setText("Vert :");
    jLabel4.setBounds(new Rectangle(185, 345, 45, 25));
    jLabel5.setText("Rouge :");
    jLabel5.setBounds(new Rectangle(85, 345, 45, 25));
    tRouge.setBounds(new Rectangle(125, 345, 40, 25));
    bouton.setText("Changer");
    bouton.setBounds(new Rectangle(150, 380, 125, 25));
    this.getContentPane().add(bouton, null);
    this.getContentPane().add(tRouge, null);
    this.getContentPane().add(jLabel5, null);
    this.getContentPane().add(jLabel4, null);
    this.getContentPane().add(tVert, null);
    this.getContentPane().add(tBleu, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(panel, null);
    
    // 1ère étape : Définir un écouteur
    Ecouteur ec = new Ecouteur();
    
    // 2ème étape : inscrire la source à l'écouteur
    bouton.addActionListener(ec);
  }
  
  // 3ème étape : définir la classe qui met en ouvre une ou plusieurs interfaces écouteurs
  private class Ecouteur implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      // saisir le contenu du champ texte
      String tr = tRouge.getText();
      String tv = tVert.getText();
      String tb = tBleu.getText();
        
      // transtyper en int
      int R = Integer.parseInt(tr);
      int G = Integer.parseInt(tv);
      int B = Integer.parseInt(tb);
      
      // concaténer
      Color RGB = new Color(R,G,B);
      
      // afficher le resultat
      panel.setBackground(RGB);
    }
  }
}
