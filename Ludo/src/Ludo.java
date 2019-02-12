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
public class Ludo extends JFrame {
	
	Player[] player = new Player[4];
	
	public static Color Cblue = new Color(30,144,255);
	public static Color Cred = new Color(255,99,71);
	public static Color Cyellow = new Color(255,215,0);
	public static Color Cgreen = new Color(50,250,50);
	
	Dice dice = new Dice();
	Board board = new Board();
	
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
			case 0 :player[i].setColor(Cyellow);
	 		 		player[i].setStartPoisition(20);
	 		 		player[i].setEndPoisition(35);
	 		 		player[i].pawn[0].setHomePosition(0);
	 		 		player[i].pawn[1].setHomePosition(1);
	 		 		player[i].pawn[2].setHomePosition(7);
	 		 		player[i].pawn[3].setHomePosition(8);
			break;
			case 1 :player[i].setColor(Cgreen);
	 		 		player[i].setStartPoisition(4);
	 		 		player[i].setEndPoisition(25);
	 		 		player[i].pawn[0].setHomePosition(5);
	 		 		player[i].pawn[1].setHomePosition(6);
	 		 		player[i].pawn[2].setHomePosition(12);
	 		 		player[i].pawn[3].setHomePosition(13);
			break;
			case 2 :player[i].setColor(Cred);
			 		player[i].setStartPoisition(51);
			 		player[i].setEndPoisition(36);
			 		player[i].pawn[0].setHomePosition(63);
			 		player[i].pawn[1].setHomePosition(64);
			 		player[i].pawn[2].setHomePosition(70);
			 		player[i].pawn[3].setHomePosition(71);
			break;
			case 3 :player[i].setColor(Cblue);
					player[i].setStartPoisition(67);
					player[i].setEndPoisition(46);
					player[i].pawn[0].setHomePosition(58);
					player[i].pawn[1].setHomePosition(59);
					player[i].pawn[2].setHomePosition(65);
					player[i].pawn[3].setHomePosition(66);
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
   		        	 butt[nameField] = new JButton();
		        	 butt[nameField].setBounds(posx, posy, buttonWidth, buttonHeight);
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
         

 		
       
         buttonRoll = new JButton("Rzuæ kostk¹");
         buttonRoll.setBounds((width/2)-(buttonWidth*2)-((buttonWidth/6)), height - buttonHeight - 40, buttonWidth*3, buttonHeight);
         buttonRoll.addActionListener(new buttonMainWindowListener());
         score = new JLabel();
         score.setBounds((width/2)+(buttonWidth)+((buttonWidth/6)), height - buttonHeight - 40, buttonWidth*2, buttonHeight);

         thePanel2.add(buttonRoll);
         thePanel2.add(score);
         this.add(thePanel2);         
         this.setVisible(true);
         
         setBoardColor();         
         refreshBoard();
		 }
		

		private void setBoardColor() {
			for (int i=0;i<9;i++) {
		 		 int YellowTablica [] = {0,1,7,8,20,32,33,34,35};
		 		 int GreenTtablica [] = {4,5,6,10,12,13,15,18,25};
		 		 int BlueTablica [] = {58,59,65,66,61,56,53,67,46};
		 		 int RedTablica [] = {36,37,38,39,51,63,64,70,71};
				 butt[YellowTablica[i]].setBackground(Ludo.Cyellow);
	        	 butt[BlueTablica[i]].setBackground(Ludo.Cblue);
	        	 butt[RedTablica[i]].setBackground(Ludo.Cred);
	        	 butt[GreenTtablica[i]].setBackground(Ludo.Cgreen);
	         }
			
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
	
	public void refreshBoard() {
		for (int z=0; z<butt.length;z++) {
			butt[z].setIcon(null);
		}
		for (int i=0;i<4;i++) {
        	 if (player[i].getActive()) {
        		 for (int j=0;j<4;j++) {
 					 butt[player[i].pawn[j].getPosition()].setIcon(player[i].getPawnIcon());
				 }
        	  }
 			}
		
	}
	
	public void setGame() {

		for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++) {
				player[i].pawn[j].setPosition(player[i].pawn[j].getHomePosition());
				player[i].pawn[j].setHome(true);
			}		
		}
		for (int i=0;i<4;i++) {
			if (player[i].getActive()) {
				activePlayer = i;
				break;
				}
			}

		StartMenu.dispose();

		MainWindow = new MainWindow();
		buttonRoll.setBackground(player[activePlayer].getColor());
		

	}
	
	public void playerChange() {
		activePlayer++;
		if (activePlayer==4) {activePlayer=0;}
		if (player[activePlayer].getActive()==false) {playerChange();}
		player[activePlayer].setDiceScore(0);
		buttonRoll.setBackground(player[activePlayer].getColor());
	}

	public void diceRoll() {
		dice.throwDice();
		player[activePlayer].setDiceScore((int)dice.getScore());
		score.setText(Integer.toString(player[activePlayer].getDiceScore()));
		if (player[activePlayer].getDiceScore()==6) {
				player[activePlayer].setAditionalMove(true);
		}else {
				player[activePlayer].setAditionalMove(false);
		}
	}

	public void gamePlay() {
		
		if (player[activePlayer].pawn[0].getHome() && player[activePlayer].getDiceScore()==6) {
			player[activePlayer].pawn[0].setPotentialPosition(player[activePlayer].getStartPoisition());
			player[activePlayer].pawn[0].setPosition(player[activePlayer].pawn[0].getPotentialPosition());
			player[activePlayer].pawn[0].setGo(true);
			player[activePlayer].pawn[0].setHome(false);
			player[activePlayer].pawn[0].setLeft(board.BOARD.length-1);
		}else if (player[activePlayer].pawn[0].getGo()){
			
			player[activePlayer].pawn[0].setLeft(player[activePlayer].pawn[0].getLeft()-player[activePlayer].getDiceScore());
			if (player[activePlayer].pawn[0].getLeft()<0) {
				player[activePlayer].pawn[0].setGo(false);
				player[activePlayer].pawn[0].setSafe(true);
				int l = -(player[activePlayer].pawn[0].getLeft()-1);
				if (l>3) {l=3;}
								
				switch (activePlayer) {
				case 0:	player[activePlayer].pawn[0].setPosition(board.YellowArray[l]);
						break;
				case 1:	player[activePlayer].pawn[0].setPosition(board.GreenArray[l]);
						break;
				case 2: player[activePlayer].pawn[0].setPosition(board.RedArray[l]);
						break;
				case 3: player[activePlayer].pawn[0].setPosition(board.BlueArray[l]);
						break;

				}
				
				
				//player[activePlayer].pawn[0].setPotentialPosition(player[activePlayer].getEndPoisition());
				//player[activePlayer].pawn[0].setPosition(player[activePlayer].pawn[0].getPotentialPosition());
				
			}else {
			int x = board.getBoardElementPosition(player[activePlayer].pawn[0].getPosition());
			x = x + player[activePlayer].getDiceScore();
			if (x >= board.BOARD.length) {x= x-board.BOARD.length;}
			player[activePlayer].pawn[0].setPotentialPosition(board.BOARD[x]);
			player[activePlayer].pawn[0].setPosition(player[activePlayer].pawn[0].getPotentialPosition());
			}
			
			
		}else {}
		
		
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
				diceRoll();
				gamePlay();
				System.out.println("----------------");
				System.out.println("gracz nr "+ activePlayer);
				System.out.println("gracz color "+player[activePlayer].getColor());
				System.out.println("gracz rzucil "+player[activePlayer].getDiceScore());
				System.out.println("pozycja "+player[activePlayer].pawn[0].getPosition());
				System.out.println("pozostalo "+player[activePlayer].pawn[0].getLeft());
				
				playerChange();
				refreshBoard();
				/*
				System.out.println(board.BOARD[2]);
				System.out.println(board.getBoardElementPosition(16));
				
				System.out.println(activePlayer);
				
				System.out.println(activePlayer);
				System.out.println(player[activePlayer].getAditionalMove());
				*/


			}
			
		}
		
	}
}