import java.io.*;
import java.util.*;

public class EmployeeHours {
    public static void main(String[] args) throws FileNotFoundException{
        File myFile = new File("/Users/home/OneDrive - Greenhill School/10-Java/hours.txt");
        Scanner input = new Scanner(myFile);
        int ID = 0;
        String name = "";
        double hours = 0;
        int days = 0;
        System.out.println();
        while(input.hasNextLine()){
            Scanner line = new Scanner(input.nextLine());
            if(line.hasNextInt()){
                ID = line.nextInt();
            } 
            else{
                System.out.println("Missing ID Number");
            }
            if(line.hasNext()){
                name = line.next();
            } 
            else{
                System.out.println("Missing Name");
            }
            while(line.hasNextDouble()){
                hours += line.nextDouble();
                days++;
            }
            System.out.printf("%s (ID#%d) worked %.1f hours (%.2f hours/day)\n", name, ID, hours, hours/days);
            ID = 0;
            name = "";
            hours = 0;
            days = 0;
        }
        System.out.println();
        input.close();
    }
}