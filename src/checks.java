import java.awt.Color;

import javax.swing.BorderFactory;

/*
 *  Author: Cameron Voigt & Jacob Vilevac
 *  Date: 5/25/2018
 * 
 *  Class for checking wins and ties
 */


public class checks
{
	//Constants
	final int BLANK = 0;
	final int B_MOVE = 1;
	final int W_MOVE = 2;
	int[][] pieces = new int[15][15];

	public boolean checkWin(int[][] board, int player, int x, int y) //goes through and checks every win combination
	{
		/*
		 * Check what's nearby
		 * if there is a piece adjacent
		 * follow the path and see if there is 5 in a row
		 * check both directions and add
		 */
		//--------------------------------------------------------------------HOROZONTAL---------------------------------------
		pieces = new int[15][15];
		pieces[x][y] = 1;
		int total = 1; //count the piece you placed as 1
		if (x > 0 && board[x-1][y] == player) //left 1
		{
			total++;
			pieces[x-1][y] = 1;
			if (x > 1 && board[x-2][y] == player) //left 2
			{
				total++; //add one to the total
				pieces[x-2][y] = 1;
				if (x > 2 && board[x-3][y] == player) //left 3
				{
					total++; //add one to the total
					pieces[x-3][y] = 1;
					if (x > 3 && board[x-4][y] == player) //left 4
					{
						total++; //add one to the total
						pieces[x-4][y] = 1;
					}
				}
			}
		}
		
		if (x < 14 && board[x+1][y] == player) //right 1
		{
			total++; //add one to the total
			pieces[x+1][y] = 1;
			if (x < 13 && board[x+2][y] == player) //right 2
			{
				total++; //add one to the total
				pieces[x+2][y] = 1;
				if (x < 12 && board[x+3][y] == player) //right 3
				{
					total++; //add one to the total
					pieces[x+3][y] = 1;
					if (x < 11 && board[x+4][y] == player) //right 4
					{
						total++; //add one 1 the total
						pieces[x+4][y] = 1;
					}
				}
			}
		}

		if (total >= 5) //if there is 5 in a row return true
		{
			highlight(pieces);
			return true;
		}
		
		//----------------------------------------------------------------------VERTICAL----------------------------------------
		pieces = new int[15][15];
		pieces[x][y] = 1;
		total = 1; //count the piece you placed as 1
		if (y > 0 && board[x][y-1] == player) //up 1
		{
			total++; //add one to the total
			pieces[x][y-1] = player;
			if (y > 1 && board[x][y-2] == player) //up 2
			{
				total++; //add one to the total
				pieces[x][y-2] = player;
				if (y > 2 && board[x][y-3] == player) //up 3
				{
					total++; //add one to the total
					pieces[x][y-3] = player;
					if (y > 3 && board[x][y-4] == player) //up 4
					{
						total++;//add one to the total
						pieces[x][y-4] = player;
					}
				}
			}
		}

		if (y < 14 && board[x][y+1] == player) //down 1
		{
			total++; //add one to the total
			pieces[x][y+1] = player;
			if (y < 13 && board[x][y+2] == player) //down 2
			{
				total++; //add one to the total
				pieces[x][y+2] = player;
				if (y < 12 && board[x][y+3] == player) //down 3
				{
					total++; //add one to the total
					pieces[x][y+3] = player;
					if (y < 11 && board[x][y+4] == player) //down 4
					{
						total++; //add one to the total
						pieces[x][y+4] = player;
					}
				}
			}
		}

		if (total >= 5) //if theres 5 in a row return true
		{
			highlight(pieces);
			return true;
		}

		//-------------------------------------------------------------------DIAGNOL \--------------------------------------------
		pieces = new int[15][15];
		pieces[x][y] = 1;
		total = 1; //count the piece you placed as 1
		if (x > 0 && y > 0 && board[x-1][y-1] == player) //up left 1
		{
			total++; //add one to the total
			pieces[x-1][y-1] = player;
			if (x > 1 && y > 1 && board[x-2][y-2] == player) //up left 2
			{
				total++; //add one to the total
				pieces[x-2][y-2] = player;
				if (x > 2 && y > 2 && board[x-3][y-3] == player) //up left 3
				{
					total++; //add one to the total
					pieces[x-3][y-3] = player;
					if (x > 3 && y > 3 && board[x-4][y-4] == player) //up left 4 
					{
						total++; //add one to the total
						pieces[x-4][y-4] = player;
					}
				}
			}
		}

		if (x < 14 && y < 14 && board[x+1][y+1] == player) //down right 1
		{
			total++;
			pieces[x+1][y+1] = player;
			if (x < 13 && y < 13 && board[x+2][y+2] == player) //down right 2
			{
				total++; //add one to the total
				pieces[x+2][y+2] = player;
				if (x < 12 && y < 12 && board[x+3][y+3] == player) //down right 3
				{
					total++; //add one to the total
					pieces[x+3][y+3] = player;
					if (x < 11 && y < 11 && board[x+4][y+4] == player)//down right 4
					{
						total++; //add one to the total
						pieces[x+4][y+4] = player;
					}
				}
			}
		}

		if (total >= 5) //if theres 5 in a row return true
		{
			highlight(pieces);
			return true;
		}
		//--------------------------------------------------------------DIAGNOL /--------------------------------------------------------
		pieces = new int[15][15];
		pieces[x][y] = 1;
		total = 1; //count the piece you placed as 1
		if (x < 14 && y > 0 && board[x+1][y-1] == player) //up right 1
		{
			total++;
			pieces[x+1][y-1] = player;
			if (x < 13 && y > 1 && board[x+2][y-2] == player) //up right 2 
			{
				total++; //add one to the total
				pieces[x+2][y-2] = player;
				if (x < 12 && y > 2 && board[x+3][y-3] == player) //up right 3 
				{
					total++; //add one to the total
					pieces[x+3][y-3] = player;
					if (x < 11 && y > 3 && board[x+4][y-4] == player) //up right 4
					{
						total++; //add one to the total
						pieces[x+4][y-4] = player;
					}
				}
			}
		}

		if (x > 0 && y < 14 && board[x-1][y+1] == player) //down left 1
		{
			total++;
			pieces[x-1][y+1] = player;
			if (x > 1 && y < 13 && board[x-2][y+2] == player) //down left 2 
			{
				total++; //add one to the total
				pieces[x-2][y+2] = player;
				if (x > 2 && y < 12 && board[x-3][y+3] == player) //down left 3 
				{
					total++; //add one to the total
					pieces[x-3][y+3] = player;
					if (x > 3 && y < 11 && board[x-4][y+4] == player) //down left 4 
					{
						total++; //add one to the total
						pieces[x-4][y+4] = player;
					}
				}
			}
		}

		if (total >= 5) //if theres 5 in a row return true
		{
			highlight(pieces);
			return true;
		}

		return false;
	}

	private void highlight(int[][] pieces) {
		for (int x = 0; x < pieces.length; x++) {
			for (int y = 0; y < pieces[x].length; y++) {
				if (pieces[x][y] == 1) {
					System.out.println("Highlighting " + x + " " + y);
					gomoku.button[x][y].setBorder(BorderFactory.createLineBorder(Color.red, 5));
				}
			}
		}
	}

	public boolean checkTie(int[][] board)  //checks if every spot on the board is filled and then determines it's a tie
	{
		for (int row = 0; row < board.length; row++)
		{
			for (int column = 0; column < board[0].length; column++)
			{
				if (board[row][column] == BLANK) //if after checking the whole board theres a blank spot return false
				{
					return false;
				}
			}
		}
		System.out.println("TIE");
		return true; //if there are no blank spots return true
	}

}
