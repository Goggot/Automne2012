package project2;

import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class FrameComboBox
  extends JFrame
{
  // remplir le JComboBox au départ
  String[] tab = {"Québec", "Ontario", "Manitoba", "Saskatchewan"};
  private JComboBox combo = new JComboBox(tab);
  
  int nbEvenements;
  private JLabel champTexte = new JLabel();

  public FrameComboBox()
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
    this.setSize( new Dimension(400, 300) );
    this.setTitle( "Combien d'événements sont lancés ?" );
    combo.setBounds(new Rectangle(75, 50, 230, 30));
    this.getContentPane().add(champTexte, null);
    this.getContentPane().add(combo, null);
    
   // combo.setSelectedItem(null);
    //étape 1 : création de l'écouteur 
    Ecouteur e = new Ecouteur ();
    // étape 2 inscription des sources aux écouteurs 
    combo.addActionListener(e);
    champTexte.setBounds(new Rectangle(75, 125, 230, 80));
    champTexte.setHorizontalAlignment(SwingConstants.CENTER);
    champTexte.setHorizontalTextPosition(SwingConstants.CENTER);

    // combo.setSelectedItem("Ontario");
    
  }
  
  private class Ecouteur implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if (combo.getSelectedIndex() == 0)
        champTexte.setText("Population : 7 719 993 habitants");
      else if (combo.getSelectedIndex() == 1)
        champTexte.setText("Population : 12 850 836 habitants");
      else if (combo.getSelectedIndex() == 2)
        champTexte.setText("Population : 1 190 300 habitants");
      else if (combo.getSelectedIndex() == 3)
        champTexte.setText("Population : 1 003 700 habitants");
    }
  }
  
  public static void main ( String[] args )
  {
    FrameComboBox f = new FrameComboBox ();
    f.setVisible(true);
    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

}
