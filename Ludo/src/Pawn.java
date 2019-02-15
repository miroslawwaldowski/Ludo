
public class Pawn {

	private int position;
	private int homePosition;
	private int potentialPosition;
	private int left;
	private boolean home;
	private boolean go;
	private boolean safe;
	private boolean active;
	private int potentialPower;
	
	public int getPosition () {return position;}
	public int getHomePosition () {return homePosition;}
	public int getPotentialPosition () {return potentialPosition;}
	public int getLeft () {return left;}
	public boolean getHome () {return home;}
	public boolean getGo () {return go;}
	public boolean getSafe () {return safe;}
	public boolean getActive () {return active;}
	public int getPotentialPower () {return potentialPower;}
	
	
	public void setPosition (int position) {this.position = position;}
	public void setHomePosition (int position) {this.homePosition = position;}
	public void setPotentialPosition (int position) {this.potentialPosition = position;}
	public void setLeft (int position) {this.left = position;}
	public void setHome (boolean b) {this.home = b;}
	public void setGo (boolean b) {this.go = b;}
	public void setSafe (boolean b) {this.safe = b;}
	public void setActive (boolean b) {this.active = b;}
	public void setPotentialPower (int power) {this.potentialPower = power;}
	
//	public void movePawn(int manyPositions) {		
//		this.position = this.position + manyPositions;
//	}
	

	
}
