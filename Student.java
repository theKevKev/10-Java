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
    public void returnStats(){
        System.out.println("this kid wiht name" + name + "is very cool, he has this grade");
    }
    public void CreateDocumentReport(){
        //files
        //create a file with a report 
    }
}
