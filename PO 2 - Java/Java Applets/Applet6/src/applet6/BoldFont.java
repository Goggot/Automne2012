package applet6;

import java.awt.Component;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class BoldFont
  extends JFrame
{
  private JCheckBox boutonBold = new JCheckBox();
  private JPanel jPanel1 = new JPanel();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel1 = new JLabel();

  public BoldFont()
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
    this.setSize(new Dimension(400, 254));
    this.setTitle("Bold Font");
    boutonBold.setText("Bold");
    boutonBold.setBounds(new Rectangle(35, 145, 75, 25));
    boutonBold.setHorizontalAlignment(SwingConstants.CENTER);
    jPanel1.add(jLabel3, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(jLabel1, null);
    this.getContentPane().add(jPanel1, null);
    this.getContentPane().add(boutonBold, null);
    jPanel1.setBounds(new Rectangle(30, 25, 265, 95));
    jPanel1.setLayout(null);
    jLabel3.setText("Fonction :");
    jLabel3.setFont(new Font("Tahoma", 0, 16));
    jLabel3.setBounds(new Rectangle(30, 65, 90, 25));
    jLabel2.setText("Prenom :");
    jLabel2.setFont(new Font("Tahoma", 0, 16));
    jLabel2.setBounds(new Rectangle(30, 30, 90, 25));
    jLabel1.setText("Nom :");
    jLabel1.setFont(new Font("Tahoma", 0, 16));
    jLabel1.setBounds(new Rectangle(30, 0, 60, 20));
    
    Ecouteur ec = new Ecouteur();
    
    boutonBold.addItemListener(ec);
  }
  
  private class Ecouteur implements ItemListener
  {
    @Override
    public void itemStateChanged(ItemEvent e)
    {
      if (boutonBold.isSelected())
      {
        Component[] tab = jPanel1.getComponents();
        for (int i=0; i< tab.length; i++)
        {
          if (tab[i] instanceof JLabel)
            ((JLabel)tab[i]).setFont(new Font("Bold",Font.BOLD,16));
        }
        BoldFont.this.setTitle("Bold");
      }
      else
      {
        Component[] tab = jPanel1.getComponents();
        for (int i=0; i< tab.length; i++)
        {
          tab[i].setFont(new Font("Tahoma", 0, 16));
        }
        BoldFont.this.setTitle("Pas Bold");
      }
    }
  } 
  
  public static void main(String[] args)
  {
    BoldFont checkbutton = new BoldFont();
    
    checkbutton.setVisible(true);
    
    checkbutton.setLocationRelativeTo(null);
    
    checkbutton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}










