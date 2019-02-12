import java.awt.Choice;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Player {
	
	private int number;
	private Color color;
	private boolean active;
	private boolean aditionalMove;
	
	private int typPlayerSet; //0 gracz, 1,2 komputer, 3 brak
	private Choice typPlayer;
	
	private JLabel numberPlayer;
	private String name;
	private JTextField namePlayer;
	
	private ImageIcon PawnIcon;
	
	private int startPosition;
	private int endPosition;
	private int diceScore;

	
	Pawn[] pawn = new Pawn[4];
	
  
	public Color getColor () {return color;}
	public int getNumber () {return number;}
	public String getName () {return name;}
	public Choice getTypPlayer() {return typPlayer;}
	public JLabel getNumberPlayer() {return numberPlayer;}
	public JTextField getNamePlayer() {return namePlayer;}
	public Pawn getPawn (int i) {return pawn[i];}
	public boolean getActive () {return active;}
	public boolean getAditionalMove () {return aditionalMove;}
	public int getTypPlayerSet () {return typPlayerSet;}
	public ImageIcon getPawnIcon() {return PawnIcon;}
	public int getStartPoisition () {return startPosition;}
	public int getEndPoisition () {return endPosition;}
	public int getDiceScore () {return diceScore;}
	
	public void setActive (boolean b) {this.active = b;}
	public void setAditionalMove (boolean b) {this.aditionalMove = b;}
	public void setName (String s) {this.name = s;}
	public void setTypPlayerSet (int typPlayerSet) {this.typPlayerSet = typPlayerSet;}
	public void setTypPlayer(Choice typPlayer) {this.typPlayer = typPlayer;}
	public void setColor (Color color) {
		this.color = color;
		this.numberPlayer.setBackground(this.color);
		this.numberPlayer.setOpaque(true);
		}
	public void setNumber (int number) {
		this.number = number;
		this.numberPlayer.setText(Integer.toString(this.number+1));
		}
	public void setPawnIcon () {
		this.PawnIcon = new ImageIcon (PawnImage.PawnIcon(this.color));
		}
	public void setStartPoisition (int position) {this.startPosition = position;}
	public void setEndPoisition (int position) {this.endPosition = position;}
	public void setDiceScore (int score) {this.diceScore = score;}
	
	public Player() {
		
		this.namePlayer=new JTextField();
		this.numberPlayer=new JLabel();
		this.typPlayer =new Choice();
		this.typPlayer.add("Gracz");
		this.typPlayer.add("Komputer - ³atwy");
		this.typPlayer.add("Komputer - trudny");
		this.typPlayer.add("Brak");
		this.typPlayer.select("Gracz");
		this.active=true;
		this.PawnIcon=new ImageIcon();
	
		for (int i=0; i<4; i++)
		{
			pawn[i] = new Pawn();
		}
	}//Player()
}//class Player
