package restaurant;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class FrameResto extends JFrame {
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JSpinner nombreInvites;
    private JCheckBox caseCocher = new JCheckBox();
    private JTextField champReponse = new JTextField();
    private JButton bouton = new JButton();
    private JLabel jLabel5 = new JLabel();
    private JTextField champNombreTablesOccupees = new JTextField();

    public FrameResto() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        
        SpinnerNumberModel s = new SpinnerNumberModel (2,2,4,1);
        nombreInvites =  new JSpinner(s);
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(400, 292));
        this.setTitle("ClientTableMatch 2009");
        jLabel1.setText("nombre de convives:");
        jLabel1.setBounds(new Rectangle(30, 25, 145, 30));
        jLabel1.setFont(new Font("Tw Cen MT", 0, 14));
        jLabel2.setText("Voulez-vous une banquette ?");
        jLabel2.setBounds(new Rectangle(25, 75, 210, 35));
        jLabel2.setFont(new Font("Tw Cen MT", 0, 14));
        jLabel4.setText("Rendez vous à la table numéro : ");
        jLabel4.setBounds(new Rectangle(20, 155, 200, 45));
        jLabel4.setFont(new Font("Tw Cen MT", 0, 14));
        nombreInvites.setBounds(new Rectangle(255, 25, 65, 35));
        caseCocher.setText("Oui");
        caseCocher.setBounds(new Rectangle(255, 80, 115, 25));
        champReponse.setBounds(new Rectangle(230, 165, 150, 25));
        champReponse.setEditable(false);
        bouton.setText("Valider");
        bouton.setBounds(new Rectangle(130, 120, 115, 30));
        this.getContentPane().add(champNombreTablesOccupees, null);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().add(bouton, null);
        this.getContentPane().add(champReponse, null);
        this.getContentPane().add(caseCocher, null);
        this.getContentPane().add(nombreInvites, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel1, null);
       
        
        
        jLabel5.setText("nbre de tables occupées:");
        jLabel5.setBounds(new Rectangle(20, 205, 200, 45));
        jLabel5.setFont(new Font("Tw Cen MT", 0, 14));
        champNombreTablesOccupees.setBounds(new Rectangle(230, 215, 150, 25));
        champNombreTablesOccupees.setEditable(false);
        
        Ecouteur e = new Ecouteur ();
        bouton.addActionListener(e);
        
    }
    
    
    private class Ecouteur implements ActionListener {
        Restaurant r = new Restaurant ();
        
        public void actionPerformed ( ActionEvent ae) {
            int nb =(Integer) nombreInvites.getValue();
            boolean banquette = caseCocher.isSelected();
            
            // codez ici !
            
            
         
        }
    }
    
    public static void main ( String [] args ) {
        FrameResto fr = new FrameResto();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
