import java.util.Scanner;

public class Maze {
    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println("test 2");
        
        System.out.println("hello");
        
        System.out.println("test pull request");

        makeBoard();

        while(1==1){
            displayBoard();
            userInput();
        }


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
            int userInputtedCell = scan.nextInt() - 1;

            int y = 3;
            //System.out.println((userInputtedCell)/y);
            //System.out.println((userInputtedCell)%y);

            int userInputRow = (userInputtedCell)/y;
            int userInputColumn = (userInputtedCell)%y;


            if (board[userInputRow][userInputColumn].equals("-")) {
                board[userInputRow][userInputColumn] = "X";
                loop++;
                checkForWin();
                
            }
    
            else{
                System.out.println("That square is taken! choose another");
            }
        }
    }



    public static boolean checkForWin() {
        boolean checkForWinner = checkRows() || checkColumns() || checkDiagonals();
        if (checkForWinner == true){
            System.out.println("You won!");
        }
        return (checkForWinner);
    }

    private static boolean checkRows() {
        for (int row = 0; row < 3; row++){
            if (checkThreeSame(board[row][0], board[row][1], board[row][2]) == true){
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumns() {
        for (int column = 0; column < 3; column++){
            if (checkThreeSame(board[0][column], board[1][column], board[2][column]) == true){
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonals() {
        return ((checkThreeSame(board[0][0], board[1][1], board[2][2]) == true) || (checkThreeSame(board[0][2], board[1][1], board[2][0]) == true));
    }



    private static boolean checkThreeSame(String string1, String string2, String string3) {
        return (string1.equals("X") && string2.equals(string1) && string3.equals(string2));
    }


}
