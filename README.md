# Gomoku
Gomoku is a game like tic-tac-toe played on a 15x15 grid. The goal of the game is to get five in a row. Once you've gotten five in a row you win the game. Pretty simple, right? Our game has you separated by the piece color: Black and White. You can reset the board and it keeps track of wins. It also highlights the winning row.

GUI

![gui](https://lh5.googleusercontent.com/VjN-Ho9_avfR0fA-omY8RG87Gdu3aWC8jjDd04nf5_WkPOw5l_RDKGCSf_u_2-X981vo-Ca2bVKX0YzdM-uK1by8_ZhCNgfAi8wOycq_p0gh7sFTeXCtzeCEapaplbemhubuhOVG)

We have a pretty simple board. On the bottom left is the black wins and on the bottom right is the white wins. The number updates with each win and will only be set to zero if you relaunch the game. You play pieces by clicking on the square you want to play.

If you click the “RESET BOARD” button you clear it of every piece. (The wins will stay even if you reset the board)

On a win, the winning row will be highlighted in blue and the rest of the board will be blacked out. Then you need to click reset in order to start the next match. After clicking reset the board will look the same as when you first launched the game. 


We have also included these headers incase you forget whats going on in the game.

From left to right: minimize, full screen, and exits the game.

Java symbol, no functionality.

What it looks like in your hotbar.

Strategy
	Try to get five in a row and if you can't, just click reset so the other person cant win. It's a really neat trick.

