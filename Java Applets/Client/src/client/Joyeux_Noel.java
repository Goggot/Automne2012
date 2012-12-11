package client;

import java.applet.Applet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Joyeux_Noel
  extends Applet
{
  public Joyeux_Noel()
  {
  }

  private void jbInit()
    throws Exception
  {
    this.setLayout( null );
    this.setSize(new Dimension(596, 382));
  }

  public void init()
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

  public void paint (Graphics g)
  {
    this.setBackground(Color.darkGray);  // ou (new Color(200,200,200))
    Color c = new Color(230, 3, 3, 200);
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g.setColor(c);
    Font f = new Font("Comic Sans MS", Font.BOLD, 30);
    g.setFont(f);
    g.drawString("Joyeux Noël !", 40, 125);
    g.drawLine(35, 150, 250, 150);
    
    
  }

  public static void main(String[] args)
  {
    Joyeux_Noel applet = new Joyeux_Noel();
    Frame frame = new Frame();
    frame.addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) { System.exit(0); } } );
    frame.add(applet, BorderLayout.CENTER);
    frame.setTitle( "Joyeux Noël !" );
    applet.init();
    applet.start();
    frame.setSize(300, 300);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    frame.setLocation((d.width-frameSize.width)/2, (d.height-frameSize.height)/2);
    frame.setVisible(true);
  }

  public void start()
  {
  }

  public void stop()
  {
  }

  public void destroy()
  {
  }
}
