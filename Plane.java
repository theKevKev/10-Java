

//Determine if a flight is available on __ day going to ____
//Book a seat on said flight

public class Plane {
    private int ID;
    private String location;
    private int capacity;
    private String Type;
    private int[][] Seats;

    public Plane(){
        
    }
    public Plane(int ID, String Type){
        Method();
        for(int[] n: Seats){
            capacity += n.length;
        }
    }

    public void Method(){
        if(Type.equalsIgnoreCase("A380")){
            Seats = new int[60][10];
        } 
        else if(Type.equals("777")){
            Seats = new int[80][9];
        }
        else{
            throw new IllegalArgumentException("This plane does not exist! ");
        }
    }
    public void GoAwayErrors(){
        System.out.println(ID + " " + location + " " + capacity);
    }
}
