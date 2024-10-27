import java.util.Scanner;

class Main{
    public static Scanner myScanner = new Scanner(System.in);
    public static String[][] gameBoard = new String[][]{
            {"-", "-", "-"},
            {"-", "-", "-"},
            {"-", "-", "-"},
    };

    public static void main(String[] args) {
        displayBoard();
        int x = 1;
        String symbol = null;
        boolean run = true;
        int draw = 9;
        int currentPlayer = 1;

        while (run) {
            if (currentPlayer == 1) {
                System.out.print("Player 1 (X), make your move (enter row and column: 0, 1, or 2): ");
                symbol = "X";
            } else {
                System.out.print("Player 2 (O), make your move (enter row and column: 0, 1, or 2): ");
                symbol = "O";
            }

            if (controller(symbol)) {
                draw--;
                if (winChecker(gameBoard, symbol)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    run = false;
                } else if (draw == 0) {
                    System.out.println("Draw!");
                    run = false;
                } else {
                    if (currentPlayer == 1) {
                        currentPlayer = 2;
                    } else {
                        currentPlayer = 1;
                    }
                }

            }
        }
    }

    public static boolean controller(String symbol){
        int x = myScanner.nextInt();
        int y = myScanner.nextInt();

        if (x < 0 || x > 2 || y < 0 || y > 2) {
            System.out.println("Invalid input! Please enter numbers between 0 and 2.");
            return false;
        }

        if(gameBoard[x][y].equals("-")) {
            gameBoard[x][y] = symbol;
        }else{
            System.out.println("Invalid Move! (Move somewhere else)");
            return false;
        }

        displayBoard();
        return true;
    }

    public static boolean winChecker(String[][] gameBoard, String symbol) {
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0].equals(symbol) && gameBoard[i][1].equals(symbol) && gameBoard[i][2].equals(symbol)) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (gameBoard[0][i].equals(symbol) && gameBoard[1][i].equals(symbol) && gameBoard[2][i].equals(symbol)) {
                return true;
            }
        }
        if (gameBoard[0][0].equals(symbol) && gameBoard[1][1].equals(symbol) && gameBoard[2][2].equals(symbol)) {
            return true;
        }
        if (gameBoard[0][2].equals(symbol) && gameBoard[1][1].equals(symbol) && gameBoard[2][0].equals(symbol)) {
            return true;
        }
        return false;
    }

    public static void displayBoard(){
        for(int i=0; i<gameBoard.length; i++){
            for( int j=0; j< gameBoard.length; j++){
                System.out.print(gameBoard[i][j] + "\t");
            }
            System.out.println();
        }
    }

}