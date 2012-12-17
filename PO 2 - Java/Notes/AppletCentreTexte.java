package projetappletsdebut;

import java.applet.Applet;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AppletCentreTexte
  extends Applet
{
  public AppletCentreTexte()
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

  public static void main(String[] args)
  {
    AppletCentreTexte applet = new AppletCentreTexte();
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


  public void paint ( Graphics g )
  
  {
    System.out.println ( this.getSize().getWidth());
    System.out.println ( this.getSize().getHeight());
    Font f = new Font ( "Tahoma", Font.PLAIN, 19);
    // centrer 
    FontMetrics fm = this.getFontMetrics(f);
    g.setFont ( f );
    // définir la String 
    String s = new String ( "Bonjour à tous ");
    
    
    int x = (int)(getSize().getWidth() - fm.stringWidth(s)) / 2;
    int y = (int)(getSize().getHeight()-fm.getHeight()) / 2;
    
    g.drawString (s, x, y);
   
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
