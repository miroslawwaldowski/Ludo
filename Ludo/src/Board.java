
public class Board {

	
	public final int[] BOARD = {4,11,16,19,26,27,28,29,30,40,51,50,49,48,47,
											54,57,62,69,68,67,60,55,52,45,44,43,42,41,31,
											20,21,22,23,24,17,14,9,2,3};	
	
	public final int [] YellowArray = {32,33,34,35};
	public final int [] GreenArray = {10,15,18,25};
	public final int [] BlueArray = {61,56,53,46};
	public final int [] RedArray = {39,38,37,36};
	
	
	public int getBoardElementPosition (int x) {
		for(int index =0; index < BOARD.length; index++) {
			if (BOARD[index]==x) {
				return index;}		
		}
			return -1;
	}
	
	
	public int getSafeElementPosition (int x, int activePlayer) {
			switch (activePlayer) {
			case 0:
				for(int index =0; index < YellowArray.length; index++) {
					if (YellowArray[index]==x) {return index;}	
				}
			case 1:
				for(int index =0; index < GreenArray.length; index++) {
					if (GreenArray[index]==x) {return index;}	
				}
			case 2:
				for(int index =0; index < RedArray.length; index++) {
					if (RedArray[index]==x) {return index;}	
				}
			case 3:
				for(int index =0; index < BlueArray.length; index++) {
					if (BlueArray[index]==x) {return index;}	
				}
			default: return -1;
		}
			
	} 
}