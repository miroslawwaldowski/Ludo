import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Ludo extends JFrame implements ActionListener{
	
	Player[] player = new Player[4];
	
	public static Color Cblue = new Color(30,144,255);
	public static Color Cred = new Color(255,99,71);
	public static Color Cyellow = new Color(255,215,0);
	public static Color Cgreen = new Color(50,250,50);
	
	
		
	JButton buttonStart, buttonClose;
	



	public Ludo() {
		
			
		for (int i=0;i<4;i++) {
			player[i]=new Player();
			player[i].setNumber(i);

			
			switch(i) {
			case 0 : player[i].setColor(Cblue);
					 player[i].pawn[0].setHomePosition(58);
					 player[i].pawn[1].setHomePosition(58);
					 player[i].pawn[2].setHomePosition(58);
					 player[i].pawn[3].setHomePosition(58);
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
		}
		StartMenu();
	};
	
	
	
	
	public static void main(String[] args) {
		
		Ludo game=new Ludo();
		game.setTitle("Chiñczyk - Wybór gry");
		
	}
	



	public void StartMenu() {
			
		
		
 		int height = 300;
 		int width = 450;
 		
 		this.setSize(width,height);
 		this.setLocationRelativeTo(null);
 		this.setResizable(false);
 		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		//this.setTitle("Chiñczyk - Wybór gry");
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
 		}
 		
 		buttonStart = new JButton("Start");
 		buttonClose = new JButton("Zamknij");
 		

 		
 		buttonStart.setBounds(50, 190, 160, 40);
 		buttonClose.setBounds(230, 190, 160, 40);
 		
 		buttonStart.addActionListener(this);
 		buttonClose.addActionListener(this);
 		
 		
 		thePanel.add(buttonStart);
 		thePanel.add(buttonClose);
 		
 		
 		this.add(thePanel);        
        this.setVisible(true);
	}
	
	
	public void PlayerSet () {
		for (int i=0;i<4;i++) {
			if (player[i].getTypPlayer().getSelectedIndex()==3) {
				player[i].setActive(false);
			}
		}
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonStart) {
			new MainWindow();
			dispose();
		}
		else if (e.getSource() == buttonClose) {
			System.exit(EXIT_ON_CLOSE);		
		}
		
	}
	
	
		

}



