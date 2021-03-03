package G1.A1;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLReader extends FileReader
{
	public static ArrayList <String>s1 =new ArrayList<String>();
   
    	@Override
    	public ArrayList<String> parseFile(FileInputStream file) {
    	
    	try
        {
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //Get firstsheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) 
            {
            	Row row = rowIterator.next();
            	String addr= "";
            	//For each row, iterate through all the columns
            	Iterator<Cell> cellIterator = row.cellIterator();

            	while (cellIterator.hasNext()) 
            	{
            		Cell cell = cellIterator.next();
      
            		if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC) {//if the value read is an intger (eg : zipcode or street number)
            			int s1= (int) cell.getNumericCellValue();
            			String s3= s1 + " ";
            			addr=  addr+ s3;       			
            		}
            		else {
            			String s2= (cell.getStringCellValue() + " ");//if the value read is a string(eg street name)
            			addr= addr+ s2;
            		}
                      
                }
                System.out.println(" ");               
                s1.add(addr);    
            }
   
            file.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    	return s1;
    	}

}