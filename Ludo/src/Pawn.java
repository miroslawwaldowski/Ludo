
public class Pawn {

	private int position;
	private int homePosition;
	
	public int getPosition () {return position;}
	public int getHomePosition () {return homePosition;}
	
	public void setPosition (int position) {this.position = position;}
	public void setHomePosition (int position) {this.homePosition = position;}
	
	public void movePawn(int manyPositions) {		
		this.position = this.position + manyPositions;
	}
	
	public Pawn() {
		this.position = 0;
	}
	
}
