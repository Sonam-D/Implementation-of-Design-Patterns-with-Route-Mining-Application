package G1.A1;

import java.io.FileOutputStream;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class ReportBuilder {

	public abstract void settitle();

	public abstract void setheader();
	
//	public abstract void getcontent();//should this method be incl in abstract?
	public abstract void setcontent();
	
	public abstract Report get_report();

	
}
