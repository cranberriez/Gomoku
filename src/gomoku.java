/* Create gomoku
 * Author: Cameron Voigt & Jacob Vilevac
 * Date: 5/25/2018
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
	JButton[][] button = new JButton[15][15];
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

	Container south = new Container();
	JButton reset = new JButton("RESET");
	String bPlayerName = "Black";
	String wPlayerName = "White";
	int bwins = 0;
	int wwins = 0;
	checks check = new checks();

	//Constructor
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
				button[j][i].setBackground(Color.WHITE);
				center.add(button[j][i]);
				button[j][i].addActionListener(this);
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
						if(turn == B_TURN)
						{
							try {
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
							board[j][i] = B_MOVE;
							if (check.checkWin(board, B_MOVE, j, i) == true)
							{
								//bwins yay
								bwins++;
								bname.setText(bPlayerName + " wins: " + bwins);
								//clearBoard();
								System.out.println("Black WIN");
							}
							turn = W_TURN;
						}
						else
						{
							try {
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
							board[j][i] = W_MOVE;
							if (check.checkWin(board, W_MOVE, j, i) == true)
							{
								//white wins yay
								wwins++;
								wname.setText(wPlayerName + " wins: " + wwins);
								//clearBoard();
								System.out.println("White WIN");
							}
							turn = B_TURN;
						}
						if (check.checkTie(board) == true)
						{
							clearBoard();
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
		for (int a = 0; a < board.length; a++)
		{
			for (int b = 0; b < board[0].length; b++)
			{
				board[a][b] = BLANK; //makes the board blank
				button[a][b].setEnabled(true); //enable all buttons
				button[a][b].setText(""); //gets rid of black and white text
				button[a][b].setIcon(null);
			}

		}
		turn = B_TURN; //its B's turn
	}



}
