package Chapter4and5Projects;
//Pig Latin
import java.util.*;

public class Chapter5Project1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String sentence = "";
        System.out.println("Sentence to convert? ");
        sentence = input.nextLine();
        do{
        Convert(sentence + ' ');
        System.out.println("Sentence to convert? ");
        sentence = input.nextLine();
        }
        while(sentence.equalsIgnoreCase("") != true);
        input.close();
    }
    public static void Convert(String sentence){
        //for each word, 
        while(sentence.indexOf(' ') >= 0) {
            //isolate letters before first vowel
            int i = 100;
            if(sentence.indexOf('a') != -1){
                i = Math.min(sentence.indexOf('a'), i);
            }
            if(sentence.indexOf('e') != -1){
                i = Math.min(sentence.indexOf('e'), i);
            }
            if(sentence.indexOf('i') != -1){
                i = Math.min(sentence.indexOf('i'), i);
            }
            if(sentence.indexOf('o') != -1){
                i = Math.min(sentence.indexOf('o'), i);
            }
            if(sentence.indexOf('u') != -1){
                i = Math.min(sentence.indexOf('u'), i);
            }
            if(sentence.indexOf('y') != -1){
                i = Math.min(sentence.indexOf('y'), i);
            }
            //print remaining letters
            String temporary = sentence.substring(i, sentence.indexOf(' '));
            System.out.print(temporary + "-");
            System.out.print(sentence.substring(0, i) + "ay ");
            //repeat without initial letters
            sentence = sentence.substring(sentence.indexOf(' ') + 1);
        }
        System.out.println();
    }
}
