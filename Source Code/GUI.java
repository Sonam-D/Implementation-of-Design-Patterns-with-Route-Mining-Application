package G1.A1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {
//shud a1 b static
/*	Demo d1= new Demo();

	
	
ArrayList a3=	d1.getA1();
ArrayList<input_Address> s1= d1.getA1();
//init gui components here
//o/p the 
*/
	
	private JFrame frame;
	private JTextField txtInputAddress;
	private JTextField txtValidatedAddress;
	private JTextField txtCarrierRoute;
	private JTextField txtAddresses;
public void start_displaying() {
	
	GUI window = new GUI();
	window.frame.setVisible(true);}

public GUI() {
	final Demo d1= new Demo();
	
	System.out.println("Displaying");
	
	ArrayList<input_Address> s1= d1.getA1();
	
	
	
	final Director myDir= new Director();
	frame = new JFrame();
	frame.setBounds(100, 100, 1000, 547);
//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	JTextArea textArea = new JTextArea();
	textArea.setBounds(44, 73, 294, 240);
	frame.getContentPane().add(textArea);
	

	
	for(input_Address s2:s1) {
		String address= s2.street_number+" "+s2.street_name+" "+s2.optional_apartment_number+" "+s2.city+" "+s2.state+" "+ s2.zip;
		textArea.append(address+"\n");
	}
	
	txtInputAddress = new JTextField();
	txtInputAddress.setText("Input Address");
	txtInputAddress.setBounds(44, 32, 96, 19);
	frame.getContentPane().add(txtInputAddress);
//	txtInputAddress.setColumns(10);
	
	txtValidatedAddress = new JTextField();
	txtValidatedAddress.setText("Validated Address");
	txtValidatedAddress.setBounds(372, 32, 96, 19);
	frame.getContentPane().add(txtValidatedAddress);
	txtValidatedAddress.setColumns(10);
	
	final JTextArea textArea_1 = new JTextArea();
	textArea_1.setBounds(372, 73, 320, 240);
	frame.getContentPane().add(textArea_1);
	
	final JTextArea textArea_2 = new JTextArea();
	textArea_2.setBounds(740, 73, 70, 240);
	frame.getContentPane().add(textArea_2);
	
	final JTextArea textArea_3 = new JTextArea();
	textArea_3.setBounds(860, 73, 71, 240);
	frame.getContentPane().add(textArea_3);
	
	txtCarrierRoute = new JTextField();
	txtCarrierRoute.setText("Carrier Route");
	txtCarrierRoute.setBounds(740, 32, 96, 19);
	frame.getContentPane().add(txtCarrierRoute);
	txtCarrierRoute.setColumns(10);
	
	txtAddresses = new JTextField();
	txtAddresses.setText("Addresses");
	txtAddresses.setBounds(860, 32, 96, 19);
	frame.getContentPane().add(txtAddresses);
	txtAddresses.setColumns(10);
	
	JButton btnNewButton = new JButton("Generate Output");
	btnNewButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			ArrayList<String> Validated_address= d1.getOutput_1();
//		ArrayList<String> s1= data.getData2();
			 ArrayList<Carrier_count> Carrier_Route= d1.getOutput_2();
		for (String s2:Validated_address) {
			
		
		textArea_1.append(s2+"\n");
		}
		
		for (Carrier_count s2:Carrier_Route) {
			
			
			textArea_2.append(s2.address+"\n");
	//		textArea_3.append(s2.split(" ")[1]+"\n");
			String append = s2.count +" ";
			textArea_3.append(append+"\n");
			}
		}
	});
	btnNewButton.setBounds(44, 361, 170, 19);
	frame.getContentPane().add(btnNewButton);
	
	JButton btnGenerateReport = new JButton("Generate Report1");
	btnGenerateReport.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		      ReportBuilder report1= new XLReport1();
		       myDir.constructReport(report1);
		       Report completedreport= report1.get_report();
//		ArrayList<String> s1= data.getData2();
		
		}
	});
	btnGenerateReport.setBounds(44, 408, 170, 19);
	frame.getContentPane().add(btnGenerateReport);
	
	JButton btnGenerateReport_1 = new JButton("Generate Report2");
	btnGenerateReport_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		      ReportBuilder report2= new XLReport2();
		       myDir.constructReport(report2);
		       Report completedreport2= report2.get_report();
//		ArrayList<String> s1= data.getData2();
		
		}
	});
	btnGenerateReport_1.setBounds(44, 452, 170, 19);
	frame.getContentPane().add(btnGenerateReport_1);
}
	

}


