package projetappletdebut;

import java.awt.Graphics;
import java.awt.Image;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;
import javax.swing.JPanel;

public class AppletAlbumPhoto extends JApplet
  implements MouseListener
{
  Image i;
  private int boucle = 0;
  public AppletAlbumPhoto(){};
  SurfaceDessin surface;
  
  private void jbInit() throws Exception
  {
    this.getContentPane().setLayout(null);
  }
  
  public void init()
  {
    this.getMouseListeners();
    
    Image[] album = new Image[4];
    album [0] = getImage(getCodeBase(), "photos/un.JPG");
    album [1] = getImage(getCodeBase(), "photos/deux.JPG");
    album [2] = getImage(getCodeBase(), "photos/trois.JPG");
    album [3] = getImage(getCodeBase(), "photos/quatre.JPG");
    
    surface = new SurfaceDessin();
    surface.setSize(600,600);       // Taille de la surface
    surface.setLocation(20,20);     // Emplacement de la surface
    this.getContentPane().add(surface);
    
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public void mouseClicked(MouseEvent e)
  {
    if (e.getX() > 400 && e.getX() < 450)
            // get par rapport à l'applet, pas à la surface
    {
      if (e.getY() > 100 && e.getY() < 300)
      {
        if (boucle == 0)
          boucle = 3;
        else
          boucle --;
        
        
      }
      else if (e.getY() > 350 && e.getY() < 550)
            // get par rapport à l'applet, pas à la surface
      {        
        if (boucle == 3)
          boucle = 0;
        else
          boucle ++;
        
        
      }
    }
  }

  @Override
  public void mousePressed(MouseEvent e)
  {
  }

  @Override
  public void mouseReleased(MouseEvent e)
  {
  }

  @Override
  public void mouseEntered(MouseEvent e)
  {
  }

  @Override
  public void mouseExited(MouseEvent e)
  {
  }

  private class SurfaceDessin extends JPanel
  {
    protected void paintComponent (Graphics g)
    {
      // IMPORTANT
      super.paintComponent(g);
      g.drawImage(i,50,50,400,300,this);

      g.drawRect(100,400, 200,50);
      g.drawString("Precedant", 150, 430);
      
      g.drawRect(350,400, 200,50);
      g.drawString("Suivant", 400, 430);
    }
  }

  
  
  public static void main(String[] args)
  {
    AppletAlbumPhoto appletAlbumPhoto = new AppletAlbumPhoto();
  }
}
