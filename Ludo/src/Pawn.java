
public class Pawn {

	private int position;
	
	public int getPosition () {return position;}
	public void setPosition (int position) {this.position = position;}
	
	public void movePawn(int manyPositions) {		
		this.position = this.position + manyPositions;
	}
	
	public Pawn() {
		this.position = 0;
	}
	
}
