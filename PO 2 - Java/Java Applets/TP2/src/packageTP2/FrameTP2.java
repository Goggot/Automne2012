package packageTP2;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FrameTP2
  extends JFrame
{
    private JLabel jLabel1 = new JLabel();
    private JTextField champNumClt = new JTextField();
    private JPanel panelInfos = new JPanel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();

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
        jLabel1.setText("Numéro du client :");
        jLabel1.setBounds(new Rectangle(20, 20, 160, 30));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setFont(new Font("Dialog", 0, 14));
        champNumClt.setBounds(new Rectangle(195, 20, 225, 35));
        panelInfos.setBounds(new Rectangle(15, 70, 420, 235));
        panelInfos.setLayout(null);
        panelInfos.setBounds(new Rectangle(15, 70, 415, 230));
        jLabel2.setText("NOM");
        jLabel2.setBounds(new Rectangle(65, 20, 270, 50));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setFont(new Font("Dialog", 0, 16));
        jLabel3.setText("jLabel3");
        jLabel3.setBounds(new Rectangle(65, 110, 280, 90));
        panelInfos.add(jLabel3, null);
        panelInfos.add(jLabel2, null);
        this.getContentPane().add(panelInfos, null);
        this.getContentPane().add(panelInfos, null);
        this.getContentPane().add(champNumClt, null);
        this.getContentPane().add(jLabel1, null);
    }
}
