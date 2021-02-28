/* OMG I FINALLY DID IT!!!!!!!!! (9:06 PM) THIS TOOK ME AN HOUR AND A HALF WHAT AM I MISSING
WHATEVER I DID IT WOOOOOOOOOO
YAAAAAAAAAA*/

package Chapter4Exercises;
import java.util.Scanner;
public class Chapter4Exercise14 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("sentence/word?");
        String word = input.nextLine();
        String newWord = swapPairs(word);
        System.out.println(newWord);
        input.close();
    }
    public static String swapPairs(String word){
        String construction = "";
        //remove second letter, add to new string
        //remove first letter, add to new string
        //repeat
        // System.out.println(word.length());
        String temp = "";
        if(word.length() % 2 == 1){
            temp = word.substring(word.length() - 1, word.length());
            // System.out.println(temp);
            // System.out.println(word);
            word = word.substring(0, word.length() - 1);
        } 
        // System.out.println(word);
        for(int i = 1; i <= word.length(); i++){
            construction += word.charAt(i + 2 * (i % 2) - 2);
            // System.out.println(construction);
        }
        construction = construction + temp;
        return construction;
    }
}
