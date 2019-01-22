import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Ludo extends JFrame{
	
	Player[] player = new Player[4];
	
	

	public Ludo() {
		
			
		for (int i=0;i<4;i++) {
			player[i]=new Player();
			player[i].setNumber(i);
			Color blue = new Color(30,144,255);
			Color red = new Color(255,99,71);
			Color yellow = new Color(255,215,0);
			Color green = new Color(50,250,50);
			switch(i) {
			case 0 : player[i].setColor(blue);
			break;
			case 1 : player[i].setColor(red);
			break;
			case 2 : player[i].setColor(yellow);
			break;
			case 3 : player[i].setColor(green);
			break;
			}
		}
		StartMenu();
	};
	
	
	
	
	public static void main(String[] args) {
		

		Ludo game=new Ludo();
		
		int i,j;
		for (i=0; i<4; i++) {
			for (j=0; j<4; j++) {
				game.player[i].pawn[j].setPosition(i+j);
				System.out.print(game.player[i].getNumber());
				System.out.println(game.player[i].pawn[j].getPosition());
				System.out.println(game.player[i].getColor());
			}
		}
		
	}
	


	public void StartMenu() {
			
		
		
 		int height = 300;
 		int width = 450;
 		
 		this.setSize(width,height);
 		this.setLocationRelativeTo(null);
 		this.setResizable(false);
 		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		this.setTitle("Chiñczyk - Wybór gry");
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
 		
 		JButton buttonStart = new JButton("Start");
 		JButton buttonClose = new JButton("Zamknij");
 		
 		buttonStart.setBounds(50, 190, 160, 40);
 		buttonClose.setBounds(230, 190, 160, 40);
 		
 		
 		thePanel.add(buttonStart);
 		thePanel.add(buttonClose);
 		
 		
 		this.add(thePanel);        
        this.setVisible(true);
	}
	
	
	public void PlayerSet () {
		for (int i=0;i<4;i++) {
			if (player[i].getTypPlayer().getSelectedIndex()==2) {
				player[i].setActive(false);
			}
		}
	}
	
	
		

}
