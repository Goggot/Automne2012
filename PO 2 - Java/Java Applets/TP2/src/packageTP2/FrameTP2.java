package packageTP2;

import java.awt.Dimension;

import javax.swing.JFrame;

public class FrameTP2
  extends JFrame
{
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
    this.setSize( new Dimension(400, 300) );
        this.setTitle("Parachutisme FinHeureuse");
    }
}
