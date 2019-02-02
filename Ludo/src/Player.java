import java.awt.Choice;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Player {
	
	private int number;
	private Color color;
	private boolean active;

	
	private Choice typPlayer;
	private JLabel numberPlayer;
	private JTextField namePlayer;
	

	
	Pawn[] pawn = new Pawn[4];
	
  
	public Color getColor () {return color;}
	public int getNumber () {return number;}
	public Choice getTypPlayer() {return typPlayer;}
	public JLabel getNumberPlayer() {return numberPlayer;}
	public JTextField getNamePlayer() {return namePlayer;}
	public Pawn getPawn (int i) {return pawn[i];}
	public boolean getActive () {return active;}

	
	public void setActive (boolean b) {
		this.active = b;
	}
	
	public void setColor (Color color) {
		this.color = color;
		this.numberPlayer.setBackground(this.color);
		this.numberPlayer.setOpaque(true);
		}
	
	public void setNumber (int number) {
		this.number = number;
		this.numberPlayer.setText(Integer.toString(this.number+1));
		}
	
	public void setTypPlayer(Choice typPlayer) {this.typPlayer = typPlayer;}

	
	
	
	public Player() {
		
		this.namePlayer=new JTextField();

		this.numberPlayer=new JLabel();
		
		this.typPlayer =new Choice();
		
		this.typPlayer.add("Gracz");
		this.typPlayer.add("Komputer - ³atwy");
		this.typPlayer.add("Komputer - trudny");
		this.typPlayer.add("Brak");
		this.typPlayer.select("Gracz");
		
		
		for (int i=0; i<4; i++)
		{
			pawn[i] = new Pawn();
		}
		
	}
	
	

	}
