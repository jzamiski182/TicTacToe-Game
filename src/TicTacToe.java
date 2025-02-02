import java.util.Scanner;

public class TicTacToe
{
    private final int BOARDSIZE = 3;
    private enum Status { WIN, DRAW, CONTINUE }
    private char[][] board;
    private boolean firstPlayer;
    private boolean gameOver;

    // default constructor
    public TicTacToe()
    {
        board = new char[BOARDSIZE][BOARDSIZE];
        firstPlayer = true;
        gameOver = false;

        // initializing the game board to contain an
        // X at each position to start with, replace
        // the X with a blank space at the start of game
        for (int i = 0; i < BOARDSIZE; ++i)
            for (int j = 0; j < BOARDSIZE; ++j)
                board[i][j] = ' ';
    }

    public void play()
    {
        Scanner scanner= new Scanner(System.in);
        while (!gameOver){
            printBoard();
            printStatus(firstPlayer ? 1 : 2);
            System.out.print("Enter row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0-2): ");
            int col = scanner.nextInt();

            if (validMove(row,col)){
                board[row][col]= firstPlayer ? 'X' : 'O';
                Status status = gameStatus();

                if (status == Status.WIN){
                    printBoard();
                    System.out.println("Player"+ (firstPlayer ? 1 : 2)+ " win!");
                    gameOver = true;
        
                }else if (status == Status.DRAW){
                    printBoard();
                    System.out.println("The game is a draw.");
                    gameOver = true;


                }else{
                    firstPlayer = !firstPlayer;
                }
            }else{
                System.out.println ("Invalid move, try again");
            }

        }

    }

    private void printStatus(int player){
        System.out.println("Player "+ player + " 's turn (" + (player == 1 ? 'X' : 'O')+ ")" );
    
    }
    

    private Status gameStatus(){
        // this return value is temporary, modify
        // when ready to implement function
        //check rows and colums
        for (int i=0; i < BOARDSIZE; i++ ){
            if ((board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) ||
            (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i])){
                return Status.WIN;
            }
        }

        //check diagnols
        if ((board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
        (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])){
            return Status.WIN;
        }

        //check for draw
        for (int i=0; i < BOARDSIZE; i++){
            for (int j=0; j < BOARDSIZE; j++){
                if (board[i][j]== ' '){
                    return Status.CONTINUE;
                }
            }
        }
        return Status.DRAW;
    }
        
    public void printBoard(){
        String border = "-------------------"; 

    System.out.println(border); // Print the top border

    for (int i = 0; i < BOARDSIZE; i++) {
        
        for (int row = 0; row < 3; row++) { 
            System.out.print("|"); 

            for (int j = 0; j < BOARDSIZE; j++) {
                if (row == 1) { 
                    System.out.printf("  %c  ", board[i][j]); 
                } else {
                    System.out.print("     "); 
                }
                System.out.print("|"); 
            }

            System.out.println(); // Move to the next line
        }

        System.out.println(border); // Print the border after each row
    }
    }
    
    private boolean validMove(int row, int column)
    {
        return row >= 0 && row < BOARDSIZE && column >=0 && column < BOARDSIZE && board[row][column]==' ';
        
    }
}
