
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
import java.io.*;

//import com.google.gson.JsonArray;

//import static java.awt.GraphicsDevice.WindowTranslucency.*;
//import java.awt.GraphicsDevice.WindowTranslucency;

public class Client extends JFrame implements ActionListener {

	//create the various GUI elements
	JLabel d1Label = new JLabel("Ascalon Catacombs");
	JLabel d2Label = new JLabel("Caudecus's Manor");
	JLabel d3Label = new JLabel("Twilight Arbor");
	JLabel d4Label = new JLabel("Sorrow's Embrace");
	JLabel d5Label = new JLabel("Citadel of Flame");
	JLabel d6Label = new JLabel("Honor of the Waves");
	JLabel d7Label = new JLabel("Crucible of Eternity");
	JLabel d8Label = new JLabel("The Ruined City of Arah");
	
	JLabel d1StatusLabel = new JLabel("YES");
	JLabel d2StatusLabel = new JLabel("YES");
	JLabel d3StatusLabel = new JLabel("YES");
	JLabel d4StatusLabel = new JLabel("YES");
	JLabel d5StatusLabel = new JLabel("YES");
	JLabel d6StatusLabel = new JLabel("YES");
	JLabel d7StatusLabel = new JLabel("YES");
	JLabel d8StatusLabel = new JLabel("YES");
	
	JButton refreshButton = new JButton("Refresh");
	JLabel selectServerLabel = new JLabel("Select Server");
	String [] serverNames = {"Anvil Rock", "Blackgate", "Borlis Pass", "Crystal Desert", "Darkhaven",
				 "Devona's Rest", "Dragonbrand", "Ehmry Bay", "Eredon Terrace",
				 "Ferguson's Crossing", "Fort Aspenwood", "Gate of Madness", 
				 "Henge of Denravi", "Isle of Janthir", "Jade Quarry", "Kaineng", "Maguuma",
				 "Northern Shiverpeaks", "Sanctum of Rail", "Sea of Sorrows", 
				 "Sorrow's Furnace", "Stormbluff Isle", "Tarnished Coast", "Yak's Bend"};

	JComboBox serverList = new JComboBox(serverNames);


	public static void main(String args[]){
		Client m = new Client();//create an instance of Client
		
	}
	

	public Client(){
		
		initializeBasicUI();
		sendHTTPRequest();
		//more todo client code here
	}

	public void sendHTTPRequest(){
	
	try{
		String baseURL = "https://api.guildwars2.com";
		URL worldURL = new URL(baseURL + "/v1/world_names.json?lang=en");
		URLConnection yc = worldURL.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		

		String inputLine;
		while ((inputLine = in.readLine()) != null){
			System.out.println(inputLine);
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


	public void initializeBasicUI(){

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = new Dimension();
		dim.setSize(tk.getScreenSize().getWidth()/2, tk.getScreenSize().getHeight()/2);
		

		//set up containers for the UI

		//label containers
		Container leftContainer = new Container();
		leftContainer.setLayout(new GridLayout(8,1));
		leftContainer.add(d1Label);
		leftContainer.add(d2Label);
		leftContainer.add(d3Label);
		leftContainer.add(d4Label);
		leftContainer.add(d5Label);
		leftContainer.add(d6Label);
		leftContainer.add(d7Label);
		leftContainer.add(d8Label);
		
		//status containers
		Container rightContainer = new Container();
		rightContainer.setLayout(new GridLayout(8,1));
		rightContainer.add(d1StatusLabel);
		rightContainer.add(d2StatusLabel);
		rightContainer.add(d3StatusLabel);
		rightContainer.add(d4StatusLabel);
		rightContainer.add(d5StatusLabel);
		rightContainer.add(d6StatusLabel);
		rightContainer.add(d7StatusLabel);
		rightContainer.add(d8StatusLabel);

		Container bottomContainer = new Container();
		bottomContainer.setLayout(new GridLayout(1,3));
		bottomContainer.add(selectServerLabel);
		bottomContainer.add(serverList);
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
	}

	public void actionPerformed(ActionEvent e){
		
		if (e.getSource() == refreshButton){
			d1StatusLabel.setText("Refresh works");
		}

	}//end actionListeners

	
}
