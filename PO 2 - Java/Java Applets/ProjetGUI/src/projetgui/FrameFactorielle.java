package projetgui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import oracle.jdeveloper.layout.BoxLayout2;

public class FrameFactorielle
  extends JFrame
{


  private JPanel borderlayout = new JPanel();
  private BorderLayout borderLayout1 = new BorderLayout();
  private JPanel flowlayout = new JPanel();
  private JPanel cardlayout = new JPanel();
  private CardLayout cardLayout1 = new CardLayout();
  private JPanel boxlayout = new JPanel();
  private BoxLayout2 boxLayout21 = new BoxLayout2();
  private JPanel gridlayout = new JPanel();
  private GridLayout gridLayout1 = new GridLayout();
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JButton jButton3 = new JButton();
  private JButton jButton4 = new JButton();
  private JButton jButton5 = new JButton();
  private JButton jButton6 = new JButton();
  private JButton jButton7 = new JButton();
  private JButton jButton8 = new JButton();
  private JButton jButton9 = new JButton();
  private JButton jButton10 = new JButton();
  private JButton jButton11 = new JButton();
  private JButton jButton13 = new JButton();
  private JButton jButton12 = new JButton();
  private JButton jButton14 = new JButton();
  private JButton jButton15 = new JButton();
  private JButton jButton16 = new JButton();
  private JButton jButton18 = new JButton();
  private JButton jButton19 = new JButton();
  private JButton jButton20 = new JButton();
  private JButton jButton17 = new JButton();

  public FrameFactorielle()
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
    this.setSize(new Dimension(630, 770));
    this.setTitle( "Calcul Factorielle" );
    this.getContentPane().setLayout(null);
    borderlayout.setBackground(new Color(237, 237, 125));
    borderlayout.setLayout(borderLayout1);
    borderlayout.setBorder(BorderFactory.createTitledBorder("Border Layout"));
    borderlayout.setBounds(new Rectangle(0, 0, 630, 125));
    flowlayout.setBounds(new Rectangle(15, 150, 340, 290));
    flowlayout.setBackground(new Color(231, 57, 0));
    flowlayout.setBorder(BorderFactory.createTitledBorder("Flow Layout"));
    cardlayout.setBounds(new Rectangle(490, 155, 120, 170));
    cardlayout.setBackground(new Color(0, 82, 255));
    cardlayout.setLayout(cardLayout1);
    cardlayout.setBorder(BorderFactory.createTitledBorder("Card Layout"));
    boxlayout.setBounds(new Rectangle(380, 345, 185, 75));
    boxlayout.setBackground(Color.black);
    boxlayout.setLayout(boxLayout21);
    boxlayout.setBorder(BorderFactory.createTitledBorder("Box Layout"));
    gridlayout.setBackground(new Color(0, 214, 0));
    gridlayout.setLayout(gridLayout1);
    gridlayout.setBorder(BorderFactory.createTitledBorder("Grid Layout"));
    gridlayout.setBounds(new Rectangle(45, 470, 495, 250));
    gridLayout1.setColumns(8);
    gridLayout1.setRows(8);
    jButton1.setText("jButton1");
    jButton2.setText("jButton2");
    jButton3.setText("jButton3");
    jButton4.setText("jButton4");
    jButton5.setText("jButton5");
    jButton6.setText("jButton6");
    jButton7.setText("jButton7");
    jButton8.setText("jButton8");
    jButton9.setText("jButton9");
    jButton10.setText("jButton10");
    jButton11.setText("jButton11");
    jButton13.setText("jButton13");
    jButton12.setText("jButton12");
    jButton14.setText("jButton14");
    jButton15.setText("jButton15");
    jButton16.setText("jButton16");
    jButton18.setText("jButton18");
    jButton19.setText("jButton19");
    jButton20.setText("jButton20");
    jButton17.setText("jButton17");
    gridlayout.add(jButton14, null);
    gridlayout.add(jButton15, null);
    gridlayout.add(jButton12, null);
    gridlayout.add(jButton16, null);
    gridlayout.add(jButton18, null);
    gridlayout.add(jButton19, null);
    gridlayout.add(jButton17, null);
    gridlayout.add(jButton20, null);
    this.getContentPane().add(boxlayout, null);
    boxlayout.add(jButton13, null);
    cardlayout.add(jButton11, "jButton11");
    this.getContentPane().add(cardlayout, null);
    flowlayout.add(jButton6, null);
    flowlayout.add(jButton7, null);
    flowlayout.add(jButton8, null);
    flowlayout.add(jButton9, null);
    flowlayout.add(jButton10, null);
    this.getContentPane().add(flowlayout, null);
    borderlayout.add(jButton1, BorderLayout.EAST);
    borderlayout.add(jButton2, BorderLayout.NORTH);
    borderlayout.add(jButton3, BorderLayout.SOUTH);
    borderlayout.add(jButton4, BorderLayout.WEST);
    borderlayout.add(jButton5, BorderLayout.CENTER);
    this.getContentPane().add(borderlayout, BorderLayout.CENTER);
    this.getContentPane().add(gridlayout, null);
  }
}
