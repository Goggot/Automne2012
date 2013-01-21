package project2;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FrameComboBox3
  extends JFrame
{
  Vector<String> tab = new Vector<String>();
  private JComboBox combo = new JComboBox(tab);
  private JTextField champTexte = new JTextField();

  public FrameComboBox3()
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
    this.setTitle( "Editable" );
    combo.setBounds(new Rectangle(100, 80, 175, 35));
    combo.setEditable(true);
    
    this.getContentPane().add(champTexte, null);
    this.getContentPane().add(combo, null);
    
   
    champTexte.setBounds(new Rectangle(100, 130, 175, 30));
    tab.add("Arial");
    tab.add("Courier");
    
    Ecouteur ec = new Ecouteur();
    
    combo.addActionListener(ec);
  }
  
  private class Ecouteur implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      champTexte.setFont(tab.get());
    }
  }

  public static void main ( String [] args )
  {
    FrameComboBox3 f = new FrameComboBox3();
    f.setVisible(true);
    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  
}
