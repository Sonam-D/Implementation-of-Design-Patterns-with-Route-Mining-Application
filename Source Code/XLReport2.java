package G1.A1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLReport2 extends ReportBuilder {
	private Report report = new Report();
	
	
	@Override
	public void settitle() {
		report.title="Report2";
		
	}

	@Override
	public void setheader() {
		report.header.add("Carrier Route");
		report.header.add("Num. of Address");
		
	}
	
	

	@Override
	public void setcontent() {
		Demo demo1= new Demo();
		ArrayList<input_Address> s1= demo1.getA1();
		ArrayList<String> Validated_address= demo1.getOutput_1();
		ArrayList<Carrier_count> Carrier_Route= demo1.getOutput_2();
	//	Data d1= new Data();
//		d1.setData();
//		ArrayList<String> s1= demo1.getData();// TODO Auto-generated method stub
		
//		report.data=d1.data1;
		 XSSFWorkbook workbook = new XSSFWorkbook(); 
         
	        //Create a blank sheet
	        XSSFSheet sheet = workbook.createSheet("Carrier Routes");
	          
	        //This data needs to be written to - report.data (Object[])
//	        Map<String, Object[]> report.data = new TreeMap<String, Object[]>();
	        report.data.put(1, new String[] {report.title});
	        
	        report.data.put(2, new String[] {report.header.get(0),report.header.get(1)});
	        
	        for (int i=3,j=0;i<Carrier_Route.size()+3;i++) {
		    	  
	        	
	        	        report.data.put(i, new String[] {Carrier_Route.get(j).address,Carrier_Route.get(j).count+" "});
	        	
	        	      j++;
	        	      }

	        //Iterate over data and write to sheet
	        Set<Integer> keyset = report.data.keySet();
	        int rownum = 0;
	        for (Integer key : keyset)
	        {
	            Row row = sheet.createRow(rownum++);
	            Object [] objArr = report.data.get(key);//repl with String[]
	            int cellnum = 0;
	            for (Object obj : objArr)
	            {
	               Cell cell = row.createCell(cellnum++);
	               if(obj instanceof String)
	                    cell.setCellValue((String)obj);
	                else if(obj instanceof Integer)
	                    cell.setCellValue((Integer)obj);
	            }
	        }
	        try
	        {//try put this in show method
	            //Write the workbook in file system
	            FileOutputStream out = new FileOutputStream(new File("Report2.xlsx"));
	            workbook.write(out);
	            out.close();
	            System.out.println("Report2.xlsx written successfully on disk.");
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	}
	

      
	@Override
	public Report get_report() {
		
		
		return report;
	}
	
	
	

}
