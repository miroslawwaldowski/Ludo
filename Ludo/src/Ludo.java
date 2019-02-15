import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
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
	JTextArea textArea;

	
	int activePlayer, amountPlayers;

	public Ludo() {
		
			
		for (int i=0;i<4;i++) {
			player[i]=new Player();
			player[i].setNumber(i);

			
			switch(i) {
			case 0 :player[i].setColor(Cyellow);
	 		 		player[i].setStartPoisition(20);
	 		 		player[i].setEndPoisition(31);
	 		 		player[i].pawn[0].setHomePosition(0);
	 		 		player[i].pawn[1].setHomePosition(1);
	 		 		player[i].pawn[2].setHomePosition(7);
	 		 		player[i].pawn[3].setHomePosition(8);
			break;
			case 1 :player[i].setColor(Cgreen);
	 		 		player[i].setStartPoisition(4);
	 		 		player[i].setEndPoisition(3);
	 		 		player[i].pawn[0].setHomePosition(5);
	 		 		player[i].pawn[1].setHomePosition(6);
	 		 		player[i].pawn[2].setHomePosition(12);
	 		 		player[i].pawn[3].setHomePosition(13);
			break;
			case 2 :player[i].setColor(Cred);
			 		player[i].setStartPoisition(51);
			 		player[i].setEndPoisition(40);
			 		player[i].pawn[0].setHomePosition(63);
			 		player[i].pawn[1].setHomePosition(64);
			 		player[i].pawn[2].setHomePosition(70);
			 		player[i].pawn[3].setHomePosition(71);
			break;
			case 3 :player[i].setColor(Cblue);
					player[i].setStartPoisition(67);
					player[i].setEndPoisition(68);
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
 		int height = buttonHeight * 15;
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
 		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
 		thePanel2.setLayout(null);
       
        for (int i =0; i<11; i++) {
        	 for (int y = 0; y<11; y++) {
        		 if(contains(tablica, number)){
        		 } else {
   		        	 butt[nameField] = new JButton();
		        	 butt[nameField].setBounds(posx, posy, buttonWidth, buttonHeight);
		        	 butt[nameField].setBackground(Color.white);
		        	 butt[nameField].setFont(new Font("Arial", Font.PLAIN, 8));
		        	 butt[nameField].addActionListener(new buttonMainWindowListener());
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
         buttonRoll.setBounds(20, height - buttonHeight - 110, buttonWidth*3, buttonHeight);
         buttonRoll.addActionListener(new buttonMainWindowListener());
         
         score = new JLabel();
         score.setBounds(170, height - buttonHeight - 110, 52, 52);
         score.setBorder(border);
         score.setVerticalAlignment(JLabel.CENTER);
         score.setHorizontalAlignment(JLabel.CENTER);
                 
         textArea = new JTextArea("",1,22);
         textArea.setEditable(false);
         textArea.setLineWrap(true);
         textArea.setWrapStyleWord(true);
         textArea.setBorder(border);
         
         setComunicate("Rzuæ kostk¹!");
         
         JScrollPane scroll = new JScrollPane (textArea);
         scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );
         scroll.setBounds(230, height - buttonHeight - 110, buttonWidth*5+20, buttonHeight*2);
         
         thePanel2.add(buttonRoll);
         thePanel2.add(score);
         thePanel2.add(scroll);
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
		
		switch (player[activePlayer].getTypPlayerSet()) {
		case 0:
			buttonRoll.setEnabled(true);
			break;
		case 1:
			buttonRoll.setEnabled(false);
			AI();
			break;
		case 2:
			buttonRoll.setEnabled(false);
			AI();
			break;
		case 3:
			break;
		}
	}
	
	public void playerChange() {
		activePlayer++;
		if (activePlayer==4) {activePlayer=0;}
		if (player[activePlayer].getActive()==false) {playerChange();}
		player[activePlayer].setDiceScore(0);
		buttonRoll.setBackground(player[activePlayer].getColor());
		switch (player[activePlayer].getTypPlayerSet()) {
		case 0:
			buttonRoll.setEnabled(true);
			System.out.println("czlowik");
			break;
		case 1:
			buttonRoll.setEnabled(false);
			System.out.println("Ai latwe");
			AI();
			break;
		case 2:
			buttonRoll.setEnabled(false);
			System.out.println("Ai trudne");
			AI();
			break;
		case 3:
			break;
		}
		
	}

	public void diceRoll() {
		dice.throwDice();
		player[activePlayer].setDiceScore((int)dice.getScore());
		score.setIcon(new ImageIcon (DiceImage.DiceIcon(player[activePlayer].getColor(),(byte)player[activePlayer].getDiceScore())));
		setComunicate("Wypad³o "+player[activePlayer].getDiceScore());
		if (player[activePlayer].getDiceScore()==6) {
				player[activePlayer].setAditionalMove(true);
		}else {
				player[activePlayer].setAditionalMove(false);
		}
	}

	public void gamePlay() {
		//funkcja wskazuje mo¿liwoœci
		for (int i=0;i<4;i++) {
			player[activePlayer].pawn[i].setPotentialPosition(player[activePlayer].pawn[i].getPosition());
			player[activePlayer].pawn[i].setActive(false);
			player[activePlayer].pawn[i].setPotentialPower(-1);
			
			if (player[activePlayer].pawn[i].getHome() && (player[activePlayer].getDiceScore()!=6)) {
				player[activePlayer].pawn[i].setLeft(-99);
			}
			else
			if (player[activePlayer].pawn[i].getHome() && player[activePlayer].getDiceScore()==6) {
				player[activePlayer].pawn[i].setPotentialPosition(player[activePlayer].getStartPoisition());
				if(isBoardFreeByPlayer(i)) {
					player[activePlayer].pawn[i].setLeft(board.BOARD.length-1);
					player[activePlayer].pawn[i].setActive(true);
					player[activePlayer].pawn[i].setPotentialPower(1);
				}
			}else 
			if (player[activePlayer].pawn[i].getGo()){								
				player[activePlayer].pawn[i].setLeft(calcLeft(i));
				player[activePlayer].pawn[i].setLeft(player[activePlayer].pawn[i].getLeft()-player[activePlayer].getDiceScore());
				if (player[activePlayer].pawn[i].getLeft()>=0) {
					int x = board.getBoardElementPosition(player[activePlayer].pawn[i].getPosition());
					x = x + player[activePlayer].getDiceScore();
					if (x >= board.BOARD.length) {x= x-board.BOARD.length;}
					player[activePlayer].pawn[i].setPotentialPosition(board.BOARD[x]);				
					setWhenFree(i,2);
				}else if (player[activePlayer].pawn[i].getLeft()>-5){
					int l = -(player[activePlayer].pawn[i].getLeft())-1;			
					switch (activePlayer) {
					case 0:	player[activePlayer].pawn[i].setPotentialPosition(board.YellowArray[l]);
							setWhenFree(i,3);				
							break;
					case 1:	player[activePlayer].pawn[i].setPotentialPosition(board.GreenArray[l]);
							setWhenFree(i,3);			
							break;
					case 2: player[activePlayer].pawn[i].setPotentialPosition(board.RedArray[l]);
							setWhenFree(i,3);				
							break;
					case 3: player[activePlayer].pawn[i].setPotentialPosition(board.BlueArray[l]);
							setWhenFree(i,3);				
							break;
					}
				}else {
					//nothing
				}
			}else if (player[activePlayer].pawn[i].getSafe()) {
				int l =board.getSafeElementPosition (player[activePlayer].pawn[i].getPosition(), activePlayer);
				int y = l+player[activePlayer].getDiceScore();
				if (y<4) {
				switch (activePlayer) {
				case 0:	player[activePlayer].pawn[i].setPotentialPosition(board.YellowArray[y]);
						setWhenFree(i,4);
						break;
				case 1:	player[activePlayer].pawn[i].setPotentialPosition(board.GreenArray[y]);
						setWhenFree(i,4);
						break;
				case 2: player[activePlayer].pawn[i].setPotentialPosition(board.RedArray[y]);
						setWhenFree(i,4);
						break;
				case 3: player[activePlayer].pawn[i].setPotentialPosition(board.BlueArray[y]);
						setWhenFree(i,4);
						break;
					}//switch
				}//if (y<4)
			}else {
				//nothing}
			}//else
		}//for (int i=0;i<4;i++)
	}
			
	public int calcLeft(int i) {
		int x = board.getBoardElementPosition(player[activePlayer].pawn[i].getPosition());
		int y = board.getBoardElementPosition(player[activePlayer].getEndPoisition());
		if (x<y) {return y-x;}
		else if (x>y) {return board.BOARD.length-(x-y);}
		else {return 0;}
	}
	
	public void movePawn(int i) {
		if (player[activePlayer].pawn[i].getActive()) {
			if (player[activePlayer].pawn[i].getHome()){
				player[activePlayer].pawn[i].setGo(true);
				player[activePlayer].pawn[i].setHome(false);
			} else if (player[activePlayer].pawn[i].getLeft()<0){
				player[activePlayer].pawn[i].setGo(false);
				player[activePlayer].pawn[i].setSafe(true);
			}
		player[activePlayer].pawn[i].setPosition(player[activePlayer].pawn[i].getPotentialPosition());
		setWhenKill(i);
		}
		if (isWinner()>-1) {
			buttonRoll.setEnabled(false);
			for (int z=0; z<butt.length;z++) {
				butt[z].setEnabled(false);;
			}
			JOptionPane.showMessageDialog(null,"Wygranym graczem jest "+player[isWinner()].getName(), "Gratulacje", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public boolean isActivePawn() {
		boolean x = false;
		for (int i=0;i<4; i++) {
			if (player[activePlayer].pawn[i].getActive()){
				x = true;
			}
		}
		return x;
	}
		
	public boolean isBoardFreeByPlayer(int i) {
		boolean x = true;
		for (int j=0;j<4; j++) {
			if (player[activePlayer].pawn[i].getPotentialPosition() == player[activePlayer].pawn[j].getPosition()) {
				x = false;
			}
		}
		return x;
	}
	
	public void setWhenFree(int i,int p) {
		if (isBoardFreeByPlayer(i)) {
			player[activePlayer].pawn[i].setActive(true);
			player[activePlayer].pawn[i].setPotentialPower(p);
		}else {
			player[activePlayer].pawn[i].setActive(false);
		}					
	}
	
	public void setWhenKill (int i) {
		
		for (int k=0;k<4; k++) {
			for (int j=0;j<4; j++) {
				if (k != activePlayer) {
					if (player[activePlayer].pawn[i].getPotentialPosition() == player[k].pawn[j].getPosition()) {
						player[k].pawn[j].setActive(false);
						player[k].pawn[j].setHome(true);
						player[k].pawn[j].setGo(false);
						player[k].pawn[j].setLeft(-99);
						player[k].pawn[j].setSafe(false);
						player[k].pawn[j].setPosition(player[k].pawn[j].getHomePosition());
						setComunicate("Zbi³ pion gracza :"+player[k].getName());
					}
				}
			}
		}

	}

	public void setComunicate(String s) {
		String textColor ="";
		
		switch (activePlayer) {
		case 0:	textColor = " (¿ó³ty): ";	
				break;
		case 1:	textColor = " (zielony): ";			
				break;
		case 2: textColor = " (czerwony): ";				
				break;
		case 3: textColor = " (niebieski): ";				
				break;
		}
				
		String text=(player[activePlayer].getName()+textColor+s);
		textArea.append(text);
		textArea.append("\n");
		textArea.getCaret().setDot( Integer.MAX_VALUE );
	}
	
	public boolean isPlayerWinner (int i) {
		boolean x=true;
		for (int j=0;j<4;j++) {
  			 if (!player[i].pawn[j].getSafe()) {
  				 x=false;
  			 }				 
  		 }
		return x;
		
	}
	
	public int isWinner() {
		int x=-1;
		for (int i=0;i<4;i++) {
		  if (player[i].getActive()&&isPlayerWinner(i)) {
       		 x=i;
       		 break;
       	 }
		}
		return x;
	}
	
	private void CanKill() {
		for (int k=0;k<4; k++) { //gracze
			for (int j=0;j<4; j++) { //ich piony
				for (int i=0;i<4;i++) { //piony gracza
					if(player[activePlayer].pawn[i].getActive()) {
						if (k != activePlayer) {
							if (player[activePlayer].pawn[i].getPotentialPosition() == player[k].pawn[j].getPosition()) {
								player[activePlayer].pawn[i].setPotentialPower(10);
							}
						}	
					}
				}
			}
		}
	}

	public void AI() {
		diceRoll();
		gamePlay();
		CanKill();
		if(player[activePlayer].getTypPlayerSet()==1) {//hard
			loop: for(int z=0;z<1;z++) {
				for (int i=0;i<4;i++) {//can kill
					if (player[activePlayer].pawn[i].getPotentialPower()==10) {
						movePawn(i);
						refreshBoard();
						break loop;
					}
				}
				for (int i=0;i<4;i++) {//go out
					if (player[activePlayer].pawn[i].getPotentialPower()==1) {
						movePawn(i);
						refreshBoard();
						break loop;
					}
				}
				for (int i=0;i<4;i++) {//move to home
					if (player[activePlayer].pawn[i].getPotentialPower()==3) {
						movePawn(i);
						refreshBoard();
						break loop;
					}
				}
				for (int i=0;i<4;i++) {//move on board
					if (player[activePlayer].pawn[i].getPotentialPower()==2) {
						movePawn(i);
						refreshBoard();
						break loop;
					}
				}
				for (int i=0;i<4;i++) {//move at home
					if (player[activePlayer].pawn[i].getPotentialPower()==4) {
						movePawn(i);
						refreshBoard();
						break loop;
					}		
				}
			}
		}else if(player[activePlayer].getTypPlayerSet()==2) {//easy
			loop: for(int z=0;z<1;z++) {
				for (int i=0;i<4;i++) {//go out
					if (player[activePlayer].pawn[i].getPotentialPower()==1) {
						movePawn(i);
						refreshBoard();
						break loop;
					}
				}
				for (int i=0;i<4;i++) {//move on board
					if (player[activePlayer].pawn[i].getPotentialPower()==2) {
						movePawn(i);
						refreshBoard();
						break loop;
					}
				}
				for (int i=0;i<4;i++) {//move to home
					if (player[activePlayer].pawn[i].getPotentialPower()==3) {
						movePawn(i);
						refreshBoard();
						break loop;
					}
				}
				for (int i=0;i<4;i++) {//move at home
					if (player[activePlayer].pawn[i].getPotentialPower()==4) {
						movePawn(i);
						refreshBoard();
						break loop;
					}
				}
				for (int i=0;i<4;i++) {//can kill
					if (player[activePlayer].pawn[i].getPotentialPower()==10) {
						movePawn(i);
						refreshBoard();
						break loop;
					}		
				}
			}
		}
		
		if (player[activePlayer].getAditionalMove()) {
			player[activePlayer].setAditionalMove(false);
			AI();
		}
		if (!(isWinner()>-1)) {
			playerChange();
		}else{
			buttonRoll.setEnabled(false);	
		}
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
							player[i].setName("Brak gracza "+Integer.toString(i+1));
						}
					}
					System.out.println(player[i].getName());
					System.out.println(player[i].getActive());
				}//for (int i=0;i<4;i++) 
				if (isActivePlayer()) {
					setGame();
				}else {
					//komunikat o iloœci graczy
					JOptionPane.showMessageDialog(null,"Wybierz przynajmienj jednego gracza", "Uwaga", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				//nothing
			}
		}//actionPerformed
		
		public boolean isActivePlayer() {
			boolean x = false;
			for (int i=0;i<4; i++) {
				if (player[i].getActive()){
					x = true;
				}
			}
			return x;
		}
	}
	
	class buttonMainWindowListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonRoll) {
				diceRoll(); 
				gamePlay(); 
				refreshBoard();
//				System.out.println("-----");
//				for (int i=0;i<4; i++) {
//				System.out.print("pion"+i+" "+player[activePlayer].pawn[i].getActive()+" ");
//				System.out.print("left "+player[activePlayer].pawn[i].getLeft()+" ");
//				System.out.print("pos "+player[activePlayer].pawn[i].getPosition()+" ");
//				System.out.println("pot "+player[activePlayer].pawn[i].getPotentialPosition()+" ");
//				}
				buttonRoll.setEnabled(false);
								
				if(!isActivePawn()) {
					if (player[activePlayer].getAditionalMove()) {
						refreshBoard();
						buttonRoll.setEnabled(true);
					}else {
						playerChange();
						setComunicate("Rzuæ kostk¹!");
						}
				}else {
					setComunicate("IdŸ Pionem!");
				}

			}else if (e.getSource() == butt[player[activePlayer].pawn[0].getPosition()]){
				if (!buttonRoll.isEnabled() && player[activePlayer].pawn[0].getActive()) 
					{
					buttonPawnMowe(0);
					}
			}else if (e.getSource() == butt[player[activePlayer].pawn[1].getPosition()]){
				if (!buttonRoll.isEnabled() && player[activePlayer].pawn[1].getActive()) 
					{
					buttonPawnMowe(1);
					}
			}else if (e.getSource() == butt[player[activePlayer].pawn[2].getPosition()]){
				if (!buttonRoll.isEnabled() && player[activePlayer].pawn[2].getActive()) 
					{
					buttonPawnMowe(2);
					}
			}else if (e.getSource() == butt[player[activePlayer].pawn[3].getPosition()]){
				if (!buttonRoll.isEnabled() && player[activePlayer].pawn[3].getActive()) 
					{
					buttonPawnMowe(3);
					}
			}
		}//actionPerformed
	}
	
	public void buttonPawnMowe(int i) {
		movePawn(i);
		refreshBoard();
		if (isWinner()<0) {
				if (!player[activePlayer].getAditionalMove()) {
				playerChange();
			}
		}
		setComunicate("Rzuæ kostk¹!");
		buttonRoll.setEnabled(true);
		refreshBoard();
	}
}