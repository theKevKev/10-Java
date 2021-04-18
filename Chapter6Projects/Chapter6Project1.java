package Chapter6Projects;
import java.io.*;
import java.util.*;

/*
Students are often asked to write term papers containing a certain number of words. Counting words in a long paper
is a tedious task, but the computer can help. Write a program that counts the number of words, lines, and total characters
(not including whitespace) in a paper, assuming that consecutive words are separated either by spaces or endof-line characters.
*/

public class Chapter6Project1 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner console = new Scanner(System.in);
        String FileName = GetFileName(console);
        Scanner input = new Scanner(new File(FileName));
        CountWords(input);
        input = new Scanner(new File(FileName));
        CountLines(input);
        input = new Scanner(new File(FileName));
        CountCharacters(input);
    }
    public static void CountWords(Scanner input){
        int counter = 0;
        while(input.hasNext()){
            input.next();
            counter++;
        }
        System.out.println("Number of words: " + counter);
    }
    public static void CountLines(Scanner input){
        int counter = 1;
        while(input.hasNextLine()){
            input.nextLine();
            counter++;
        }
        System.out.println("Number of lines: " + counter);
    }
    public static void CountCharacters(Scanner input){
        int counter = 0;
        while(input.hasNext()){
            //how many characters in this word?
            String tempWord = input.next();
            counter += tempWord.length();
        }
        System.out.println("Number of characters: " + counter);
    }
    public static String GetFileName(Scanner console) throws FileNotFoundException{
        System.out.print("Input File Name? ");
        String FileName = console.nextLine();
        File myFile = new File(FileName);
        while(!myFile.canRead()){
            System.out.println("File not found, please try again. ");
            System.out.print("Input File Name? ");
            myFile = new File(FileName);
        }
        return FileName;
    }
}