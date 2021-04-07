package Chapter7Projects;
import java.util.*;
/*Write a program that plays a variation of the game of Mastermind with a user. For example, the program can use
pseudorandom numbers to generate a four-digit number. The user should be allowed to make guesses until she gets
the number correct. Clues should be given to the user indicating how many digits of the guess are correct and in the
correct place and how many digits are correct but in the wrong place.*/
public class Chapter7Project3 {
    public static int num = -1;
    public static void main(String[] args){
        //Generate 4 digit number
        Random randy = new Random();
        num = randy.nextInt(9000)+1000;

        //Guessing time!
        Scanner input = new Scanner(System.in);
        int guess = -1, correct = -1, close = -1, numOfGuesses = 0; //initializing variable
        while(correct != 4){
            System.out.print("Your next guess? (Should be a 4 digit integer): ");
            guess = input.nextInt();
            if(guess < 10000 && guess >= 1000){ //check if the guess is within the range
                numOfGuesses++;                //counts total guesses
                correct = CorrectPlace(guess); //here the system gives the 
                close = IncorrectPlace(guess); //player hints on their guess
                System.out.println(correct + " digits were correct and in the right place and " + close + " digits were correct but in the wrong place. ");
            } else{
                System.out.println("Your guess is not a 4 digit integer. ");
            }
        }
        System.out.println("Your guess of " + guess + " was right!");
        System.out.println("It took you " + numOfGuesses + " guesses.");
        input.close();
    }
    public static int CorrectPlace(int guess){
        int count = 0; //represents number of correct digits. 
        for(int i = 1; i <= 4; i++){
            if(num % (int)Math.pow(10, i) / (int)Math.pow(10, i - 1) == guess % (int)Math.pow(10, i) / (int)Math.pow(10, i - 1)){ //if the ith digit of num and the ith digit of guess are the same: 
                count++; 
            }
        }
        return count;
    }
    public static int IncorrectPlace(int guess){
        int[] numarray = new int[10], guessarray = new int[10];
        for(int i = 1; i <= 4; i++){
            numarray[num % (int)Math.pow(10, i) / (int)Math.pow(10, i - 1)]++;
            guessarray[guess % (int)Math.pow(10, i) / (int)Math.pow(10, i - 1)]++;
        } //creates two arrays, finding how many of each digit there are in the guess and the answer
        int counter = 0;
        for(int i = 0; i <= 9; i++){
            counter += Math.min(numarray[i], guessarray[i]);
        } //minimum finds the number of overlaps, but we need to remove the digits in the correct place: 
        counter -= CorrectPlace(guess);
        
        return counter;
    }
}
