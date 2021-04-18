/*
This File is a copy of the original file <EmployeeHours.java>, however, properly indented through the use of another program. 
*/

import java.io.*;
import java.util.*;

public class EmployeeHours_Indented {
    public static void main(String[] args) throws FileNotFoundException{
        File myFile = new File("/Users/home/OneDrive - Greenhill School/10-Java/hours.txt");
        Scanner input = new Scanner(myFile);
        //File myFile2 = new File("testing2.txt")
        PrintStream Output = new PrintStream(new File("testinFile.txt")); //myFile2
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
            Output.printf("%s (ID#%d) worked %.1f hours (%.2f hours/day)\n", name, ID, hours, hours/days);
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
