package Chapter7Exercises;
import java.util.*;
public class Chapter7Exercise2 {
    public static void main(String[] args){
        int[] array = {3, 5, 19, 12, 6}; //all this stuff isn't important, 
        int result = range(array);
        System.out.println(result);
    }
    public static int range(int[] array){ //it's just this method that's important
        Arrays.sort(array);
        return (array[array.length - 1] - array[0] + 1);
    }
}
