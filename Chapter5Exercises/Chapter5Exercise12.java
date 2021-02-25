package Chapter5Exercises;
import java.util.Scanner;
public class Chapter5Exercise12 { //print average 
    public static void main(String[] args){
        printAverage();
    }
    public static void printAverage(){
        Scanner input = new Scanner(System.in);
        int num = 0, total = 0, NumOfNum = 0;
        do{
            System.out.print("\nType a number: ");
            num = input.nextInt();
            if(num >= 0){
                total += num;
                NumOfNum++;
            }
        } while(num >= 0);
        if(NumOfNum != 0){
            double average = ((double)total / NumOfNum);
            System.out.println("\nAverage was " + average);
        }
        input.close();
    }
}
