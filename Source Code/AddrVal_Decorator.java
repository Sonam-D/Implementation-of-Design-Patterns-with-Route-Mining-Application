package G1.A1;

import com.smartystreets.api.ClientBuilder;
import com.smartystreets.api.Request;
import com.smartystreets.api.exceptions.SmartyException;                                                        
import com.smartystreets.api.us_street.*;

import okhttp3.OkHttpClient;

import java.io.IOException;   
public class AddrVal_Decorator extends Decorator {
Address address;
	

public AddrVal_Decorator(Address address) {
	this.address=address;
}
	public String get_address(input_Address a1) {

		 String authId = "20a965fb-f263-b096-0b9e-24930805b8ec";                                                 
	        String authToken = "wXfqa82PnsQ1BqsH3KyU";                                                              
	                                       
                                  
	       Client client = new ClientBuilder(authId, authToken).buildUsStreetApiClient();                          
   
	        Lookup lookup = new Lookup();                                                                           
	        lookup.setStreet((a1.street_number +" "+a1.street_name));
	   //     System.out.println("Street"+lookup.getStreet());
	        lookup.setStreet2(a1.optional_apartment_number);
	//        System.out.println("Street2"+lookup.getStreet2());
	        lookup.setCity(a1.city);
	  //      System.out.println("City"+lookup.getCity());
	        lookup.setState(a1.state);
	    //    System.out.println("state"+lookup.getState());
	        lookup.setZipCode(a1.zip);

                                                                    
	        lookup.setMaxCandidates(10);                                                                            
     //Make API CALL                                               
	        try {
				client.send(lookup);
			} catch (SmartyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}                       
	        
	     
	 //Response of API CAll is converted to string and returned  
	        		
	          String validated_address=lookup.getResult(0).getDeliveryLine1()+" "+lookup.getResult(0).getLastLine() ;                                                                        
                                

		return (address.get_address(a1)+" "+validated_address);
	}
}
