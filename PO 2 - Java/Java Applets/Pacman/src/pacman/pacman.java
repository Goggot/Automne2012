package pacman;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Graphics;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class pacman
  extends JPanel
{
  private int x,y;
  
  public pacman()
  {
    x=10;
    y=10;
    
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
    this.setLayout( null );
    this.setSize(new Dimension(476, 358));
  }
  
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.setColor(Color.YELLOW);
    g.fillArc(x, y, 20, 20, 50, 270);
  }
  
  public void gauche()
  {
    x -= 10;
    repaint();
  }
  
  public void droite()
  {
    x += 10;
    repaint();
  }
  
  public void haut()
  {
    y -= 10;
    repaint();
  }
  
  public void bas()
  {
    y += 10;
    repaint();
  }
}
