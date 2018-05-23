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
		Image White Piece; //new image
	
	public Board()
	{d
		try
		{
			myImage = ImageIO.read(new File("asteroid.png")); //sets the new image to the asteroid picture
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	}
	public void paintMe(Graphics g)
	{
		g.drawImage(myImage, x, y, null);
	}
	
}
