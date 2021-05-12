package FinalProject;

import java.io.*;
import java.util.*;

public class Appointment {
    //Colored text yay!
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private int StartTime;
    private int EndTime;
    private int Duration;
    private double DurationHours;
    private boolean BallMachine;
    private String Name;
    private int Court;

    public static final int CourtSheetSize = 9;   // Adjusts the view size of the courtsheet (in case monitor is too small or something)

    //Construction Methods: 
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
    
    //Assessor Methods
    public int getStartTime(){
        return StartTime;
    }
    public int getEndTime(){
        return EndTime;
    }
    public int getDuration(){
        return Duration;
    }
    public double getDurationHours(){
        return DurationHours;
    }
    public boolean getBallMachine(){
        return BallMachine;
    }
    public String getName(){
        return Name;
    }
    public int getCourt(){
        return Court;
    }

    //Mutator Methods  
    //Not applicable as changing individual terms at a time could cause interferences with the court sheet 
    //appointments cannot be changed without 

    //toString Method:
    //This is the PrintDetails() Method

    //Useful Methods
    public void PrintDetails(){
        System.out.print("\u001B[36mCourt " + Court + " is booked for <" + Name + "> from ");
        Convert(StartTime);
        System.out.print(" - ");
        Convert(EndTime);
        System.out.print(", for a duration of " + Duration + " minutes or ");
        System.out.printf("%.1f", DurationHours);
        System.out.println(" hours. ");
        if(BallMachine){
            System.out.println("\u001B[3mBall Machine included");
        }
        System.out.print("\u001B[0m");
    }
    private static void Convert(int Time){
        if(Time < 1300){
            System.out.print(Time / 100);
        }
        else{
            System.out.print(Time / 100 % 12);
        }
        System.out.print(":");
        System.out.print(Time % 100);
        if(Time < 1200){
            System.out.print(" am");
        }
        else{
            System.out.print(" pm");
        }
    }
    public boolean CheckAvailability() throws FileNotFoundException{
        boolean[][] BooleanCourtSheet = new boolean[56][16];
        boolean[] BallMachineAvailability = new boolean[56];
        Scanner sc = new Scanner(new File("FinalProject/AppointmentData.txt"));
        int dataStartTime, dataEndTime, dataCourt;
        boolean dataBallMachine;

        //set up court sheet of when courts are booked or not booked (and also when ball machine is booked/not booked)
        while(sc.hasNextLine()){
            Scanner Line = new Scanner(sc.nextLine()).useDelimiter(":");
            dataCourt = Line.nextInt();
            Line.next();
            dataStartTime = Line.nextInt();
            dataEndTime = Line.nextInt();
            dataBallMachine = Line.nextBoolean();

            //Starting Time on Array:
            //800 = [0], 815 = [1], 830 = [2], 845 = [3], 900 = [4], 915 = [5]: 4 * (hundreds - 8) + startTime%100 / 15 
            int efficiency = (4 * (dataStartTime / 100 - 8) + dataStartTime % 100 / 15);
            // 4 * difference in hours - difference in minutes / 15 gives the number of 15 minute blocks of the appointment's length
            for(int count = 1; count <= 4 * (dataEndTime / 100 - dataStartTime / 100) + (dataEndTime % 100 - dataStartTime % 100) / 15; count++){
                int efficiency2 = efficiency + count - 1;
                BooleanCourtSheet[efficiency2][dataCourt - 1] = true;
                if(dataBallMachine){
                    BallMachineAvailability[efficiency2] = true;
                }
            }
        }
        //same formulas (in fact this formula is also used for the FillCourtSheet method)
        int StartSlot = (4 * (StartTime / 100 - 8) + StartTime % 100 / 15);
        for(int count = 1; count <= 4 * (EndTime / 100 - StartTime / 100) + (EndTime % 100 - StartTime % 100) / 15; count++){
            int tempVar = StartSlot + count - 1;
            //if the user doesn't request for ball machine, should not check for BallMachineAvailability
            if(BallMachine && BallMachineAvailability[tempVar]){
                return false;
            }
            if(BooleanCourtSheet[tempVar][Court - 1]){
                return false;
            }
        }
        return true;
    }
    public void LockInAppointment() throws FileNotFoundException{
        //Check for court/machine availablility
        //If possible, update data log with appointment
        //Otherwise state that appointment slot is not available
        if(CheckAvailability()){
            File myFile = new File("/Users/home/OneDrive - Greenhill School/10-Java/FinalProject/AppointmentData.txt");
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

            PrintStream printer = new PrintStream("FinalProject/AppointmentData.txt");
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
        else{
            System.out.println("This appointment time is not available. Please edit your request and try again. ");
        }
    }
    public static void ViewCourtSheet() throws FileNotFoundException{
        Appointment[][] CourtSheet = new Appointment[56][16];
        FillCourtSheet(CourtSheet);
        System.out.println("Court Sheet: Tennis Center (\u001B[33m\u001B[3mYellow bookings are ball machine bookings\u001B[0m)");
        System.out.println();
        System.out.print("\t");
        for(int courts = 1; courts <= CourtSheet[0].length; courts++){
            System.out.print("|");
            //the below for-loop is really just an if statement, but formatting like this avoids an error of "comparing identical expressions"
            for(int If = 1; If <= CourtSheetSize % 2; If++){        // if(CourtSheetSize % 2 == 1){
                System.out.print(" ");                              //     System.out.print(" ");
            }   // To the right is the identical if statement       // }     
            for(int i = 1; i <= (CourtSheetSize - 8) / 2; i++){
                System.out.print(" ");
            }
            System.out.printf("Court %-2d", courts);
            for(int i = 1; i <= (CourtSheetSize - 8) / 2; i++){
                System.out.print(" ");
            }
            System.out.print("|");
        }
        System.out.println();
        System.out.print("--------");
        for(int r = 1; r <= CourtSheet[0].length; r++){
            System.out.print("+");
            for(int z = 1; z <= CourtSheetSize; z++){
                System.out.print("-");
            }
            System.out.print("+");
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
                        for(int i = 1; i <= CourtSheetSize; i++){
                            System.out.print(" ");
                        }
                    }
                    else{
                        String format = " %-" + (CourtSheetSize - 2) + "." + (CourtSheetSize - 2) + "s ";
                        if(CourtSheet[4 * (k - 1) + d - 1][j - 1].BallMachine){
                            System.out.printf(ANSI_YELLOW + format + ANSI_RESET, CourtSheet[4 * (k - 1) + d - 1][j - 1].Name);
                        }
                        else{
                            System.out.printf(ANSI_GREEN + format + ANSI_RESET, CourtSheet[4 * (k - 1) + d - 1][j - 1].Name);
                        }
                    }
                    System.out.print("]");
                }
                System.out.println();
            }
            System.out.print("--------");
            for(int e = 1; e <= CourtSheet[k].length; e++){
                System.out.print("+");
                for(int f = 1; f <= CourtSheetSize; f++){
                    System.out.print("-");
                }
                System.out.print("+");
            }
            System.out.println();
        }
        System.out.print("\t");
        for(int courts = 1; courts <= CourtSheet[0].length; courts++){
            System.out.print("|");
            //the below for-loop is really just an if statement, but formatting like this avoids an error of "comparing identical expressions"
            for(int If = 1; If <= CourtSheetSize % 2; If++){        // if(CourtSheetSize % 2 == 1){
                System.out.print(" ");                              //     System.out.print(" ");
            }   // To the right is the identical if statement       // }     
            for(int i = 1; i <= (CourtSheetSize - 8) / 2; i++){
                System.out.print(" ");
            }
            System.out.printf("Court %-2d", courts);
            for(int i = 1; i <= (CourtSheetSize - 8) / 2; i++){
                System.out.print(" ");
            }
            System.out.print("|");
        }
        System.out.println();
        System.out.println();
    }
    public static void FillCourtSheet(Appointment[][] CourtSheet) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("FinalProject/AppointmentData.txt"));
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
            // 4 * difference in hours - difference in minutes / 15 gives the number of 15 minute blocks of the appointment's length
            for(int count = 1; count <= 4 * (EndTime / 100 - StartTime / 100) + (EndTime % 100 - StartTime % 100) / 15; count++){
                //Starting Time on Array:
                //800 = [0], 815 = [1], 830 = [2], 845 = [3], 900 = [4], 915 = [5]: 4 * (hundreds - 8) + startTime%100 / 15 
                CourtSheet[(4 * (StartTime / 100 - 8) + StartTime % 100 / 15) + count - 1][Court - 1] = new Appointment(name, StartTime, EndTime, BallMachine, Court);
            }
        }
    }
}