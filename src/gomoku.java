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

public class gomoku implements ActionListener 
{

	
	JFrame frame = new JFrame();
	JButton[][] button = new JButton[3][3];
	int[][] board = new int[3][3];
	final int BLANK = 0; 
	final int X_MOVE = 1; 
	final int O_MOVE = 2; 
	final int X_TURN = 0; 
	final int O_TURN = 1; 
	int turn = X_TURN; 
	Container center = new Container();
	JLabel xname = new JLabel("X wins: 0");
	JLabel oname = new JLabel("O wins: 0");
	Container north = new Container();
	JButton xChangeName = new JButton("change x name");
	JButton oChangeName = new JButton("change o name");
	JTextField xChangeField	= new JTextField();
	JTextField oChangeField	= new JTextField();
	String xPlayerName = "x";
	String oPlayerName = "o";
	int xwins = 0;
	int owins = 0;	
	
	public gomoku()	
	{
		frame.setSize(600,600);
		//center container
		frame.setLayout(new BorderLayout());
		center.setLayout(new GridLayout(3,3));
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
		north.setLayout(new GridLayout(3,2));	
		north.add(xname);
		north.add(oname);
		north.add(xChangeName);
		xChangeName.addActionListener(this);
		north.add(oChangeName);
		oChangeName.addActionListener(this);
		north.add(xChangeField);
		north.add(oChangeField);
		frame.add(north, BorderLayout.NORTH);
		
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
			for (int j = 0; j < button[0].length; j++) 
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
							button[0][0].setEnabled(true);
							button[0][1].setEnabled(true);
							button[0][2].setEnabled(true);
							button[1][0].setEnabled(true);
							button[1][1].setEnabled(true);
							button[1][2].setEnabled(true);
							button[2][0].setEnabled(true);
							button[2][1].setEnabled(true);
							button[2][2].setEnabled(true);
						}
						else
						{
							if (checkWin(X_MOVE) == true)
							{
								//xwins yay
								xwins++;
								xname.setText(xPlayerName + " wins: " + xwins);
								clearBoard();
								button[0][0].setEnabled(true);
								button[0][1].setEnabled(true);
								button[0][2].setEnabled(true);
								button[1][0].setEnabled(true);
								button[1][1].setEnabled(true);
								button[1][2].setEnabled(true);
								button[2][0].setEnabled(true);
								button[2][1].setEnabled(true);
								button[2][2].setEnabled(true);
							}
							else if (checkWin(O_MOVE) == true)
							{
								//o wins yay
								owins++;
								oname.setText(oPlayerName + " wins: " + owins);
								clearBoard();
								button[0][0].setEnabled(true);
								button[0][1].setEnabled(true);
								button[0][2].setEnabled(true);
								button[1][0].setEnabled(true);
								button[1][1].setEnabled(true);
								button[1][2].setEnabled(true);
								button[2][0].setEnabled(true);
								button[2][1].setEnabled(true);
								button[2][2].setEnabled(true);
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
			else if (event.getSource().equals(oChangeName) == true)
			{
				oPlayerName = oChangeField.getText();
				oname.setText(oPlayerName + " wins: " + owins);
			}
		}
	}
	
	public boolean checkWin(int player) //goes through and checks every win combination
	{
		if (board[0][0] == player && board[0][1] == player && board[0][2] == player)
		{
			return true;
		}
		if (board[1][0] == player && board[1][1] == player && board[1][2] == player)
		{
			return true;
		}
		if (board[2][0] == player && board[2][1] == player && board[2][2] == player)
		{
			return true;
		} //check rows
		if (board[0][0] == player && board[1][0] == player && board[2][0] == player)
		{
			return true;
		}
		if (board[0][1] == player && board[1][1] == player && board[2][1] == player)
		{
			return true;
		}
		if (board[0][2] == player && board[1][2] == player && board[2][2] == player)
		{
			return true;
		} //check columns
		if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
		{
			return true;
		}
		if (board[2][0] == player && board[1][1] == player && board[0][2] == player)
		{
			return true;
		} //check diag
		return false;
	}
	public boolean checkTie()  //checks if every spot on the board is filled and then determines it's a tie
	{
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
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
		for (int a = 0; a < board.length; a++) {
			for (int b = 0; b < board[0].length; b++) {
				board[a][b] = BLANK;
				button[a][b].setText("");
				
			}
			
		}
			turn = X_TURN;
	}
	

}