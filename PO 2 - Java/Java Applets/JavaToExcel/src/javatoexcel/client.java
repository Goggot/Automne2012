package javatoexcel;

import com.sun.rowset.internal.Row;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class client
{
  public static void main(String[] args)
  {
    try
    {
      InputStream inp = new FileInputStream("Client.xlsx");
      XSSFWorkbook wb = (XSSFWorkbook )  WorkbookFactory.create(inp);
      
      Sheet feuille = wb.createSheet("Nouvel onglet");
      
      Row row = feuille.createRow(0);
      
      Cell cell = row.createCell(0);
      cell.setCellValue(1);
      
      row.createCell(1).setCellValue(1.2);
      row.createCell(2).setCellValue("coucou");
      row.createCell(3).setCellValue(true);
      inp.close();
      
      wb.setSheetOrder("Nouvel onglet", 0);
      
      FileOutputStream fileOut = new FileOutputStream("Client.xlsx");
      wb.write(fileOut);
      fileOut.close();
    }
    catch(Exception ee)
    {
      ee.printStackTrace();
    }
  }
}
