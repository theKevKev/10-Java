import java.io.*;
import java.util.*;

public class UsingFiles {
    public static void main(String[] args) throws FileNotFoundException{
        File myFile = new File("/Users/home/OneDrive - Greenhill School/10-Java/weather.txt");
        Scanner input = new Scanner(myFile);
        while(input.hasNextLine()){
            Scanner line = new Scanner(input.nextLine());
            while(line.hasNext()){
                if(line.hasNextDouble()){
                    System.out.println(line.nextDouble());
                } else{
                    String trash = line.next();
                    System.out.println(trash);
                }
            }
        }
        input.close();
    }
}
