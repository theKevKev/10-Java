import java.awt.*;

public class LineMain {
    public static void main(String[] args){
        Point first = new Point(0, 2);
        Point second = new Point(3, 6);
        Line myLine = new Line(first, second);
        System.out.println(myLine.getP1());
        System.out.println(myLine.getP2());
        System.out.println(myLine.toString());
        System.out.printf("%.2f\n", myLine.getSlope());
        System.out.println(myLine.isCollinear(new Point(-3, -2)));
    }
}
