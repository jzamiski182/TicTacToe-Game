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
        firstPlayer = gameOver = false;

        // initializing the game board to contain an
        // X at each position to start with, replace
        // the X with a blank space at the start of game
        for (int i = 0; i < BOARDSIZE; ++i)
            for (int j = 0; j < BOARDSIZE; ++j)
                board[i][j] = 'X';
    }

    public void play()
    {

    }

    private void printStatus(int status)
    {

    }

    private Status gameStatus()
    {
        // this return value is temporary, modify
        // when ready to implement function
        return Status.WIN;
    }

    public void printBoard()
    {
        final int column1 = 0;
        final int column2 = 1;

        System.out.println("___________ ___________ ___________");

        for (int i = 0; i < BOARDSIZE; ++i) {
            System.out.printf("%s\t\t %2s\t\t\t %2s\t\t %6s\n", "|", "|", "|", "|");

            for (int j = 0; j < BOARDSIZE; ++j) {
                if (j == column1)
                    System.out.printf("%s %4c %4s", "|", board[i][j], "|");
                else if (j == column2)
                    System.out.printf("%6c %5s", board[i][j], "|");
                else
                    System.out.printf("%7c %4s", board[i][j], "|");
            }

            System.out.println();
            System.out.printf("%s\t\t %2s\t\t\t %2s\t\t %6s\n", "|", "|", "|", "|");
            System.out.println("___________ ___________ ___________");
        }
    }

    private void printSymbol(int column, char value)
    {

    }

    private boolean validMove(int row, int column)
    {
        // this return value is temporary, modify
        // when ready to implement function
        return true;
    }
}
