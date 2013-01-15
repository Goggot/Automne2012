package javatoexcel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.io.OutputStream;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class p1
{
  public static void main(String[] args)
  {
      // Exemple 1 : lire d'un fichier Excel 
      
      //A- créer un fichier excel , y mettre des données textuelles et numériques
    try
    {
      InputStream inp = new FileInputStream("javaToExcel.xlsx");
      XSSFWorkbook classeur = (XSSFWorkbook )  WorkbookFactory.create(inp);
      XSSFSheet feuille = classeur.getSheetAt(0); // première feuille 
      XSSFRow rangee = feuille.getRow(3); // attention rangee commencent à 0 
      XSSFCell celluleNom = rangee.getCell(0);
      System.out.println(celluleNom.getStringCellValue());
      XSSFCell celluleNote = rangee.getCell(1);
      System.out.println(celluleNote.getNumericCellValue());
        
        // modifier le contenu d'une cellule existante 
        
      celluleNote.setCellValue(80);
      System.out.println(celluleNote.getNumericCellValue());
        
        // modifier le contenu de cellules vides : ajouter Jonathan Tourangeau 87
        XSSFRow nlleRangee = feuille.createRow ( 7); // 7eme rangee
        XSSFCell nlleCellule1 = nlleRangee.createCell(0);
        nlleCellule1.setCellValue("Jonathan Tourangeau");
        XSSFCell nlleCellule2 = nlleRangee.createCell(1);
        nlleCellule2.setCellValue(87);
        
        
        // utiliser la fonction MOYENNE d'Excel 
       /* XSSFRow nlleRangeeMoy = feuille.createRow ( 8); // 7eme rangee
        XSSFCell nlleCelluleMoy = nlleRangeeMoy.createCell(1);
        nlleCelluleMoy.setCellFormula("AVERAGE(B4:B8)");*/
        //utiliser un flux d'écriture pour enregistrer les changements 
      OutputStream out = new FileOutputStream("javaToExcel.xlsx");
      classeur.write(out);
      out.close();
      inp.close();
    }
    catch ( Exception e)
    {
      e.printStackTrace();
    }
  }
}
