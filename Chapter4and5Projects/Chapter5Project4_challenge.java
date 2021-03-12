package Chapter4and5Projects;
import java.util.*;
public class Chapter5Project4_challenge {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("This program has you, the user, choose a number\nbetween 1 and 10. Then I, the computer, will try\nmy best to guess it.");
        Random Randy = new Random();
        String response = ("");
        int attempts = 0;
        int i = 0, a = 1, b = 10;
        while(response.contains("y") != true){
            i = Randy.nextInt(b) + a; //1 to 10
            System.out.print("Is it " + i + "? (yes/higher/lower) ");
            response = input.nextLine();
            while(response.contains("y") == false && response.contains("higher") == false && response.contains("lower") == false){
                System.out.println("Please enter a \"yes\", \"higher\", or \"lower\"");
                System.out.print("Is it " + i + "? (yes/higher/lower) ");
                response = input.nextLine();
            }
            if(response.contains("higher")){
                b -= i + 1 - a;
                a = i + 1;
            } else if(response.contains("lower")){
                b = b - (b + a - 1 - i) - 1;
            }
            // System.out.println(a + " " + (a + b - 1));
            attempts++;
        }
        input.close();
        System.out.println("I got your number of " + i + " correct in " + attempts + " guesses.");
    }
}
