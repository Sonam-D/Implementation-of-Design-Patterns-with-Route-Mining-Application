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

public class XLReport1 extends ReportBuilder {
	private Report report = new Report();
	
	
	@Override
	public void settitle() {
		report.title="Report1";
		
	}

	@Override
	public void setheader() {
		report.header.add("Validated address");
		
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
		System.out.println("R1");
		for(String s:Validated_address) {
		System.out.println(s);}
//		report.data=d1.data1;
		 XSSFWorkbook workbook = new XSSFWorkbook(); 
         
	        //Create a blank sheet
	        XSSFSheet sheet = workbook.createSheet("Address Validation");
	          
	        //This data needs to be written to report.data (Object[])
//	        Map<String, Object[]> report.data = new TreeMap<String, Object[]>();
	        report.data.put(1, new String[] {report.title});
	        
	        report.data.put(2, new String[] {report.header.get(0)});
	        
	        for (int i=3,j=0;i<s1.size()+3;i++) {
		    	  
	        	
	        	        report.data.put(i, new String[] {Validated_address.get(j)});
	        	
	        	      j++;
	        	      }

	        
	          
	        //Iterate over data and write to sheet
	        Set<Integer> keyset = report.data.keySet();
	        int rownum = 0;
	        for (Integer key : keyset)
	        {
	            Row row = sheet.createRow(rownum++);
	            Object [] objArr = report.data.get(key);
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
	            FileOutputStream out = new FileOutputStream(new File("Report1.xlsx"));
	            workbook.write(out);
	            out.close();
	            //System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
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
