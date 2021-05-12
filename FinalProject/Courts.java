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
                } catch (Exception e) {
                    System.out.println("Unacceptable input. Try again. (" + e + ")");
                    input.next();
                    didcatch = true;
                }
                if(!didcatch){
                    if(request < 1 || request > 3){
                        System.out.println("Unacceptable input. Try again. (Input should be 1, 2, or 3)");
                    }
                }
            } while(request < 1 || request > 3);

            if(request == 1){
                NewReservation();
            }
            else if(request == 2){
                Appointment.ViewCourtSheet();
            }
            else if(request == 3){
                int FileLine = SearchReservation();
                //Ask if they want to delete or edit
                do{
                    didcatch = false;
                    System.out.println("Enter 1 to edit this reservation or enter 2 to delete this reservation.");
                    try {
                        request = input.nextInt();
                    } catch (Exception e) {
                        System.out.println("Unacceptable input. Try again. (" + e + ")");
                        input.next();
                        didcatch = true;
                    }
                    if(!didcatch){
                        if(request < 1 || request > 2){
                            System.out.println("Unacceptable input. Try again. (Input should be 1 or 2)");
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
            //Checks if user still wants to make more reservations/continue the program. 
            do{
                String recieve;
                didcatch = false; 
                System.out.println("Would you like to continue using this reservation system? (Yes/No)");
                recieve = input.next();
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
    public static void NewReservation() throws FileNotFoundException{
        //Option 1: Make a new reservation
            //show courtsheet
            //ask user for inputs
            //attempt to place reservation
        //if reservation attempt failes, ask user what they want to change
        //once placed:
        //confirmation text + court they are on
        //place onto file
        Scanner input = new Scanner(System.in);
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
                } catch (Exception e) {
                    System.out.println("Unacceptable input. Try again. (" + e + ")");
                    input.next();
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
                } catch (Exception e) {
                    System.out.println("Unacceptable input. Try again. (" + e + ")");
                    input.next();
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
            } catch (Exception e) {
                System.out.println("Unacceptable input. Try again. (" + e + ")");
                input.next();
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
        input.close();
    }
    public static int SearchReservation() throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(new File("FinalProject/AppointmentData.txt"));

        System.out.print("Please enter the name under the appointment you are looking for: ");
        String FindName = input.nextLine();
        
        //Step 1: Locate any appointment that contains the input and figure out how many there are. 
        String name;
        int ArraySize = 0; //This will count how many appointments are under that name. 
        int FileLine = 1;
        String MemoryFileLine = "";
        while(sc.hasNextLine()){
            Scanner Line = new Scanner(sc.nextLine()).useDelimiter(":");
            Line.next();
            name = Line.next();
            Line.next();
            Line.next();
            Line.next();
            if(name.toLowerCase().contains(FindName.toLowerCase())){
                ArraySize++;
                MemoryFileLine += FileLine + ",";
            }
        }
        Appointment[] Choices = new Appointment[ArraySize];
        input = new Scanner(new File("FinalProject/AppointmentData.txt"));
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
            
        }

        FileLine = 2;
        input.close();

        return FileLine;
    }
}
