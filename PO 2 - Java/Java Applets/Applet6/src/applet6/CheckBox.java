package applet6;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.Highlighter;

public class CheckBox
  extends JFrame
{
  private JPanel panelBouton = new JPanel();
  private JRadioButton boutonGauche = new JRadioButton();
  private JRadioButton boutonCentre = new JRadioButton();
  private JRadioButton boutonDroit = new JRadioButton();
  private JTextArea champTexte = new JTextArea();

  public CheckBox()
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
    this.setSize(new Dimension(456, 354));
    this.setTitle("Alignement texte");
    panelBouton.setBounds(new Rectangle(20, 235, 410, 65));
    panelBouton.setLayout(null);
    panelBouton.setBackground(new Color(214, 214, 214));
    boutonGauche.setText("Gauche");
    boutonGauche.setBounds(new Rectangle(25, 20, 110, 25));
    boutonGauche.setHorizontalAlignment(SwingConstants.CENTER);
    boutonCentre.setText("Centré");
    boutonCentre.setBounds(new Rectangle(150, 20, 110, 25));
    boutonCentre.setHorizontalAlignment(SwingConstants.CENTER);
    boutonDroit.setText("Droit");
    boutonDroit.setBounds(new Rectangle(275, 20, 110, 25));
    boutonDroit.setHorizontalAlignment(SwingConstants.CENTER);
    champTexte.setBounds(new Rectangle(20, 20, 410, 200));
    panelBouton.add(boutonDroit, null);
    panelBouton.add(boutonCentre, null);
    panelBouton.add(boutonGauche, null);
    this.getContentPane().add(champTexte, null);
    this.getContentPane().add(panelBouton, null);
    
    
    ButtonGroup bg = new ButtonGroup();
    bg.add(boutonGauche);
    bg.add(boutonCentre);
    bg.add(boutonDroit);
    boutonGauche.setSelected(true);
    
    Ecouteur ec = new Ecouteur();
    
    boutonGauche.addItemListener(ec);
    boutonDroit.addItemListener(ec);
    boutonCentre.addItemListener(ec);
  }
  
  private class Ecouteur implements ItemListener
  {
    @Override
    public void itemStateChanged(ItemEvent e)
    {/*
      if (boutonGauche.isSelected())
        champTexte.setAlignmentX(50);
      else if (e.getItemSelectable() == boutonDroit)
        //champTexte.setHorizontalAlignment(JTextField.RIGHT)
      else
        champTexte.setAlignmentX(100);*/
    }
  }
  
  public static void main(String[] args)
  {
    CheckBox radiobutton = new CheckBox();
    
    radiobutton.setVisible(true);
    
    radiobutton.setLocationRelativeTo(null);
    
    radiobutton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
