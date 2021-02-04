public class Maze {
    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println("test 2");
        
        System.out.println("hello");
        
        System.out.println("test pull request");

        makeBoard();

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

}
