package projetgui;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Num4
  extends JFrame
{
  private JPanel jPanel1 = new JPanel();
  private JTextArea jTextArea1 = new JTextArea();
  private JTextField champNom = new JTextField();
  private JTextArea jTextArea3 = new JTextArea();
  private JTextArea jTextArea4 = new JTextArea();
  private JTextField champPrenom = new JTextField();
  private JTextField champNum = new JTextField();
  private JTextArea jTextArea5 = new JTextArea();
  private JTextField champAdresse = new JTextField();

  public Num4()
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
    this.setSize(new Dimension(458, 318));
    jPanel1.setBounds(new Rectangle(20, 35, 425, 245));
    jPanel1.setLayout(null);
    jTextArea1.setBounds(new Rectangle(25, 5, 95, 30));
    jTextArea1.setText("Nom :");
    jTextArea1.setFont(new Font("Tahoma", 0, 16));
    jTextArea1.setBackground(new Color(247, 247, 247));
    champNom.setBounds(new Rectangle(180, 5, 175, 30));
    jTextArea3.setBounds(new Rectangle(25, 55, 95, 30));
    jTextArea3.setText("Prenom :");
    jTextArea3.setFont(new Font("Tahoma", 0, 16));
    jTextArea3.setBackground(new Color(247, 247, 247));
    jTextArea4.setBounds(new Rectangle(25, 110, 95, 30));
    jTextArea4.setText("Telephone :");
    jTextArea4.setFont(new Font("Tahoma", 0, 16));
    jTextArea4.setBackground(new Color(247, 247, 247));
    champPrenom.setBounds(new Rectangle(180, 55, 175, 30));
    champNum.setBounds(new Rectangle(180, 110, 175, 30));
    jTextArea5.setBounds(new Rectangle(25, 165, 95, 30));
    jTextArea5.setText("Adresse :");
    jTextArea5.setFont(new Font("Tahoma", 0, 16));
    jTextArea5.setBackground(new Color(247, 247, 247));
    champAdresse.setBounds(new Rectangle(180, 165, 230, 30));
    jPanel1.add(champNom, null);
    jPanel1.add(jTextArea1, null);
    jPanel1.add(jTextArea3, null);
    jPanel1.add(jTextArea4, null);
    jPanel1.add(champPrenom, null);
    jPanel1.add(champNum, null);
    jPanel1.add(jTextArea5, null);
    jPanel1.add(champAdresse, null);
    this.getContentPane().add(jPanel1, null);
    
    Ecouteur ec = new Ecouteur();
    champNom.addActionListener(ec);
    champPrenom.addActionListener(ec);
    champNum.addActionListener(ec);
    champAdresse.addActionListener(ec);
  }
  
  private class Ecouteur implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      if (e.getSource()==champNom)
        champPrenom.requestFocus();
      if (e.getSource()==champPrenom)
        champNum.requestFocus();
      if (e.getSource()==champNum)
        champAdresse.requestFocus();
    }
  }
}
