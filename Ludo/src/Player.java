

public class Player {
	
	private int number;
	private String color;
	int y=0;
	
	Pawn[] pawn = new Pawn[4];
	{for (int i=0; i<4; i++)
	{
		pawn[i] = new Pawn();
	}}
  
	public String getColor () {return color;}
	public int getNumber () {return number;}
	
	public void setColor (String color) {this.color = color;}
	public void setNumber (int number) {this.number = number;}
	
	
	public Player(String color, int number) {
		this.color = color;
		this.number = number;
	}
	

	}
