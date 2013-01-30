package packageTP2;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class newClient extends JPanel {
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JLabel jLabel6 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JButton boutonValider = new JButton();
    private JTextField champNom = new JTextField();
    private JTextField champNumCarte = new JTextField();
    private JTextField champDateNaissance = new JTextField();
    private JTextField champCoord = new JTextField();
    private JTextField champPts = new JTextField();
    private JLabel jLabel1 = new JLabel();

    public newClient() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(477, 346));
        jLabel3.setText("Numero de carte :");
        jLabel3.setBounds(new Rectangle(35, 115, 140, 25));
        jLabel3.setFont(new Font("Dialog", 0, 14));
        jLabel4.setText("Date de naissance :");
        jLabel4.setBounds(new Rectangle(35, 160, 140, 25));
        jLabel4.setFont(new Font("Dialog", 0, 14));
        jLabel5.setText("Coordonnees :");
        jLabel5.setBounds(new Rectangle(35, 210, 125, 20));
        jLabel5.setFont(new Font("Dialog", 0, 14));
        jLabel6.setText("Points bonus :");
        jLabel6.setBounds(new Rectangle(35, 255, 125, 20));
        jLabel6.setFont(new Font("Dialog", 0, 14));
        jLabel2.setText("Nom :");
        jLabel2.setBounds(new Rectangle(35, 70, 95, 25));
        jLabel2.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel2.setFont(new Font("Dialog", 0, 14));
        boutonValider.setText("Valider");
        boutonValider.setBounds(new Rectangle(160, 300, 155, 30));
        boutonValider.setFont(new Font("Tahoma", 1, 14));
        champNom.setBounds(new Rectangle(195, 70, 260, 30));
        champNumCarte.setBounds(new Rectangle(195, 115, 260, 30));
        champDateNaissance.setBounds(new Rectangle(195, 160, 260, 30));
        champCoord.setBounds(new Rectangle(195, 205, 260, 30));
        champPts.setBounds(new Rectangle(195, 250, 260, 30));
        jLabel1.setText("Nouveau Client");
        jLabel1.setBounds(new Rectangle(80, 15, 305, 35));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setFont(new Font("Tahoma", 0, 18));
        this.add(jLabel1, null);
        this.add(champPts, null);
        this.add(champCoord, null);
        this.add(champDateNaissance, null);
        this.add(champNumCarte, null);
        this.add(champNom, null);
        this.add(boutonValider, null);
        this.add(jLabel2, null);
        this.add(jLabel6, null);
        this.add(jLabel5, null);
        this.add(jLabel4, null);
        this.add(jLabel3, null);
    }
}
