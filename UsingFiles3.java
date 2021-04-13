import java.io.*;
import java.util.*;

public class UsingFiles3 {
    public static void main(String[] args) throws FileNotFoundException{
        File myFile = new File("/Users/home/OneDrive - Greenhill School/10-Java/textFile.txt");
        Scanner input = new Scanner(myFile);
        //Read file and print String per line
        while(input.hasNextLine()){
            Scanner line = new Scanner(input.nextLine());
            while(line.hasNext()){
                if(line.hasNextDouble()){
                    line.next();
                }
                else{
                    System.out.print(line.next() + " ");
                }
            }
            System.out.println();
        }
        input.close();
    }
}
