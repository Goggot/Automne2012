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


public class echiquierGraph
  extends JFrame
{
  Echiquier echiquier = new Echiquier();
  Position depart, arrivee;
  Color couleurDepart, couleurArrivee;
  Piece laPiece;
  
  private JPanel panelControl = new JPanel();
  private JButton boutonDebuter = new JButton();
  private JPanel panelPieceBlanche = new JPanel();
  private JPanel panelPieceNoir = new JPanel();
  private JPanel panelEchiquier = new JPanel();
  private GridLayout gridDamier = new GridLayout(8, 8);
  private JLabel[][] tabLabel = new JLabel[8][8];
  private JPanel jPanel1 = new JPanel();
  private JLabel labelCouleur = new JLabel();

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

  public echiquierGraph()
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
    panelPieceNoir.setBounds(new Rectangle(520, 15, 50, 520));
    panelPieceNoir.setBackground(Color.black);
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
      for (int j = 0; j < 8; j++)
      {
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

  private class GestionnaireEvenement
    implements MouseListener
  {
    public void mousePressed(MouseEvent e)
    {
    }

    public void mouseReleased(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }

    public void mouseClicked(MouseEvent e)
    {
      if (e.getSource() == boutonDebuter)
      {
        for (int i = 0; i < 8; i++)
          for (int j = 0; j < 8; j++)
            tabLabel[i][j].setIcon(null);

        if (boutonDebuter.getText() == "RESET")
          boutonDebuter.setText("Debuter");

        labelCouleur.setText("Noir");
        boutonDebuter.setText("RESET");
        tabLabel[0][0].setIcon(TN);
        echiquier.getCase(0, 0).setPiece(new Tour("TN1", "noir"));
        tabLabel[0][1].setIcon(CN);
        echiquier.getCase(0, 1).setPiece(new Cavalier("CN1", "noir"));
        tabLabel[0][2].setIcon(FN);
        echiquier.getCase(0, 2).setPiece(new Fou("FN1", "noir"));
        tabLabel[0][3].setIcon(RN);
        echiquier.getCase(0, 3).setPiece(new Roi("RN", "noir"));
        tabLabel[0][4].setIcon(DN);
        echiquier.getCase(0, 4).setPiece(new Reine("DN", "noir"));
        tabLabel[0][5].setIcon(FN);
        echiquier.getCase(0, 5).setPiece(new Fou("FN2", "noir"));
        tabLabel[0][6].setIcon(CN);
        echiquier.getCase(0, 6).setPiece(new Cavalier("CN2", "noir"));
        tabLabel[0][7].setIcon(TN);
        echiquier.getCase(0, 7).setPiece(new Tour("TN2", "noir"));
        tabLabel[7][0].setIcon(TB);
        echiquier.getCase(7, 0).setPiece(new Tour("TB1", "blanc"));
        tabLabel[7][1].setIcon(CB);
        echiquier.getCase(7, 1).setPiece(new Cavalier("CB1", "blanc"));
        tabLabel[7][2].setIcon(FB);
        echiquier.getCase(7, 2).setPiece(new Fou("FB1", "blanc"));
        tabLabel[7][3].setIcon(RB);
        echiquier.getCase(7, 3).setPiece(new Roi("RB", "blanc"));
        tabLabel[7][4].setIcon(DB);
        echiquier.getCase(7, 4).setPiece(new Reine("DB", "blanc"));
        tabLabel[7][5].setIcon(FB);
        echiquier.getCase(7, 5).setPiece(new Fou("FB2", "blanc"));
        tabLabel[7][6].setIcon(CB);
        echiquier.getCase(7, 6).setPiece(new Cavalier("CB2", "blanc"));
        tabLabel[7][7].setIcon(TB);
        echiquier.getCase(7, 7).setPiece(new Tour("TB2", "blanc"));

        for (int i = 0; i < 8; i++)
        {
          tabLabel[1][i].setIcon(PN);
          tabLabel[6][i].setIcon(PB);
          echiquier.getCase(1,i).setPiece(new Pion("p" + (i + 1), "noir"));
          echiquier.getCase(7,i).setPiece(new Pion("p" + (i + 1), "blanc"));
        }

        echiquier.debuter();
      }

      else if (boutonDebuter.getText() == "RESET")
      {
        for (int i = 0; i < 8; i++)
          for (int j = 0; j < 8; j++)
            if (e.getSource().equals(tabLabel[i][j]))
            {
              boolean valid = false;
              if (depart == null)
              {
                depart = new Position(i, j);
                couleurDepart = tabLabel[i][j].getBackground();
                laPiece = echiquier.getCase(i,j).getPiece();
              }
              else
              {
                arrivee = new Position(i, j);
                valid = true;
                couleurArrivee = tabLabel[i][j].getBackground();
              }
              tabLabel[i][j].setBackground(Color.RED);
              if (valid)
              {
                if (echiquier.cheminPossible(depart, arrivee) && laPiece.estValide(depart, arrivee))
                {
                  tabLabel[i][j].setIcon(tabLabel[depart.getLigne()][depart.getColonne()].getIcon());
                  tabLabel[depart.getLigne()][depart.getColonne()].setIcon(null);
                  //echiquier.getCase(i, j).setPiece(laPiece);
                }
                tabLabel[depart.getLigne()][depart.getColonne()].setBackground(couleurDepart);
                tabLabel[i][j].setBackground(couleurArrivee);
                depart = null;
                arrivee = null;
                if (labelCouleur.getText() == "Noir")
                  labelCouleur.setText("Blanc");
                else
                  labelCouleur.setText("Noir");
              }
            }
      }
    }
  }

  public static void main(String[] args)
  {
    echiquierGraph echiquier = new echiquierGraph();

    echiquier.setVisible(true);

    echiquier.setLocationRelativeTo(null);

    echiquier.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
