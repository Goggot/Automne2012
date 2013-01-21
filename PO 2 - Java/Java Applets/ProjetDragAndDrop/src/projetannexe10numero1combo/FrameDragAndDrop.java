package projetannexe10numero1combo;

import java.awt.Cursor;
import java.awt.Dimension;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameDragAndDrop extends JFrame {
    
   Ecouteur ec;
   Point posInitialeParRapportaEcran, posInitialeBoutonParRapportAuFrame;
  private JButton bouton = new JButton();

  public FrameDragAndDrop() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize( new Dimension(400, 300) );
        
        
       //1
         ec = new Ecouteur ();
        //2
    bouton.addMouseListener(ec);
      
    bouton.setText("jButton4");
    bouton.setBounds(new Rectangle(125, 90, 115, 40));
    this.getContentPane().add(bouton, null);

  }
    
    private class Ecouteur implements MouseListener, MouseMotionListener {

        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
         
            ((JButton)e.getSource()).addMouseMotionListener( ec );
                
            posInitialeParRapportaEcran = e.getLocationOnScreen();   // position de l'événement par rapport à l'écran : attention e.getLocation() emplacement de l'événement par raport à sa source
              
            posInitialeBoutonParRapportAuFrame = ((JButton)e.getSource()).getLocation();  // position du bouton par rapport au Frame 
           
            ((JButton)e.getSource()).setCursor( Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR) );  // changer le symbole du curseur 
        }

        public void mouseReleased(MouseEvent e) {
            ((JButton)e.getSource()).removeMouseMotionListener( ec ); // enlever le mouseDragged
            ((JButton)e.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)); // remettre le curseur régulier  
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseDragged(MouseEvent e) {
            
            Point dragged = e.getLocationOnScreen(); // événement par rapport à l'écran 
           
            int dragX = (int)(dragged.getX()-posInitialeParRapportaEcran.getX()); // on doit passer par la position par rapport à l'écran ; pas de position de l'événement par rapport à la fenêtre car la source est le bouton
            int dragY = (int)(dragged.getY()-posInitialeParRapportaEcran.getY());
            
            System.out.println ( e.getX() + "  "+ e.getY()); // la preuve : position de l'événement par rapport à la source  
            
            ((JButton)e.getSource()).setLocation(posInitialeBoutonParRapportAuFrame.x + dragX, posInitialeBoutonParRapportAuFrame.y + dragY);
          
           

        }

        public void mouseMoved(MouseEvent e) {
        }
    }
    
    public static void main ( String [] args ) {
        FrameDragAndDrop f = new FrameDragAndDrop();
        f.setVisible(true);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
