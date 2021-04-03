package Chapter7Exercises;
import java.util.*;
public class Chapter7Exercise16{
/* Write a method called append that accepts two integer arrays as parameters and returns a new array that contains the
result of appending the second array’s values at the end of the first array. For example, if arrays list1 and list2
store {2, 4, 6} and {1, 2, 3, 4, 5} respectively, the call of append(list1, list2) should return a new array containing {2, 4, 6, 1, 2, 3, 4, 5}. If the call instead had been append(list2, list1), the method would return an
array containing {1, 2, 3, 4, 5, 2, 4, 6}. */
    public static void main(String[] args){
        int[] list1 = {2, 4, 6};
        int[] list2 = {1, 2, 3, 4, 5};
        int[] list3 = append(list1, list2);
        System.out.println(Arrays.toString(list3));
    }
    public static int[] append(int[] list1, int[] list2){
        //Create new array with combined length of both arrays. 
        int[] list3 = Arrays.copyOf(list1, list1.length + list2.length);
        for(int i = list1.length; i < list1.length + list2.length; i++){
            list3[i] = list2[i - list1.length];
        }
        return list3;
    }
}