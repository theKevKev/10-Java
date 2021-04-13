import java.io.*;
import java.util.*;

public class UsingFiles2 {
    public static void main(String[] args) throws FileNotFoundException{
        File myFile = new File("/Users/home/OneDrive - Greenhill School/10-Java/weather.txt");
        Scanner input = new Scanner(myFile);
        double temp1 = 0;
        if(input.hasNextDouble()){
            temp1 = input.nextDouble(); 
        }
        double temp2 = 0, change = 0;
        while(input.hasNext()){
            if(input.hasNextDouble()){
                temp2 = input.nextDouble();
                change = temp2 - temp1;
                System.out.printf("%-4.1f to %-4.1f, change = %-4.1f\n", temp1, temp2, change);
                temp1 = temp2;
            } else{
                input.next();
            }

        }
        input.close();
    }
}
