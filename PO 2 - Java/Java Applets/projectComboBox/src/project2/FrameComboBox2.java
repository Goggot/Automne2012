package project2;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Enumeration;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Hashtable;
import java.util.Set;

public class FrameComboBox2
  extends JFrame
{
  private JPanel jPanel1 = new JPanel();
  private JPanel jPanel2 = new JPanel();
  private JComboBox combo = new JComboBox();
  private JLabel reponse = new JLabel();

  private MaHashtableSecrete h = new MaHashtableSecrete();
  
  public FrameComboBox2()
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
    this.setSize(new Dimension(400, 120));
    this.setTitle( "Capitales des provinces" );
    jPanel1.setBounds(new Rectangle(15, 10, 165, 65));
    jPanel1.setLayout(null);
    jPanel1.setBorder(BorderFactory.createTitledBorder("Choisissez un état"));
    jPanel2.setBounds(new Rectangle(205, 10, 160, 65));
    jPanel2.setBorder(BorderFactory.createTitledBorder("La capitale est :"));
    jPanel2.setLayout(null);
    combo.setBounds(new Rectangle(20, 25, 125, 25));
    reponse.setBounds(new Rectangle(40, 25, 80, 25));
    reponse.setFont(new Font("Tw Cen MT", 1, 13));
    jPanel2.add(reponse, null);
    this.getContentPane().add(jPanel2, null);
    jPanel1.add(combo, null);
    this.getContentPane().add(jPanel1, null);
    
    Set<String> s = h.keySet();
    for (String cle : s)
      combo.addItem(cle);
    
    // étape 1
    Ecouteur ec = new Ecouteur();
    
    // étape 2
    combo.addActionListener(ec);
  }
  
  //etape 3
  private class Ecouteur implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent e)
    {
      String item = (String)combo.getSelectedItem();
      reponse.setText((String)h.get(item));
    }
  } 
  
  
  public static void main ( String [] args )
  {
    FrameComboBox2 f = new FrameComboBox2();
    f.setVisible(true);
    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}
