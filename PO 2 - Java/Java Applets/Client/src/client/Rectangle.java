package client;

import java.applet.Applet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Rectangle
  extends Applet
{
  public Rectangle()
  {
  }

  private void jbInit()
    throws Exception
  {
    this.setLayout( null );
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
  
  public void paint(Graphics g)
  {
    this.setBackground(Color.darkGray);
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
    g.setColor(Color.blue);
    g.fillRect(70, 90, 80, 75);
    
    g.setColor(Color.yellow);
    g.fillOval(110, 20, 85, 85);
    //g.fillRect(150, 75, 100, 100);
    
    g.setColor(Color.red);
    int [] x = {10,80,25};
    int [] y = {10,10,65};
    Polygon p = new Polygon(x,y,3);
    g.fillPolygon(p);
    /*g.drawLine(90, 100, 50, 20);
    g.drawLine(90, 100, 130, 20);
    g.drawLine(50, 20, 130, 20);
    g.fillRect(20, 20, 100, 200);*/
    
  }

  public static void main(String[] args)
  {
    Rectangle applet = new Rectangle();
    Frame frame = new Frame();
    frame.addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent e) { System.exit(0); } } );
    frame.add(applet, BorderLayout.CENTER);
    frame.setTitle( "Applet Frame" );
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
