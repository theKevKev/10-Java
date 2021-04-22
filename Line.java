import java.awt.*;
public class Line {
    //Initialize Variables
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    //Question 9 Methods
    public Line(Point p1, Point p2){
        if(!(p1.equals(p2))){
            x1 = p1.x;
            y1 = p1.y;
            x2 = p2.x;
            y2 = p2.y;
        }
        else{
            System.out.println("Both points equal, try again. ");
        }
    }
    public Point getP1(){
        return new Point(x1, y1);
    }
    public Point getP2(){
        return new Point(x2, y2);
    }
    public String toString(){
        return "[(" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + ")]";
    }

    //Mutator Methods
    public void changeP1(Point newP1){
        if(newP1.equals(new Point(x2, y2)) != true){
            x1 = newP1.x;
            y1 = newP1.y;
        }
        else{
            System.out.println("Equivalent points, try again. ");
        }
    }
    public void changeP2(Point newP2){
        if(newP2.equals(new Point(x1, y1)) != true){
            x1 = newP2.x;
            y1 = newP2.y;
        }
        else{
            System.out.println("Equivalent points, try again. ");
        }
    }

    //Question 10 Methods
    public double getSlope(){
        if(x1 == x2){
            throw new IllegalArgumentException("Slope is undefined! ");
        }
        else{
            return (((double)y2 - (double)y1)/((double)x2 - (double)x1));
        }
    }

    //Question 11 Methods
    public Line(int X1, int X2, int Y1, int Y2){
        x1 = X1;
        x2 = X2;
        y1 = Y1;
        y2 = Y2;
    }

    //Question 12 Methods:
    public boolean isCollinear(Point p){
        if(p.equals(new Point(x1, y1)) || p.equals(new Point(x2, y2))){
            return true;
        }
        else if(x1 == x2){
            if(p.x == x1){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if(p.x == x1 || p.x == x2){
                return false;
            }
            double slope1 = ((double)y1 - p.y)/((double)x1 - p.x);
            double slope2 = ((double)y2 - p.y)/((double)x2 - p.x);
            //Round slopes
            slope1 *= 10000;
            slope1 = Math.round(slope1);
            slope1 /= 10000;
            slope2 *= 10000;
            slope2 = Math.round(slope2);
            slope2 /= 10000;
            if(slope1 == slope2){
                return true;
            }
            else{
                return false;
            }
        }
    }
}
