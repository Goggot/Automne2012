package annexe8c;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Frame1
  extends JFrame
{
  private JMenuBar jMenuBar1 = new JMenuBar();
  private JMenu jMenu1 = new JMenu();
  private JMenuItem jMenuItem1 = new JMenuItem();
  private JMenuItem jMenuItem2 = new JMenuItem();
  private JMenuItem jMenuItem3 = new JMenuItem();

  public Frame1()
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
    this.setSize( new Dimension(400, 300) );
    this.setJMenuBar(jMenuBar1);
    jMenu1.setText("Fichier");
    jMenuItem1.setText("Nouveau");
    jMenuItem2.setText("Cr�er");
    jMenuItem3.setText("Supprimer");
    jMenu1.add(jMenuItem1);
    jMenu1.add(jMenuItem2);
    jMenu1.add(jMenuItem3);
    jMenuBar1.add(jMenu1);
    
  }
}
