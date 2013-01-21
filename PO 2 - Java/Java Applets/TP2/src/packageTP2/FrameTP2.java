package packageTP2;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FrameTP2
  extends JFrame
{
    EnsembleClients tabClient = new EnsembleClients();
    
    private JLabel jLabel1 = new JLabel();
    private JTextField champNumClt = new JTextField();
    private JPanel panelInfos = new JPanel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JLabel champDate = new JLabel();
    private JLabel champNom = new JLabel();
    private JLabel champNumCarte = new JLabel();
    private JLabel champCoord = new JLabel();
    private JButton boutonValid = new JButton();

    public FrameTP2()
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
    this.setSize(new Dimension(449, 337));
        this.setTitle("Parachutisme FinHeureuse");
        jLabel1.setText("Numero du client :");
        jLabel1.setBounds(new Rectangle(20, 20, 160, 30));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setFont(new Font("Dialog", 0, 14));
        champNumClt.setBounds(new Rectangle(195, 20, 225, 35));
        panelInfos.setBounds(new Rectangle(15, 70, 420, 235));
        panelInfos.setLayout(null);
        panelInfos.setBounds(new Rectangle(15, 70, 415, 230));
        jLabel2.setText("Nom :");
        jLabel2.setBounds(new Rectangle(25, 30, 95, 25));
        jLabel2.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel2.setFont(new Font("Dialog", 0, 14));
        jLabel3.setText("Numero de carte :");
        jLabel3.setBounds(new Rectangle(25, 65, 140, 25));
        jLabel3.setFont(new Font("Dialog", 0, 14));
        jLabel4.setText("Date de naissance :");
        jLabel4.setBounds(new Rectangle(25, 100, 140, 25));
        jLabel4.setFont(new Font("Dialog", 0, 14));
        jLabel5.setText("Coordonnees :");
        jLabel5.setBounds(new Rectangle(25, 135, 125, 20));
        jLabel5.setFont(new Font("Dialog", 0, 14));
        champDate.setBounds(new Rectangle(225, 100, 170, 25));
        champDate.setFont(new Font("Dialog", 0, 14));
        champNom.setFont(new Font("Dialog", 0, 14));
        champNom.setBounds(new Rectangle(225, 30, 170, 25));
        champNumCarte.setFont(new Font("Dialog", 0, 14));
        champNumCarte.setBounds(new Rectangle(225, 65, 170, 25));
        champCoord.setFont(new Font("Dialog", 0, 14));
        champCoord.setBounds(new Rectangle(225, 135, 170, 25));
        boutonValid.setText("Valider");
        boutonValid.setBounds(new Rectangle(125, 180, 175, 40));
        boutonValid.setFont(new Font("Dialog", 1, 16));
        panelInfos.add(boutonValid, null);
        panelInfos.add(champCoord, null);
        panelInfos.add(champNumCarte, null);
        panelInfos.add(champNom, null);
        panelInfos.add(champDate, null);
        panelInfos.add(jLabel5, null);
        panelInfos.add(jLabel4, null);
        panelInfos.add(jLabel3, null);
        panelInfos.add(jLabel2, null);
        this.getContentPane().add(panelInfos, null);
        this.getContentPane().add(panelInfos, null);
        this.getContentPane().add(champNumClt, null);
        this.getContentPane().add(jLabel1, null);
        
        Ecouteur ec = new Ecouteur();
        
        boutonValid.addActionListener(ec);
    }

    private class Ecouteur implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Client client = tabClient.getClient(champNumClt.getText());
                champNom.setText(client.getNom());
                champCoord.setText(client.getCoordonnees());
                champDate.setText(String.valueOf(client.getDateNaissance()));
                champNumCarte.setText(client.getNoCarte());
            }
            catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(FrameTP2.this, "Numero inexistant");
                champNumClt.setText("");
            }
        }
    }
}
