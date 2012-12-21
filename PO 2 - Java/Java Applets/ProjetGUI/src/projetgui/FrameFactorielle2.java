package projetgui;

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
import javax.swing.JTextPane;
import javax.swing.JToggleButton;

public class FrameFactorielle2
  extends JFrame
{


  private JTextField texte = new JTextField();
  private JTextField champReponse = new JTextField();
  private JButton bouton = new JButton();

  public FrameFactorielle2()
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
    this.setSize(new Dimension(577, 431));
    this.setTitle( "Frame 2" );
    this.getContentPane().add(bouton, null);
    this.getContentPane().add(champReponse, null);
    this.getContentPane().add(texte, null);
    texte.setBounds(new Rectangle(165, 60, 250, 45));
    champReponse.setEnabled(false);
    champReponse.setBounds(new Rectangle(210, 170, 160, 50));
    bouton.setText("Validation");
    bouton.setBounds(new Rectangle(235, 315, 125, 40));
    
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
      String t = texte.getText();
        
      // transtyper en int
      int nombre = Integer.parseInt(t);
        
      // calculer la factorielle
      int reponse = 1;
      for (int i = nombre; i >= 1; i--)
      {
        reponse *= i;
      }        
        
      // afficher le resultat
      champReponse.setText(String.valueOf(reponse));
    }
  }
}
