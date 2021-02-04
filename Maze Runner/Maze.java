public class Maze {
    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println("test 2");
        
        System.out.println("hello");
        
        System.out.println("test pull request");

        System.out.println("pushing test6");
    }

    public void makeBoard(){
        String[][] board = new String[2][2];
        for (int row = 0; row < 3; row++){
            for (int column = 0; column < 3; column++){
                board[row][column] = "-";
            }
        }
    }
    
}
