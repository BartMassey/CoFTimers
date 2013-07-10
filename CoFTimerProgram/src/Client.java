
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

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Client extends JFrame {

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
	



	public static void main(String args[]){
		Client m = new Client();//create an instance of Client
	}
	

	public Client(){
		initializeBasicUI();
	}

	public void initializeBasicUI(){

		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = new Dimension();
		dim.setSize(tk.getScreenSize().getWidth()/2, tk.getScreenSize().getHeight()/2);
		


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
		bottomContainer.setLayout(new GridLayout(1,1));
		bottomContainer.add(refreshButton);

		
		this.add(bottomContainer, BorderLayout.SOUTH);
		this.add(leftContainer, BorderLayout.WEST);
		this.add(rightContainer, BorderLayout.EAST);
		






		setPreferredSize(dim);
		pack();
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
}
