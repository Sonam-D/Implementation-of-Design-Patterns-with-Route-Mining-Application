package G1.A1;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Report {
	public  String title;
	public  ArrayList<String> header = new ArrayList<String>();
	public Map<Integer, String[]> data=new TreeMap<Integer, String[]>();
	
	
}
