package projetgui;

import javax.swing.JFrame;

public class main
{
  public static void main(String[] args)
  {
  // Créer un objet du nom de la classe
    FrameFactorielle2 frame = new FrameFactorielle2();
    PanelCouleur panel = new PanelCouleur();
    ConversionTemp temp = new ConversionTemp();
    
  // Rendre visible 
    //frame.setVisible(true);
    panel.setVisible(true);
    temp.setVisible(true);
    
  // Placer par rapport à l'écran
    frame.setLocationRelativeTo(null);
    panel.setLocationRelativeTo(null);
    temp.setLocationRelativeTo(null);
    
  // Pour tuer le processus en même temps que la fenêtre
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
  // Pour la denêtre en plein écran
    // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
  }
}