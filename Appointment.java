import java.io.*;
import java.util.*;

public class Appointment {
    private int StartTime;
    private int EndTime;
    private int Duration;
    private double DurationHours;
    private boolean BallMachine;
    private String Name;
    private int Court;

    public Appointment(){
        Name = "Guest";
    }
    public Appointment(String Name, int StartTime, int EndTime, boolean BallMachine, int Court){
        this.Name = Name;
        if(StartTime >= 800 && StartTime < 2200 && (StartTime % 100 == 0 || StartTime % 100 == 15 || StartTime % 100 == 30 || StartTime % 100 == 45)){
            this.StartTime = StartTime;
        } 
        else{
            System.out.println("The selected start time is not allowed. ");
        }
        if(EndTime > 800 && EndTime <= 2200 && (EndTime % 100 == 0 || EndTime % 100 == 15 || EndTime % 100 == 30 || EndTime % 100 == 45)){
            this.EndTime = EndTime;
        } 
        else{
            System.out.println("The selected end time is not allowed. ");
        }
        this.BallMachine = BallMachine;
        this.Court = Court;
        
        Duration = 60 * (EndTime / 100 - StartTime / 100) + (EndTime % 100 - StartTime % 100);
        DurationHours = (double)Duration / 60;
    }
    public Appointment(String Name, int StartTime, boolean BallMachine, int Court, int Duration){
        this.Name = Name;
        if(StartTime >= 800 && StartTime < 2200 && (StartTime % 100 == 0 || StartTime % 100 == 15 || StartTime % 100 == 30 || StartTime % 100 == 45)){
            this.StartTime = StartTime;
        } 
        else{
            System.out.println("The selected start time is not allowed. ");
        }
        int tempEndTime = StartTime + 100 * (Duration / 60) + Duration % 60;
        if(Duration % 15 == 0 && tempEndTime <= 2200){
            this.Duration = Duration;
            EndTime = tempEndTime;
        } 
        else{
            System.out.println("The selected end time is not allowed. ");
        }
        this.BallMachine = BallMachine;
        this.Court = Court;
        
        DurationHours = (double)Duration / 60;
    }
    public void PrintDetails(){
        System.out.println("Your appointment under the name <" + Name + "> begins at " + StartTime + " and ends at " + EndTime + ", for a total of " + Duration + " minutes or " + DurationHours + " hours. \nRequest for ball machine is " + BallMachine + ". You will be on court " + Court);
    }
    public void LockInAppointment() throws FileNotFoundException{
        //Check for court/machine availablility
        //If possible, update data log with appointment
        File myFile = new File("/Users/home/OneDrive - Greenhill School/10-Java/test.txt");
        Scanner sc = new Scanner(myFile);
        int NumLines = 0;

        while(sc.hasNextLine()){
            if(sc.nextLine().length() != 0){
                NumLines++;
            }
        }
        String[][] Array = new String[NumLines + 1][5];
        sc.close();
        sc = new Scanner(myFile);
        int axis1 = 0;
        while(sc.hasNextLine()){
            Scanner Line = new Scanner(sc.nextLine()).useDelimiter(":");
            int axis2 = 0;
            String word = null;
            while(Line.hasNext()){
                word = Line.next();
                // System.out.println(word + " ");
                Array[axis1][axis2] = word;
                axis2++;
            }
            if(word != null){
                axis1++;
            }
        }

        Array[NumLines][0] = "" + Court;
        Array[NumLines][1] = Name;
        Array[NumLines][2] = "" + StartTime;
        Array[NumLines][3] = "" + EndTime;
        Array[NumLines][4] = "" + BallMachine;

        PrintStream printer = new PrintStream("test.txt");
        sc.close();
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
    public static void ViewCourtSheet() throws FileNotFoundException{
        Appointment[][] CourtSheet = new Appointment[56][16];
        FillCourtSheet(CourtSheet);
        CourtSheet[9][6] = new Appointment();
        int size = 9;
        System.out.println("Court Sheet: Tennis Center");
        System.out.print("\t  ");
        for(int courts = 1; courts <= CourtSheet[0].length; courts++){
            System.out.printf("Court %-2d   ", courts);
        }
        System.out.println();
        for(int k = 1; k <= CourtSheet.length / 4; k++){
            for(int d = 1; d <= 4; d++){
                System.out.print("{");
                if((k + 7) / 10 == 0){
                    System.out.print("0");
                }
                System.out.print(k + 7 + ":");
                if(d == 1){
                    System.out.print("0");
                }
                System.out.print(15 * d - 15 + "}\t");
                for(int j = 1; j <= CourtSheet[k].length; j++){
                    System.out.print("[");
                    if(CourtSheet[4 * (k - 1) + d - 1][j - 1] == null){
                        for(int i = 1; i <= size; i++){
                            System.out.print(" ");
                        }
                    }
                    else{
                        String format = " %-" + (size - 2) + "." + (size - 2) + "s ";
                        System.out.printf(format, CourtSheet[4 * (k - 1) + d - 1][j - 1].Name);
                    }
                    System.out.print("]");
                }
                System.out.println();
            }
            System.out.print("--------");
            for(int e = 1; e <= CourtSheet[k].length; e++){
                System.out.print("+");
                for(int f = 1; f <= size; f++){
                    System.out.print("-");
                }
                System.out.print("+");
            }
            System.out.println();
        }
    }
    public static void FillCourtSheet(Appointment[][] CourtSheet) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("test.txt"));
        String name;
        int StartTime, EndTime, Court;
        boolean BallMachine;
        while(sc.hasNextLine()){
            Scanner Line = new Scanner(sc.nextLine()).useDelimiter(":");
            Court = Line.nextInt();
            name = Line.next();
            StartTime = Line.nextInt();
            EndTime = Line.nextInt();
            BallMachine = Line.nextBoolean();
            for(int count = 1; count <= EndTime - StartTime; count++){
                // CourtSheet[count][Court - 1] = new Appointment(name, StartTime, EndTime, BallMachine, Court);
            }
        }
    }
}