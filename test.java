import java.io.*;
import java.util.*;

public class test {
    public static void main(String[] args) throws FileNotFoundException{
        File myFile = new File("/Users/home/OneDrive - Greenhill School/10-Java/test.txt");
        Scanner sc = new Scanner(myFile);
        int NumLines = 0;

        while(sc.hasNextLine()){
            NumLines++;
            sc.nextLine();
        }
        String[][] Array = new String[NumLines + 1][5];
        sc.close();
        sc = new Scanner(myFile);
        int axis1 = 0;
        while(sc.hasNextLine()){
            Scanner Line = new Scanner(sc.nextLine()).useDelimiter(":");
            int axis2 = 0;
            while(Line.hasNext()){
                String word = Line.next();
                System.out.println(word + " ");
                Array[axis1][axis2] = word;
                axis2++;
            }
            axis1++;
            System.out.println();
        }

        Array[NumLines][0] = "2";
        Array[NumLines][1] = "Hello World";
        Array[NumLines][2] = "1200";
        Array[NumLines][3] = "1500";
        Array[NumLines][4] = "false";

        PrintStream printer = new PrintStream("test.txt");
        sc.close();
        for(int i = 0; i < Array.length; i++){
            System.out.println(Arrays.toString(Array[i]));
        }
        for(int i = 0; i < Array.length; i++){
            for(int j = 0; j < Array[i].length; j++){
                printer.print(Array[i][j]);
                if(j != Array[i].length - 1){
                    printer.print(":");
                }
            }
            if(i != Array.length - 1){
                printer.println();
            }
        }
        printer.close();
    }
}
