package packageTP2;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FrameTP2
  extends JFrame
{
    EnsembleClients tabClient = new EnsembleClients();
    boolean valid = false;
    
    newClient panelNouvClient = new newClient();
    private JLabel numClient = new JLabel();
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
    private JButton boutonRecherche = new JButton();
    private JLabel jLabel6 = new JLabel();
    private JLabel champPtsBonus = new JLabel();
    private JButton boutonAccepter = new JButton();
    private JMenuBar jMenuBar1 = new JMenuBar();
    private JMenu jMenu1 = new JMenu();
    private JMenuItem ajoutClt = new JMenuItem();

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
    this.setSize(new Dimension(536, 395));
        this.setTitle("Parachutisme FinHeureuse");
        this.setJMenuBar(jMenuBar1);
        numClient.setText("Numero du client :");
        numClient.setBounds(new Rectangle(20, 20, 160, 30));
        numClient.setHorizontalAlignment(SwingConstants.CENTER);
        numClient.setFont(new Font("Dialog", 0, 14));
        champNumClt.setBounds(new Rectangle(195, 20, 225, 35));
        panelInfos.setBounds(new Rectangle(15, 70, 420, 235));
        panelInfos.setLayout(null);
        panelInfos.setBounds(new Rectangle(15, 70, 500, 260));
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
        jLabel6.setText("Points bonus :");
        jLabel6.setBounds(new Rectangle(25, 170, 125, 20));
        jLabel6.setFont(new Font("Dialog", 0, 14));
        champPtsBonus.setFont(new Font("Dialog", 0, 14));
        champPtsBonus.setBounds(new Rectangle(185, 170, 310, 25));
        boutonAccepter.setText("Accepter");
        boutonAccepter.setBounds(new Rectangle(270, 220, 125, 25));
        boutonAccepter.setFont(new Font("Dialog", 1, 16));
        boutonAccepter.setEnabled(false);
        champDate.setBounds(new Rectangle(185, 100, 310, 25));
        champDate.setFont(new Font("Dialog", 0, 14));
        champNom.setFont(new Font("Dialog", 0, 14));
        champNom.setBounds(new Rectangle(185, 30, 315, 25));
        champNumCarte.setFont(new Font("Dialog", 0, 14));
        champNumCarte.setBounds(new Rectangle(185, 65, 310, 25));
        champCoord.setFont(new Font("Dialog", 0, 14));
        champCoord.setBounds(new Rectangle(185, 135, 310, 25));
        boutonRecherche.setText("Recherche");
        boutonRecherche.setBounds(new Rectangle(100, 220, 125, 25));
        boutonRecherche.setFont(new Font("Dialog", 1, 16));
        jMenu1.setText("Nouveau Client");
        ajoutClt.setText("Ajouter");
        panelInfos.add(boutonAccepter, null);
        panelInfos.add(champPtsBonus, null);
        panelInfos.add(jLabel6, null);
        panelInfos.add(boutonRecherche, null);
        panelInfos.add(champCoord, null);
        panelInfos.add(champNumCarte, null);
        panelInfos.add(champNom, null);
        panelInfos.add(champDate, null);
        panelInfos.add(jLabel5, null);
        panelInfos.add(jLabel4, null);
        panelInfos.add(jLabel3, null);
        panelInfos.add(jLabel2, null);
        jMenu1.add(ajoutClt);
        jMenuBar1.add(jMenu1);
        this.getContentPane().add(panelInfos, null);
        this.getContentPane().add(champNumClt, null);
        this.getContentPane().add(numClient, null);

        
        Ecouteur ecA = new Ecouteur();
        ItemEcouteur ecI = new ItemEcouteur();
        
        boutonRecherche.addActionListener(ecA);
        boutonAccepter.addActionListener(ecA);
        jMenu1.addActionListener(ecA);
        ajoutClt.addItemListener(ecI);
  }

    private class Ecouteur implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==boutonRecherche)
                try {
                    Client client = tabClient.getClient(champNumClt.getText());
                    champNom.setText(client.getNom());
                    champCoord.setText(client.getCoordonnees());
                    champDate.setText(String.valueOf(client.getDateNaissance().getTime()));
                    champNumCarte.setText(client.getNoCarte());
                    champPtsBonus.setText(String.valueOf(client.getNbPointsBonis()));
                    boutonAccepter.setEnabled(true);
                    valid = true;
                }
                catch (NullPointerException npe) {
                    JOptionPane.showMessageDialog(FrameTP2.this, "Numero inexistant");
                    champNumClt.setText("");
                }
            if (e.getSource()==boutonAccepter && valid == true) {
                FrameTP2.this.getContentPane().remove(panelInfos);
                champNumClt.setEnabled(false);
            }
            
            //if (e.getSource() == panelNouvClient)
        }
    }

    private class ItemEcouteur implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            FrameTP2.this.getContentPane().remove(panelInfos);
            FrameTP2.this.getContentPane().add(panelNouvClient,null);
        }
    }
}
