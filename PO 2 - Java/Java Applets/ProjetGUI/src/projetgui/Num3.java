package projetgui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class Num3
  extends JFrame
{
  private JButton champDeux = new JButton();
  private JButton champSix = new JButton();
  private JButton champTrois = new JButton();
  private JButton champUn = new JButton();
  private JButton champQuatre = new JButton();
  private JButton champCinq = new JButton();
  private JButton champHuit = new JButton();
  private JButton champNeuf = new JButton();
  private JButton champSept = new JButton();
  private JLabel resultat = new JLabel();
  private JTextArea champCode = new JTextArea();
  private JPanel jPanel1 = new JPanel();

  public Num3()
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
    this.setSize(new Dimension(286, 398));
    this.setTitle("Alarme");
    champDeux.setText("2");
    champDeux.setBounds(new Rectangle(115, 75, 50, 50));
    champSix.setText("6");
    champSix.setBounds(new Rectangle(185, 145, 50, 50));
    champTrois.setText("3");
    champTrois.setBounds(new Rectangle(185, 75, 50, 50));
    champUn.setText("1");
    champUn.setBounds(new Rectangle(45, 75, 50, 50));
    champQuatre.setText("4");
    champQuatre.setBounds(new Rectangle(45, 145, 50, 50));
    champCinq.setText("5");
    champCinq.setBounds(new Rectangle(115, 145, 50, 50));
    champHuit.setText("8");
    champHuit.setBounds(new Rectangle(115, 215, 50, 50));
    champNeuf.setText("9");
    champNeuf.setBounds(new Rectangle(185, 215, 50, 50));
    champSept.setText("7");
    champSept.setBounds(new Rectangle(45, 215, 50, 50));
    resultat.setText("Entrez un code");
    resultat.setBounds(new Rectangle(45, 300, 185, 40));
    resultat.setOpaque(true);
    resultat.setHorizontalAlignment(SwingConstants.CENTER);
    resultat.setBackground(new Color(214, 214, 214));
    champCode.setBounds(new Rectangle(90, 20, 100, 35));
    jPanel1.setBounds(new Rectangle(25, 70, 235, 210));
    jPanel1.setLayout(null);
    this.getContentPane().add(champCode, null);
    this.getContentPane().add(resultat, null);
    this.getContentPane().add(champSept, null);
    this.getContentPane().add(champNeuf, null);
    this.getContentPane().add(champHuit, null);
    this.getContentPane().add(champCinq, null);
    this.getContentPane().add(champQuatre, null);
    this.getContentPane().add(champUn, null);
    this.getContentPane().add(champTrois, null);
    this.getContentPane().add(champSix, null);
    this.getContentPane().add(champDeux, null);

    this.getContentPane().add(jPanel1, null);
    Ecouteur ec = new Ecouteur();
    
    champUn.addActionListener(ec);
    champDeux.addActionListener(ec);
    champTrois.addActionListener(ec);
    champQuatre.addActionListener(ec);
    champCinq.addActionListener(ec);
    champSix.addActionListener(ec);
    champSept.addActionListener(ec);
    champHuit.addActionListener(ec);
    champNeuf.addActionListener(ec);
    /*
    Component[] tab = jPanel1.getComponents();
    for (int i=0; i< tab.length; i++)
      if (tab[i].instanceof(JButton))
          ((JButton)tab[i]).addActionListener(ec);
    */
  }
    
  private class Ecouteur implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      champCode.setText("");
      String pass = "123";
      for (int i=0; i<3; i++)
      {
        if (champUn)
        {
          String code = champCode.getText(); 
          champCode.setText(code+"1");
        }
        if (champDeux. )
        {
          String code = champCode.getText(); 
          champCode.setText(code+"2");
        }
        if (champTrois != null)
        {
          String code = champCode.getText(); 
          champCode.setText(code+"3");
        }
        if (champQuatre != null)
        {
          String code = champCode.getText(); 
          champCode.setText(code+"4");
        }
        if (champCinq != null)
        {
          String code = champCode.getText(); 
          champCode.setText(code+"5");
        }
        if (champSix != null)
        {
          String code = champCode.getText(); 
          champCode.setText(code+"6");
        }
        if (champSept != null)
        {
          String code = champCode.getText(); 
          champCode.setText(code+"7");
        }
        if (champHuit != null)
        {
          String code = champCode.getText(); 
          champCode.setText(code+"8");
        }
        if (champNeuf != null)
        {
          String code = champCode.getText(); 
          champCode.setText(code+"9");
        }
      }
      
      if (champCode.getText() == pass)
      {
        resultat.setBackground(Color.GREEN);
        resultat.setText("Code valide !");
      }
      else 
      {
        resultat.setBackground(Color.RED);
        resultat.setText("Code invalide !");
      }
    }
  }
}
