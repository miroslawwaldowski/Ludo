import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;



@SuppressWarnings("serial")
public class Ludo extends JFrame implements ActionListener{
	
	Player[] player = new Player[4];
	
	public static Color Cblue = new Color(30,144,255);
	public static Color Cred = new Color(255,99,71);
	public static Color Cyellow = new Color(255,215,0);
	public static Color Cgreen = new Color(50,250,50);
	
	Dice dice = new Dice();
	
	JFrame StartMenu, MainWindow;	
	JButton buttonStart, buttonClose, buttonRoll;
	JButton butt[]=new JButton[72];
	JLabel score;
	
	int activePlayer, amountPlayers;
	



	public Ludo() {
		
			
		for (int i=0;i<4;i++) {
			player[i]=new Player();
			player[i].setNumber(i);

			
			switch(i) {
			case 0 : player[i].setColor(Cblue);
					 player[i].pawn[0].setHomePosition(58);
					 player[i].pawn[1].setHomePosition(59);
					 player[i].pawn[2].setHomePosition(65);
					 player[i].pawn[3].setHomePosition(66);
			break;
			case 1 : player[i].setColor(Cred);
			 		 player[i].pawn[0].setHomePosition(63);
			 		 player[i].pawn[1].setHomePosition(64);
			 		 player[i].pawn[2].setHomePosition(70);
			 		 player[i].pawn[3].setHomePosition(71);
			break;
			case 2 : player[i].setColor(Cyellow);
	 		 		 player[i].pawn[0].setHomePosition(0);
	 		 		 player[i].pawn[1].setHomePosition(1);
	 		 		 player[i].pawn[2].setHomePosition(7);
	 		 		 player[i].pawn[3].setHomePosition(8);
			break;
			case 3 : player[i].setColor(Cgreen);
	 		 		 player[i].pawn[0].setHomePosition(5);
	 		 		 player[i].pawn[1].setHomePosition(6);
	 		 		 player[i].pawn[2].setHomePosition(12);
	 		 		 player[i].pawn[3].setHomePosition(13);
			break;
			}
			player[i].setPawnIcon();
		}
		StartMenu = new StartMenu();

	};
	
	
	
	
	public static void main(String[] args) {
		
		Ludo game=new Ludo();
		game.setTitle("Chiñczyk - Wybór gry");
		
	}
	

	
	
	class StartMenu extends JFrame{
	
		public StartMenu() {
			
		
		
 		int height = 300;
 		int width = 450;
 		
 		this.setSize(width,height);
 		this.setLocationRelativeTo(null);
 		this.setResizable(false);
 		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
 		JPanel thePanel = new JPanel();
 		thePanel.setLayout(null);
        
 		JLabel number = new JLabel("Nr");
 		JLabel typePlayer = new JLabel("Rodzaj gracza");
 		JLabel name = new JLabel("Imiê gracza");
 		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
 		
 		number.setBorder(border);
 		typePlayer.setBorder(border);
 		name.setBorder(border);
 		
 		number.setBounds(25, 20, 25, 20);
 		typePlayer.setBounds(60, 20, 130, 20);
 		name.setBounds(200, 20, 210, 20);
 		
 		number.setHorizontalAlignment(JLabel.CENTER);
 		typePlayer.setHorizontalAlignment(JLabel.CENTER);
 		name.setHorizontalAlignment(JLabel.CENTER);
 	
 		
 		thePanel.add(number);
 		thePanel.add(typePlayer);
 		thePanel.add(name);
 		
 		for (int i=0;i<4;i++) 
 		{
 			player[i].getNumberPlayer().setHorizontalAlignment(JLabel.CENTER);
 			player[i].getNumberPlayer().setBounds(25, 50+(i*30), 25, 21);
 			thePanel.add(player[i].getNumberPlayer());
 			
 			player[i].getTypPlayer().setBounds(60, 50+(i*30), 130, 20);
 			thePanel.add(player[i].getTypPlayer());
 			
 			player[i].getNamePlayer().setBounds(200, 50+(i*30), 210, 23);
 			thePanel.add(player[i].getNamePlayer());
 			
 			player[i].getTypPlayer().addItemListener(new typPlayerListener());
 		}
 		
 		buttonStart = new JButton("Start");
 		buttonClose = new JButton("Zamknij");
 		

 		
 		buttonStart.setBounds(50, 190, 160, 40);
 		buttonClose.setBounds(230, 190, 160, 40);
 		
 		buttonStart.addActionListener(new buttonStartMenuListener());
 		buttonClose.addActionListener(new buttonStartMenuListener());
 		
 		
 		
 		thePanel.add(buttonStart);
 		thePanel.add(buttonClose);
 		
 		
 		this.add(thePanel);        
        this.setVisible(true);
		}
	}
	
	class MainWindow extends JFrame{
	
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
 		JPanel thePanel2 = new JPanel();
 		thePanel2.setLayout(null);
       
         for (int i =0; i<11; i++) {
        	 
        	 for (int y = 0; y<11; y++) {
        	 
        		 if(contains(tablica, number)){
        		 } else {
   		        	 butt[nameField] = new JButton(/*Integer.toString(nameField)*/);
		        	 butt[nameField].setBounds(posx, posy, buttonWidth, buttonHeight);
		        	 butt[nameField].setEnabled(false);
		        	 butt[nameField].setBackground(Color.white);
		        	 butt[nameField].setFont(new Font("Arial", Font.PLAIN, 8));
		        	 thePanel2.add(butt[nameField]);
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
         
         for (int i=0;i<4;i++) {
        	 if (player[i].getActive()) {
        		 for (int j=0;j<4;j++) {
 					 butt[player[i].pawn[j].getPosition()].setIcon(player[i].getPawnIcon());
         			 butt[player[i].pawn[j].getPosition()].setEnabled(true);
				 }
        	  }
 			}
 		
       
         buttonRoll = new JButton("Rzuæ kostk¹");
         buttonRoll.setBounds((width/2)-(buttonWidth*2)-((buttonWidth/6)), height - buttonHeight - 40, buttonWidth*3, buttonHeight);
         buttonRoll.addActionListener(new buttonMainWindowListener());
         score = new JLabel();
         score.setBounds((width/2)+(buttonWidth)+((buttonWidth/6)), height - buttonHeight - 40, buttonWidth*2, buttonHeight);

         thePanel2.add(buttonRoll);
         thePanel2.add(score);
         this.add(thePanel2);         
         this.setVisible(true);
         
}
		private boolean contains(int[] tablica, int number) {
			boolean result = false;
	        for(int i : tablica){
	            if(i == number){
	                result = true;
	                break;
	            }
	        }
	        return result;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
	public void setGame() {

		for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++) {
				player[i].pawn[j].setPosition(player[i].pawn[j].getHomePosition());
			}
		}
		
		StartMenu.dispose();

		MainWindow = new MainWindow();
		

	}
		



	class typPlayerListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			for (int i=0;i<4;i++) {
				if (player[i].getTypPlayer().getSelectedIndex()==3) {
					player[i].setActive(false);
					player[i].getNamePlayer().setEditable(false);
				} else {
					player[i].setActive(true);
					player[i].getNamePlayer().setEditable(true);
					
				}
			}
			
		}
	}


	class buttonStartMenuListener implements ActionListener {



		@Override
		public void actionPerformed(ActionEvent e) {
			 
			if (e.getSource() == buttonClose) {
					System.exit(EXIT_ON_CLOSE);		
			}else if (e.getSource() == buttonStart){
				
			for (int i=0;i<4;i++) {
					 
			player[i].setTypPlayerSet(player[i].getTypPlayer().getSelectedIndex());
			player[i].setName(player[i].getNamePlayer().getText());
			
			if (player[i].getName().equals("")){
				if (player[i].getTypPlayerSet()==0) {
					player[i].setName("Gracz "+Integer.toString(i+1));
				} else if(player[i].getTypPlayerSet()==1 || player[i].getTypPlayerSet()==2) {
					player[i].setName("Komputer "+Integer.toString(i+1));
				} else {
						//noting
					}
				}
			System.out.println(player[i].getName());
			System.out.println(player[i].getActive());
			}
		
			System.out.println("start");
			
			setGame();
			} else {
				//nothing
			}
		}
	}
	
	class buttonMainWindowListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonRoll) {
				dice.throwDice();
				int scoreDice = (int)dice.getScore();
				score.setText(Integer.toString(scoreDice));
				if (butt[11].isEnabled()) {
				butt[11].setEnabled(false);
				}else {
				butt[11].setEnabled(true);	
				}
			}
			
		}
		
	}
}

