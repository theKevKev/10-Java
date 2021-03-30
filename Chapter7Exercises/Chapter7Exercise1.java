package Chapter7Exercises;
import java.util.*;
public class Chapter7Exercise1 {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        Exercise1Method();
    }
    public static void Exercise1Method(){
        //This exercise asks the user for a value to find in a given array, then finds the last index where that value is in the array. 
        int[] num = {3, 15, 24, 12, 234, 34, 23, 12, 3, 5, 16, 23}; //Given array
        System.out.println("What number would you like to find? ");
        int value = input.nextInt();                                //value to be found
        int index = lastIndexOf(num, value);                        //This method returns an index or -1
        if(index >= 0){
            System.out.println("The value of " + value + " is at index " + index + " of the array. "); //if index was found, prints index
        } else{
            System.out.println("The value " + value + " is not in the array. "); //if index was not found
        }
    }
    public static int lastIndexOf(int[] num, int value){ //finds the index in the array. 
        for(int i = num.length - 1; i >= 0; i--){
            if(num[i] == value){
                return i;
            }
        }
        return -1;
    }
}
