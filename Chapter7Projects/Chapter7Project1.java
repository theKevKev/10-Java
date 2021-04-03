package Chapter7Projects;
import java.util.*;
public class Chapter7Project1 {
    public static void main(String[] args){
        System.out.println("This program asks for two integers of up to 50 digits and returns the sum of those two integers. ");
        Scanner sc = new Scanner(System.in).useDelimiter("");
        int[] sum = new int[51];
        int[] num1 = new int[50];
        int[] num2 = new int[50];

        //Begin asking user for the two numbers to be summed. 
        Create(sc, num1, "first");
        sc = new Scanner(System.in).useDelimiter(""); //not sure why the scanner has to be recreated but this solves a weird problem
        Create(sc, num2, "second");

        //Add values into summation array
        for(int i = 0; i < num1.length; i++){
            sum[i + 1] = num1[i] + num2[i];
        }
        //Carry over
        for(int i = sum.length - 1; i > 0; i--){
            if(sum[i] / 10 == 1){
                sum[i] -= 10;
                sum[i - 1]++;
            }
        }

        //Finally, print!
        System.out.print("The sum of ");
        printarray(num1);
        System.out.print(" and ");
        printarray(num2);
        System.out.print(" is: ");
        printarray(sum);
        System.out.println();

        sc.close();
    }

    public static void Create(Scanner sc, int[] num, String word){
        int[] temp = new int[50];
        Arrays.fill(temp, 10); //filled with 10 to determine where end of input is

        System.out.println("What is the " + word + " integer? ");
        int i = 0;
        
        do{
            if(i == 50)
                System.out.println("The number entered is too large. Please enter a number of up to 50 digits. ");
            temp[i] = sc.nextInt(); //insert each digit of input into temporary array
            i++;
        } while(sc.hasNextInt());
        

        int count = 0;
        for(int n : temp){ //determine how many digits are in the number. 
            if(n != 10){
                count++;
            }
        }

        for(int j = 0; j < count; j++){ 
            num[j + 50 - count] = temp[j];  //Shift numbers from temporary array into appropriate locations in real array 
        }
    }
    public static void printarray(int[] array){
        boolean check = false; //check represents whether there has been a non-zero digit
        for(int n : array){
            if(n != 0 || check == true){
                System.out.print(n);
                check = true;
            }
        }
    }
}

