/*
Kevin Han - Java Final Project
Sophomore Year: 2021
Main Class 

This program is the user interface where the user may choose between creating, editing, and deleting appointments under a booking system for a tennis center. 
This tennis center contains 16 courts, and is open from 8:00 am to 10:00 pm. 
There is only one ball machine in the facility, so there can only be one ball machine booking at a given time. 
*/
package FinalProject;
import java.io.*;
import java.util.*;

public class Courts {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        
        //User interface: 
        int request;
        do{
            //Figure out what the user wants to do
            request = 0;
            boolean didcatch = false; // represents whether an exception was caught
            do{
                didcatch = false;
                System.out.println("Enter 1 to make a new reserevation, enter 2 to view availabilities, or enter 3 to view/edit/delete a reservation.");
                try {
                    request = input.nextInt();
                    input.skip("\\R"); //I found out that nextInt does not consume the enter character
                } catch (Exception e) {
                    System.out.println("Unacceptable input. Try again. (" + e + ")");
                    input.nextLine();
                    didcatch = true;
                }
                //if an exception is caught there is no need to print this, 
                //but if no exception was caught there is a chance the input could be out of bounds
                if(!didcatch){ 
                    if(request < 1 || request > 3){
                        System.out.println("Unacceptable input. Try again. (Input should be 1, 2, or 3)");
                    }
                }
            } while(request < 1 || request > 3);

            //Feed into user's choices
            if(request == 1){
                NewReservation(input);
            }
            else if(request == 2){
                Appointment.ViewCourtSheet();
            }
            else if(request == 3){
                int FileLine = SearchReservation(input); // figures out which appointment the user would like to look at and gets its file line number. 
                do{
                    //Ask if they want to delete or edit
                    request = 0;

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
                        // Edit Appointment

                        //editreservation menu
                    }
                    else if(request == 2){
                        // Delete Appointment

                        // Give confirmation message
                        System.out.println("\u001B[31mWarning! This action cannot be undone! ");
                        // recieve confirmation
                        do{
                            String recieve;
                            didcatch = false; 
                            System.out.println("\u001B[31mAre you sure you want to delete this appointment? (\u001B[3mYes/No\u001B[0m\u001B[31m)\u001B[0m");
                            recieve = input.nextLine();
                            if((recieve.contains("y") || recieve.contains("Y")) && (recieve.contains("n") || recieve.contains("N"))){
                                System.out.println("Invalid response, please indicate either yes or no. ");
                                didcatch = true;
                            }
                            else if(recieve.contains("y") || recieve.contains("Y")){
                                // Nothing happens, request just can't be zero at this point
                            }
                            else if(recieve.contains("n") || recieve.contains("N")){
                                request = 0; // setting request to 0 goes back to the edit/delete question
                            }
                            else{
                                System.out.println("Invalid response, please indicate either yes or no. ");
                                didcatch = true;
                            }
                        }
                        while(didcatch);

                        //Confirm Deletion
                        //Delete Appointment
                    }
                    System.out.println(FileLine);
                }
                while(request == 0);
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
                    // Nothing happens, request just can't be zero at this point
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
        // End of program
        System.out.println("Thank you for using this booking system! ");
        input.close();
    }
    public static void NewReservation(Scanner input) throws FileNotFoundException{
        //Option 1: Make a new reservation
            //show courtsheet
            //ask user for inputs
            //attempt to place reservation
        //if reservation attempt failes, let user change variables and retry
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

        // Recieve all inputs and check for availability of court
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
                    // Time slots should be in 15-min intervals and between 8:00 am and 10:00pm (not including 10pm)
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
                    // Time slots should be in 15-min intervals and between 8:00 am and 10:00pm (not including 8am)
                    if(EndTime <= 800 || EndTime > 2200 || !(EndTime % 100 == 0 || EndTime % 100 == 15 || EndTime % 100 == 30 || EndTime % 100 == 45) || EndTime <= StartTime){
                        System.out.println("Invalid Time, please try again. (\u001B[3mTimes are placed at 15-minute slots\u001B[0m)");
                    }
                }
            } while(EndTime <= 800 || EndTime > 2200 || !(EndTime % 100 == 0 || EndTime % 100 == 15 || EndTime % 100 == 30 || EndTime % 100 == 45) || EndTime <= StartTime); 
            // Also checks that the ending time is after the start time above

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
        app.PrintReceipt();
    }
    public static int SearchReservation(Scanner input) throws FileNotFoundException{
        // This method allows the user to input a String and gives options for appointments that contain the input
        Scanner sc = new Scanner(new File("FinalProject/AppointmentData.txt"));

        String FindName;
        int ArraySize;
        int FileLine;
        String MemoryFileLine;
        String name;
        do{
            // Collect name to search for
            System.out.print("Please enter the name under the appointment you are looking for: ");
            FindName = input.nextLine();
            
            //Step 1: Locate any appointment that contains the input and figure out how many there are. 
            //ArraySize will count how many appointments are under that name
            ArraySize = 0; 
            FileLine = 1; 
            // MemoryFileLine will store all the line numbers in the data file that are under the input name (mainly for efficiency purposes)
            MemoryFileLine = ""; 

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

            if(ArraySize == 0){
                // No matches under that name
                System.out.println("No appointments were found under the name <" + FindName + ">. Please try again. ");
                sc = new Scanner(new File("FinalProject/AppointmentData.txt"));
            }
        }
        while(ArraySize == 0);

        MemoryFileLine = MemoryFileLine.substring(0, MemoryFileLine.length() - 1); //we just want to cut off the last comma
        Appointment[] Choices = new Appointment[ArraySize];                        //setting up the array to contain all the possible choices
        int[] ChoiceIndex = new int[ArraySize];                                    //after the user chooses an appointment from the Choices array, it will return the line that that appoitnment was on. 

        //Step 2: Knowing the number of appointments there are under the input name, we can locate each one and put it into an array
        sc = new Scanner(new File("FinalProject/AppointmentData.txt")); //reset scanner
        int StartTime, EndTime, Court;
        boolean BallMachine;
        FileLine = 1; 
        Scanner LineNum = new Scanner(MemoryFileLine).useDelimiter(","); // Not sure why it says LineNum isn't closed, it is closed on line 370
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
                // Collect/Create appointment
                Scanner Line = new Scanner(sc.nextLine()).useDelimiter(":");
                Court = Line.nextInt();
                name = Line.next();
                StartTime = Line.nextInt();
                EndTime = Line.nextInt();
                BallMachine = Line.nextBoolean();
                
                // This kind of works like a dictionary, with Choices and ChoiceIndex being used together
                Choices[spot] = new Appointment(name, StartTime, EndTime, BallMachine, Court); // fill in the array
                ChoiceIndex[spot] = FileLine; // fill in the corresponding file line
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
            // Prints each option under the input name and assigns it a corresponding integer
            for(int i = 0; i < Choices.length; i++){
                System.out.printf("\u001B[35m%4d: \u001B[0m\n", (i + 1));
                Choices[i].PrintOptions();
            }
            System.out.println();
            // User should attempt to type the corresponding integer of the appointment they want to edit/delete
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
        // return the file line number of the appointment they choose
        return ChoiceIndex[request - 1];
    }
}