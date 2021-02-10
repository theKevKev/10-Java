import java.util.Scanner;
public class BaseConverter1{
    public static void main(String[] args){
        //Create Number
        System.out.println("What number do you want to convert?");
        Scanner input1 = new Scanner(System.in);
        int Number = input1.nextInt();
        //Choose Base
        System.out.println("What base do you want to convert to?");
        Scanner input2 = new Scanner(System.in);
        int Base = input2.nextInt();
        input1.close();
        input2.close();
        if(Number >= 0){
            //make base high (find max exponent value)
            int power = 0;
            for(int x = 0; Math.pow(Base, x) <= Number; x++){
                power = x;
            }
            System.out.println("Your number in base " + Base + " is:");
                                                                                            //Decimal values of Number
            //solve or decrease until printed                                               //Negatives
            for(int exponent = power; Math.pow(Base, exponent) >= 1; exponent--){
                if (Number - (Base - 1) * Math.pow(Base, exponent) >= 0) {                  //how to make this general
                    System.out.print(Base - 1);                                             //What if base > 10
                    Number = Number - (Base - 1) * (int) Math.pow(Base, exponent);          //Base = 1
                } else if (Number - (Base - 2) * Math.pow(Base, exponent) >= 0) {
                    System.out.print(Base - 2);
                    Number = Number - (Base - 2) * (int) Math.pow(Base, exponent);
                } else if (Number - (Base - 3) * Math.pow(Base, exponent) >= 0){ // Base > Number
                    System.out.print(Base - 3);
                    Number = Number - (Base - 3) * (int) Math.pow(Base, exponent);
                } else{
                    System.out.print("base is greater than 3");
                }
            }
            System.out.println();
        }
        else{
            System.out.print("Your number is less than zero");
        }
    }
}