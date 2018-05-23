import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

/*
 * 	class for the grid of the boar
 * 
 * 
 * 
 * 
 */


public class Board 
{
	//Variables and Objects
		Image White_Piece; //new image
		int x;
		int y;
	
	public Board()
	{	
		try
		{
			White_Piece = ImageIO.read(new File("asteroid.JPEG")); //sets the new image to the asteroid picture
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	public void paintMe(Graphics g)
	{
		g.drawImage(White_Piece, x, y, null);
	}
	
}
