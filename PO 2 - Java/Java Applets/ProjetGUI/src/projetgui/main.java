package projetgui;

import javax.swing.JFrame;

public class main
{
  public static void main(String[] args)
  {
  // Cr�er un objet du nom de la classe
    FrameFactorielle2 frame = new FrameFactorielle2();
    PanelCouleur panel = new PanelCouleur();
    ConversionTemp temp = new ConversionTemp();
    Num3 num3 = new Num3();
    Num4 num4 = new Num4();
    Num5 num5 = new Num5();
    Num6 num6 = new Num6();
    
  // Rendre visible 
    //frame.setVisible(true);
    //panel.setVisible(true);
    //temp.setVisible(true);
    num3.setVisible(true);
    //num4.setVisible(true);
    //num5.setVisible(true);
    //num6.setVisible(true);
    
  // Placer par rapport � l'�cran
    //frame.setLocationRelativeTo(null);
    //panel.setLocationRelativeTo(null);
    //temp.setLocationRelativeTo(null);
    num3.setLocationRelativeTo(null);
    //num4.setLocationRelativeTo(null);
    //num5.setLocationRelativeTo(null);
    //num6.setLocationRelativeTo(null);
    
  // Pour tuer le processus en m�me temps que la fen�tre
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
  // Pour la den�tre en plein �cran
    // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
  }
}