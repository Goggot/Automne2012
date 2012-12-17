package feusignalisation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

public class FeuSignalisation extends JApplet implements MouseListener
{
  SurfaceDessin surface;
  Timer t;
  
  public FeuSignalisation()
  {
  }

  private void jbInit() throws Exception
  {
    this.getContentPane().setLayout( null );
  }

  public void init()
  {
    surface = new SurfaceDessin();
    surface.setSize(900,900);       // Taille de la surface
    surface.setLocation(0,0);     // Emplacement de la surface
    this.getContentPane().add(surface);
    
    t = new Timer(1000, this);
    t.start();
    
    try
    {
      jbInit();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private class SurfaceDessin extends JPanel
  {
    protected void paintComponent (Graphics g)
    {
      super.paintComponent(g);
      
      Color light_red = new Color(247, 93, 89, 80);
      Color light_yellow = new Color(253, 208, 2, 80);
      Color light_green = new Color(177, 251, 23, 80);
      
      this.setBackground(Color.black);
      
      g.setColor(light_red);
      g.fillOval(150, 100, 200, 200);
      
      g.setColor(light_yellow);
      g.fillOval(150, 350, 200, 200);
      
      g.setColor(light_green);
      g.fillOval(150, 600, 200, 200);
      
      
    }
  }

  public static void main(String[] args)
  {
    FeuSignalisation applet = new FeuSignalisation();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.getContentPane().add(applet, BorderLayout.CENTER);
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
  static
  {
    try
    {
    }
    catch (Exception e)
    {
    }
  }
}
