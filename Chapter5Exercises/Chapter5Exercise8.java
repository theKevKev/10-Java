package Chapter5Exercises;
import java.util.Random;
public class Chapter5Exercise8 { //random walk
    public static void main(String[] args){
        randomWalk();
    }
    public static void randomWalk(){
        Random randy = new Random();
        int position = 0, maxPosition = 0;
        while(Math.abs(position) < 3){
            int num = randy.nextInt(2); //num is 0 or 1
            if(num == 0){
                num = -1;
            } //now num = -1 or 1
            position = position + num;
            System.out.println("position = " + position);
            if(position > maxPosition){
                maxPosition = position;
            }
        }
        System.out.println("max position = " + maxPosition);
    }
}
