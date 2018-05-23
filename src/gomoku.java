/* Create gomoku
 * Author: Cameron Voigt & Jacob Vilevac
 * Date: 10/12/2017
 */


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sun.prism.paint.Color;

public class gomoku implements ActionListener 
{
	JFrame frame = new JFrame();
	JButton[][] button = new JButton[15][15];
	int[][] board = new int[15][15];
	final int BLANK = 0; 
	final int X_MOVE = 1; 
	final int O_MOVE = 2; 
	final int X_TURN = 0; 
	final int O_TURN = 1; 
	int turn = X_TURN; 
	Container center = new Container();
	JLabel xname = new JLabel("X wins: 0");
	JLabel oname = new JLabel("O wins: 0");
	Container south = new Container();
	JButton xChangeName = new JButton("change x name");
	JButton oChangeName = new JButton("change o name");
	JButton reset = new JButton("RESET");
	JTextField xChangeField	= new JTextField();
	JTextField oChangeField	= new JTextField();
	String xPlayerName = "x";
	String oPlayerName = "o";
	int xwins = 0;
	int owins = 0;	
	
	public gomoku()	
	{
		frame.setSize(1000,1000);
		//center container
		frame.setLayout(new BorderLayout());
		center.setLayout(new GridLayout(15,15));
		for (int i = 0; i < button.length; i++) 
		{
			for (int j = 0; j < button[0].length; j++)  //J is column I is row
			{
				button[j][i] = new JButton("");
				center.add(button[j][i]);
				button[j][i].addActionListener(this);
			}
		}
		frame.add(center, BorderLayout.CENTER);	
		//north center
		south.setLayout(new GridLayout(1,3));	
		south.add(xname);
		south.add(reset);
		reset.addActionListener(this);
		south.add(oname);
		//south.add(xChangeName);
		//xChangeName.addActionListener(this);
		
		//south.add(oChangeName);
		//oChangeName.addActionListener(this);
		//south.add(xChangeField);
		//south.add(oChangeField);
		frame.add(south, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
public static void main(String[] args)
{
	new gomoku();
}
	@Override
	public void actionPerformed(ActionEvent event) //if a button is pressed do all this stuff
	{
		JButton current;
		boolean gridbutton = false;
		for (int i = 0; i < button.length; i++) 
		{
			for (int j = 0; j < button[i].length; j++) 
			{
				if (event.getSource().equals(button[j][i]))
				{
					current = button[j][i];
					if (board[j][i] == BLANK)
					{
						if(turn == X_TURN)
						{
							current.setText("X");
							current.setEnabled(false);
							board[j][i] = X_MOVE;
							turn = O_TURN;
						}
						else
						{
							current.setText("O");
							current.setEnabled(false);
							board[j][i] = O_MOVE;
							turn = X_TURN;
						}
						if (checkTie() == true)
						{
							clearBoard();
						}
						else
						{
							if (checkWin(X_MOVE, j, i) == true)
							{
								//xwins yay
								xwins++;
								xname.setText(xPlayerName + " wins: " + xwins);
								clearBoard();
							}
							else if (checkWin(O_MOVE, j, i) == true)
							{
								//o wins yay
								owins++;
								oname.setText(oPlayerName + " wins: " + owins);
								clearBoard();
							}
						}	
					}
				}
			}
		}
		
		if (gridbutton == false)
		{
			if (event.getSource().equals(xChangeName) == true)
			{
				xPlayerName = xChangeField.getText();
				xname.setText(xPlayerName + " wins: " + xwins);
			}
			else if (event.getSource().equals(oChangeName) == true) //if you click on change name
			{
				oPlayerName = oChangeField.getText();
				oname.setText(oPlayerName + " wins: " + owins);
			}
			else if (event.getSource().equals(reset)) //if you click reset
			{
				clearBoard(); //clears the board and resets the buttons
			}
		}
	}
	
	public boolean checkWin(int player, int x, int y) //goes through and checks every win combination
	{
		//look where the player placed the piece and check for a win
		int total = 1;
		System.out.println(x + " " + y);
		/*
		 * Check what's nearby
		 * if there is a piece adjacent
		 * follow the path and see if there is 5 in a row
		 * check both directions and add
		 */
		//--------------------------------------------------------------------HOROZONTAL---------------------------------------
		if (x > 0 && board[x-1][y] == player) //to the left of the piece
		{
			total++;
		}
		if (x > 1 && board[x-2][y] == player && x > 1) //to the left of the piece
		{
			total++;
		}
		if (x > 2 && board[x-3][y] == player) //to the left of the piece
		{
			total++;
		}
		if (x > 3 && board[x-4][y] == player && x > 3) //to the left of the piece
		{
			total++;
		}
		if (x < 14 && board[x+1][y] == player && x < 14) //to the right of the piece
		{
			total++;
		}
		if (x < 13 && board[x+2][y] == player) //to the right of the piece
		{
			total++;
		}
		if (x < 12 && board[x+3][y] == player) //to the right of the piece
		{
			total++;
		}
		if (x < 11 && board[x+4][y] == player) //to the right of the piece
		{
			total++;
		}
		if (total >= 5)
		{
			return true;
		}
		
		//----------------------------------------------------------------------VERTICAL----------------------------------------
		total = 1;
		if (y > 0 && board[x][y-1] == player) //to the left of the piece
		{
			total++;
		}
		if (y > 1 && board[x][y-2] == player && x > 1) //to the left of the piece
		{
			total++;
		}
		if (y > 2 && board[x][y-3] == player) //to the left of the piece
		{
			total++;
		}
		if (y > 3 && board[x][y-4] == player && x > 3) //to the left of the piece
		{
			total++;
			
		}
		if (y < 14 && board[x][y+1] == player && x < 14) //to the right of the piece
		{
			total++;
		}
		if (y < 13 && board[x][y+2] == player) //to the right of the piece
		{
			total++;
		}
		if (y < 12 && board[x][y+3] == player) //to the right of the piece
		{
			total++;
		}
		if (y < 11 && board[x][y+4] == player) //to the right of the piece
		{
			total++;
		}
		if (total >= 5)
		{
			return true;
		}
		
		//-------------------------------------------------------------------DIAGNOL \--------------------------------------------
		total = 1;
		if (x > 0 && y > 0 && board[x-1][y-1] == player) //to the left of the piece
		{
			total++;
		}
		if (x > 1 && y > 1 && board[x-2][y-2] == player && x > 1) //to the left of the piece
		{
			total++;
		}
		if (x > 2 && y > 2 && board[x-3][y-3] == player) //to the left of the piece
		{
			total++;
		}
		if (x > 3 && y > 3 && board[x-4][y-4] == player && x > 3) //to the left of the piece
		{
			total++;
		}
		if (x < 14 && y < 14 && board[x+1][y+1] == player && x < 14) //to the right of the piece
		{
			total++;
			
		}
		if (x < 13 && y < 13 && board[x+2][y+2] == player) //to the right of the piece
		{
			total++;
		}
		if (x < 12 && y < 12 && board[x+3][y+3] == player) //to the right of the piece
		{
			total++;
		}
		if (x < 11 && y < 11 && board[x+4][y+4] == player) //to the right of the piece
		{
			total++;
		}
		if (total >= 5)
		{
			return true;
		}
		//--------------------------------------------------------------DIAGNOL /--------------------------------------------------------
		total = 1;
		if (x < 14 && y > 0 && board[x+1][y-1] == player) //to the left of the piece
		{
			total++;
		}
		if (x < 13 && y > 1 && board[x+2][y-2] == player && x > 1) //to the left of the piece
		{
			total++;
		}
		if (x < 12 && y > 2 && board[x+3][y-3] == player) //to the left of the piece
		{
			total++;
		}
		if (x < 11 && y > 3 && board[x+4][y-4] == player && x > 3) //to the left of the piece
		{
			total++;
		}
		if (x > 0 && y < 14 && board[x-1][y+1] == player && x < 14) //to the right of the piece
		{
			total++;
		}
		if (x > 1 && y < 13 && board[x-2][y+2] == player) //to the right of the piece
		{
			total++;
		}
		if (x > 2 && y < 12 && board[x-3][y+3] == player) //to the right of the piece
		{
			total++;
		}
		if (x > 3 && y < 11 && board[x-4][y+4] == player) //to the right of the piece
		{
			total++;
		}
		if (total >= 5)
		{
			return true;
		}
		return false;
	}
	
	public boolean checkTie()  //checks if every spot on the board is filled and then determines it's a tie
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
		return true;
	}
	public void clearBoard() //clears the board of every move
	{
		for (int a = 0; a < board.length; a++) 
		{
			for (int b = 0; b < board[0].length; b++) 
			{
				board[a][b] = BLANK; //makes the board blank
				button[a][b].setEnabled(true); //enable all buttons
				button[a][b].setText(""); //gets rid of x and o text
			}
			
		}
		turn = X_TURN; //its X's turn
	}

	

}