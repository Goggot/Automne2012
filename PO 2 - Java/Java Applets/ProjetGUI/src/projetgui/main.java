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
    
  // Rendre visible 
    //frame.setVisible(true);
    panel.setVisible(true);
    temp.setVisible(true);
    
  // Placer par rapport � l'�cran
    frame.setLocationRelativeTo(null);
    panel.setLocationRelativeTo(null);
    temp.setLocationRelativeTo(null);
    
  // Pour tuer le processus en m�me temps que la fen�tre
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
  // Pour la den�tre en plein �cran
    // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
  }
}