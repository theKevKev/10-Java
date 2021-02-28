package Chapter4Exercises;
import java.util.Scanner;
public class Chapter4Exercise16 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("x-value?: ");
        double x = sc.nextDouble();
        System.out.print("y-value?: ");
        double y = sc.nextDouble();
        sc.close();
        quadrant(x, y);
    }
    public static void quadrant(double x, double y){
        int quadrant = 0;
        if(x != 0 && y != 0){
            if(x > 0){
                if(y > 0){ 
                    quadrant = 1;
                } else{ // y < 0
                    quadrant = 4;
                }
            } else{ // x < 0
                if(y > 0){ 
                    quadrant = 2;
                } else{ // y < 0
                    quadrant = 3;
                }
            }
        }
        System.out.println("Your point of (" + x + ", " + y + ") is in quadrant " + quadrant + ". ");
    }
}
