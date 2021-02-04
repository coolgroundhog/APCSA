import java.util.Scanner;

public class Maze {
    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println("test 2");
        
        System.out.println("hello");
        
        System.out.println("test pull request");

        makeBoard();

        displayBoard();

        userInput();

        displayBoard();

    }

    static String[][] board = new String[3][3];

    static void makeBoard(){
        for (int row = 0; row < 3; row++){
            for (int column = 0; column < 3; column++){
                board[row][column] = "-";

            }
        }
    }

    static void displayBoard(){
        for (int row = 0; row < 3; row++){
            System.out.print(" | ");
            for (int column = 0; column < 3; column++){
                System.out.print(board[row][column] + " | ");
            }
            System.out.println();
        }
    }

    static void userInput(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Which row?");
        int userInputRow = scan.nextInt();

        System.out.println("Which column?");
        int userInputColumn = scan.nextInt();


        if (board[userInputRow][userInputColumn].equals("-")) {
            board[userInputRow][userInputColumn] = "X";
        }

        else{
            System.out.println("That square is taken! choose another");
        }
    }
/*
    static void checkWinner(){
        for (int row = 0; row < 3; row++){
            for (int column = 0; column < 3; column++){
                System.out.print(board[row][column] == );
            }
    }
*/

}
