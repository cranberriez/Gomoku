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
	final int B_MOVE = 1;
	final int W_MOVE = 2;

	public boolean checkWin(int[][] board, int player, int x, int y) //goes through and checks every win combination
	{
		/*
		 * Check what's nearby
		 * if there is a piece adjacent
		 * follow the path and see if there is 5 in a row
		 * check both directions and add
		 */
		//--------------------------------------------------------------------HOROZONTAL---------------------------------------
		int total = 1;

		if (x > 0 && board[x-1][y] == player) //left 1
		{
			total++;
			if (x > 1 && board[x-2][y] == player) //left 2
			{
				total++;
				if (x > 2 && board[x-3][y] == player) //left 3
				{
					total++;
					if (x > 3 && board[x-4][y] == player) //left 4
					{
						total++;
					}
				}
			}
		}

		if (x < 14 && board[x+1][y] == player) //right 1
		{
			total++;
			if (x < 13 && board[x+2][y] == player) //right 2
			{
				total++;
				if (x < 12 && board[x+3][y] == player) //right 3
				{
					total++;
					if (x < 11 && board[x+4][y] == player) //right 4
					{
						total++;
					}
				}
			}
		}

		if (total >= 5) //if there is 5 in a row return true
		{
			return true;
		}

		//----------------------------------------------------------------------VERTICAL----------------------------------------
		total = 1;
		if (y > 0 && board[x][y-1] == player)  //down
		{
			total++;
			if (y > 1 && board[x][y-2] == player) 
			{
				total++;
				if (y > 2 && board[x][y-3] == player) 
				{
					total++;
					if (y > 3 && board[x][y-4] == player) 
					{
						total++;
					}
				}
			}
		}

		if (y < 14 && board[x][y+1] == player)
		{
			total++;
			if (y < 13 && board[x][y+2] == player) 
			{
				total++;
				if (y < 12 && board[x][y+3] == player) 
				{
					total++;
					if (y < 11 && board[x][y+4] == player) 
					{
						total++;
					}
				}
			}
		}

		if (total >= 5)
		{
			return true;
		}

		//-------------------------------------------------------------------DIAGNOL \--------------------------------------------
		total = 1;
		if (x > 0 && y > 0 && board[x-1][y-1] == player) 
		{
			total++;
			if (x > 1 && y > 1 && board[x-2][y-2] == player) 
			{
				total++;
				if (x > 2 && y > 2 && board[x-3][y-3] == player) 
				{
					total++;
					if (x > 3 && y > 3 && board[x-4][y-4] == player) 
					{
						total++;
					}
				}
			}
		}

		if (x < 14 && y < 14 && board[x+1][y+1] == player) 
		{
			total++;
			if (x < 13 && y < 13 && board[x+2][y+2] == player) 
			{
				total++;
				if (x < 12 && y < 12 && board[x+3][y+3] == player) 
				{
					total++;
					if (x < 11 && y < 11 && board[x+4][y+4] == player)
					{
						total++;
					}
				}
			}
		}

		if (total >= 5)
		{
			return true;
		}
		//--------------------------------------------------------------DIAGNOL /--------------------------------------------------------
		total = 1;
		if (x < 14 && y > 0 && board[x+1][y-1] == player) 
		{
			total++;
			if (x < 13 && y > 1 && board[x+2][y-2] == player) 
			{
				total++;
				if (x < 12 && y > 2 && board[x+3][y-3] == player) 
				{
					total++;
					if (x < 11 && y > 3 && board[x+4][y-4] == player) 
					{
						total++;
					}
				}
			}
		}

		if (x > 0 && y < 14 && board[x-1][y+1] == player) 
		{
			total++;
			if (x > 1 && y < 13 && board[x-2][y+2] == player) 
			{
				total++;
				if (x > 2 && y < 12 && board[x-3][y+3] == player) 
				{
					total++;
					if (x > 3 && y < 11 && board[x-4][y+4] == player) 
					{
						total++;
					}
				}
			}
		}

		if (total >= 5)
		{
			return true;
		}

		return false;
	}

	public boolean checkTie(int[][] board)  //checks if every spot on the board is filled and then determines it's a tie
	{
		for (int row = 0; row < board.length; row++)
		{
			for (int column = 0; column < board[0].length; column++)
			{
				if (board[row][column] == BLANK)
				{
					return false;
				}
			}
		}
		System.out.println("TIE");
		return true;
	}

}
