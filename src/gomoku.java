/*  Create gomoku
 *  Author: Cameron Voigt & Jacob Vilevac
 *  Date: 5/30/2018
 * 
 *  Gomoku is like tic tac toe except its on a much larger board (15x15)
 *  the goal of this program is to offer you a simple version of gomoku that you
 *  can play with someone else on the same computer.
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class gomoku implements ActionListener
{
	//Variables and Objects
	JFrame frame = new JFrame();
	static JButton[][] button = new JButton[15][15];
	int[][] board = new int[15][15];
	final int BLANK = 0;
	final int B_MOVE = 1;
	final int W_MOVE = 2;
	final int B_TURN = 0;
	final int W_TURN = 1;
	int turn = B_TURN;
	Container center = new Container();
	JLabel bname = new JLabel("Black wins: 0");
	JLabel wname = new JLabel("White wins: 0");
	static JLabel alert = new JLabel("Black's Turn");
	Container south = new Container();
	Container north = new Container();
	JButton reset = new JButton("RESET BOARD");
	String bPlayerName = "Black";
	String wPlayerName = "White";
	int bwins = 0;
	int wwins = 0;
	checks check = new checks(); //the check class used for wins and ties

	//Constructor
	public gomoku()
	{
		/*
		 *  Create the frame and set up all of the containers
		 *  South has: Black wins, RESET, and White wins
		 * 	Center has: the 15x15 grid
		 */
		frame.setSize(1000,1000);
		//center container
		frame.setLayout(new BorderLayout());
		center.setLayout(new GridLayout(15,15));
		for (int x = 0; x < button.length; x++)
		{
			for (int y = 0; y < button[0].length; y++)  //J is column I is row
			{
				button[x][y] = new JButton("");
				button[x][y].setBackground(Color.WHITE);
				button[x][y].setBorder(BorderFactory.createLineBorder(Color.black, 1));
				center.add(button[x][y]);
				button[x][y].addActionListener(this);
			}
		}
		frame.add(center, BorderLayout.CENTER);
		//north center
		south.setLayout(new GridLayout(1,3));
		south.add(bname);
		bname.setHorizontalAlignment(JLabel.CENTER);
		south.add(reset);
		reset.addActionListener(this);
		south.add(wname);
		wname.setHorizontalAlignment(JLabel.CENTER);
		frame.add(south, BorderLayout.SOUTH);
		
		north.setLayout(new BorderLayout());
		north.add(alert);
		alert.setHorizontalAlignment(JLabel.CENTER);
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
		for (int x = 0; x < button.length; x++)
		{
			for (int y = 0; y < button[x].length; y++)
			{
				if (event.getSource().equals(button[y][x]))
				{
					current = button[y][x];
					if (board[y][x] == BLANK) //if the current button where you played is blank
					{
						if(turn == B_TURN) //if its blacks turn
						{
							try //set black piece to the image of it 
							{ 
								Image Black_Piece = ImageIO.read(new File("Black_Piece.JPG"));
								ImageIcon B_Icon = new ImageIcon(Black_Piece);
								current.setIcon(B_Icon);
								current.setDisabledIcon(B_Icon);
							}
							catch (Exception ex)
							{
								ex.printStackTrace();
							}
							current.setEnabled(false);
							board[y][x] = B_MOVE; //sets the board to Blacks move
							if (check.checkWin(board, B_MOVE, y, x) == true) //if check win for black is true
							{
								//bwins yay
								bwins++; //add 1 win to black
								bname.setText(bPlayerName + " wins: " + bwins); //changes the text of wins
								alert.setText("! ! ! BLACK WIN ! ! !");
							}
							else {
								alert.setText("White's Turn");
								turn = W_TURN; //set turn to white 
							}
						}
						else
						{
							try //sets the white image to the white piece
							{
								Image White_Piece = ImageIO.read(new File("White_Piece.JPG"));
								ImageIcon W_Icon = new ImageIcon(White_Piece);
								current.setIcon(W_Icon);
								current.setDisabledIcon(W_Icon);
							}
							catch (Exception ex)
							{
								ex.printStackTrace();
							}
							current.setEnabled(false);
							board[y][x] = W_MOVE; //the board is set to whites move
							if (check.checkWin(board, W_MOVE, y, x) == true) //if checkwin for white equals true
							{
								//white wins yay
								wwins++; //add a win to white
								wname.setText(wPlayerName + " wins: " + wwins); //update the text for win number
								alert.setText("! ! ! WHITE WIN ! ! !");
							}
							else {
								alert.setText("Black's Turn");
								turn = B_TURN; //set turn to black
							}
							
						}
						if (check.checkTie(board) == true) //if check tie is true
						{
							clearBoard(); //clear the board
						}
					}
				}
			}
		}

		if (gridbutton == false)
		{
			if (event.getSource().equals(reset)) //if you click reset
			{
				clearBoard(); //clears the board and resets the buttons
			}
		}
	}

	public void clearBoard() //clears the board of every move
	{
		for (int x = 0; x < board.length; x++)
		{
			for (int y = 0; y < board[0].length; y++)				
			{
				board[x][y] = BLANK; //makes the board blank
				button[x][y].setEnabled(true); //enable all buttons
				button[x][y].setText(""); //gets rid of black and white text
				button[x][y].setIcon(null);
				button[x][y].setBackground(Color.white);
				button[x][y].setBorder(BorderFactory.createLineBorder(Color.black, 1));
			}

		}
		turn = B_TURN; //its B's turn
	}



}
