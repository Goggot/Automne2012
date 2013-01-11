package pacman;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FramePacman
  extends JFrame
{
  pacman p;
  private JLabel jLabel1 = new JLabel();

  public FramePacman()
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
    this.setSize( new Dimension(600, 600) );
    
    p = new pacman();
    p.setSize(500, 500);
    p.setLocation(50,25);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(p);
    p.setBackground(Color.BLACK);

    jLabel1.setText("Location");
    jLabel1.setBounds(new Rectangle(230, 535, 160, 25));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    Ecouteur ec = new Ecouteur();
    
    this.addKeyListener(ec);
  }
  
  private class Ecouteur implements KeyListener
  {
    @Override
    public void keyPressed(KeyEvent e)
    {
      if (e.getKeyCode() == KeyEvent.VK_UP)
        p.haut();
      else if (e.getKeyCode() == KeyEvent.VK_DOWN)
        p.bas();
      else if (e.getKeyCode() == KeyEvent.VK_LEFT)
        p.gauche();
      else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        p.droite();
      FramePacman.this.jLabel1.setText(String.valueOf(e.getKeyLocation()));
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }
  }
  
  public static void main(String[] args)
  {
    FramePacman couleur = new FramePacman();
    
    couleur.setVisible(true);
    
    couleur.setLocationRelativeTo(null);
    
    couleur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
