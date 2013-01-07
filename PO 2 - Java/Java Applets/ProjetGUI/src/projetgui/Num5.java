package projetgui;

import java.awt.Dimension;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Num5
  extends JFrame
{
  private JPanel jPanel1 = new JPanel();

  public Num5()
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
    this.setSize(new Dimension(455, 345));
    
    Ecouteur ml = new Ecouteur();
    this.addMouseListener(ml);
  }
  
  private class Ecouteur implements MouseListener
  {
    public void mousePressed(MouseEvent e)
    {
    }
    public void mouseReleased(MouseEvent e) 
    {
    }

    public void mouseEntered(MouseEvent e) 
    {
    }

    public void mouseExited(MouseEvent e) 
    {
    }
    
    public void mouseClicked(MouseEvent e) 
    {
      if (e.getButton() == 3)
      {
        Num5.this.dispose();  // Ferme l'écouteur
        System.exit(0);
      }
    }
  }
}
