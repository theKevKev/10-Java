import java.util.Scanner;

public class Chapter4Project1{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("please type a number between 1 and 3999:");
        int num = input.nextInt();
        if(num >= 1 && num <= 3999){
            Thousands(num);
            Hundreds(num);
            Tens(num);
            Ones(num); 
            System.out.println();
        } else{
            System.out.println("Your number is not within the boundaries of 1 and 3999.");
        }
        input.close();
    }
    public static void Thousands(int num){
        for(int i = 1; i <= num / 1000; i++){
            System.out.print("M");
        }
    }
    public static void Hundreds(int num){
        if(num / 100 % 10 <= 3 && num / 100 % 10 >= 1){ //1 - 3
            for(int i = 1; i <= num / 100 % 10; i++){
                System.out.print("C");
            }
        } else if(num / 100 % 10 == 4){ //4
            System.out.print("CD");
        } else if(num / 100 % 10 >= 5 && num / 100 % 10 <= 8){ //5 - 8
            System.out.print("D");
            for(int i = 1; i <= num % 500 / 100; i++){
                System.out.print("C");
            }
        } else if(num / 100 % 10 == 9){ //9
            System.out.print("CM");
        }
    }
    public static void Tens(int num){
        if(num % 100 / 10 <= 3 && num % 100 / 10 >= 1){ //1 - 3
            for(int i = 1; i <= num % 100 / 10; i++){
                System.out.print("X");
            }
        } else if(num % 100 / 10 == 4){ //4
            System.out.print("XL");
        } else if(num % 100 / 10 >= 5 && num % 100 / 10 <= 8){ //5 - 8
            System.out.print("L");
            for(int i = 1; i <= num % 50 / 10; i++){
                System.out.print("X");
            }
        } else if(num % 100 / 10 == 9){ //9
            System.out.print("XC");
        }
    }
    public static void Ones(int num){
        if(num % 10 <= 3 && num % 10 >= 1){ //1 - 3
            for(int i = 1; i <= num % 10; i++){
                System.out.print("I");
            }
        } else if(num % 10 == 4){ //4
            System.out.print("IV");
        } else if(num % 10 >= 5 && num % 10 <= 8){ //5 - 8
            System.out.print("V");
            for(int i = 1; i <= num % 5; i++){
                System.out.print("I");
            }
        } else if(num % 10 == 9){ //9
            System.out.print("IX");
        }
    }
}