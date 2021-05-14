package FinalProject;
import java.io.*;
import java.util.*;

public class Courts {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        int request;
        do{
            //Figure out what the user wants to do
            request = 0;
            boolean didcatch = false;
            do{
                didcatch = false;
                System.out.println("Enter 1 to make a new reserevation, enter 2 to view availabilities, or enter 3 to view/edit/delete a reservation.");
                try {
                    request = input.nextInt();
                    input.skip("\\R");
                } catch (Exception e) {
                    System.out.println("Unacceptable input. Try again. (" + e + ")");
                    input.nextLine();
                    didcatch = true;
                }
                if(!didcatch){
                    if(request < 1 || request > 3){
                        System.out.println("Unacceptable input. Try again. (Input should be 1, 2, or 3)");
                    }
                }
            } while(request < 1 || request > 3);

            if(request == 1){
                NewReservation(input);
            }
            else if(request == 2){
                Appointment.ViewCourtSheet();
            }
            else if(request == 3){
                int FileLine = SearchReservation(input); // figures out which appointment the user would like to look at and gets its file line number. 
                
                //Ask if they want to delete or edit
                Method1(input);
                System.out.println(FileLine);
            }
            //Checks if user still wants to make more reservations/continue the program. 
            do{
                String recieve;
                didcatch = false; 
                System.out.println("Would you like to continue using this reservation system? (Yes/No)");
                recieve = input.nextLine();
                if((recieve.contains("y") || recieve.contains("Y")) && (recieve.contains("n") || recieve.contains("N"))){
                    System.out.println("Invalid response, please indicate either yes or no. ");
                    didcatch = true;
                }
                else if(recieve.contains("y") || recieve.contains("Y")){
                    //Nothing happens, request just can't be zero at this point
                }
                else if(recieve.contains("n") || recieve.contains("N")){
                    request = -1;
                }
                else{
                    System.out.println("Invalid response, please indicate either yes or no. ");
                    didcatch = true;
                }
            }
            while(didcatch);

        }
        while(request != -1);
        System.out.println("Thank you for using this booking system! ");
        input.close();
    }
    public static void NewReservation(Scanner input) throws FileNotFoundException{
        //Option 1: Make a new reservation
            //show courtsheet
            //ask user for inputs
            //attempt to place reservation
        //if reservation attempt failes, ask user what they want to change
        //once placed:
        //confirmation text + court they are on
        //place onto file
        Appointment app;
        boolean success = true;
        String Name = "";
        int StartTime = 0;
        boolean BallMachine = false;
        int Court = 0;
        int EndTime = 0;
        Appointment.ViewCourtSheet();
        do{
            if(!success){
                System.out.println("Let's redo this appointment! ");
            }
            
            if(success){ //should not ask for name if court is not available
                // recieve Name
                System.out.print("What name should the reservation be under? ");
                Name = input.nextLine();
            }
            // recieve StartTime
            boolean didcatch;
            StartTime = 0;
            do{
                didcatch = false;
                System.out.print("What time would you like your appointment to \u001B[31mstart\u001B[0m at? We are open from 8:00 to 22:00. \nPlease type your time as a 4-digit number (ex. 930 for 9:30 am or 1745 for 5:45 pm): ");
                try {
                    StartTime = input.nextInt();
                    input.nextLine();
                } catch (Exception e) {
                    System.out.println("Unacceptable input. Try again. (" + e + ")");
                    input.nextLine();
                    didcatch = true;
                }
                if(!didcatch){
                    if(StartTime < 800 || StartTime >= 2200 || !(StartTime % 100 == 0 || StartTime % 100 == 15 || StartTime % 100 == 30 || StartTime % 100 == 45)){
                        System.out.println("Invalid Time, please try again. (\u001B[3mTimes are placed at 15-minute slots\u001B[0m)");
                    }
                }
            } while(StartTime < 800 || StartTime >= 2200 || !(StartTime % 100 == 0 || StartTime % 100 == 15 || StartTime % 100 == 30 || StartTime % 100 == 45));
            
            // recieve EndTime
            EndTime = 0;
            do{
                didcatch = false;
                System.out.print("What time would you like your appointment to \u001B[31mend\u001B[0m at? We are open from 8:00 to 22:00. \nPlease type your time as a 4-digit number (ex. 930 for 9:30 am or 1745 for 5:45 pm): ");
                try {
                    EndTime = input.nextInt();
                    input.nextLine();
                } catch (Exception e) {
                    System.out.println("Unacceptable input. Try again. (" + e + ")");
                    input.nextLine();
                    didcatch = true;
                }
                if(!didcatch){
                    if(EndTime <= 800 || EndTime > 2200 || !(EndTime % 100 == 0 || EndTime % 100 == 15 || EndTime % 100 == 30 || EndTime % 100 == 45) || EndTime <= StartTime){
                        System.out.println("Invalid Time, please try again. (\u001B[3mTimes are placed at 15-minute slots\u001B[0m)");
                    }
                }
            } while(EndTime <= 800 || EndTime > 2200 || !(EndTime % 100 == 0 || EndTime % 100 == 15 || EndTime % 100 == 30 || EndTime % 100 == 45) || EndTime <= StartTime);

            // recieve ball machine request
            BallMachine = false;
            String recieve;
            do{
                didcatch = false; //in this case didcatch indicated whether an error was caught
                System.out.println("Do you wish to use the ball machine? (Yes/No)");
                recieve = input.next();
                input.nextLine();
                if((recieve.contains("y") || recieve.contains("Y")) && (recieve.contains("n") || recieve.contains("N"))){
                    System.out.println("Invalid response, please indicate either yes or no. ");
                    didcatch = true;
                }
                else if(recieve.contains("y") || recieve.contains("Y")){
                    BallMachine = true;
                }
                else if(recieve.contains("n") || recieve.contains("N")){
                    BallMachine = false;
                }
                else{
                    System.out.println("Invalid response, please indicate either yes or no. ");
                    didcatch = true;
                }
            }
            while(didcatch);

            // recieve court choice
            Court = 0;
            do{
                didcatch = false;
                System.out.println("Which court would you like to reserve? (\u001B[3m1 - 16\u001B[0m)");
                try {
                    Court = input.nextInt();
                    input.nextLine();
                } catch (Exception e) {
                    System.out.println("Unacceptable input. Try again. (" + e + ")");
                    input.nextLine();
                    didcatch = true;
                }
                if(!didcatch){
                    if(Court < 1 || Court > 16){
                        System.out.println("Unacceptable input. Try again. (\u001B[3mInput should be between 1 and 16\u001B[0m)");
                    }
                }
            } while(Court < 1 || Court > 16);
        
            app = new Appointment(Name, StartTime, EndTime, BallMachine, Court);
            success = app.CheckAvailability();
            app.LockInAppointment();
        }
        while(!success);
        System.out.println("Success! ");
        app.PrintDetails();

    }
    public static int SearchReservation(Scanner input) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("FinalProject/AppointmentData.txt"));

        System.out.print("Please enter the name under the appointment you are looking for: ");
        String FindName = input.nextLine();
        
        //Step 1: Locate any appointment that contains the input and figure out how many there are. 
        String name;
        int ArraySize = 0; //This will count how many appointments are under that name. 
        int FileLine = 1;
        String MemoryFileLine = "";

        //Determine Array Size
        while(sc.hasNextLine()){
            Scanner Line = new Scanner(sc.nextLine()).useDelimiter(":");
            Line.next();
            name = Line.next();
            Line.next();
            Line.next(); //just trashing these values as we can't use them yet
            Line.next(); 
            if(name.toLowerCase().contains(FindName.toLowerCase())){ // if any term on the data file contains the input, we add one to the array size
                ArraySize++;
                MemoryFileLine += FileLine + ","; // For efficiency: Rather than looking through every line again to check if the name contains the input, we
            }                                     // can use this String to contain all the lines on the data file that contain said input. 
            FileLine++;
        }
        MemoryFileLine = MemoryFileLine.substring(0, MemoryFileLine.length() - 1); //we just want to cut off the last comma
        Appointment[] Choices = new Appointment[ArraySize];                        //setting up the array to contain all the possible choices
        int[] ChoiceIndex = new int[ArraySize];                                    //after the user chooses an appointment from the Choices array, it will return the line that that appoitnment was on. 

        //Step 2: Knowing the number of appointments there are under the input name, we can locate each one and put it into an array
        sc = new Scanner(new File("FinalProject/AppointmentData.txt")); //reset scanner
        int StartTime, EndTime, Court;
        boolean BallMachine;
        FileLine = 1; 
        Scanner LineNum = new Scanner(MemoryFileLine).useDelimiter(",");
        Boolean foundOne = true; //determines if a match was found 
        int temp = 0; // just to store the next item from the string. 
        int spot = 0; // the index of the array that we are on
        boolean NoMoreTerms = false; //this happens if there are no more appointments we need to search for

        //Fill in index/reference 
        while(sc.hasNextLine() && !NoMoreTerms){
            if(foundOne){ // This part sets the line number that we need to find
                if(LineNum.hasNextInt()){
                    temp = LineNum.nextInt();
                    foundOne = false;
                }
                else{ // basically if there are no more terms to search for the while loop will end
                    NoMoreTerms = true;
                }
            }
            if(FileLine == temp){   //if a line is equal to temp, we know that this line contains a reservation under the input name. 
                Scanner Line = new Scanner(sc.nextLine()).useDelimiter(":");
                Court = Line.nextInt();
                name = Line.next();
                StartTime = Line.nextInt();
                EndTime = Line.nextInt();
                BallMachine = Line.nextBoolean();
                Choices[spot] = new Appointment(name, StartTime, EndTime, BallMachine, Court); // fill in the array
                ChoiceIndex[spot] = FileLine;
                spot++;
                foundOne = true;
            }
            else{
                sc.nextLine();
            }
            FileLine++;
        }
        sc.close();

        //Step 3: Give user all options under the input name and ask for which specific appointment they want to edit
        int request = 0;
        boolean didcatch;
        do{
            didcatch = false;
            System.out.println("Which of these appointments do you want to edit/delete? (\u001B[3mType the corresponding integer\u001B[0m)");
            for(int i = 0; i < Choices.length; i++){
                System.out.printf("\u001B[35m%4d: \u001B[0m\n", (i + 1));
                Choices[i].PrintOptions();
            }
            System.out.println();
            try {
                request = input.nextInt();
                input.skip("\\R");
            } catch (Exception e) {
                System.out.println("Unacceptable input. Try again. (" + e + ")");
                input.nextLine();
                didcatch = true;
            }
            if(!didcatch){
                if(request < 1 || request > ArraySize){
                    System.out.println("Unacceptable input. Try again. (\u001B[3mInput should be between 1 and " + ArraySize + "\u001B[0m)");
                }
            }
        } while(request < 1 || request > ArraySize);

        LineNum.close();
        return ChoiceIndex[request - 1];

    }
    public static void Method1(Scanner input){
        int request = 0;
        boolean didcatch = false;

        do{
            didcatch = false;
            System.out.println("Enter 1 to edit the appointment or enter 2 to delete the appointment. ");
            try {
                request = input.nextInt();
                input.skip("\\R");
            } catch (Exception e) {
                System.out.println("Unacceptable input. Try again. (" + e + ")");
                didcatch = true;
                input.nextLine();
            }
            if(!didcatch){
                if(request < 1 || request > 2){
                    System.out.println("Unacceptable input. Try again. (Input should be 1, 2, or 3)");
                }
            }
        } while(request < 1 || request > 2);

        if(request == 1){
            //editreservation menu
        }
        else if(request == 2){
            //delete reservation confirmation
        }
    }
}