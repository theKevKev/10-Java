/* Kevin Han
02/08/2021
How to use the scanner for use input
if/else statements
*/

import java.util.Scanner;
    public class Practice{
        public static void main(String[] args){
            System.out.println("Please enter your age");
            Scanner input = new Scanner(System.in);
            int age = input.nextInt();
            System.out.println( "You are " + age + " years old.");
            if(age >= 60){
                System.out.println("You will need the vaccine");
            }
            else if(age >= 40){
                System.out.println("You might want to get tested.");
            } 
            else{
                System.out.println("You are probably safe for now");
            }
            input.close();
        }
    }
