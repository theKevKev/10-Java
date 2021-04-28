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
    public void LockInAppointment(){
        //Check for court/machine availablility
        //If possible, update data log with appointment
    }
}
