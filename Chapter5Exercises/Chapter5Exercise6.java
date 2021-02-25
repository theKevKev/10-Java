package Chapter5Exercises;
import java.util.Random;
public class Chapter5Exercise6 { //Make Guesses
    public static void main(String[] args){
        makeGuesses();
    }
    public static void makeGuesses(){
        Random placeholder = new Random();
        int num = 0, TotalGuesses = 0;
        while(num < 48){
            num = placeholder.nextInt(50) + 1; 
            System.out.println("guess = " + num);
            TotalGuesses++;
        }
        System.out.println("total guesses = " + TotalGuesses);
    }
}
