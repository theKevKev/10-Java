/*
Kevin Han - Java Final Project
Sophomore Year: 2021
Object Class 

This class is used to communicate with the data file and formally create, edit, and delete apointments. 
It also can print visuals of the current status of the courtsheet along with printing details of specific appointments. 
*/
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

    // Object Fields
    private int StartTime;
    private int EndTime;
    private int Duration;
    private double DurationHours;
    private boolean BallMachine;
    private String Name;
    private int Court;

    // Adjusts the view size of the courtsheet (in case monitor is too small or something)
    public static final int CourtSheetSize = 9;

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
    // This tertiary appointment creation method proved to be unnessesary, however it still work just in case I might need it in the future. 
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
    public void setCourt(int newCourt){
        Court = newCourt;
    }
    public void setName(String newName){
        Name = newName;
    }
    public void setTime(int newStartTime, int newEndTime){
        // Main class should check whether the times are possible
        StartTime = newStartTime;
        EndTime = newEndTime;
        Duration = 60 * (EndTime / 100 - StartTime / 100) + (EndTime % 100 - StartTime % 100);
        DurationHours = (double)Duration / 60;
    }
    public void setBallMachineStatus(boolean BallMachineStatus){
        BallMachine = BallMachineStatus;
    }

    //toString Method:
    //This is represented by the PrintReceipt() or PrintOptions() Method

    //Printing Methods
    public void PrintReceipt(){
        // This method prints a summary of the appointment after creating a new appointment. 
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
    public void PrintOptions(){
        // This method prints a more brief summary of an appointment. 
        System.out.println("\t" + Name + " - Court " + Court);
        System.out.print("\t");
        Convert(StartTime);
        System.out.print(" - ");
        Convert(EndTime);
        System.out.println();
        if(BallMachine){
            System.out.println("\t(\u001B[3mBall Machine included\u001B[0m)");
        }
    }
    private static void Convert(int Time){
        // This method converts a 4-digit integer that represents a time into 12-hour time format. 
        if(Time < 1300){
            System.out.print(Time / 100);
        }
        else{
            System.out.print(Time / 100 % 12);
        }
        System.out.print(":");
        System.out.print(Time % 100);
        if(Time % 100 == 0){
            System.out.print("0");
        }
        if(Time < 1200){
            System.out.print(" am");
        }
        else{
            System.out.print(" pm");
        }
    }
    
    //File Methods
    public boolean CheckAvailability() throws FileNotFoundException{
        // This method scans through the data file and the new appointment to see if there is space for the new appointment. 
        
        // This array represents each 15-minute time slot of the 16 courts:
            // contains false if the slot is open
            // or contains true if the slot is booked
        boolean[][] BooleanCourtSheet = new boolean[56][16]; 
        // This array represents each time slot as well but for the ball machine (there is only one ball machine in the facility)
        boolean[] BallMachineAvailability = new boolean[56];
        Scanner sc = new Scanner(new File("FinalProject/AppointmentData.txt"));
        int dataStartTime, dataEndTime, dataCourt;
        boolean dataBallMachine;

        //set up court sheet of when courts are booked or not booked (and also when ball machine is booked/not booked)
        while(sc.hasNextLine()){
            // Collect line-by-line the appointments from the file
            Scanner Line = new Scanner(sc.nextLine()).useDelimiter(":");
            dataCourt = Line.nextInt();
            Line.next();
            dataStartTime = Line.nextInt();
            dataEndTime = Line.nextInt();
            dataBallMachine = Line.nextBoolean();

            //Starting Time on Array:
            //800 = [0], 815 = [1], 830 = [2], 845 = [3], 900 = [4], 915 = [5]: 4 * (hundreds - 8) + startTime % 100 / 15 
            int efficiency = (4 * (dataStartTime / 100 - 8) + dataStartTime % 100 / 15); 
            //supposedly using a variable rather than doing the same calculation multiple times is more efficient

            // 4 * difference in hours - difference in minutes / 15 gives the number of 15 minute blocks of the appointment's length
            for(int count = 1; count <= 4 * (dataEndTime / 100 - dataStartTime / 100) + (dataEndTime % 100 - dataStartTime % 100) / 15; count++){
                int efficiency2 = efficiency + count - 1;
                // Change values in the arrays to true to represent a court/ball machine being booked for that time. 
                BooleanCourtSheet[efficiency2][dataCourt - 1] = true;
                if(dataBallMachine){
                    BallMachineAvailability[efficiency2] = true;
                }
            }
        }

        // Now we check for each 15-minute time slot of the requested appointment whether both the court and ball machine are available at the time. 
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
        // No slots were booked, so the appointment is free and available
        return true;
    }
    public void LockInAppointment() throws FileNotFoundException{
        //Check for court/machine availablility
        //If possible, update data log with appointment
            // Store current data in array
            // Add new data to array
            // PrintStream all array values back to data file
        //Otherwise state that appointment slot is not available
        if(CheckAvailability()){
            File myFile = new File("FinalProject/AppointmentData.txt");
            Scanner sc = new Scanner(myFile);
            int NumLines = 0;
            // Figure out how many non-blank lines are in the data file
            while(sc.hasNextLine()){
                if(sc.nextLine().length() != 0){
                    NumLines++;
                }
            }
            // Create an array to store the values so when we use printstream we still have all the previous data
            String[][] Array = new String[NumLines + 1][5]; //we add 1 to the rows to add space for the new appointment
            sc.close();
            sc = new Scanner(myFile);
            //axis1 represents each line (so each appointment)
            int axis1 = 0;
            while(sc.hasNextLine()){
                Scanner Line = new Scanner(sc.nextLine()).useDelimiter(":");
                //axis2 represents the 5 aspects of each appointment (court, name, start, end, ballmachine)
                int axis2 = 0;
                String word = null;
                while(Line.hasNext()){
                    word = Line.next();
                    // System.out.println(word + " ");
                    Array[axis1][axis2] = word;
                    axis2++;
                }
                // if no inputs are read on the line, we can just move on to the next line. 
                if(word != null){
                    axis1++;
                }
            }

            // Fill in new Appointment data
            Array[NumLines][0] = "" + Court;
            Array[NumLines][1] = Name;
            Array[NumLines][2] = "" + StartTime;
            Array[NumLines][3] = "" + EndTime;
            Array[NumLines][4] = "" + BallMachine;

            // Reprint all saved data back into the same file. 
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
        // If the appointment was not available: 
        else{
            System.out.println("This appointment time is not available. Please edit your request and try again. ");
        }
    }
    public static void ViewCourtSheet() throws FileNotFoundException{
        // This method prints a visual of the current bookings using color coordination. 
        
        // Build an array that represents all the booked/not booked slots
        Appointment[][] CourtSheet = new Appointment[56][16];
        FillCourtSheet(CourtSheet);

        // Print all the fancy visual stuff

        // Title
        System.out.println("Court Sheet: Tennis Center (\u001B[33m\u001B[3mYellow bookings are ball machine bookings\u001B[0m)");
        System.out.println();
        
        // Top Header 
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

        // Print a horizontal line with occasional + to make the visual look cleaner (all dependent on the int CourtSheetSize)
        System.out.print("--------");
        for(int r = 1; r <= CourtSheet[0].length; r++){
            System.out.print("+");
            for(int z = 1; z <= CourtSheetSize; z++){
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println();

        // Here we print the actual spreadsheet 

        // k represents each hour
        for(int k = 1; k <= CourtSheet.length / 4; k++){
            // d represents each 15-minute block within the hour
            for(int d = 1; d <= 4; d++){
                // Print out the time
                System.out.print("{");
                if((k + 7) / 10 == 0){
                    System.out.print("0");
                }
                System.out.print(k + 7 + ":");
                if(d == 1){
                    System.out.print("0");
                }
                System.out.print(15 * d - 15 + "}\t");

                // j represents each court
                for(int j = 1; j <= CourtSheet[k].length; j++){
                    System.out.print("[");
                    // If there is no appointment, print spaces:
                    if(CourtSheet[4 * (k - 1) + d - 1][j - 1] == null){
                        for(int i = 1; i <= CourtSheetSize; i++){
                            System.out.print(" ");
                        }
                    }
                    // Otherwise print the name of the appointment
                    else{
                        // Cuts off the characters in the name to 2 less than the int size
                        String format = " %-" + (CourtSheetSize - 2) + "." + (CourtSheetSize - 2) + "s ";
                        // Yellow for ball machine appointments
                        if(CourtSheet[4 * (k - 1) + d - 1][j - 1].BallMachine){
                            System.out.printf(ANSI_YELLOW + format + ANSI_RESET, CourtSheet[4 * (k - 1) + d - 1][j - 1].Name);
                        }
                        // Green for regular appointments
                        else{
                            System.out.printf(ANSI_GREEN + format + ANSI_RESET, CourtSheet[4 * (k - 1) + d - 1][j - 1].Name);
                        }
                    }
                    System.out.print("]");
                }
                System.out.println();
            }
            // Print out another line
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
        // Printing the header again for ease of reading
        System.out.print("\t");
        for(int courts = 1; courts <= CourtSheet[0].length; courts++){
            System.out.print("|");
            for(int If = 1; If <= CourtSheetSize % 2; If++){
                System.out.print(" ");
            }
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
        // This methods fills an array that represents the courtsheet with appointments from the data file
        Scanner sc = new Scanner(new File("FinalProject/AppointmentData.txt"));
        String name;
        int StartTime, EndTime, Court;
        boolean BallMachine;
        
        // go through each line of the data file and add to the courtsheet array
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
    public static void DeleteAppointment(int FileLine) throws FileNotFoundException {
        // This method deletes the given line from the data file 
        
        // Step 1: Count how many non-blank lines are in the data file
        File myFile = new File("FinalProject/AppointmentData.txt");
        Scanner sc = new Scanner(myFile);
        int NumLines = 0;

        while(sc.hasNextLine()){
            if(sc.nextLine().length() != 0){
                NumLines++;
            }
        }

        // Step 2: Create an array with 1 less line and store lines in the array
        String[] Array = new String[NumLines - 1];
        sc.close();
        sc = new Scanner(myFile);
        //readingfileline represents which line of the file the scanner is reading
        int readingfileline = 1;
        int arrayindex = 0;
        String Line;
        while(sc.hasNextLine()){
            Line = sc.nextLine();
            // if the link is not blank nor the line we are trying to delete: 
            if(Line.length() != 0 && readingfileline != FileLine){
                Array[arrayindex] = Line; // store the line
                arrayindex++; // move to next index of array
            }
            readingfileline++; // prepare to read the next line
        }
        
        // Step 3: PrintStream the array back into the file
        PrintStream printer = new PrintStream("FinalProject/AppointmentData.txt");
        sc.close();
        for(int i = 0; i < Array.length; i++){
            printer.print(Array[i]);
            if(i != Array.length - 1){
                printer.println();
            }
        }
        printer.close();
        sc.close();
    }
}