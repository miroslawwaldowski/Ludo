import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class PawnImage {

	public static Image PawnIcon (Color c) {
		BufferedImage bufferedImage = new BufferedImage(25, 25,BufferedImage.TYPE_4BYTE_ABGR );
		Graphics g = bufferedImage.getGraphics();
		g.setColor(Color.black);
		g.fillOval(0,0,24,24);
		g.setColor(Color.gray);
		g.fillOval(2,2,20,20);
		g.setColor(c);
		g.fillOval(4,4,16,16);
		
		return bufferedImage;
	}


}
