package packageTP2;

import java.awt.Dimension;

import javax.swing.JPanel;

public class panelMagasin extends JPanel {
    public panelMagasin() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(527, 366));
    }
}
