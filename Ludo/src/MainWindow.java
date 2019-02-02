import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainWindow extends JFrame implements ActionListener{
	 JButton button1;
	 public MainWindow(){
		 		
	 			int buttonHeight = 45;
	 			int buttonWidth = 45;
		 		int height = buttonHeight * 13;
		 		int width = (buttonWidth * 11)+(buttonWidth/3);

		        int posx =0;
		        int posy =0;
		        int number = 1;
		        int nameField = 0;
		 		int tablica [] = {3,4, 8, 9,14,15,19,20,23,24,25,26,30,31,32,33,34,35,36,37,41,42,43,44,61,78,79,80,81,85,86,87,88,89,90,91,92,96,97,98,99,102,103,107,108,113,114,118,119};
		 		int YellowTablica [] = {0,1,7,8,20,32,33,34,35};
		 		int GreenTtablica [] = {4,5,6,10,12,13,15,18,25};
		 		int BlueTablica [] = {58,59,65,66,61,56,53,67,46};
		 		int RedTablica [] = {36,37,38,39,51,63,64,70,71};
		 		
		 		
		 		this.setSize(width,height);
		 		this.setLocationRelativeTo(null);
		 		this.setResizable(false);
		 		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 		this.setTitle("Chiñczyk");
		 		JPanel thePanel = new JPanel();

		 		
		         thePanel.setLayout(null);
		         

		         JButton butt[]=new JButton[72];
		         
		         for (int i =0; i<11; i++) {
		        	 
		        	 for (int y = 0; y<11; y++) {
		        	 
		        		 if(contains(tablica, number)){
		        		 } else {
		   		        	 butt[nameField] = new JButton(Integer.toString(nameField));
				        	 butt[nameField].setBounds(posx, posy, buttonWidth, buttonHeight);
				        	 butt[nameField].setEnabled(false);
				        	 butt[nameField].setFont(new Font("Arial", Font.PLAIN, 8));
				        	 thePanel.add(butt[nameField]);
				        	 nameField++;
		        	      }	 
		        		 posx = posx+buttonWidth;

		        	 number++;
		        	 }
		        	 posx = 0;
		        	 posy = posy+buttonHeight;
		         }
		         
		         
		         for (int i=0;i<9;i++) {
		        	 butt[YellowTablica[i]].setBackground(Ludo.Cyellow);
		        	 butt[BlueTablica[i]].setBackground(Ludo.Cblue);
		        	 butt[RedTablica[i]].setBackground(Ludo.Cred);
		        	 butt[GreenTtablica[i]].setBackground(Ludo.Cgreen);
		         }
		         
		  
		         
		         button1 = new JButton("Losuj");
		         button1.setBounds((width/2)-(buttonWidth)-((buttonWidth/6)), height - buttonHeight - 40, buttonWidth*2, buttonHeight);
		         
		         button1.addActionListener(this);

		         thePanel.add(button1);
		         this.add(thePanel);
		         
		         
		         
		         
		         this.setVisible(true);



		         
	 }
	 
	 
	 public static boolean contains(final int[] array, final int v) {

	        boolean result = false;

	        for(int i : array){
	            if(i == v){
	                result = true;
	                break;
	            }
	        }

	        return result;
	    }


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			dispose();
		}
		
	}

}