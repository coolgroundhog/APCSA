import java.util.ArrayList;
public class test {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();

        cars.add("Volkswagen");
        cars.add("Honda");
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
