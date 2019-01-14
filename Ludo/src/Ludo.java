
public class Ludo {
	
	
	Player[] player = new Player[4];
	
	public static void main(String[] args) {
		

		Ludo game=new Ludo();


		
		
		/*Board board = new Board();
		Player red = new Player("red", 0);
		
		Dice dice = new Dice();
		
		int i =0;
		while (red.pawn[1].getPosition()<board.getSize()) {
			dice.throwDice();
			int scoreDice = (int)dice.getScore();
			i=i+1;
			if ((red.pawn[1].getPosition()+scoreDice)>board.getSize()){
				System.out.println("wynik rzutu kostk¹: " + scoreDice);
				System.out.println("pion nie mo¿e wyjœæ poza planszê");
				break;
				}
			
		red.pawn[1].movePawn(scoreDice);
		board.setScore(red.getNumber(), red.pawn[1].getPosition());
		
		System.out.println("nr rzutu kostk¹: " + i);
		System.out.println("wynik rzutu kostk¹: " + scoreDice);
		System.out.println("Pozycja pionu " + ": " + red.pawn[1].getPosition());
		System.out.println(board.getScore(red.getNumber()));
		}
		
		System.out.println("pozycja " +red.getColor() + ": "  + red.pawn[1].getPosition());
		*/
		
		//new StartMenu();
		//new MainWindow();
		
		

	}

	public Ludo() {
		
		for (int i=0;i<4;i++) {
			player[i]=new Player();
		}
		new StartMenu();
	};
	
	
	
	
	


}
