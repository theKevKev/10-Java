import java.util.Scanner;
public class BaseConverter1{
    public static void main(String[] args){
        //Create Number
        System.out.println("What number do you want to convert?");
        Scanner input1 = new Scanner(System.in);
        int Number = input1.nextInt();
        input1.close();
        //Choose Base
        System.out.println("What base do you want to convert to?");
        Scanner input2 = new Scanner(System.in);
        int Base = input2.nextInt();
        input2.close();
        if(Number >= 1){
        
            for(int exponent = 1; Math.pow(Base, exponent) <= Number; exponent++){
                if (Number - 2 * Math.pow(Base, exponent) > 0) {
                    System.out.print("2");
                } else if (Number - Math.pow(Base, exponent) > 0) {
                    System.out.print("1");
                } else{ // Base > Number
                    System.out.print("0");
                }
            }
        }
    }
}