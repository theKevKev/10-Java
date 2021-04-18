package Chapter6Projects;
import java.io.*;
import java.util.*;

/*
Write a program that prompts the user for a file name, assuming that the file contains a Java program. Your program
should read the file and print its contents properly indented. When you see a left-brace character ( { ) in the file,
increase your indentation level by four spaces. When you see a right-brace character ( } ), decrease your indentation
level by four spaces. You may assume that the file has only one opening or closing brace per line, that every block
statement (such as if or for) uses braces rather than omitting them, and that every relevant occurrence of a { or }
character in the file occurs at the end of a line. Consider using a class constant for the number of spaces to indent (4),
so that it can easily be changed later
*/

/*PsuedoCode:
By Line:
check first character to see if it is a { or }
update spacing level
print spaces
word by word re-print, don't forget spaces!
*/

public class Chapter6Project3_makeNewFile {
    public static final int indent = 4;
    public static void main(String[] args) throws FileNotFoundException{
        Scanner console = new Scanner(System.in);
        String FileName = GetFile(console);
        Scanner input = new Scanner(new File(FileName));
        Scanner input2 = new Scanner(new File(FileName)); 
        String newFileName = FileName.substring(0, FileName.lastIndexOf(".")); //newFileName is just the file without the .java
        PrintStream output = new PrintStream(new File(newFileName + "_Indented.java")); //create a new file, changing the name slightly
        //Duplicate Scanners needed to be made: One to locate Brackets and the other to reprint with normal spacing between words. 
        int Spacing = 0;
        String tempword = "";

        output.println("/*\nThis File is a copy of the original file <" + FileName + ">, however, properly indented through the use of another program. \n*/\n");

        while(input.hasNextLine()){
            Scanner line = new Scanner(input.nextLine());
            String line2 = input2.nextLine();
            if(line2.contains("}")){ //check for }, lower spacing
                Spacing--;
            }
            //Spacing is set, now print
            for(int i = 1; i <= Spacing * indent; i++){
                output.print(" ");
            }
            if(line.hasNext()){ //Rather than just printing the String, I printed word by word so that if there were two spaces
                tempword = line.next();                         //had to force each next word into a String variable to check in case that word was the name of the file, 
                if(tempword.equals(newFileName) == false){      //in which case I needed to rename that word to fit the new file's name. 
                    output.print(tempword); //between words, it would shorten those to become one space. 
                }
                else{
                    output.print(newFileName + "_Indented"); //This is only in the case that the word is the name of the program file. 
                }
                while(line.hasNext()){
                    tempword = line.next();
                    if(tempword.equals(newFileName) == false){ //same here
                        output.print(" " + tempword);
                    }
                    else{
                        output.print(" " + newFileName + "_Indented"); //continued
                    }
                }
            }
            output.println();
            if(line2.contains("{")){ //Open Brackets only change the spacing for following lines
                Spacing++;
            }
        }
    }
    public static String GetFile(Scanner console) throws FileNotFoundException{ //This asks for a file name, 
        System.out.print("Input File Name? ");
        String FileName = console.nextLine();
        File myFile = new File(FileName);
        while(!myFile.canRead()){                                               //checks if the file is readable, 
            System.out.println("File not found, please try again. ");
            System.out.print("Input File Name? ");
            FileName = console.nextLine();
            myFile = new File(FileName);
        }
        return FileName;                                                        //and returns the file name if so. 
    }                                                                           //Afterwards, scanners are created under this file. 
}