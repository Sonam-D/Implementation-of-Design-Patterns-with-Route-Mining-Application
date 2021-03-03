package G1.A1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;



import org.codehaus.jackson.map.ObjectMapper;
//import org.codehaus.jackson.type.TypeReference;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Demo {
	//create a static copy of Input address, Validated address, and  Carrier Route Count ArrayLists so that 
	//it can be accessed by other classes for Report Generation and GUI purposes.
	public static  ArrayList<input_Address> input=new ArrayList<input_Address>();
	public  ArrayList<input_Address> getA1() {
		return input;
	}
	public static void setA1(ArrayList<input_Address> a1) {
		input = a1;
	}
	
	public static  ArrayList<String> Output_AddrVal=new ArrayList<String>();
	
	public  ArrayList<String> getOutput_1() {
		return Output_AddrVal;
	}
	public static void setOutput_1(ArrayList<String> Output_1) {
		Output_AddrVal=Output_1;
		
	}
	public static  ArrayList<Carrier_count> Output_Carrier=new ArrayList<Carrier_count>();
	public  ArrayList<Carrier_count> getOutput_2() {
		return Output_Carrier;
	}
	public static void setOutput_2(ArrayList<Carrier_count> Output_2) {
		Output_Carrier=Output_2;
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {	
	
		ArrayList <String>s2 =new ArrayList<String>();
		ArrayList<input_Address> a1=new ArrayList<input_Address>();//can 
		ArrayList<String> Validated_address =new ArrayList<String>();
		ArrayList<String> num_address=new ArrayList<String>();
		
		//Read the input file.This is implemented using Template method design pattern
		 FileReader r1= new XLReader();
		 FileInputStream file = new FileInputStream(new File("Address.xlsx"));
		 a1=r1.processFile(file);
		 setA1(a1);
		 
		 //Once the input file is read it returns an arraylist of address. It is ArrayList<input_Address>a1.
		 //for each address in a1,the decorator design pattern is implemented.
		
		 
		 for (input_Address ip_addr:a1) {
			Address a4= new Concrete_Address();
		//	System.out.println(a4.get_address(ip_addr));
			//decorate it
			
			a4= new AddrVal_Decorator(a4);
			String AddrVal_output=(a4.get_address(ip_addr));
			Validated_address.add(AddrVal_output);// validated address without carrier route
			
			a4= new CarrierRoute_Decorator(a4);
			String decorator_return=a4.get_address(ip_addr);// validated address with carrier route appended
			String[] spaced_decorator_return= decorator_return.split(" ");
			String decorator_output=spaced_decorator_return[spaced_decorator_return.length -1];
	//		System.out.println("Dec"+decorator_output);
			num_address.add(decorator_output);//with carrier 
					
			//the string returned by the above function has to be appended to the string array called <Validated_address><num_address>
			
		}
		
		//populate the ArrayList<String>Output_AddrVal and ArrayList<Carrier_count>Output_Carrier. These will be used by the Builder Pattern 
		 //to create reports
		setOutput_1(Validated_address);
/*		for(String s3:Validated_address) {
			System.out.println(s3);
		}*/
		
		for(String str:num_address) {
			Carrier_count c1= new Carrier_count(str,0);
			Output_Carrier.add(c1);
		}
		int i=0,j=0;
		for(i=0;i<Output_Carrier.size();i++) {
			System.out.println(Output_Carrier.get(i).address);
			System.out.println(Output_Carrier.get(i).count);
			
		}for(i=0;i<Output_Carrier.size();i++) {
//			System.out.println(num1.get(i).carriers);
			String srt= (Output_Carrier.get(i).address);
			for(j=0;j<Output_Carrier.size();j++) {
				String srt1= (Output_Carrier.get(j).address);
				if (srt.equals(srt1)) {
					Output_Carrier.get(j).count++;
				}
			}
			
		}

		
	//	to turn on the gui
		GUI ap1= new GUI();
		ap1.start_displaying();

	       

	}
}

