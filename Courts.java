import java.io.*;
import java.util.*;

public class Courts {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        
        //Figure out what the user wants to do
        int request = 0;
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
            //recieve reservation name and decide which reservation they want. 
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

        // Appointment app1 = new Appointment();

        //Option 1: Make a new reservation
        //do{
            //show courtsheet
            //give inputs
            //check for availability
        //while(available)
        //if available:
        //confirmation text + court they are on
        //place onto file

        // Appointment.ViewCourtSheet();

        String Name = "Kevin";
        //Open 8:00 am - 10:00 pm
        int StartTime = 800;
        boolean BallMachine = false;
        int Court = 1;
        int Duration = 90;
        Appointment app2 = new Appointment(Name, StartTime, BallMachine, Court, Duration);

        Name = "Thumby Forcel";
        //Open 8:00 am - 10:00 pm
        StartTime = 1015;
        int EndTime = 1115;
        BallMachine = true;
        Court = 4;
        
        Appointment app3 = new Appointment(Name, StartTime, EndTime, BallMachine, Court);

        // app1.PrintDetails();
        // app2.PrintDetails();
        app3.PrintDetails();
        app2.LockInAppointment();

        input.close();
    }
    public static void NewReservation(){
        
    }
}
