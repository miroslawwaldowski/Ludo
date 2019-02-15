import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class DiceImage {

	public static Image DiceIcon (Color c, byte value) {
		final int SIZE = 4;
		BufferedImage bufferedImage = new BufferedImage(SIZE*13, SIZE*13,BufferedImage.TYPE_4BYTE_ABGR );
		Graphics g = bufferedImage.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, SIZE*13, SIZE*13);
		g.setColor(c);
		switch (value) {
		case 1:
			g.fillOval(SIZE*5,SIZE*5,SIZE*3,SIZE*3);
			break;
		case 2:
			g.fillOval(SIZE*9,SIZE,SIZE*3,SIZE*3);
			g.fillOval(SIZE-1,SIZE*9-1,SIZE*3,SIZE*3);
			break;
		case 3:
			g.fillOval(SIZE*9,SIZE,SIZE*3,SIZE*3);
			g.fillOval(SIZE,SIZE*9,SIZE*3,SIZE*3);
			g.fillOval(SIZE*5,SIZE*5,SIZE*3,SIZE*3);
			break;
		case 4:
			g.fillOval(SIZE,SIZE,SIZE*3,SIZE*3);
			g.fillOval(SIZE*9,SIZE*9,SIZE*3,SIZE*3);
			g.fillOval(SIZE*9,SIZE,SIZE*3,SIZE*3);
			g.fillOval(SIZE,SIZE*9,SIZE*3,SIZE*3);
			break;
		case 5:
			g.fillOval(SIZE,SIZE,SIZE*3,SIZE*3);
			g.fillOval(SIZE*9,SIZE*9,SIZE*3,SIZE*3);
			g.fillOval(SIZE*9,SIZE,SIZE*3,SIZE*3);
			g.fillOval(SIZE,SIZE*9,SIZE*3,SIZE*3);
			g.fillOval(SIZE*5,SIZE*5,SIZE*3,SIZE*3);
			break;
		case 6:
			g.fillOval(SIZE,SIZE,SIZE*3,SIZE*3);
			g.fillOval(SIZE*9,SIZE*9,SIZE*3,SIZE*3);
			g.fillOval(SIZE*9,SIZE,SIZE*3,SIZE*3);
			g.fillOval(SIZE,SIZE*9,SIZE*3,SIZE*3);
			g.fillOval(SIZE,SIZE*5,SIZE*3,SIZE*3);
			g.fillOval(SIZE*9,SIZE*5,SIZE*3,SIZE*3);
			break;
		}
		return bufferedImage;
	}
	
}
