package projetSynthese;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class echiquierGraph extends JFrame {
    int pBlanche = 0, pNoir = 0;
    Echiquier echiquier = new Echiquier();
    Position depart, arrivee;
    Piece laPiece;
    Color couleurDepart, couleurArrivee;

    private JPanel panelControl = new JPanel();
    private JButton boutonDebuter = new JButton();
    private JPanel panelPieceBlanche = new JPanel();
    private JPanel panelPieceNoir = new JPanel();
    private JPanel panelEchiquier = new JPanel();
    private GridLayout gridDamier = new GridLayout(8, 8);
    private JLabel[][] tabLabel = new JLabel[8][8];
    private JLabel[] pieceBlancheLabel = new JLabel[16];
    private JLabel[] pieceNoirLabel = new JLabel[16];
    private JPanel jPanel1 = new JPanel();
    private JLabel labelCouleur = new JLabel();
    private GridLayout gridPieceBlanche = new GridLayout(16, 1);
    private GridLayout gridPieceNoir = new GridLayout(16, 1);

    ImageIcon TB = new ImageIcon("Icones/TB.gif");
    ImageIcon FB = new ImageIcon("Icones/FB.gif");
    ImageIcon CB = new ImageIcon("Icones/CB.gif");
    ImageIcon RB = new ImageIcon("Icones/RB.gif");
    ImageIcon DB = new ImageIcon("Icones/DB.gif");
    ImageIcon PB = new ImageIcon("Icones/PB.gif");
    ImageIcon TN = new ImageIcon("Icones/TN.gif");
    ImageIcon FN = new ImageIcon("Icones/FN.gif");
    ImageIcon CN = new ImageIcon("Icones/CN.gif");
    ImageIcon RN = new ImageIcon("Icones/RN.gif");
    ImageIcon DN = new ImageIcon("Icones/DN.gif");
    ImageIcon PN = new ImageIcon("Icones/PN.gif");


    public echiquierGraph() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        this.setSize(new Dimension(661, 589));
        this.setTitle("Jeu d'echec");
        panelControl.setBounds(new Rectangle(10, 15, 495, 45));
        panelControl.setLayout(null);
        panelControl.setBackground(new Color(148, 148, 148));
        boutonDebuter.setText("DEBUTER");
        boutonDebuter.setBounds(new Rectangle(20, 10, 115, 25));
        panelPieceBlanche.setBounds(new Rectangle(580, 15, 50, 520));
        panelPieceBlanche.setBackground(Color.white);
        panelPieceBlanche.setLayout(gridPieceBlanche);
        panelPieceNoir.setBounds(new Rectangle(520, 15, 50, 520));
        panelPieceNoir.setBackground(Color.black);
        panelPieceNoir.setLayout(gridPieceNoir);
        panelEchiquier.setBounds(new Rectangle(35, 80, 450, 450));
        panelEchiquier.setLayout(gridDamier);
        panelEchiquier.setBackground(new Color(79, 79, 79));
        jPanel1.setBounds(new Rectangle(0, 0, 660, 570));
        jPanel1.setBackground(new Color(79, 79, 79));
        labelCouleur.setText("Couleur");
        labelCouleur.setBounds(new Rectangle(165, 10, 295, 25));
        labelCouleur.setForeground(new Color(231, 231, 231));
        labelCouleur.setHorizontalAlignment(SwingConstants.CENTER);
        labelCouleur.setHorizontalTextPosition(SwingConstants.CENTER);
        labelCouleur.setFont(new Font("Dialog", 0, 18));
        panelControl.add(labelCouleur, null);
        panelControl.add(boutonDebuter, null);
        this.getContentPane().add(panelEchiquier, null);
        this.getContentPane().add(panelPieceNoir, null);
        this.getContentPane().add(panelPieceBlanche, null);
        this.getContentPane().add(panelControl, null);
        this.getContentPane().add(jPanel1, null);

        GestionnaireEvenement ec = new GestionnaireEvenement();

        boutonDebuter.addMouseListener(ec);

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                Color couleur = new Color(255, 255, 255);

                if (i % 2 == 1 && j % 2 == 0)
                    couleur = Color.GRAY;
                else if (i % 2 == 0 && j % 2 == 1)
                    couleur = Color.GRAY;
                else
                    couleur = Color.WHITE;

                tabLabel[i][j] = new JLabel();
                tabLabel[i][j].setOpaque(true);
                tabLabel[i][j].setBackground(couleur);
                tabLabel[i][j].setSize(53, 53);
                tabLabel[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                panelEchiquier.add(tabLabel[i][j]);
                tabLabel[i][j].addMouseListener(ec);
            }
    }

    private class GestionnaireEvenement implements MouseListener {
        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == boutonDebuter) {
                
                for (int i = 0; i < 8; i++)
                    for (int j = 0; j < 8; j++)
                    {
                        tabLabel[i][j].setIcon(null);
                        echiquier.getCase(i,j).enleverPiece();
                    }

                if (boutonDebuter.getText() == "RESET")
                    boutonDebuter.setText("Debuter");

                labelCouleur.setText("NOIR");
                boutonDebuter.setText("RESET");
                
                tabLabel[0][0].setIcon(TN);
                tabLabel[0][1].setIcon(CN);
                tabLabel[0][2].setIcon(FN);
                tabLabel[0][3].setIcon(RN);
                tabLabel[0][4].setIcon(DN);
                tabLabel[0][5].setIcon(FN);
                tabLabel[0][6].setIcon(CN);
                tabLabel[0][7].setIcon(TN);
                tabLabel[7][0].setIcon(TB);
                tabLabel[7][1].setIcon(CB);
                tabLabel[7][2].setIcon(FB);
                tabLabel[7][3].setIcon(RB);
                tabLabel[7][4].setIcon(DB);
                tabLabel[7][5].setIcon(FB);
                tabLabel[7][6].setIcon(CB);
                tabLabel[7][7].setIcon(TB);

                for (int i = 0; i < 8; i++) {
                    tabLabel[1][i].setIcon(PN);
                    tabLabel[6][i].setIcon(PB);
                }
                
                for (int i = 0; i < pBlanche; i++) 
                    pieceBlancheLabel[i].setIcon(null);
                for (int i = 0; i < pNoir; i++)
                    pieceNoirLabel[i].setIcon(null);
                    
                echiquier.debuter();
            }

            else if (boutonDebuter.getText() == "RESET"){
                for (int i = 0; i < 8; i++)
                    for (int j = 0; j < 8; j++)
                        if (e.getSource().equals(tabLabel[i][j])){
                                boolean valid = false;
                                if (depart == null && echiquier.getCase(i, j).estOccupe()) {
                                    if (echiquier.getCase(i,j).getPiece().getCouleur() == labelCouleur.getText()){
                                        depart = new Position(i, j);
                                        couleurDepart = tabLabel[i][j].getBackground();
                                        laPiece = echiquier.getCase(i, j).getPiece();
                                        tabLabel[i][j].setBackground(Color.RED);
                                    }
                                }
                                else {
                                    arrivee = new Position(i, j);
                                    valid = true;
                                    couleurArrivee = tabLabel[i][j].getBackground();
                                }
                                if (valid) {
                                    if (echiquier.cheminPossible(depart, arrivee) && laPiece.estValide(depart, arrivee)) {
                                        if (echiquier.getCase(i, j).estOccupe()) {
                                            if (echiquier.getCase(depart.getLigne(), depart.getColonne()).getPiece().getCouleur() == "NOIR") {
                                                pieceBlancheLabel[pBlanche] = new JLabel();
                                                pieceBlancheLabel[pBlanche].setHorizontalAlignment(SwingConstants.CENTER);
                                                pieceBlancheLabel[pBlanche].setIcon(tabLabel[arrivee.getLigne()][arrivee.getColonne()].getIcon());
                                                panelPieceNoir.add(pieceBlancheLabel[pBlanche]);
                                                pBlanche++;
                                            }
                                            else {
                                                pieceNoirLabel[pNoir] = new JLabel();
                                                pieceNoirLabel[pNoir].setHorizontalAlignment(SwingConstants.CENTER);
                                                pieceNoirLabel[pNoir].setIcon(tabLabel[arrivee.getLigne()][arrivee.getColonne()].getIcon());
                                                panelPieceBlanche.add(pieceNoirLabel[pNoir]);
                                                pNoir++;
                                            }
                                        }
                                        tabLabel[i][j].setIcon(tabLabel[depart.getLigne()][depart.getColonne()].getIcon());
                                        tabLabel[depart.getLigne()][depart.getColonne()].setIcon(null);
                                        echiquier.getCase(depart.getLigne(), depart.getColonne()).enleverPiece();
                                        echiquier.getCase(i, j).setPiece(laPiece);
                                        tabLabel[depart.getLigne()][depart.getColonne()].setBackground(couleurDepart);
                                        tabLabel[i][j].setBackground(couleurArrivee);
                                        depart = null;
                                        arrivee = null;
                                        if (labelCouleur.getText() == "NOIR")
                                            labelCouleur.setText("BLANC");
                                        else
                                            labelCouleur.setText("NOIR");
                                    }
                                }
                            }
            }
        }
    }

    public static void main(String[] args) {
        echiquierGraph echiquier = new echiquierGraph();

        echiquier.setVisible(true);

        echiquier.setLocationRelativeTo(null);

        echiquier.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
