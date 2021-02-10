import java.util.Scanner;
public class BMICalc {
    public static void main(String[] args){
        System.out.println("This program reads data for two people and computes their body mass index (BMI). \n");
        double Weight1, Height1, Weight2, Height2, BMI1, BMI2;
        System.out.println("Enter next person's information:");
        
        //Height 1 setup
        System.out.print("Height (in inches)? ");
        Scanner input1 = new Scanner(System.in);
        Height1 = input1.nextDouble();
        
        //Weight 1 setup
        System.out.print("Weight (in pounds)? ");
        Scanner input2 = new Scanner(System.in);
        Weight1 = input2.nextDouble();
        System.out.println();

        System.out.println("Enter next person's information:");

        //Height 2 setup
        System.out.print("Height (in inches)? ");
        Scanner input3 = new Scanner(System.in);
        Height2 = input3.nextDouble();
        
        //Weight 2 setup
        System.out.print("Weight (in pounds)? ");
        Scanner input4 = new Scanner(System.in);
        Weight2 = input4.nextDouble();
        System.out.println();

        BMI1 = (Weight1 / (Height1 * Height1) * 703);
        BMI2 = (Weight2 / (Height2 * Height2) * 703);
        input1.close();
        input2.close();
        input3.close();
        input4.close();
        Analysis(1, BMI1);
        Analysis(2, BMI2);
        System.out.println("Difference = " + Math.abs(BMI1 - BMI2));
    }
    public static void Analysis(int name, double x){
        System.out.println("Person " + name + " BMI = " + x);
        if(x > 18.5 && x < 24.9){
            System.out.println("normal");
        } else if (x <= 18.5){
            System.out.println("underweight");
        } else if (x >= 24.9 && x <= 30){
            System.out.println("overweight");
        } else{ //BMI is greater than 30
            System.out.println("obese");
        }
        System.out.println();
    }
}
