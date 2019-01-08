
public class Board {

	private final int SIZE_BOARD = 40;
	private int[] score = new int[4];	
	
	public int getSize () {return SIZE_BOARD;}	
	public int getScore (int player) {return score[player];}
	
	public void setScore (int player, int score) {this.score[player]=score;}
}
