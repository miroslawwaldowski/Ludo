import java.awt.Choice;


import javax.swing.JLabel;
import javax.swing.JTextField;

public class Player {
	
	private int number;
	private String color;
	int y=0;
	
	private Choice typPlayer;
	private JLabel numberPlayer;
	private JTextField namePlayer;
	
	
	
	
	Pawn[] pawn = new Pawn[4];
	
  
	public String getColor () {return color;}
	public int getNumber () {return number;}
	public Choice getTypPlayer() {return typPlayer;}
	
	
	public void setColor (String color) {this.color = color;}
	public void setNumber (int number) {this.number = number;}
	public void setTypPlayer(Choice typPlayer) {this.typPlayer = typPlayer;}
	
	
	
	public Player() {
		
		this.namePlayer=new JTextField();
		this.numberPlayer=new JLabel();
		this.typPlayer =new Choice();
		this.typPlayer.add("Gracz");
		this.typPlayer.add("Komputer");
		this.typPlayer.select("Gracz");
		
		for (int i=0; i<4; i++)
		{
			pawn[i] = new Pawn();
		}
		
	}
	
	

	}
