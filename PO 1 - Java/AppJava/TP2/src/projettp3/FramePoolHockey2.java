package projettp3;

import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class FramePoolHockey2 extends JFrame {
    private JPanel panelSynthèse = new JPanel();
    private JTabbedPane jTabbedPane1 = new JTabbedPane();
    private JPanel panelIdentification = new JPanel();
    private JPanel panelAvants = new JPanel();
    private JPanel panelDefenseurs = new JPanel();
    private JPanel panelGardiens = new JPanel();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JTextField champNom = new JTextField();
    private JTextField champCourriel = new JTextField();
    private JLabel jLabel3 = new JLabel();
    private JComboBox comboAvants = new JComboBox();
    private JButton boutonAjouterAvants = new JButton();
    private JComboBox comboJoueursChoisis = new JComboBox();
    private JTextField champSalaire = new JTextField();
   
    private JComboBox comboDefenseurs = new JComboBox();
    private JComboBox comboGardiens = new JComboBox();
    private JLabel jLabel4 = new JLabel();
    private JButton boutonAjouterDefenseurs = new JButton();
    private JButton boutonAjouterGardiens = new JButton();
    private JButton boutonConfirmerNom = new JButton();


   
    private JPanel panelConfirmation = new JPanel();
    private JLabel jLabel5 = new JLabel();
    private JLabel jLabel6 = new JLabel();
    private JButton boutonPoints = new JButton();
    private JTextField champPoints = new JTextField();
    private JButton boutonRecommencer = new JButton();
    private JLabel jLabel7 = new JLabel();
    private JLabel jLabel8 = new JLabel();
    private JLabel jLabel9 = new JLabel();
    ListeJoueurs l = new ListeJoueurs();


    public FramePoolHockey2() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(541, 505));
        this.setTitle( "Pool de hockey" );
        panelSynthèse.setBounds(new Rectangle(15, 330, 470, 135));
        panelSynthèse.setBorder(BorderFactory.createTitledBorder("Synthèse"));
        panelSynthèse.setLayout(null);
        jTabbedPane1.setBounds(new Rectangle(10, 30, 470, 290));
        jTabbedPane1.setTabPlacement(JTabbedPane.BOTTOM);
        panelIdentification.setLayout(null);
        panelIdentification.setBorder(BorderFactory.createTitledBorder("Identification"));
        panelAvants.setLayout(null);
        panelAvants.setBorder(BorderFactory.createTitledBorder("Avants"));
        panelDefenseurs.setLayout(null);
        panelDefenseurs.setBorder(BorderFactory.createTitledBorder("Défenseurs"));
        panelGardiens.setLayout(null);
        panelGardiens.setBorder(BorderFactory.createTitledBorder("Gardiens"));
        jLabel1.setText("Nom:");
        jLabel1.setBounds(new Rectangle(70, 75, 70, 15));
        jLabel2.setText("Courriel");
        jLabel2.setBounds(new Rectangle(70, 100, 100, 25));
        champNom.setBounds(new Rectangle(230, 70, 155, 20));
        champCourriel.setBounds(new Rectangle(230, 105, 155, 20));
        jLabel3.setText("Choississez 7 joueurs avants , cliquez sur ajouter pour les choisir :");
        jLabel3.setBounds(new Rectangle(30, 15, 405, 20));
        comboAvants.setBounds(new Rectangle(125, 70, 215, 30));
        boutonAjouterAvants.setText("Ajouter");
        boutonAjouterAvants.setBounds(new Rectangle(125, 120, 215, 35));
        comboJoueursChoisis.setBounds(new Rectangle(275, 35, 180, 25));
        champSalaire.setBounds(new Rectangle(275, 80, 180, 25));
        comboDefenseurs.setBounds(new Rectangle(145, 100, 190, 30));
        comboGardiens.setBounds(new Rectangle(135, 100, 185, 30));
        jLabel4.setText("Choississez 2 défenseurs  , cliquez sur ajouter pour les choisir :");
        jLabel4.setBounds(new Rectangle(30, 25, 405, 20));
        boutonAjouterDefenseurs.setText("Ajoutez");
        boutonAjouterDefenseurs.setBounds(new Rectangle(145, 155, 190, 30));
        boutonAjouterGardiens.setText("Ajouter");
        boutonAjouterGardiens.setBounds(new Rectangle(135, 145, 185, 30));
        panelIdentification.add(boutonConfirmerNom, null);
        panelIdentification.add(champCourriel, null);
        panelIdentification.add(champNom, null);
        panelIdentification.add(jLabel2, null);
        panelIdentification.add(jLabel1, null);
        jTabbedPane1.addTab("Identification", panelIdentification);
        panelAvants.add(boutonAjouterAvants, null);
        panelAvants.add(comboAvants, null);
        panelAvants.add(jLabel3, null);
        jTabbedPane1.addTab("Avants", panelAvants);
        panelDefenseurs.add(boutonAjouterDefenseurs, null);
        panelDefenseurs.add(jLabel4, null);
        panelDefenseurs.add(comboDefenseurs, null);
        jTabbedPane1.addTab("Defenseurs", panelDefenseurs);
        panelGardiens.add(jLabel7, null);
        panelGardiens.add(boutonAjouterGardiens, null);
        panelGardiens.add(comboGardiens, null);
        jTabbedPane1.addTab("Gardiens", panelGardiens);
        panelConfirmation.add(champPoints, null);
        panelConfirmation.add(boutonPoints, null);
        panelConfirmation.add(jLabel6, null);
        panelConfirmation.add(jLabel5, null);
        jTabbedPane1.addTab("Confirmation", panelConfirmation);
        this.getContentPane().add(jTabbedPane1, null);
        panelSynthèse.add(jLabel9, null);
        panelSynthèse.add(jLabel8, null);
        panelSynthèse.add(boutonRecommencer, null);
        panelSynthèse.add(champSalaire, null);
        panelSynthèse.add(comboJoueursChoisis, null);
        this.getContentPane().add(panelSynthèse, null);
        boutonConfirmerNom.setText("Confirmer");
        boutonConfirmerNom.setBounds(new Rectangle(115, 155, 215, 30));
        panelConfirmation.setLayout(null);
        jLabel5.setText("Merci d'avoir participé ! ");
        jLabel5.setBounds(new Rectangle(10, 15, 440, 35));
        jLabel6.setText("Cliquez pour savoir combien de points vous avez accumulés à ce jour");
        jLabel6.setBounds(new Rectangle(10, 65, 435, 35));
        boutonPoints.setText("Points");
        boutonPoints.setBounds(new Rectangle(140, 125, 215, 35));
        champPoints.setBounds(new Rectangle(140, 175, 215, 25));
       
        boutonRecommencer.setText("Recommencez");
        boutonRecommencer.setBounds(new Rectangle(10, 30, 110, 75));
        jLabel7.setText("Choisissez 2 gardiens");
        jLabel7.setBounds(new Rectangle(35, 35, 305, 25));
        jLabel8.setText("Joueurs choisis:");
        jLabel8.setBounds(new Rectangle(135, 35, 125, 25));
        jLabel9.setText("salaire accumulé");
        jLabel9.setBounds(new Rectangle(135, 80, 120, 25));
        
        remplirCombo();
        
        // écouteurs 
        Ecouteur e = new Ecouteur();
        boutonAjouterAvants.addActionListener(e);
        boutonAjouterDefenseurs.addActionListener(e);
        boutonAjouterGardiens.addActionListener(e);
        boutonConfirmerNom.addActionListener(e);
        boutonPoints.addActionListener(e);
        boutonRecommencer.addActionListener(e);
        
    }
    
  // 4B : coder la méthode remplirCombo  
    public void remplirCombo() {
      Vector<Joueur> liste = l.getJoueur();
      for (int i=0; i < liste.size(); i++)
      {
        if (liste.get(i) instanceof Avant)
          comboAvants.addItem(liste.get(i).getNom());
        else if (liste.get(i) instanceof Gardien)
          comboGardiens.addItem(liste.get(i).getNom());
        else if (liste.get(i) instanceof Defenseur)
          comboDefenseurs.addItem(liste.get(i).getNom());
      }
    }
    
    
    private class Ecouteur implements ActionListener {
        
      public void actionPerformed ( ActionEvent ae) {
            
            if ( ae.getSource() == boutonConfirmerNom) {
                // NUMÉRO 4C : gestion du boutonConfirmerNom
              
            }
           else if ( ae.getSource() == boutonAjouterAvants) {
                // NUMERO 4D : gestion du boutonAjouterAvants 
              
            }
            
            else if ( ae.getSource() == boutonAjouterDefenseurs) {
                // NUMERO 4E : gestion du boutonAjouterDefenseurs 
              
            }
            else if ( ae.getSource() == boutonAjouterGardiens )// ajouterGardiens
            {
                // NUMERO 4F : gestion du boutonAjouterGardiens
              
            }
            
            else if ( ae.getSource()==boutonPoints){   // boutonPoints
                // NUMERO 4G : gestion du boutonPoints
              
            }
            
            else // boutonRecommencer
            {
                // NUMERO 4H : gestion du boutonRecommencer
              
            }
        }
    }
    
    public static void main ( String [] args) {
        FramePoolHockey2 f = new FramePoolHockey2 ();
        try
        {
        UIManager.setLookAndFeel( "com.sun.java.swing.plaf.windows.WindowsLookAndFeel" );
        SwingUtilities.updateComponentTreeUI( f );
        }
        catch ( Exception e ) {
        e.printStackTrace();
    }
        f.setVisible( true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
