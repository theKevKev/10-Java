package Chapter7Projects;
import java.util.*;
/* This program creates a tic-tac-toe of any size board and allows for a two-player game. */
public class Chapter7Project5 {
    public static final int size = 3; // CHANGEABLE SIZE!!
    public static Scanner input;
    public static void main(String[] args){
        int[][] board = new int[size][size]; //Uses a 3 by 3 array as the board, 1s as Xs and -1s as Os. 
        int Turns = 0; //number of turns elapsed
        while(check(board) == 0 && Turns < size * size){ //in case all spots have been filled. 
            Player(board, Turns); //even = X, odd = O
            Turns++;
        }
        int temp = check(board);
        PrintBoard(board);
        if(temp != 0){
            if(temp == 1){ //Player using X's has won
                System.out.println("Player 1 wins!");
            } else{ //temp == -1 (Player using Os has won)
                System.out.println("Player 2 wins!");
            }
        } else{
            System.out.println("Tie! No one wins! ");
        }
        input.close();
    }
    public static int check(int[][] board){ //check outputs a 1 if Player 1 (X) has won, a -1 if Player 2 (O) has won, and a 0 if no one has won yet. 
        if(horizontals(board) != 0){            // these methods just represent checking all rows, 
            return horizontals(board);
        } else if(verticals(board) != 0){       // columns, 
            return verticals(board);
        } else if(diagonals(board) != 0){       // and diagonals for which player (if there is one) who has won
            return diagonals(board);
        } else{
        return 0; //returning a zero represents that no player has won yet. 
        }
    }
    public static int horizontals(int[][] board){ //checks each row to determine if there is 3 in a row
        int sum;
        for(int i = 0; i < size; i++){
            sum = 0;
            for(int j = 0; j < size; j++){
                sum += board[i][j];
            }
            if(sum == size){
                return 1;
            } else if(sum == -size){
                return -1;
            }
        }
        return 0;
    }
    public static int verticals(int[][] board){ //checks each column to determine if there is 3 in a row
        int sum;
        for(int i = 0; i < size; i++){
            sum = 0;
            for(int j = 0; j < size; j++){
                sum += board[j][i];
            }
            if(sum == size){
                return 1;
            } else if(sum == -size){
                return -1;
            }
        }
        return 0;
    }
    public static int diagonals(int[][] board){ 
        int sum = 0;
        for(int i = 0; i < size; i++){
            sum += board[i][i];
        }       //check top-left to bottom-right diagonal
        if(sum == size){
            return 1;
        } else if(sum == -size){
            return -1;
        }
        sum = 0;
        for(int i = 0; i < size; i++){
            sum += board[i][size - 1 - i];
        }       //checks top-right to bottom left diagonal
        if(sum == size){
            return 1;
        } else if(sum == -size){
            return -1;
        }
        return 0;
    }
    public static void Player(int[][] board, int Turns){ //Time for the player to give input, changing the board
        int val1, val2; //these will represent the players choice where their marker will go. 
        do{ //the do-while loop accounts for giving the player a second chance in case they mess up their format or try to place a marker
            PrintBoard(board); //on an already taken square. 
            if(Turns <= 1){
                System.out.println("Player " + (Turns % 2 + 1) + "'s Turn! Please type two numbers, starting with the row and then the column. \nExample: If you want to place an X on the top left square, you would type 11. ");
            } else{                           //this expression gives a 1 or a 2 depending on the turn. 
                System.out.print("Player " + (Turns % 2 + 1) + "'s Turn! ");
            }
            input = new Scanner(System.in).useDelimiter("");
            val1 = input.nextInt();
            val2 = input.nextInt();
            if(val1 > size || val1 < 1 || val2 > size || val2 < 1){ //check for bounds
                System.out.println("This value does not exist within the bounds of the board! Please try again! ");
            } else if(board[val1 - 1][val2 - 1] != 0){ //check if spot is taken
                System.out.println("That spot has already been taken! Please try again. ");
            }
        } while(val1 > size || val1 < 1 || val2 > size || val2 < 1 || board[val1 - 1][val2 - 1] != 0);
        board[val1 - 1][val2 - 1] = -(Turns % 2 * 2 - 1); 
    }
    public static void PrintBoard(int[][] board){
        System.out.println();
        System.out.println();
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