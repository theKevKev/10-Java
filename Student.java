import java.io.*;
public class Student {
    private String name;
    private double history;
    private double science;
    private double english;
    private double math;

    public Student(){
        name = "whatever you want";
    }
    public Student(String name, double history, double science, double english, double math){
        this.name = name;
        this.history = history;
        this.science = science;
        this.math = math;
        //,..
    }
    
    //assesor methods
    public String getName(){
        return name;
    }
    public double getMath(){
        return math;
    }
//...

    //mutator methods: if you want to change a variable
    public void setMath(double math){
        this.math = math;
    }
    //...

    //useful methods
    public double getAverage(){
        return (math + history+ science+english)/4;
    }
    public void strengthweaknesses(){
        //find average of humanities
        //find average of arts
        //find average of stem courses
        //compare the three
        //print:
            //stem is their strongest aspect: they have a GPA in STEM of 4
            //arts is their second st: ggpa = 3.5
            //humnaities is their weakest : gpa = 3
    }
    public void CreateDocumentReport() throws FileNotFoundException{

        PrintStream output = new PrintStream("ReportFor"+ getName() + ".txt");
        //files

        output.println("Your math grade is " + getMath());
        if(getMath() > 3){
            output.println("You have a strong GPA in math. Keep workign hard");
        }
        else if(getMath() > 2){
            output.println("You have a decent GPA you got this");
        }
        else{
            output.println("your gpa in this class could be better: keep studying");
        }
        output.println("Your average GPA is " + getAverage());
        output.println("this gpa is ready for college! ");
        

        //create a file with a report 
        output.close();
    }
}
