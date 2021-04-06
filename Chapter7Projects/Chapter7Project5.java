package Chapter7Projects;
import java.util.*;
/* This program creates a tic-tac-toe board and allows for a two-player game. */
public class Chapter7Project5 {
    public static final int size = 3;
    public static void main(String[] args){
        int[][] board = new int[size][size];
        Scanner input = new Scanner(System.in);
        while(check(board) == false){
            Player1(board);
            if(check(board) == false){
                Player2(board);
            }
        }
        System.out.println("hello!");
        PrintBoard(board);
        //WhoWon(); should include printing the board for the last time
        input.close();
    }
    public static boolean check(int[][] board){
        if(horizontals(board) == true || verticals(board) == true || diagonals(board) == true){
            return true;
        }
        return false;
    }
    public static boolean horizontals(int[][] board){
        int sum;
        for(int i = 0; i < size; i++){
            sum = 0;
            for(int j = 0; j < size; j++){
                sum += board[i][j];
            }
            if(Math.abs(sum) == size)
                return true;
        }
        return false;
    }
    public static boolean verticals(int[][] board){
        int sum;
        for(int i = 0; i < size; i++){
            sum = 0;
            for(int j = 0; j < size; j++){
                sum += board[j][i];
            }
            if(Math.abs(sum) == size)
                return true;
        }
        return false;
    }
    public static boolean diagonals(int[][] board){
        int sum = 0;
        for(int i = 0; i < size; i++){
            sum += board[i][i];
        }
        if(Math.abs(sum) == size)
            return true;
        sum = 0;
        for(int i = 0; i < size; i++){
            sum += board[i][size - 1 - i];
        }
        if(Math.abs(sum) == size)
            return true;
        return false;
    }
    public static void Player1(int[][] board){
        PrintBoard(board);
        if(pieces(board) <= 1){
            System.out.println("Player 1's Turn! Please type two numbers, starting with the row and then the column. Example: If you want to place an X on the top left square, you would type 11");
        }
        board[0][0] = 1;
        board[1][2] = -1;
    }
    public static void Player2(int[][] board){
        PrintBoard(board);
        board[1][1] = 1;
        board[2][2] = 1;
    }
    public static void PrintBoard(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1){
                    System.out.print(" X ");
                } else if(board[i][j] == -1){
                    System.out.print(" O ");
                } else{
                    System.out.print("   ");
                }
                if(j != size - 1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i != size - 1){
                for(int z = 1; z <= size - 1; z++){
                    System.out.print("---+");
                }
                System.out.println("---");
            }
        }
        System.out.println();
        System.out.println();
    }
    public static int pieces(int[][] board){
        int sum = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] != 0){
                    sum++;
                }
            }
        }
        return sum;
    }
}
