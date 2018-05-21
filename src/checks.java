/*
 *  Class for checking wins and ties
 * 
 * 
 * 
 * 
 */


public class checks 
{
	final int BLANK = 0; 
	final int X_MOVE = 1; 
	final int O_MOVE = 2; 
	
	public checks()
	{
		
	}
	
	
//	public boolean checkWin(int[][] board, int player, int x, int y) //goes through and checks every win combination
//	{
//		//look where the player placed the piece and check for a win
//		int total = 1;
//		System.out.println(x + " " + y);
//		if (player == X_MOVE)
//		{
//			/*
//			 * Check what's nearby
//			 * if there is a piece adjacent
//			 * follow the path and see if there is 5 in a row
//			 * check both directions and add
//			 */
//			//--------------------------------------------------------------------HOROZONTAL---------------------------------------
//			if (x > 0 && board[x-1][y] == player) //to the left of the piece
//			{
//				total++;
//			
//			}
//			if (x > 1 && board[x-2][y] == player && x > 1) //to the left of the piece
//			{
//				total++;
//				
//			}
//			if (x > 2 && board[x-3][y] == player) //to the left of the piece
//			{
//				total++;
//				
//			}
//			if (x > 3 && board[x-4][y] == player && x > 3) //to the left of the piece
//			{
//				total++;
//				
//			}
//			if (x < 14 && board[x+1][y] == player && x < 14) //to the right of the piece
//			{
//				total++;
//				
//			}
//			if (x < 13 && board[x+2][y] == player) //to the right of the piece
//			{
//				total++;
//				
//			}
//			if (x < 12 && board[x+3][y] == player) //to the right of the piece
//			{
//				total++;
//				
//			}
//			if (x < 11 && board[x+4][y] == player) //to the right of the piece
//			{
//				total++;
//				
//			}
//			if (total >= 5)
//			{
//				return true;
//			}
//			
//			//----------------------------------------------------------------------VERTICAL----------------------------------------
//			total = 0;
//			if (y > 0 && board[x][y-1] == player) //to the left of the piece
//			{
//				total++;
//				
//			}
//			if (y > 1 && board[x][y-2] == player && x > 1) //to the left of the piece
//			{
//				total++;
//				
//			}
//			if (y > 2 && board[x][y-3] == player) //to the left of the piece
//			{
//				total++;
//				
//			}
//			if (y > 3 && board[x][y-4] == player && x > 3) //to the left of the piece
//			{
//				total++;
//				
//			}
//			if (y < 14 && board[x][y+1] == player && x < 14) //to the right of the piece
//			{
//				total++;
//				
//			}
//			if (y < 13 && board[x][y+2] == player) //to the right of the piece
//			{
//				total++;
//				
//			}
//			if (y < 12 && board[x][y+3] == player) //to the right of the piece
//			{
//				total++;
//				
//			}
//			if (y < 11 && board[x][y+4] == player) //to the right of the piece
//			{
//				total++;
//				
//			}
//			if (total >= 5)
//			{
//				return true;
//			}
//			
//			//-------------------------------------------------------------------DIAGNOL \--------------------------------------------
//			total = 1;
//			if (x > 0 && y > 0 && board[x-1][y-1] == player) //to the left of the piece
//			{
//				total++;
//			}
//			if (x > 1 && y > 1 && board[x-2][y-2] == player && x > 1) //to the left of the piece
//			{
//				total++;
//			}
//			if (x > 2 && y > 2 && board[x-3][y-3] == player) //to the left of the piece
//			{
//				total++;
//			}
//			if (x > 3 && y > 3 && board[x-4][y-4] == player && x > 3) //to the left of the piece
//			{
//				total++;
//			}
//			if (x < 14 && y < 14 && board[x+1][y+1] == player && x < 14) //to the right of the piece
//			{
//				total++;
//			}
//			if (x < 13 && y < 13 && board[x+2][y+2] == player) //to the right of the piece
//			{
//				total++;
//			}
//			if (x < 12 && y < 12 && board[x+3][y+3] == player) //to the right of the piece
//			{
//				total++;
//			}
//			if (x < 11 && y < 11 && board[x+4][y+4] == player) //to the right of the piece
//			{
//				total++;
//			}
//			if (total >= 5)
//			{
//				return true;
//			}
//			//--------------------------------------------------------------DIAGNOL /--------------------------------------------------------
//			total = 1;
//			if (x < 14 && y > 0 && board[x+1][y-1] == player) //to the left of the piece
//			{
//				total++;
//			}
//			if (x < 13 && y > 1 && board[x+2][y-2] == player && x > 1) //to the left of the piece
//			{
//				total++;
//			}
//			if (x < 12 && y > 2 && board[x+3][y-3] == player) //to the left of the piece
//			{
//				total++;
//			}
//			if (x < 11 && y > 3 && board[x+4][y-4] == player && x > 3) //to the left of the piece
//			{
//				total++;
//			}
//			if (x > 0 && y < 14 && board[x-1][y+1] == player && x < 14) //to the right of the piece
//			{
//				total++;
//			}
//			if (x > 1 && y < 13 && board[x-2][y+2] == player) //to the right of the piece
//			{
//				total++;
//			}
//			if (x > 2 && y < 12 && board[x-3][y+3] == player) //to the right of the piece
//			{
//				total++;
//			}
//			if (x > 3 && y < 11 && board[x-4][y+4] == player) //to the right of the piece
//			{
//				total++;
//			}
//			if (total >= 5)
//			{
//				return true;
//			}
//			
//			
//			
//		}
//		else if (player == O_MOVE)
//		{
//			return false;
//			
//			
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		return false;
//	}
	
}
