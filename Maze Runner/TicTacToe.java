import java.util.Scanner;
import java.util.Random; 

public class TicTacToe {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        System.out.println("Will you be playing with 1 or 2 players?"); // lets you choose between 1 or 2 players
        int answer = scan.nextInt();


            if (answer == 1){ //If you choose 1 player it lets you play against the computer

                makeBoard();//makes the physical board
                displayBoard();

                while(true){
                    userInput("X");
                    displayBoard();
                    checkForEnd();
                    if (checkForEnd()){
                        break;
                    }
    
                    computerAction();
                    displayBoard();
                    checkForEnd();
                    if (checkForEnd()){
                        break;
                    }
                }
            } else if (answer == 2){ //If you choose 2 players it let's you play against another local person

                makeBoard();//makes the physical board
                displayBoard();

                while(true){
                    userInput("X");
                    displayBoard();
                    checkForEnd();
                    if (checkForEnd()){
                        break;
                    }

                    userInput("O");
                    displayBoard();
                    checkForEnd();
                    if (checkForEnd()){
                        break;
                    }
            }


        }
        
        }

    static String[][] board = new String[3][3];//creates 2d 3x3 array

    static void makeBoard(){
        for (int row = 0; row < 3; row++){
            for (int column = 0; column < 3; column++){
                board[row][column] = "-";//fills all elements within array with '-'

            }
        }
    }

    static void displayBoard(){
        System.out.println("\n-------------");//top horizontal "wall" of tic tac toe
        for (int row = 0; row < 3; row++){
            System.out.print("| ");//vertical "walls"
            for (int column = 0; column < 3; column++){//iterate through every element within array
                System.out.print(board[row][column] + " | ");//vertical "walls"
            }
            System.out.println("\n-------------");//horizontal "walls". appears once for each row
        }
    }

    //Method for what the user does during their turn
    static void userInput(String XorO){
        int loop = 0;
        while (loop == 0){
            Scanner scan = new Scanner(System.in);

            System.out.println("Enter an open position from 1 to 9.");//asks for user position
            int userInputtedCell = scan.nextInt() - 1;// minus 1 because array position starts from [0][0], not [0][1]

            //Convert user input from single digit to an element in 2d 3x3 array
            int y = 3;
            int userInputRow = (userInputtedCell)/y;//user input divided by 3 rounded down is the row of the 3x3 array.
                                                    //e.g. 7/3 = 2 rounded down, so its row would be 2
            int userInputColumn = (userInputtedCell)%y;//user input mod 3 is its column
                                                    //e.g. 7 mod 3 = 1, so its column would be 1. 7 -> board[2][1]


            if (board[userInputRow][userInputColumn].equals("-")) {
                board[userInputRow][userInputColumn] = XorO;
                loop++;//breaks loop if the user's chosen square is not taken. Fills it with "X"
                
            }

            else{
                System.out.println("That square is taken! choose another");//continues loop if user chose a filled in square
            }
        }
    }




    static int winLoseOrDraw = 0;//if this variable = 1, the user won. variable = 2, computer won. variable = 3, draw. variable = 0, game is still in session

    public static boolean checkForEnd() {
        checkThreeInARow();//checks if there's 3 in a row (either by user or computer)
        checkThreeInAColumn();//checks if there's 3 in a column (either by user or computer)
        checkThreeInADiagonal();//checks if there's 3 in a diagonal (either by user or computer)
        checkForDraw();//checks for draw

        if (winLoseOrDraw == 1){
            System.out.println("X wins!");
            return true;
        }
        else if (winLoseOrDraw == 2){
            System.out.println("O wins!");
            return true;
        }
        else if (winLoseOrDraw == 3){
            System.out.println("Draw!");
            return true;
        }
        else{
            return false;
        }
    }
    
    //checks if there's 3 in a row (either by user or computer)
    private static void checkThreeInARow() {
        for (int row = 0; row < 3; row++){//iterates through each row
            if (checkThreeSame(board[row][0], board[row][1], board[row][2], "X")){//if there's 3 X's in a row
                winLoseOrDraw = 1;
            }
            else if (checkThreeSame(board[row][0], board[row][1], board[row][2], "O")){//if there's 3 O's in a row
                winLoseOrDraw = 2;
            }
        }

    }

    //checks if there's 3 in a column (either by user or computer)
    private static void checkThreeInAColumn() {
        for (int column = 0; column < 3; column++){//iterates through each column
            if (checkThreeSame(board[0][column], board[1][column], board[2][column], "X")){//if there's 3 X's in a column
                winLoseOrDraw = 1; 
            }
            else if (checkThreeSame(board[0][column], board[1][column], board[2][column], "O")){//if there's 3 O's in a column
                winLoseOrDraw = 2; 
            }
        }

    }

    //checks if there's 3 in a diagonal (either by user or computer)
    private static void checkThreeInADiagonal() {
        if (checkThreeSame(board[0][0], board[1][1], board[2][2], "X") || checkThreeSame(board[0][2], board[1][1], board[2][0], "X")){//if there's 3 X's in a diagonal
            winLoseOrDraw = 1;
        }
        else if (checkThreeSame(board[0][0], board[1][1], board[2][2], "O")|| checkThreeSame(board[0][2], board[1][1], board[2][0], "O")){//if there's 3 O's in a diagonal
            winLoseOrDraw = 2;
        }
    }

    //checks if all squares are filled
    private static void checkForDraw(){
        int numberOfFreeSquares = 9;
        for (int row = 0; row < 3; row++){
            for (int column = 0; column < 3; column ++){//iterates through every array element
                if (!board[row][column].equals("-")){
                    numberOfFreeSquares --;//for every element that isn't blank, subtract numberOfFreeSquares by 1
                }
            }
        }
        if (numberOfFreeSquares == 0 && winLoseOrDraw == 0){//checks if winLoserOrDraw = 0 (if no one has won) since the squares may all be filled AND someone may have won
            winLoseOrDraw = 3;
        }
    }






     
//Computer-related


    public static void computerAction(){

        System.out.println("Computer's turn:");

        //checks if there is a winning move (individual methods explained below)
        if (checkTwoInARowComputer("O")){//parameter "O" tells it to identify if there are two O's in a row (see method for specifics)
            checkTwoInARowComputer("O");
        }
        else if (checkTwoInAColumnComputer("O")){
            checkTwoInAColumnComputer("O");
        }
        else if (checkTwoInADiagonalComputer("O")){
            checkTwoInADiagonalComputer("O");
        }


        //if there's no winning move, checks if user is about to do winning move
        else if (checkTwoInARowComputer("X")){//parameter "X" tells it to identify if there are two X's in a row
            checkTwoInARowComputer("X");
        }
        else if (checkTwoInAColumnComputer("X")){
            checkTwoInAColumnComputer("X");
        }
        else if (checkTwoInADiagonalComputer("X")){
            checkTwoInADiagonalComputer("X");
        }

        //if user isn't about to do winning move, computer takes middle
        else if (checkMiddle()){
            checkMiddle();
        }

        //if middle is taken, take random square
        else{
            chooseRandomDiagonal();
        }

    }

    //check if there's two in a row, either X or O (specified in parameter)
    private static boolean checkTwoInARowComputer(String XorO) {
        for (int row = 0; row < 3; row++){
            if (checkTwoSame(board[row][0], board[row][1], XorO) ||//if left and center in same row are same string
                checkTwoSame(board[row][1], board[row][2], XorO) ||//if center and right are same string
                checkTwoSame(board[row][0], board[row][2], XorO)){//if left and right are same string
                
                for (int column = 0; column < 3; column++){//iterates through each element in the row
                    if (board[row][column].equals("-")){// identifies the one element with a '-' (the other two in the row will already be filled)
                        board[row][column] = "O";//fills it with an O
                        return true;//returns true so it can get activated in computerAction
                    }
                }
            }
        }
        return false;//if there aren't two in a row it doesn't get activated = no input from computer
    }  

    //check if there's two in a column, either X or O (specified in parameter)
    private static boolean checkTwoInAColumnComputer(String XorO) {
        for (int column = 0; column < 3; column++){
            if (checkTwoSame(board[0][column], board[1][column], XorO) ||//goes through each possiblity of there being two of the same in a column
                checkTwoSame(board[1][column], board[2][column], XorO) ||
                checkTwoSame(board[0][column], board[2][column], XorO)){

                    //same as checkTwoInARowComputer method, but just iterates through each element in same column
                    for (int row = 0; row < 3; row++){
                        if (board[row][column].equals("-")){
                            board[row][column] = "O";
                            return true;
                        }
                    }
                }
        }
        return false;//if there aren't two in a column it doesn't get activated = no input from computer
    }

    //check if there's two in a diagonal, either X or O (specified in parameter)
    private static boolean checkTwoInADiagonalComputer(String XorO) {
        //left diagonal (top left -> bottom right)
        if (checkTwoSame(board[0][0], board[1][1], XorO) ||//goes through each possibility of two of the same in left diagonal
            checkTwoSame(board[1][1], board[2][2], XorO) ||
            checkTwoSame(board[0][0], board[2][2], XorO)){

                //same as checkTwoInARowComputer, but iterates through left diagonal
                for (int rowAndColumn = 0; rowAndColumn<3; rowAndColumn++){
                    if (board[rowAndColumn][rowAndColumn].equals("-")){
                        board[rowAndColumn][rowAndColumn] = "O";
                        return true;
                    }
                }
            }

        //right diagonal (top right -> bottom left)
        else if (checkTwoSame(board[0][2], board[1][1], XorO) ||//goes through each possibility of two of the same in right diagonal
                checkTwoSame(board[1][1], board[2][0], XorO)  ||
                checkTwoSame(board[0][2], board[2][0], XorO)){
                
                //same as checkTwoInARowComputer, but iterates through right diagonal
                    for (int rowAndColumn = 0; rowAndColumn<3; rowAndColumn++){
                        if (board[rowAndColumn][2-rowAndColumn].equals("-")){
                            board[rowAndColumn][2-rowAndColumn] = "O";
                            return true;
                        }
                }
            }

        return false;
    }

    //check if three strings are a) the same as each other and b) same as string parameter "XorO"
    private static boolean checkThreeSame(String string1, String string2, String string3, String XorO) {
        return (string1.equals(XorO) && string2.equals(string1) && string3.equals(string2));
    }

    //check if two strings are a) the same as each other and b) same as string parameter "XorO"
    private static boolean checkTwoSame(String string1, String string2, String XorO) {
        return (string1.equals(XorO) && string2.equals(string1));
    }


    //for computer to play the middle hole
    private static boolean checkMiddle() {
        if (board[1][1].equals("-")){//if middle hole is "-" aka available
            board[1][1] = "O";//fills it
            return true;//returns true = gets activated in computerAction method
        }else{
            return false;
        }
    }

    //last priority: plays random diagonal
    private static void chooseRandomDiagonal(){
        Random rand = new Random();
        int loop = 0;
        while (loop == 0){
            int randomRow = rand.nextInt(2); 
            if (randomRow == 1){
                randomRow = randomRow + 1;
            }
            int randomColumn = rand.nextInt(2);//chooses random row and column
            if (randomColumn == 1){
               randomColumn = randomColumn + 1;
            }

            if (board[randomRow][randomColumn].equals("-")){
                board[randomRow][randomColumn] = "O";//fills it if empty
                loop ++;
            }
            //if board[randomRow][randomColumn] doesn't equal "-", remains in while loop and chooses another random square
        }
        
    }

    

}
