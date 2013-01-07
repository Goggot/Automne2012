package projetgui;

import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;

public class Num7
  extends JFrame
{

  public Num7()
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
    this.setSize(new Dimension(479, 309));
    this.setTitle("Je suis normal");
    
    //Ecouteur ec = new Ecouteur();
    
    //this.addActionListener(ec);
  }
  
  /*private class Ecouteur implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      if ()
    }
  }*/
}
