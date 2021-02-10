import java.util.Scanner;
import java.util.Random; 

public class Maze {

    static int loop = 0;
    public static void main(String[] args) {
        makeBoard();

        displayBoard();
        while(loop==0){
            userInput();
            displayBoard();
            checkForEnd();

            computerAction();
            displayBoard();
            checkForEnd();
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

            System.out.println("Which position?");
            int userInputtedCell = scan.nextInt() - 1;

            int y = 3;
            int userInputRow = (userInputtedCell)/y;
            int userInputColumn = (userInputtedCell)%y;


            if (board[userInputRow][userInputColumn].equals("-")) {
                board[userInputRow][userInputColumn] = "X";
                loop++;
                
            }
            else{
                System.out.println("That square is taken! choose another");
            }
        }
    }


    static int winOrLose = 0;

    public static void checkForEnd() {
        checkThreeInARow();
        checkThreeInAColumn();
        checkThreeInADiagonal();
        checkForDraw();

        if (winOrLose == 1){
            System.out.println("You win!");
            loop++;
        }
        else if (winOrLose == 2){
            System.out.println("You lose!");
            loop++;
        }
        else if (winOrLose == 3){
            System.out.println("Draw!");
            loop++;
        }

    }

    private static void checkThreeInARow() {
        for (int row = 0; row < 3; row++){
            if (checkThreeSame(board[row][0], board[row][1], board[row][2], "X") == true){
                winOrLose++;
            }
            else if (checkThreeSame(board[row][0], board[row][1], board[row][2], "O") == true){
                winOrLose = 2;
            }
        }

    }

    private static void checkThreeInAColumn() {
        for (int column = 0; column < 3; column++){
            if (checkThreeSame(board[0][column], board[1][column], board[2][column], "X") == true){
                winOrLose++; 
            }
            else if (checkThreeSame(board[0][column], board[1][column], board[2][column], "O") == true){
                winOrLose = 2; 
            }
        }

    }

    private static void checkThreeInADiagonal() {
        if (checkThreeSame(board[0][0], board[1][1], board[2][2], "X") == true || checkThreeSame(board[0][2], board[1][1], board[2][0], "X") == true){
            winOrLose ++;
        }
        else if (checkThreeSame(board[0][0], board[1][1], board[2][2], "O") == true || checkThreeSame(board[0][2], board[1][1], board[2][0], "O") == true){
            winOrLose = 2;
        }
    }

    private static void checkForDraw(){
        int numberOfFreeSquares = 9;
        for (int row = 0; row < 3; row++){
            for (int column = 0; column < 3; column ++){
                if (!board[row][column].equals("-")){
                    numberOfFreeSquares --;
                }
            }
        }
        if (numberOfFreeSquares == 0){
            winOrLose = 3;
        }
    }
/*
    private static boolean checkTwoInARowComputer(String XorO) {
        for (int row = 0; row < 3; row++){
            if (checkTwoSame(board[row][0], board[row][1], XorO) == true && board[row][2].equals("-")){
                board[row][2] = "O";
                return true;
            }
            else if (checkTwoSame(board[row][1], board[row][2], XorO) == true && board[row][0].equals("-")){
                board[row][0] = "O";
                return true;
            }
            else if (checkTwoSame(board[row][0], board[row][2], XorO) == true && board[row][1].equals("-")){
                board[row][1] = "O";
                return true;
            }
        }
        return false;
    }
*/

    private static boolean checkTwoInARowComputer(String XorO) {
        for (int row = 0; row < 3; row++){
            if (checkTwoSame(board[row][0], board[row][1], XorO) == true ||
                checkTwoSame(board[row][1], board[row][2], XorO) == true ||
                checkTwoSame(board[row][0], board[row][2], XorO) == true){
                for (int column = 0; column < 3; column++){
                    if (board[row][column].equals("-")){
                        board[row][column] = "O";
                        return true;
                    }
                }
            }
        }
        return false;
    }  

    private static boolean checkTwoInAColumnComputer(String XorO) {
        for (int column = 0; column < 3; column++){
            if (checkTwoSame(board[0][column], board[1][column], XorO) == true ||
                checkTwoSame(board[1][column], board[2][column], XorO) == true ||
                checkTwoSame(board[0][column], board[2][column], XorO) == true){

                    for (int row = 0; row < 3; row++){
                        if (board[row][column].equals("-")){
                            board[row][column] = "O";
                            return true;
                        }
                    }
                }
        }
        return false;
    }

    private static boolean checkTwoInADiagonalComputer(String XorO) {
        if (checkTwoSame(board[0][0], board[1][1], XorO) == true ||
            checkTwoSame(board[1][1], board[2][2], XorO) == true ||
            checkTwoSame(board[0][0], board[2][2], XorO) == true){
                for (int rowAndColumn = 0; rowAndColumn<3; rowAndColumn++){
                    if (board[rowAndColumn][rowAndColumn].equals("-")){
                        board[rowAndColumn][rowAndColumn] = "O";
                        return true;
                    }
                }
            }
        if (checkTwoSame(board[0][2], board[1][1], XorO) == true ||
            checkTwoSame(board[1][1], board[2][0], XorO) == true ||
            checkTwoSame(board[0][2], board[2][0], XorO) == true){
                for (int rowAndColumn = 0; rowAndColumn<3; rowAndColumn++){
                    if (board[rowAndColumn][2-rowAndColumn].equals("-")){
                        board[rowAndColumn][2-rowAndColumn] = "O";
                        return true;
                    }
                }
            }

        return false;
    }



    private static boolean checkThreeSame(String string1, String string2, String string3, String XorO) {
        return (string1.equals(XorO) && string2.equals(string1) && string3.equals(string2));
    }

    private static boolean checkTwoSame(String string1, String string2, String input) {
        return (string1.equals(input) && string2.equals(string1));
    }



    private static boolean checkMiddle() {
        if (board[1][1].equals("-")){
            board[1][1] = "O";
            return true;
        }else{
            return false;
        }
    }

    private static void chooseRandomHole(){
        Random rand = new Random();
        int loop = 0;
        while (loop == 0){
            int randomRow = rand.nextInt(3); 
            int randomColumn = rand.nextInt(3);
            if (board[randomRow][randomColumn].equals("-")){
                board[randomRow][randomColumn] = "O";
                loop ++;
            }
        }
        
    }

    
    public static void computerAction(){

        System.out.println("Computer's turn:");
        
        if (checkTwoInARowComputer("O") == true){
            checkTwoInARowComputer("O");
        }
        else if (checkTwoInAColumnComputer("O") == true){
            checkTwoInAColumnComputer("O");
        }
        else if (checkTwoInADiagonalComputer("O") == true){
            checkTwoInADiagonalComputer("O");
        }


        else if (checkTwoInARowComputer("X") == true){
            checkTwoInARowComputer("X");
        }
        else if (checkTwoInAColumnComputer("X") == true){
            checkTwoInAColumnComputer("X");
        }
        else if (checkTwoInADiagonalComputer("X") == true){
            checkTwoInADiagonalComputer("X");
        }

        
        else if (checkMiddle() == true){
            checkMiddle();
        }
        else{
            chooseRandomHole();
        }

    }

}




