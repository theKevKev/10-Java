public class Courts {
    public static void main(String[] args){
        Appointment app1 = new Appointment();

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

        app1.PrintDetails();
        app2.PrintDetails();
        app3.PrintDetails();
    }
}
