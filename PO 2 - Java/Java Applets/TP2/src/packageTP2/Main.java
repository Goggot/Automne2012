package packageTP2;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import java.io.FileInputStream;
import java.io.InputStream;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {
    public static void main(String[] args) {
        FrameTP2 AjoutClient = new FrameTP2();
        Client client;
        EnsembleClients tableClient = new EnsembleClients();
        GregorianCalendar date = new GregorianCalendar();

        try {
            InputStream inp = new FileInputStream("Clients.xlsx");
            XSSFWorkbook classeur = (XSSFWorkbook)WorkbookFactory.create(inp);
            XSSFSheet feuille = classeur.getSheetAt(0);
            
            for (int i=1; i <= feuille.getPhysicalNumberOfRows(); i++) {
                XSSFRow rangee = feuille.getRow(i);
            
            // Extraction des données
                int numCarte = (int)rangee.getCell(0).getNumericCellValue();
                String nom = rangee.getCell(1).getStringCellValue();
                int nbPtsBonus = (int)rangee.getCell(2).getNumericCellValue();
                String coordonnees = rangee.getCell(3).getStringCellValue();
                String Sdate[] = rangee.getCell(4).getStringCellValue().split("-");                
                date.set(Integer.parseInt(Sdate[2]), Integer.parseInt(Sdate[1]), Integer.parseInt(Sdate[0]));
                System.out.println(date.getTime());
                
            // Création du client
                client = new Client(String.valueOf(numCarte), nom, coordonnees, date);
                client.setNbPointsBonis(nbPtsBonus);
                
            // Ajout du client dans la Hashtable
                tableClient.ajouterClient(client);
            }
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
        //UIManager.setLookAndFeel(new WindowsLookAndFeel());
        //SwingUtilities.updateComponentTreeUI(AjoutClient);

        AjoutClient.setVisible(true);
        AjoutClient.setLocationRelativeTo(null);
        AjoutClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
