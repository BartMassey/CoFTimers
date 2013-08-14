
/*Copyright ©  2013 Vikram Ramesh
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*/
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

//import com.google.gson.JsonArray;
//import com.google.gson;


//import static java.awt.GraphicsDevice.WindowTranslucency.*;
//import java.awt.GraphicsDevice.WindowTranslucency;

public class Client extends JFrame implements ActionListener {

	final String baseURL = "https://api.guildwars2.com";
	//create the various GUI elements
	JLabel d1Label = new JLabel("Temple of Balthazar");
	JLabel d2Label = new JLabel("Temple of Dwayna");
	JLabel d3Label = new JLabel("Temple of Grenth");
	JLabel d4Label = new JLabel("Temple of Lyssa");
	JLabel d5Label = new JLabel("Temple of Melandru");
	JLabel d6Label = new JLabel("Citadel of Flame");

	
	JLabel d1StatusLabel = new JLabel("---");
	JLabel d2StatusLabel = new JLabel("---");
	JLabel d3StatusLabel = new JLabel("---");
	JLabel d4StatusLabel = new JLabel("---");
	JLabel d5StatusLabel = new JLabel("---");
	JLabel d6StatusLabel = new JLabel("---");

	JButton refreshButton = new JButton("Refresh");
	JLabel selectServerLabel = new JLabel("Select Server");
	JButton launchOverlayButton = new JButton("Launch Overlay");
	String [] serverNames = {"Anvil Rock", "Blackgate", "Borlis Pass", "Crystal Desert", "Darkhaven",
				 "Devona's Rest", "Dragonbrand", "Ehmry Bay", "Eredon Terrace",
				 "Ferguson's Crossing", "Fort Aspenwood", "Gate of Madness", 
				 "Henge of Denravi", "Isle of Janthir", "Jade Quarry", "Kaineng", "Maguuma",
				 "Northern Shiverpeaks", "Sanctum of Rall", "Sea of Sorrows", 
				 "Sorrow's Furnace", "Stormbluff Isle", "Tarnished Coast", "Yak's Bend"};

	JComboBox serverList = new JComboBox(serverNames);
	
	Map<String, Integer> serverCodes = new HashMap<String,Integer>();


	public static void main(String args[]){
		Client m = new Client();//create an instance of Client
		
	}
	

	public Client(){
		
		initializeBasicUI();
		sendHTTPRequest();
		refreshAll(1001);
	
		//more todo client code here
	}

	//use this method to initially load the world/server/event ids TODO
	public void sendHTTPRequest(){
		
		//---------------------------------FOR DEMO----------------------
		//Manually map the world codes. Make it automated later once json parsing is properly integrated
		serverCodes.put("Anvil Rock", 1001);
		serverCodes.put("Blackgate", 1019);
		serverCodes.put("Borlis Pass", 1002);
		serverCodes.put("Crystal Desert", 1014);
		serverCodes.put("Darkhaven", 1012);
		serverCodes.put("Devona's Rest", 1023);
		serverCodes.put("Dragonbrand", 1021);
		serverCodes.put("Ehmry Bay", 1010);
		serverCodes.put("Eredon Terrace", 1024);
		serverCodes.put("Ferguson's Crossing", 1020);
		serverCodes.put("Fort Aspenwood", 1009);
		serverCodes.put("Gate of Madness", 1007);
		serverCodes.put("Henge of Denravi", 1004);
		serverCodes.put("Isle of Janthir", 1015);
		serverCodes.put("Jade Quarry", 1008);
		serverCodes.put("Kaineng", 1022);
		serverCodes.put("Maguuma", 1005);
		serverCodes.put("Northern Shiverpeaks", 1018);
		serverCodes.put("Sanctum of Rall", 1013);
		serverCodes.put("Sea of Sorrows", 1016);
		serverCodes.put("Sorrow's Furnace", 1006);
		serverCodes.put("Stormbluff Isle", 1011);
		serverCodes.put("Tarnished Coast", 1017);
		serverCodes.put("Yak's Bend", 1003);
		
		
		//---------------------------------------------------------------
		
		
	
	try{
		
		URL worldURL = new URL(baseURL + "/v1/world_names.json?lang=en");
		URLConnection yc = worldURL.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		

		String inputLine;
		while ((inputLine = in.readLine()) != null){
			//System.out.println(inputLine);
		}
		in.close();

		//JSONObjects and JSONArrays
		//added the google gson library, so begin work with that
		//https://code.google.com/p/google-gson/ 
		//figure out how to properly access the api contents in the program
		//why isn't the input statement working

	   }catch (Exception e){
		System.exit(0);
	   }
	}

	//every time program refreshes to repull data, use this
	public void refresh(int worldID, int mapID, String eventID, JLabel statusLabel){

		//anvil rock id: 1001
		//fireheart rise id: 22
		//cof event prereq id: A1182080-2599-4ACC-918E-A3275610602B

		//retrieve /events using the information from above. This information is obtained in the
		//getHTPPRequest method
		String eventString = "";
		try{
			URL worldURL = new URL(baseURL + "/v1/events.json?world_id=" + worldID + "&map_id=" + mapID);
			URLConnection yc = worldURL.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

			String resultString;
			while ((resultString = in.readLine()) != null){
				//System.out.println(resultString);
				eventString += resultString;
			}
			in.close();
		}catch(Exception e){
			System.exit(0);
		}
		

		
		//System.out.println(eventString);
		//System.out.println(eventString.charAt(eventString.indexOf("A1182080-2599-4ACC-918E-A3275610602B") + 47));

		//check to make sure eventID is correct
		if (eventString.indexOf(eventID) == -1){
			System.out.println("Event ID is not valid");
		}else{

			char status = eventString.charAt(eventString.indexOf(eventID) + 47);
			//System.out.println(status);

			if (status == 'S'){
				statusLabel.setText("Open");
			}else if(status == 'A'){
				statusLabel.setText("Event Up");
			}else{
				statusLabel.setText("Closed");
			}
		}
	}


	public void initializeBasicUI(){

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = new Dimension();
		dim.setSize(tk.getScreenSize().getWidth()/2, tk.getScreenSize().getHeight()/2);
		

		//set up containers for the UI

		//label containers
		Container leftContainer = new Container();
		leftContainer.setLayout(new GridLayout(6,1));
		leftContainer.add(d1Label);
		leftContainer.add(d2Label);
		leftContainer.add(d3Label);
		leftContainer.add(d4Label);
		leftContainer.add(d5Label);
		leftContainer.add(d6Label);

		
		//status containers
		Container rightContainer = new Container();
		rightContainer.setLayout(new GridLayout(6,1));
		rightContainer.add(d1StatusLabel);
		rightContainer.add(d2StatusLabel);
		rightContainer.add(d3StatusLabel);
		rightContainer.add(d4StatusLabel);
		rightContainer.add(d5StatusLabel);
		rightContainer.add(d6StatusLabel);


		Container bottomContainer = new Container();
		bottomContainer.setLayout(new GridLayout(1,4));
		bottomContainer.add(selectServerLabel);
		bottomContainer.add(serverList);
		bottomContainer.add(launchOverlayButton);
		bottomContainer.add(refreshButton);

		
		this.add(bottomContainer, BorderLayout.SOUTH);
		this.add(leftContainer, BorderLayout.WEST);
		this.add(rightContainer, BorderLayout.EAST);

		setPreferredSize(dim);
		pack();
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		
		//add overlay functionality
		//setBackground(new Color(0,0,0,0));
		//setUndecorated(true);
		//setAlwaysOnTop(true);
		
		//getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);

		//setOpacity(0);

		//add the action listeners



		refreshButton.addActionListener((ActionListener) this);
		launchOverlayButton.addActionListener((ActionListener) this);
		serverList.addActionListener((ActionListener) this);
	}

	public void actionPerformed(ActionEvent e){
		
		if (e.getSource() == serverList){
			//System.out.println(serverList.getSelectedItem());
			//if (serverList.getSelectedItem().equals("Anvil Rock"));
			//System.out.println(mapCodes.get(serverList.getSelectedItem()));
			int serverID = serverCodes.get(serverList.getSelectedItem());
			refreshAll(serverID);
	
			
		}
		
		if (e.getSource() == refreshButton){
			d1StatusLabel.setText("Refresh works");
			int serverID = serverCodes.get(serverList.getSelectedItem());
			refreshAll(serverID);
		}

	}//end actionListeners

	//refresh all of the temple timers
	public void refreshAll(int serverID){
	
		refresh(serverID, 51, "2555EFCB-2927-4589-AB61-1957D9CC70C8", d1StatusLabel);//balthazar
		refresh(serverID, 65, "6A6FD312-E75C-4ABF-8EA1-7AE31E469ABA", d2StatusLabel);//dwayna
		refresh(serverID, 62, "99254BA6-F5AE-4B07-91F1-61A9E7C51A51", d3StatusLabel);//grenth
		refresh(serverID, 65, "0372874E-59B7-4A8F-B535-2CF57B8E67E4", d4StatusLabel);//lyssa
		refresh(serverID, 62, "A5B5C2AF-22B1-4619-884D-F231A0EE0877", d5StatusLabel);//melandru
		refresh(serverID, 22, "A1182080-2599-4ACC-918E-A3275610602B", d6StatusLabel);//cof
	}
	
}
