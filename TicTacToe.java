import java.util.Scanner;

public class TicTacToe {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new TicTacToe();
    }

    TicTacToe() {
        printBoard(gameBoard);
        while (true) {
            playersTurnP1(gameBoard);
            if (checkGameOutcome(gameBoard))
                break;
            printBoard(gameBoard);
            playersTurnP2(gameBoard);
            if (checkGameOutcome(gameBoard))
                break;
            printBoard(gameBoard);
        }
    }

//------------------------------------------------------------
//      CREATE GAME BOARD
//------------------------------------------------------------

    static char[][] gameBoard = {
            {'_', '_', '_'},
            {'_', '_', '_'},
            {'_', '_', '_'}
    };

//------------------------------------------------------------
//      PRINTING THE GAME BOARD
//------------------------------------------------------------

    private static void printBoard(char[][] gameBoard) {
        System.out.println(gameBoard[0][0] + "|" + gameBoard[0][1] + "|" + gameBoard[0][2]);
        System.out.println(gameBoard[1][0] + "|" + gameBoard[1][1] + "|" + gameBoard[1][2]);
        System.out.println(gameBoard[2][0] + "|" + gameBoard[2][1] + "|" + gameBoard[2][2]);
    }

//------------------------------------------------------------
//      PLACING A COUNTER ON THE BOARD
//------------------------------------------------------------

    private static void placeCounter(char[][] gameBoard, int position, char symbol) {
        switch (position) {
            case 1 -> gameBoard[0][0] = symbol;
            case 2 -> gameBoard[0][1] = symbol;
            case 3 -> gameBoard[0][2] = symbol;
            case 4 -> gameBoard[1][0] = symbol;
            case 5 -> gameBoard[1][1] = symbol;
            case 6 -> gameBoard[1][2] = symbol;
            case 7 -> gameBoard[2][0] = symbol;
            case 8 -> gameBoard[2][1] = symbol;
            case 9 -> gameBoard[2][2] = symbol;
            default -> System.out.println("This is not a valid a valid move, please choose a number between 1-9.");
        }
        System.out.printf("You have chosen play on square %d\n", position);
    }

//------------------------------------------------------------
//      PLAYER 1'S TURN
//------------------------------------------------------------

    private void playersTurnP1(char[][] gameBoard) {
        System.out.println("Player 1, please choose a square between 1-9 to play on");
        int playerInput;
        while (true) {
            playerInput = scanner.nextInt();
            if (isMoveValid(gameBoard, playerInput)) {
                break;
            } else {
                System.out.println("Player 1, this is not a valid a valid move, please choose a different number between 1-9.");
            }
        }
        placeCounter(gameBoard, playerInput, 'X');
    }

//------------------------------------------------------------
//      PLAYER 2'S TURN
//------------------------------------------------------------

    private void playersTurnP2(char[][] gameBoard) {
        System.out.println("Player 2, please choose a square between 1-9 to play on");
        int playerInput;
        while (true) {
            playerInput = scanner.nextInt();
            if (isMoveValid(gameBoard, playerInput)) {
                break;
            } else {
                System.out.println("Player 2, this is not a valid a valid move, please choose a different number between 1-9.");
            }
        }
        placeCounter(gameBoard, playerInput, 'O');
    }

//------------------------------------------------------------
//      COMPUTER'S TURN
//------------------------------------------------------------

//        private void computersTurn() {
//            Random random = new Random();
//            int computersTurn;
//            while (true) {
//                computersTurn = random.nextInt(9) + 1;
//                if (isMoveValid(gameBoard, computersTurn)) {
//                    break;
//                }
//            }
//            placeCounter(gameBoard, computersTurn, 'O');
//            printBoard(gameBoard);
//        }

//------------------------------------------------------------
//      CHECKING IF VALID MOVE
//------------------------------------------------------------

    private static boolean isMoveValid(char[][] gameBoard, int position) {
        return switch (position) {
            case 1 -> (gameBoard[0][0] == '_');
            case 2 -> (gameBoard[0][1] == '_');
            case 3 -> (gameBoard[0][2] == '_');
            case 4 -> (gameBoard[1][0] == '_');
            case 5 -> (gameBoard[1][1] == '_');
            case 6 -> (gameBoard[1][2] == '_');
            case 7 -> (gameBoard[2][0] == '_');
            case 8 -> (gameBoard[2][1] == '_');
            case 9 -> (gameBoard[2][2] == '_');
            default -> false;
        };
    }

//------------------------------------------------------------
//      DEFINE THE OUTCOME OF THE GAME
//------------------------------------------------------------

    private static boolean checkGameOutcome(char[][] gameBoard) {
        if (hasAPlayerWon(gameBoard, 'X')) {
            printBoard(gameBoard);
            System.out.println("We have a WINNER! Congratulations to Player 1.");
            System.out.println("Game Over");
            return true;
        }
        if (hasAPlayerWon(gameBoard, 'O')) {
            printBoard(gameBoard);
            System.out.println("We have a WINNER! Congratulations to Player 2.");
            System.out.println("Game Over");
            return true;
        }

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == '_') {
                    return false;
                }
            }
        }
        printBoard(gameBoard);
        System.out.println("This game ended in in DRAW!");
        System.out.println("Game Over");
        return true;
    }

//------------------------------------------------------------
//      CHECKING FOR A WINNER IN THE GAME
//------------------------------------------------------------

    private static boolean hasAPlayerWon(char[][] gameBoard, char symbol) {
        return (gameBoard[0][0] == symbol && gameBoard[0][1] == symbol && gameBoard[0][2] == symbol) ||
                (gameBoard[1][0] == symbol && gameBoard[1][1] == symbol && gameBoard[1][2] == symbol) ||
                (gameBoard[2][0] == symbol && gameBoard[2][1] == symbol && gameBoard[2][2] == symbol) ||
                (gameBoard[0][0] == symbol && gameBoard[1][0] == symbol && gameBoard[2][0] == symbol) ||
                (gameBoard[0][1] == symbol && gameBoard[1][1] == symbol && gameBoard[2][1] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[1][2] == symbol && gameBoard[2][2] == symbol) ||
                (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol);
    }
}

//------------------------------------------------------------
//      END OF CODE
//------------------------------------------------------------