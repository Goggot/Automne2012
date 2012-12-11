package testjoptionpane;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Class1
{
  public static void main(String[] args)
  {
    //JOptionPane.showMessageDialog(null, "test");
    int reponse = JOptionPane.showConfirmDialog(null, "Certain ?", "Hockey", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("hockey.jpg"));
    if (reponse == JOptionPane.YES_OPTION)
      JOptionPane.showMessageDialog(null, "Reponse : OUI");
  }
}
