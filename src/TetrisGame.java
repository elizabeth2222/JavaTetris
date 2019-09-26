import java.util.Scanner;

public class TetrisGame {
    public Grid[][] board;
    public Grid[][] prepArea;
    public Shape currentShape;
    
    public int move;
    
    public boolean gameOver;    
    
    
    public TetrisGame(int row, int col) {
	
	prepArea = new Grid[4][col];
	for (int i = 0; i < prepArea.length; i ++) {
	    for (int j = 0; j < prepArea[0].length; j++) {
		prepArea[i][j] = new Grid(" ");
	    }
	}
	
	board = new Grid[row][col];
	for (int i = 0; i < board.length; i ++) {
	    for (int j = 0; j < board[0].length; j++) {
		board[i][j] = new Grid("_");
	    }
	}
	
	move = 0;
	
	gameOver = false;
	currentShape = new Shape((int)(Math.random() * 6), new Vector2(0,col/2));
    }
    
    public void RunGame() {
	while(gameOver == false) {
	    Scanner s = new Scanner(System.in);
	    System.out.println("Please input your move:\n1 for left, 3 for right\n2 for down.");
	    move = s.nextInt();
	    UpdateGame(move);
	    PrintGame();
	}
    }
    
    public void UpdateGame(int move) {

	if (move != 0) {
	    refreshBoard();
	    
	    currentShape.setUnitsPos(move);

	    Vector2[] unitsPos = currentShape.getUnitsPos();
	    for (int i = 0; i < unitsPos.length; i++) {
		int x = unitsPos[i].x;
		int y = unitsPos[i].y;

		board[x][y].setColor(currentShape.units[i].color);
	    }
	}
    }
    
    public void refreshBoard() {
	for (int i = 0; i < board.length; i ++) {
	    for (int j = 0; j < board[0].length; j++) {
		board[i][j].setColor(0);
	    }
	}
    }
    
    public void PrintPrepArea() {
	
	Vector2[] unitsPos = currentShape.getUnitsPos();
	
	for (int i = 0; i < unitsPos.length; i++) {
	    int x = unitsPos[i].x;
	    int y = unitsPos[i].y;

	    prepArea[x][y].setColor(currentShape.units[i].color);
	    //System.out.print(x + ", " + y + " " + prepArea[x][y].color);
	}
	
	for (int i = 0; i < prepArea.length; i ++) {
	    //System.out.print(i+" ");
	    for (int j = 0; j < prepArea[0].length; j++) {
		System.out.print(prepArea[i][j]);
	    }
	    System.out.println("");
	}
    }
    
    public void PrintGame() {

	for (int i = 0; i < board.length; i ++) {
	    System.out.print(i+" ");
	    for (int j = 0; j < board[0].length; j++) {
		System.out.print(board[i][j]);
	    }
	    System.out.println("");
	}
	System.out.println("\n\n");
    }
    
    public static void main(String[] args) {
	TetrisGame tt = new TetrisGame(12,10);
	tt.PrintPrepArea();
	tt.PrintGame();
	tt.RunGame();
    }
}
