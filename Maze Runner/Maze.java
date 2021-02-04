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

        userInput();

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
            System.out.print("| ");
            for (int column = 0; column < 3; column++){
                System.out.print(board[row][column] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    static void userInput(){
        int loop = 0;
        while (loop == 0){
            Scanner scan = new Scanner(System.in);
/*
            System.out.println("Which row?");
            int userInputRow = scan.nextInt();
    
            System.out.println("Which column?");
            int userInputColumn = scan.nextInt();
    */
            System.out.println("Which position?");
            long userInputtedCell = scan.nextLong() - 1;


        
	        int baseToConvertTo = 3;
            String convertedUserInput = (Long.toString(userInputtedCell, baseToConvertTo));
 
            
            int userInputColumn = Character.getNumericValue(convertedUserInput.charAt(1));
            int userInputRow = Character.getNumericValue(convertedUserInput.charAt(0));


            if (board[userInputRow][userInputColumn].equals("-")) {
                board[userInputRow][userInputColumn] = "X";
                loop++;
            }
    
            else{
                System.out.println("That square is taken! choose another");
            }
        }
    }


}
