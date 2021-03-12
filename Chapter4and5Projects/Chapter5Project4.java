package Chapter4and5Projects;
import java.util.*;
public class Chapter5Project4 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("This program has you, the user, choose a number\nbetween 1 and 10. Then I, the computer, will try\nmy best to guess it.");
        Random Randy = new Random();
        String response = ("");
        int attempts = 0;
        int i = 0;
        while(response.contains("y") != true){
            i = Randy.nextInt(10) + 1; //1 to 10
            System.out.print("Is it " + i + "? (y/n) ");
            response = input.nextLine();
            while(response.contains("y") == false && response.contains("n") == false){
                System.out.println("Please enter a yes or a no");
                System.out.print("Is it " + i + "? (y/n) ");
                response = input.nextLine();
            }
            attempts++;
        }
        input.close();
        System.out.println("I got your number of " + i + " correct in " + attempts + " guesses.");
    }
}
