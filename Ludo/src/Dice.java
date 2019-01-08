
public class Dice {

	private final byte SIZE_DICE = 6;
	private final byte RANGE_ROTATION_DICE = 20;
	private byte[] num16 = {2,3,4,5};
	private byte[] num25 = {1,3,4,6};
	private byte[] num34 = {1,2,5,6};
	private byte score;
	
	public byte getScore () {return score;}
	
	
	public void throwDice () {
		byte score = 0;
		byte RotationDice = (byte) (Math.random()* RANGE_ROTATION_DICE+1);
		for (int i = 1; i <= RotationDice; i++) {
			byte RandomTabl = (byte) (Math.random()*4);
			switch (score) {
			case 0:
				score = (byte)(Math.random() * SIZE_DICE + 1);
				break;
			case 1:
			case 6:
				score = num16[RandomTabl];
				break;
			case 2:
			case 5:
				score = num25[RandomTabl];
				break;
				
			case 3:
			case 4:
				score = num34[RandomTabl];
				break;
			} //switch(score)
		}//for
		
		this.score = score;
	}
	//overload
	public void throwDice (byte power) {
		byte score = 0;
		byte RotationDice = (byte) (power - 2 + (Math.random()* 5));
		for (int i = 1; i <= RotationDice; i++) {
			byte RandomTabl = (byte) (Math.random()*4);
			switch (score) {
			case 0:
				score = (byte)(Math.random() * SIZE_DICE + 1);
				break;
			case 1:
			case 6:
				score = num16[RandomTabl];
				break;
			case 2:
			case 5:
				score = num25[RandomTabl];
				break;
				
			case 3:
			case 4:
				score = num34[RandomTabl];
				break;
			} //switch(score)
		}//for
		
		this.score = score;
	}


}
