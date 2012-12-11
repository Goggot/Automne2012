package tp1;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.MaskFormatter;

public class BorneGraphique extends JFrame {
    
    private Color fond = new Color ( 30,152,196, 255);
    private Color bord = new Color ( 171,215,229);
    private Font tag = new Font ( "Tw Cen MT", Font.BOLD, 55);
    private Font police = new Font ( "Tw Cen MT", Font.BOLD, 15);
    private JPanel panelFond = new JPanel();
    ImageIcon i = new ImageIcon ( "logo.gif");
    private JLabel contImage = new JLabel(i);
    private JTextField champMessage = new JTextField();
    private JPanel panelClavier = new JPanel();
    private JButton boutonA = new JButton();
    private JButton boutonB = new JButton();
    private JButton boutonC = new JButton();
    private JButton bouton0 = new JButton();
    private JButton bouton1 = new JButton();
    private JButton bouton2 = new JButton();
    private JButton bouton4 = new JButton();
    private JButton bouton5 = new JButton();
    private JButton bouton6 = new JButton();
    private JButton bouton8 = new JButton();
    private JButton boutonD = new JButton();
    private JButton bouton3 = new JButton();
    private JButton bouton7 = new JButton();
    private JButton bouton9 = new JButton();
    private JButton boutonValider = new JButton();
    private JLabel jLabel1 = new JLabel();
    private JPanel panelComptant = new JPanel();
    private GridLayout gridLayout1 = new GridLayout();
    private JButton bouton25 = new JButton();
    private JButton bouton100 = new JButton();
    private JButton bouton200 = new JButton();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JPanel panelCredit = new JPanel(new FlowLayout(1));
    private JLabel jLabel4 = new JLabel();
    
    
    private JLabel jLabel5 = new JLabel();
   
    private JFormattedTextField champNumeroCarte;
    private JFormattedTextField champDateExp;
    private JLabel jLabel6 = new JLabel();
    private JButton boutonOK = new JButton();
    private JTextArea zoneRecu = new JTextArea();
    private JButton bouton25Credit = new JButton();
    private JButton boutonMaxCredit = new JButton();
    private JButton boutonEncaisser = new JButton();
    
    // Déclaration des variables provenant de votre modèle ( objets )
    private Borne laBorne;
    private String code;
    

    public BorneGraphique() {
        
        // création de ces objets 
        laBorne = new Borne (code,1);
        code = new String ();
        
        
        // vérifier si la borne est en fonction par rapport à l'heure
        if ( laBorne.VerificationDate())
          champMessage.setText("Entrez votre code de stationnement svp");
        else
          champMessage.setText("Gratuit");
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        MaskFormatter m1 = new MaskFormatter("############");
        MaskFormatter m2 = new MaskFormatter("##/##");
        champNumeroCarte = new JFormattedTextField(m1);
        champDateExp = new JFormattedTextField(m2);
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(872, 1003));
        this.setTitle( "Stationnement de Montréal" );
        panelFond.setBounds(new Rectangle(15, 20, 830, 835));
        panelClavier.add(boutonValider, null);
        panelClavier.add(bouton9, null);
        panelClavier.add(bouton7, null);
        panelClavier.add(bouton3, null);
        panelClavier.add(boutonD, null);
        panelClavier.add(boutonB,
                         new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                                new Insets(0, 0, 0, 0), 0, 0));
        panelClavier.add(boutonC,
                         new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                                new Insets(0, 0, 0, 0), 0, 0));
        panelClavier.add(bouton0,
                         new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                                new Insets(0, 0, 0, 0), 0, 0));
        panelClavier.add(bouton1,
                         new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                                new Insets(0, 0, 0, 0), 0, 0));
        panelClavier.add(bouton2,
                         new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                                new Insets(0, 0, 0, 0), 0, 0));
        panelClavier.add(bouton4,
                         new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                                new Insets(0, 0, 0, 0), 0, 0));
        panelClavier.add(bouton5,
                         new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                                new Insets(0, 0, 0, 0), 0, 0));
        panelClavier.add(bouton6,
                         new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                                new Insets(0, 0, 0, 0), 0, 0));
        panelClavier.add(bouton8,
                         new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                                new Insets(0, 0, 0, 0), 0, 0));
        panelClavier.add(boutonA, null);
        panelComptant.add(bouton25, null);
        panelComptant.add(bouton100, null);
        panelComptant.add(bouton200, null);
        panelCredit.add(boutonMaxCredit, null);
        panelCredit.add(jLabel4, null);
        panelCredit.add(champNumeroCarte, null);
        panelCredit.add(jLabel5, null);
        panelCredit.add(champDateExp, null);
        panelCredit.add(bouton25Credit, null);
        panelFond.add(zoneRecu, null);
        panelFond.add(boutonOK, null);
        panelFond.add(jLabel6, null);
        panelFond.add(panelCredit, null);
        panelFond.add(jLabel3, null);
        panelFond.add(jLabel2, null);
        panelFond.add(panelComptant, null);
        panelFond.add(jLabel1, null);
        panelFond.add(panelClavier, null);
        panelFond.add(champMessage, null);
        panelFond.add(contImage, null);
        this.getContentPane().add(boutonEncaisser, null);
        this.getContentPane().add(panelFond, null);
        panelFond.setBackground(fond);
        panelFond.setLayout(null);
        contImage.setBounds(new Rectangle(300, 5, 240, 115));
        contImage.setBorder(BorderFactory.createLineBorder(bord, 2));
        champMessage.setBounds(new Rectangle(90, 135, 655, 35));
        champMessage.setBackground(bord);
        champMessage.setFont(police);
        
        champMessage.setForeground(fond);
        champMessage.setHorizontalAlignment(JTextField.CENTER);
        panelClavier.setBounds(new Rectangle(430, 220, 370, 315));
        panelClavier.setLayout(null);
        panelClavier.setBorder(BorderFactory.createTitledBorder(new TitledBorder( new LineBorder( fond), "Entrez votre code de stationnement", 0, 0, police, fond)));
        panelComptant.setBorder(BorderFactory.createTitledBorder(new TitledBorder( new LineBorder( fond), "Entrez votre monnaie", 0, 0, police, fond)));
        panelCredit.setBorder(BorderFactory.createTitledBorder(new TitledBorder( new LineBorder( fond), "Insérez votre carte de crédit", 0, 0, police, fond)));
        panelClavier.setBackground(bord);
        boutonA.setText("A");
        boutonA.setBounds(new Rectangle(35, 30, 70, 55));
        boutonA.setSize(new Dimension(70, 55));
        boutonA.setMargin(new Insets(1, 1, 1, 1));
        boutonA.setFont(new Font("Tw Cen MT", 1, 14));
        boutonA.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        boutonA_actionPerformed(e);
                    }
                });
        boutonB.setText("B");
        boutonB.setBounds(new Rectangle(110, 30, 70, 25));
        boutonB.setSize(new Dimension(70, 55));
        boutonB.setMargin(new Insets(1, 1, 1, 1));
        boutonB.setFont(new Font("Tw Cen MT", 1, 14));
        boutonB.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        boutonB_actionPerformed(e);
                    }
                });
        boutonC.setText("C");
        boutonC.setBounds(new Rectangle(185, 30, 70, 25));
        boutonC.setSize(new Dimension(70, 55));
        boutonC.setMargin(new Insets(1, 1, 1, 1));
        boutonC.setFont(new Font("Tw Cen MT", 1, 14));
        boutonC.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        boutonC_actionPerformed(e);
                    }
                });
        bouton0.setText("0");
        bouton0.setBounds(new Rectangle(35, 90, 70, 55));
        bouton0.setMargin(new Insets(1, 1, 1, 1));
        bouton0.setFont(new Font("Tw Cen MT", 1, 14));
        bouton0.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        bouton0_actionPerformed(e);
                    }
                });
        bouton1.setText("1");
        bouton1.setBounds(new Rectangle(110, 90, 70, 55));
        bouton1.setMargin(new Insets(1, 1, 1, 1));
        bouton1.setFont(new Font("Tw Cen MT", 1, 14));
        bouton1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        bouton1_actionPerformed(e);
                    }
                });
        bouton2.setText("2");
        bouton2.setBounds(new Rectangle(185, 90, 70, 55));
        bouton2.setMargin(new Insets(1, 1, 1, 1));
        bouton2.setFont(new Font("Tw Cen MT", 1, 14));
        bouton2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        bouton2_actionPerformed(e);
                    }
                });
        bouton4.setText("4");
        bouton4.setBounds(new Rectangle(35, 150, 70, 55));
        bouton4.setSize(new Dimension(70, 55));
        bouton4.setMargin(new Insets(1, 1, 1, 1));
        bouton4.setFont(new Font("Tw Cen MT", 1, 14));
        bouton4.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        bouton4_actionPerformed(e);
                    }
                });
        bouton5.setText("5");
        bouton5.setBounds(new Rectangle(110, 150, 70, 55));
        bouton5.setMargin(new Insets(1, 1, 1, 1));
        bouton5.setFont(new Font("Tw Cen MT", 1, 14));
        bouton5.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        bouton5_actionPerformed(e);
                    }
                });
        bouton6.setText("6");
        bouton6.setBounds(new Rectangle(185, 150, 70, 55));
        bouton6.setMargin(new Insets(1, 1, 1, 1));
        bouton6.setFont(new Font("Tw Cen MT", 1, 14));
        bouton6.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        bouton6_actionPerformed(e);
                    }
                });
        bouton8.setText("8");
        bouton8.setSize(new Dimension(71, 25));
        bouton8.setBounds(new Rectangle(35, 210, 70, 55));
        bouton8.setMargin(new Insets(1, 1, 1, 1));
        bouton8.setFont(new Font("Tw Cen MT", 1, 14));
        bouton8.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        bouton8_actionPerformed(e);
                    }
                });
        boutonD.setText("D");
        boutonD.setBounds(new Rectangle(260, 30, 70, 55));
        boutonD.setMargin(new Insets(1, 1, 1, 1));
        boutonD.setFont(new Font("Tw Cen MT", 1, 14));
        boutonD.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        boutonD_actionPerformed(e);
                    }
                });
        bouton3.setText("3");
        bouton3.setBounds(new Rectangle(260, 90, 70, 55));
        bouton3.setMargin(new Insets(1, 1, 1, 1));
        bouton3.setFont(new Font("Tw Cen MT", 1, 14));
        bouton3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        bouton3_actionPerformed(e);
                    }
                });
        bouton7.setText("7");
        bouton7.setBounds(new Rectangle(260, 150, 70, 55));
        bouton7.setMargin(new Insets(1, 1, 1, 1));
        bouton7.setFont(new Font("Tw Cen MT", 1, 14));
        bouton7.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        bouton7_actionPerformed(e);
                    }
                });
        bouton9.setText("9");
        bouton9.setBounds(new Rectangle(110, 210, 70, 55));
        bouton9.setMargin(new Insets(1, 1, 1, 1));
        bouton9.setFont(new Font("Tw Cen MT", 1, 14));
        bouton9.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        bouton9_actionPerformed(e);
                    }
                });
        boutonValider.setText("Valider");
        boutonValider.setBounds(new Rectangle(185, 210, 145, 55));
        boutonValider.setMargin(new Insets(1, 1, 1, 1));
        boutonValider.setFont(new Font("Tw Cen MT", 1, 14));
        boutonValider.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        boutonValider_actionPerformed(e);
                    }
                });
        jLabel1.setText("1");
        jLabel1.setBounds(new Rectangle(385, 175, 40, 70));
        jLabel1.setForeground( bord);
        jLabel1.setFont ( tag);
        panelComptant.setBounds(new Rectangle(75, 220, 270, 105));
        panelComptant.setLayout(gridLayout1);
        panelComptant.setBackground(bord);
        gridLayout1.setHgap(5);
        gridLayout1.setVgap(5);
        gridLayout1.setColumns(3);
        bouton25.setText("0.25$");
        bouton25.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        bouton25_actionPerformed(e);
                    }
                });
        bouton100.setText("1$");
        bouton100.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        bouton100_actionPerformed(e);
                    }
                });
        bouton200.setText("2$");
        bouton200.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        bouton200_actionPerformed(e);
                    }
                });
        jLabel2.setText("2");
        jLabel2.setBounds(new Rectangle(35, 170, 40, 70));
        jLabel2.setForeground( bord);
        jLabel2.setFont ( tag);
        jLabel3.setText("ou");
        jLabel3.setBounds(new Rectangle(175, 325, 65, 45));
        jLabel3.setForeground( bord);
        jLabel3.setFont ( tag);
        panelCredit.setBounds(new Rectangle(75, 380, 270, 155));
        panelCredit.setBackground(bord);
        panelCredit.setLayout(null);
        jLabel4.setText("numéro:");
        jLabel4.setBounds(new Rectangle(25, 35, 55, 15));
        champNumeroCarte.setSize(new Dimension(57, 21));
        champNumeroCarte.setPreferredSize(new Dimension(147, 21));
        champNumeroCarte.setForeground( fond);
        champNumeroCarte.setBackground(bord);
        champNumeroCarte.setBounds(new Rectangle(85, 30, 145, 20));
        champNumeroCarte.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        champNumeroCarte_actionPerformed(e);
                    }
                });
        champDateExp.setForeground( fond);
        champDateExp.setBackground(bord);
        jLabel5.setText("date d'expiration:");
        jLabel5.setSize(new Dimension(58, 15));
        jLabel5.setBounds(new Rectangle(20, 60, 115, 15));
        champDateExp.setPreferredSize(new Dimension(107, 21));
        champDateExp.setBounds(new Rectangle(145, 55, 85, 25));
        champDateExp.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        champDateExp_actionPerformed(e);
                    }
                });
        jLabel6.setText("3");
        jLabel6.setBounds(new Rectangle(30, 530, 40, 70));
        jLabel6.setForeground( bord);
        jLabel6.setFont ( tag);
        boutonOK.setText("OK");
        boutonOK.setBounds(new Rectangle(75, 575, 725, 65));
        boutonOK.setMargin(new Insets(1, 1, 1, 1));
        boutonOK.setForeground( bord);
        boutonOK.setFont ( tag);
        boutonOK.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        boutonOK_actionPerformed(e);
                    }
                });
        zoneRecu.setBounds(new Rectangle(75, 660, 725, 155));
        zoneRecu.setForeground( fond);
        zoneRecu.setBackground(bord);
        zoneRecu.setFont ( police);
        bouton25Credit.setText("+ 0,25$");
        bouton25Credit.setBounds(new Rectangle(35, 85, 70, 55));
        bouton25Credit.setSize(new Dimension(70, 55));
        bouton25Credit.setMargin(new Insets(1, 1, 1, 1));
        bouton25Credit.setFont(new Font("Tw Cen MT", 1, 14));
        boutonMaxCredit.setText("MAX");
        boutonMaxCredit.setBounds(new Rectangle(160, 85, 70, 55));
        boutonMaxCredit.setSize(new Dimension(70, 55));
        boutonMaxCredit.setMargin(new Insets(1, 1, 1, 1));
        boutonMaxCredit.setFont(new Font("Tw Cen MT", 1, 14));
        bouton25Credit.setForeground( fond);
        bouton25Credit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        bouton25Credit_actionPerformed(e);
                    }
                });
        boutonMaxCredit.setForeground(fond);
        boutonMaxCredit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        boutonMaxCredit_actionPerformed(e);
                    }
                });
        boutonEncaisser.setText("encaisser");
        boutonEncaisser.setBounds(new Rectangle(350, 870, 215, 35));
        jLabel4.setForeground( fond);
        jLabel4.setFont ( police);
        jLabel5.setForeground(fond);
        jLabel5.setFont ( police);
        boutonEncaisser.setForeground( fond);
        boutonEncaisser.setFont ( police);
    boutonEncaisser.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            boutonEncaisser_actionPerformed(e);
          }
        });
    Component[] tab = panelClavier.getComponents();
        for ( int i = 0; i < panelClavier.getComponents().length; i++) {
            ((JButton)tab[i]).setForeground(fond);
            
        }
        Component[] tab2 = panelComptant.getComponents();
        for ( int i = 0; i < panelComptant.getComponents().length; i++) {
            ((JButton)tab2[i]).setForeground(fond);
            ((JButton)tab2[i]).setFont(police);
            
        }
    }
    
 
    
   

    private void bouton25_actionPerformed(ActionEvent e) {
        //à coder
        
    }

    private void bouton100_actionPerformed(ActionEvent e) {
        //à coder
   
    }

    private void bouton200_actionPerformed(ActionEvent e) {
        //à coder

    }

    private void champNumeroCarte_actionPerformed(ActionEvent e) {
        champDateExp.requestFocus();
    }

    private void champDateExp_actionPerformed(ActionEvent e) {
        //à coder
       
    }

    private void bouton25Credit_actionPerformed(ActionEvent e) {
 
    }

    private void boutonMaxCredit_actionPerformed(ActionEvent e) {

    }

    private void boutonA_actionPerformed(ActionEvent e) {
       code +="A";
       champMessage.setText(code);
    }

    private void boutonB_actionPerformed(ActionEvent e) {
      code +="B";
      champMessage.setText(code);
    }

    private void boutonC_actionPerformed(ActionEvent e) {
      code +="C";
      champMessage.setText(code);
    }

    private void boutonD_actionPerformed(ActionEvent e) {
      code +="D";
      champMessage.setText(code);
    }

    private void bouton0_actionPerformed(ActionEvent e) {
      code +="0";
      champMessage.setText(code);
    }

    private void bouton1_actionPerformed(ActionEvent e) {
      code +="1";
      champMessage.setText(code);
    }

    private void bouton2_actionPerformed(ActionEvent e) {
      code +="2";
      champMessage.setText(code);
    }

    private void bouton3_actionPerformed(ActionEvent e) {
      code +="3";
      champMessage.setText(code);
    }

    private void bouton4_actionPerformed(ActionEvent e) {
      code +="4";
      champMessage.setText(code);
    }

    private void bouton5_actionPerformed(ActionEvent e) {
      code +="5";
      champMessage.setText(code);
    }

    private void bouton6_actionPerformed(ActionEvent e) {
      code +="6";
      champMessage.setText(code);
    }

    private void bouton7_actionPerformed(ActionEvent e) {
      code +="7";
      champMessage.setText(code);
    }

    private void bouton8_actionPerformed(ActionEvent e) {
      code +="8";
      champMessage.setText(code);
    }

    private void bouton9_actionPerformed(ActionEvent e) {
      code +="9";
      champMessage.setText(code);
    }

    private void boutonValider_actionPerformed(ActionEvent e) {
      
    }

    private void boutonOK_actionPerformed(ActionEvent e) {
     
      SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm");
      DecimalFormat df = new DecimalFormat("0.00$");
      
    }

  private void boutonEncaisser_actionPerformed(ActionEvent e)
  {
   
  }
  
  public static void main ( String [] args ) {
      BorneGraphique b = new BorneGraphique();
      b.setVisible(true);
      b.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
}
