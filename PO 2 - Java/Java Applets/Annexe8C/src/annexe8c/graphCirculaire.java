package annexe8c;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class graphCirculaire
  extends JFrame
{
  private JPanel panelDonnees = new JPanel();
  private JLabel jLabel1 = new JLabel();
  private JLabel labelPrimaire = new JLabel();
  private JLabel labelSecondaire = new JLabel();
  private JLabel labelTertiaire = new JLabel();
  private JButton jButton1 = new JButton();
  private SpinnerNumberModel spinPrimaire = new SpinnerNumberModel(0,0,100,1);
  private SpinnerNumberModel spinSecondaire = new SpinnerNumberModel(0,0,100,1);
  private SpinnerNumberModel spinTertiaire = new SpinnerNumberModel(0,0,100,1);
  private SurfaceDessin dessin = new SurfaceDessin();
  double arcPrim, arcSec, arcTert;
  private JSpinner jSpinner1 = new JSpinner(spinPrimaire);
  private JSpinner jSpinner2 = new JSpinner(spinSecondaire);
  private JSpinner jSpinner3 = new JSpinner(spinTertiaire);

  public graphCirculaire()
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
    this.setSize(new Dimension(594, 408));
    panelDonnees.setBounds(new Rectangle(5, 5, 225, 350));
    panelDonnees.setLayout(null);
    jLabel1.setText("Activitées");
    jLabel1.setFont(new Font("Tahoma", 0, 16));
    jLabel1.setBounds(new Rectangle(55, 5, 105, 30));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    labelPrimaire.setText("Primaire :");
    labelPrimaire.setBounds(new Rectangle(10, 55, 90, 30));
    labelPrimaire.setFont(new Font("Tahoma", 0, 18));
    labelSecondaire.setText("Secondaire :");
    labelSecondaire.setBounds(new Rectangle(10, 135, 100, 30));
    labelSecondaire.setFont(new Font("Tahoma", 0, 18));
    labelTertiaire.setText("Tertiaire :");
    labelTertiaire.setBounds(new Rectangle(10, 215, 100, 30));
    labelTertiaire.setFont(new Font("Tahoma", 0, 18));
    jButton1.setText("Graphique");
    jButton1.setBounds(new Rectangle(50, 275, 120, 45));
    panelDonnees.add(jSpinner3, null);
    panelDonnees.add(jSpinner2, null);
    panelDonnees.add(jSpinner1, null);
    panelDonnees.add(jButton1, null);
    panelDonnees.add(labelTertiaire, null);
    panelDonnees.add(labelSecondaire, null);
    panelDonnees.add(jLabel1, null);
    panelDonnees.add(labelPrimaire, null);
    dessin.setBounds(265,35,300,300);
    this.getContentPane().add(panelDonnees, null);
    this.getContentPane().add(dessin, null);
    
    Ecouteur ec = new Ecouteur();
    jButton1.addActionListener(ec);
    jSpinner1.setBounds(new Rectangle(140, 60, 85, 35));
    jSpinner2.setBounds(new Rectangle(140, 135, 85, 35));
    jSpinner3.setBounds(new Rectangle(140, 215, 85, 35));
  }
  
  public class SurfaceDessin extends JPanel
  {
    protected void paintComponent (Graphics g)
    {
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      
      super.paintComponents(g);
      
      g.setColor(Color.RED);
      g.fillArc(60, 60, 125, 125, 0, (int)arcPrim);
      g.setColor(Color.BLUE);
      g.fillArc(60, 60, 125, 125, (int)arcPrim, (int)arcSec);
      g.setColor(Color.GREEN);
      g.fillArc(60, 60, 125, 125, (int)arcPrim+(int)arcSec, (int)arcTert);
    }
  }

  private class Ecouteur implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      
      int prim = (Integer)spinPrimaire.getValue();
      int sec = (Integer)spinSecondaire.getValue();
      int tert = (Integer)spinTertiaire.getValue();
      
      if (prim+sec+tert != 100)
        JOptionPane.showMessageDialog(graphCirculaire.this, "La somme des 3 secteurs ne doit pas dépasser 100");
      else
      {
        arcPrim = prim*360.0 / 100;
        arcSec = sec*360.0 / 100;
        arcTert = tert*360.0 / 100;
        
        repaint();
      }
    }
  }
  
  public static void main(String[] args)
  {
    graphCirculaire couleur = new graphCirculaire();
    
    couleur.setVisible(true);
    
    couleur.setLocationRelativeTo(null);
    
    couleur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
