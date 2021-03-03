package G1.A1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public abstract class FileReader {
	ArrayList<input_Address> a1=new ArrayList<input_Address>(); 
	public ArrayList<input_Address> processFile(FileInputStream file) {//shud declare as final?
	
	ArrayList<String> s2= parseFile(file);
	ArrayList<input_Address> a1= create_ip_object(s2);
	 closefile(file);
	return a1;
	 
	
}
public abstract ArrayList<String> parseFile(FileInputStream file);

public final ArrayList<input_Address> create_ip_object(ArrayList<String> s2) {
	
	for (String i:s2) {
		input_Address addr= new input_Address();

		addr.street_number=i.split(" ")[0];
	//	System.out.println(addr.street_number);
		addr.street_name=i.split(" ")[1]+" "+i.split(" ")[2];
//		System.out.println(addr.street_name);
		if(i.split(" ")[3].contains("Apt")){
			
		addr.optional_apartment_number=i.split(" ")[3]+" "+i.split(" ")[4];
		addr.city=i.split(" ")[5];
		addr.state=i.split(" ")[6];
		addr.zip=i.split(" ")[7];
		}
		else {addr.optional_apartment_number=" ";
		addr.city=i.split(" ")[3];
		addr.state=i.split(" ")[4];
		addr.zip=i.split(" ")[5];}
		
		a1.add(addr);
	}
	return a1;
}


public void closefile(FileInputStream file) {
	try {
		file.close();
	} catch (IOException e) {
	
		e.printStackTrace();
	}
}




}