package Chapter7Exercises;
import java.util.*;
public class Chapter7Exercise1 {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        Exercise1Method();
    }
    public static void Exercise1Method(){
        int[] num = {3, 15, 24, 12, 234, 34, 23, 12, 3, 5, 16, 23};
        System.out.println("What number would you like to find? ");
        int value = input.nextInt();
        int index = lastIndexOf(num, value);
        if(index >= 0){
            System.out.println("The value of " + value + " is at index " + index + " of the array. ");
        } else{
            System.out.println("The value " + value + " is not in the array. ");
        }
    }
    public static int lastIndexOf(int[] num, int value){
        for(int i = num.length - 1; i >= 0; i--){
            if(num[i] == value){
                return i;
            }
        }
        return -1;
    }
}
