package projetexceptions;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;

public class FenetreUsager extends JFrame 
{
  DecimalFormat d = new DecimalFormat ( "0.00$" );
  JPanel jPanel1 = new JPanel();
  JLabel jLabel3 = new JLabel();
  JTextField champMontant = new JTextField();
  JLabel jLabel4 = new JLabel();
  JPanel jPanel2 = new JPanel();
  JButton bouton = new JButton();
  JTextField champReponse = new JTextField();
  SpinnerNumberModel snm = new SpinnerNumberModel (12,12,60,12);
  private JSpinner spin = new JSpinner(snm);

  public FenetreUsager()
  {
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

  }
  
  public static void main ( String [] args )
  {
  FenetreUsager f = new FenetreUsager ();
  f.setLocationRelativeTo(null);
  f.setVisible( true );
  f.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  
  private void jbInit() throws Exception
  {
    this.getContentPane().setLayout(null);
    this.setSize(new Dimension(400, 300));
    this.setTitle("Fenetre Exceptions");
    jPanel1.setBounds(new Rectangle(10, 10, 370, 190));
    jPanel1.setLayout(null);
    jPanel1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    jLabel3.setText("Montant a investir");
    jLabel3.setBounds(new Rectangle(5, 10, 165, 45));
    champMontant.setBounds(new Rectangle(205, 20, 90, 25));
    jLabel4.setText("Nombre de mois");
    jLabel4.setBounds(new Rectangle(5, 70, 150, 20));
    jPanel2.setBounds(new Rectangle(10, 210, 370, 55));
    jPanel2.setFont(new Font("Dialog", 0, 17));
    jPanel2.setLayout(null);
    bouton.setText("Echeance");
    bouton.setBounds(new Rectangle(15, 15, 115, 25));
    bouton.setFont(new Font("Dialog", 1, 16));
    champReponse.setBounds(new Rectangle(145, 15, 195, 25));
    champReponse.setFont(new Font("SansSerif", 1, 15));
    spin.setBounds(new Rectangle(205, 70, 90, 25));
    jPanel1.add(spin, null);
    jPanel1.add(jLabel4, null);
    jPanel1.add(champMontant, null);
    jPanel1.add(jLabel3, null);
    jPanel2.add(champReponse, null);
    jPanel2.add(bouton, null);
    this.getContentPane().add(jPanel2, null);
    this.getContentPane().add(jPanel1, null);   
    
    Ecouteur ec = new Ecouteur();
    
    bouton.addMouseListener(ec);
  }


    private class Ecouteur implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                int nbMois = (Integer)spin.getValue();
                double montant = Double.parseDouble(champMontant.getText());
                
                Placement p = new Placement(montant,nbMois);
                
                champReponse.setText(d.format(p.calculerMontantFinal()));
            }
            catch (NumberFormatException nfe) {
                //JOptionPane.showMessageDialog(FenetreUsager.this, "Montant invalide");
                String rep = JOptionPane.showInputDialog("Entrez un montant valide");
                champMontant.setText(rep);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}


