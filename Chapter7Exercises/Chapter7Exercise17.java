package Chapter7Exercises;
import java.util.*;
public class Chapter7Exercise17 {
    public static void main(String[] args){
        /*Write a method called vowelCount that accepts a String as a parameter and produces and returns an array of 
        integers representing the counts of each vowel in the string. The array returned by your method should hold 
        five elements: the first is the count of As, the second is the count of Es, the third Is, the fourth Os, and the fifth Us. 
        Assume that the string contains no uppercase letters. For example, the call vowelCount("i think, therefore i am")
        should return the array {1, 3, 3, 1, 0}*/
        Scanner input = new Scanner(System.in);
        System.out.println("Gimme a sentence! lol :)");
        String sentence = input.nextLine();
        input.close();
        int[] count = vowelCount(sentence);
        System.out.println(Arrays.toString(count));
    }
    public static int[] vowelCount(String sentence){
        int[] counter = new int[5];
        for(int i = 0; i < sentence.length(); i++){
            if(sentence.charAt(i) == 'a'){
                counter[0]++;
            } else if(sentence.charAt(i) == 'e'){
                counter[1]++;
            } else if(sentence.charAt(i) == 'i'){
                counter[2]++;
            } else if(sentence.charAt(i) == 'o'){
                counter[3]++;
            } else if(sentence.charAt(i) == 'u'){
                counter[4]++;
            }
        }
        return counter;
    }
}
