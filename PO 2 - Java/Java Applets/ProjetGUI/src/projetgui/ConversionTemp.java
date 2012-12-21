package projetgui;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConversionTemp
  extends JFrame
{
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JTextField dKelvin = new JTextField();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private JTextField dCelsius = new JTextField();
  private JTextField dFah = new JTextField();
  private JButton bouton = new JButton();

  public ConversionTemp()
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
    this.setSize(new Dimension(500, 274));
    this.setBounds(new Rectangle(10, 10, 500, 280));
    jLabel1.setText("Conversion Celsius en Fahrenheit et Kelvin");
    jLabel1.setBounds(new Rectangle(95, 15, 310, 40));
    jLabel1.setFont(new Font("Tahoma", 0, 16));
    jLabel2.setText("Celsius : ");
    jLabel2.setBounds(new Rectangle(30, 70, 105, 40));
    jLabel2.setFont(new Font("Tahoma", 0, 15));
    dKelvin.setBounds(new Rectangle(170, 180, 110, 35));
    dKelvin.setEditable(false);
    jLabel3.setText("Fahrenheit :");
    jLabel3.setBounds(new Rectangle(30, 120, 85, 45));
    jLabel3.setFont(new Font("Tahoma", 0, 15));
    jLabel4.setText("Kelvin :");
    jLabel4.setBounds(new Rectangle(30, 175, 85, 45));
    jLabel4.setFont(new Font("Tahoma", 0, 15));
    dCelsius.setBounds(new Rectangle(170, 75, 110, 35));
    dFah.setBounds(new Rectangle(170, 125, 110, 35));
    dFah.setEditable(false);
    bouton.setText("Transformer !");
    bouton.setBounds(new Rectangle(340, 100, 125, 95));
    this.getContentPane().add(bouton, null);
    this.getContentPane().add(dFah, null);
    this.getContentPane().add(dCelsius, null);
    this.getContentPane().add(jLabel4, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(dKelvin, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(jLabel1, null);
    
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
      String d = dCelsius.getText();
        
      // transtyper en int
      int degree = Integer.parseInt(d);
      
      // Calculs
      int fahr = degree*(9/5)+32;
      int kel = degree+273;
      
      // afficher le resultat
      dKelvin.setText(String.valueOf(kel));
      dFah.setText(String.valueOf(fahr));
      
    }
  }
}
