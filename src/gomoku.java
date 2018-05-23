/* Create gomoku
 * Author: Cameron Voigt & Jacob Vilevac
 * Date: 10/12/2017
 */


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
	checks check = new checks();
	
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
							try {
								Image Black_Piece = ImageIO.read(new File("Black_Piece.JPG"));
								current.setIcon(new ImageIcon(Black_Piece));
							}
							catch (Exception ex)
							{
								ex.printStackTrace();
							}
							// current.setText("X");
							current.setEnabled(false);
							board[j][i] = X_MOVE;
							turn = O_TURN;
						}
						else
						{
							try {
								Image White_Piece = ImageIO.read(new File("White_Piece.JPG"));
								current.setIcon(new ImageIcon(White_Piece));
							}
							catch (Exception ex)
							{
								ex.printStackTrace();
							}
							//current.setText("O");
							current.setEnabled(false);
							board[j][i] = O_MOVE;
							turn = X_TURN;
						}
						if (check.checkTie(board) == true)
						{
							clearBoard();
						}
						else
						{
							if (check.checkWin(board, X_MOVE, j, i) == true)
							{
								//xwins yay
								xwins++;
								xname.setText(xPlayerName + " wins: " + xwins);
								clearBoard();
							}
							else if (check.checkWin(board, O_MOVE, j, i) == true)
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
	
	public void clearBoard() //clears the board of every move
	{
		for (int a = 0; a < board.length; a++) 
		{
			for (int b = 0; b < board[0].length; b++) 
			{
				board[a][b] = BLANK; //makes the board blank
				button[a][b].setEnabled(true); //enable all buttons
				button[a][b].setText(""); //gets rid of x and o text
				button[a][b].setIcon(null);
			}
			
		}
		turn = X_TURN; //its X's turn
	}

	

}