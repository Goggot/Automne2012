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
import javax.swing.JTextField;


public class Num6
  extends JFrame
{
  private JLabel jLabel1 = new JLabel();
  private JTextField champNom = new JTextField();
  private JButton jButton1 = new JButton();
  private JPanel panelSupp = new JPanel();
  private JLabel jLabel2 = new JLabel();

  public Num6()
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
    this.setSize(new Dimension(520, 310));
    jLabel1.setText("NOM DU FICHIER :");
    jLabel1.setBounds(new Rectangle(30, 20, 115, 35));
    champNom.setBounds(new Rectangle(150, 20, 325, 30));
    jButton1.setText("MODE RÉDUIT >>>");
    jButton1.setBounds(new Rectangle(150, 65, 195, 40));
    panelSupp.setBounds(new Rectangle(25, 135, 460, 115));
    panelSupp.setLayout(null);
    panelSupp.setBackground(new Color(198, 198, 198));
    jLabel2.setText("CARACTÉRISTIQUES SUPPLÉMENTAIRES :");
    jLabel2.setBounds(new Rectangle(10, 5, 260, 25));
    panelSupp.add(jLabel2, null);
    this.getContentPane().add(panelSupp, null);
    this.getContentPane().add(jButton1, null);
    this.getContentPane().add(champNom, null);
    this.getContentPane().add(jLabel1, null);
    
    Ecouteur ec = new Ecouteur();
    jButton1.addActionListener(ec);
  }
  
  private class Ecouteur implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      if (jButton1.getText() == "MODE RÉDUIT >>>")
      {
        jButton1.setText("MODE EXPERT >>>");
        panelSupp.setVisible(false);
        Num6.this.setSize(new Dimension(520, 160));
      }
      else
      {
        jButton1.setText("MODE RÉDUIT >>>");
        panelSupp.setVisible(true);
        Num6.this.setSize(new Dimension(520, 310));
      }
    }
  }
}
