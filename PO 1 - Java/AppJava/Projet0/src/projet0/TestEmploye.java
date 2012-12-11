package projetTP0;

import java.awt.Rectangle;

import javax.swing.JFrame;
import java.awt.Dimension;
import oracle.jdeveloper.layout.XYLayout;
import javax.swing.JLabel;
import oracle.jdeveloper.layout.XYConstraints;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.*;

public class TestEmploye extends JFrame 
{
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JTextField jTextField1 = new JTextField();
  JTextField jTextField2 = new JTextField();
  JTextField jTextField3 = new JTextField();
  JTextField jTextField4 = new JTextField();
  JTextField jTextField5 = new JTextField();
  JButton jButton1 = new JButton();
  JLabel jLabel6 = new JLabel();
  JTextField jTextField6 = new JTextField();
  JLabel jLabel7 = new JLabel();
  JTextField jTextField7 = new JTextField();

  public TestEmploye()
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

  private void jbInit() throws Exception
  {
    this.getContentPane().setLayout(null);
    this.setSize(new Dimension(400, 300));
    this.setLocation(300, 300);
    this.setTitle("Calcul de salaires");
    jLabel1.setText("nom:");
        jLabel1.setBounds(new Rectangle(5, 35, 135, 25));
        jLabel2.setText("numéro d\'employé:");
        jLabel2.setBounds(new Rectangle(5, 60, 125, 30));
        jLabel3.setText("salaire horaire:");
        jLabel3.setBounds(new Rectangle(5, 85, 125, 35));
        jLabel4.setText("nombre d\'heures travaillées:");
        jLabel4.setBounds(new Rectangle(5, 115, 145, 30));
        jLabel5.setText("années d\'ancienneté:");
        jLabel5.setBounds(new Rectangle(5, 145, 155, 30));
        jTextField1.setBounds(new Rectangle(155, 30, 120, 25));
        jTextField2.setBounds(new Rectangle(155, 60, 120, 25));
        jTextField3.setBounds(new Rectangle(155, 90, 120, 25));
        jTextField4.setBounds(new Rectangle(155, 120, 120, 25));
        jTextField5.setBounds(new Rectangle(155, 150, 120, 25));
        jButton1.setText("Calcul du salaire et du nombre de jours de vacances");
        jButton1.setBounds(new Rectangle(10, 185, 360, 25));
        jButton1.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButton1_actionPerformed(e);
        }
      });
    jLabel6.setText("salaire:");
        jLabel6.setBounds(new Rectangle(20, 230, 40, 20));
        jTextField6.setBounds(new Rectangle(65, 230, 105, 20));
        jLabel7.setText("jours de vacances:");
        jLabel7.setBounds(new Rectangle(185, 230, 115, 20));
        jTextField7.setBounds(new Rectangle(285, 230, 75, 20));
        this.getContentPane().add(jTextField7, new XYConstraints(285, 230, 75, 20));
    this.getContentPane().add(jLabel7, new XYConstraints(186, 228, 114, 24));
    this.getContentPane().add(jTextField6, new XYConstraints(66, 228, 102, 24));
    this.getContentPane().add(jLabel6, new XYConstraints(18, 228, 42, 24));
    this.getContentPane().add(jButton1, new XYConstraints(12, 186, 360, 24));
    this.getContentPane().add(jTextField5, new XYConstraints(156, 150, 120, 24));
    this.getContentPane().add(jTextField4, new XYConstraints(156, 120, 120, 24));
    this.getContentPane().add(jTextField3, new XYConstraints(156, 90, 120, 24));
    this.getContentPane().add(jTextField2, new XYConstraints(156, 60, 120, 24));
    this.getContentPane().add(jTextField1, new XYConstraints(156, 30, 120, 24));
    this.getContentPane().add(jLabel5, new XYConstraints(6, 144, 156, 30));
    this.getContentPane().add(jLabel4, new XYConstraints(6, 114, 144, 30));
    this.getContentPane().add(jLabel3, new XYConstraints(6, 84, 126, 36));
    this.getContentPane().add(jLabel2, new XYConstraints(6, 60, 126, 30));
    this.getContentPane().add(jLabel1, new XYConstraints(6, 36, 132, 24));
  }



  void jButton1_actionPerformed(ActionEvent e)
  {
  DecimalFormat df = new DecimalFormat ( "0.00");
  Employe unEmploye = new Employe ( jTextField1.getText(), jTextField2.getText(), Double.parseDouble(jTextField3.getText()),
                                                            Double.parseDouble(jTextField4.getText()), Integer.parseInt(jTextField5.getText()));
  jTextField6.setText(df.format(unEmploye.salaireNetApresImpot()) + "$");
  jTextField7.setText(unEmploye.joursVacances() + " jours");
  }
 
  public static void main ( String [] args )
  {
  TestEmploye un = new TestEmploye();
  un.setVisible(true );
  un.setDefaultCloseOperation(EXIT_ON_CLOSE);

  }
  

  
}