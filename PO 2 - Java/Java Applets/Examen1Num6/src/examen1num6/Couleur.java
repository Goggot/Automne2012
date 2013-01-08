package examen1num6;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Couleur
  extends JFrame
{
  private JLabel jLabel1 = new JLabel();
  private JTextField champTexte = new JTextField();
  private JLabel jLabel2 = new JLabel();
  private JPanel panelBoutons = new JPanel();
  private JButton boutonVider = new JButton();
  private JButton boutonVert = new JButton();
  private JButton boutonGris = new JButton();
  private JButton boutonBleu = new JButton();

  public Couleur()
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
    this.setSize(new Dimension(500, 359));
    this.setTitle("Changer la couleur des caractères");
    jLabel1.setText("Entrez du texte :");
    jLabel1.setBounds(new Rectangle(40, 20, 155, 55));
    jLabel1.setFont(new Font("Tahoma", 0, 20));
    champTexte.setBounds(new Rectangle(35, 75, 425, 45));
    jLabel2.setText("Modifiez la couleur du texte :");
    jLabel2.setBounds(new Rectangle(40, 135, 275, 50));
    jLabel2.setFont(new Font("Tahoma", 0, 20));
    panelBoutons.setBounds(new Rectangle(35, 210, 425, 100));
    panelBoutons.setLayout(null);
    boutonVider.setText("Vider le champ texte");
    boutonVider.setBounds(new Rectangle(90, 60, 225, 35));
    boutonVert.setText("VERT");
    boutonVert.setBounds(new Rectangle(15, 0, 105, 30));
    boutonGris.setText("GRIS");
    boutonGris.setBounds(new Rectangle(150, 0, 105, 30));
    boutonBleu.setText("BLEU");
    boutonBleu.setBounds(new Rectangle(285, 0, 100, 30));
    panelBoutons.add(boutonVider, null);
    panelBoutons.add(boutonVert, null);
    panelBoutons.add(boutonGris, null);
    panelBoutons.add(boutonBleu, null);
    this.getContentPane().add(panelBoutons, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(champTexte, null);
    this.getContentPane().add(jLabel1, null);

    Ecouteur ec = new Ecouteur();
    
    Component[] tab = panelBoutons.getComponents();
    for (int i=0; i< tab.length; i++)
      if (tab[i] instanceof JButton)   // instanceof ne fonctione pas
        ((JButton)tab[i]).addActionListener(ec);
  }
  private class Ecouteur implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      if (e.getSource()==boutonGris)
        champTexte.setForeground(Color.GRAY);
      else if (e.getSource()==boutonBleu)
        champTexte.setForeground(Color.BLUE);
      else if (e.getSource()==boutonVert)
        champTexte.setForeground(Color.GREEN);
      else if (e.getSource()==boutonVider)
        champTexte.setText("");
    }
  }
  
  public static void main(String[] args)
  {
    Couleur couleur = new Couleur();
    
    couleur.setVisible(true);
    
    couleur.setLocationRelativeTo(null);
    
    couleur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
