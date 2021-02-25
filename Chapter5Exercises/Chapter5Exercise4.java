package Chapter5Exercises;
import java.util.Random;
public class Chapter5Exercise4 { //RandomX 
    public static void main(String[] args){
        randomX();
    }
    public static void randomX(){
        Random randy = new Random();
        int num = 0;
        while(num < 16){
            num = randy.nextInt(16) + 5; // 0 to 15 (+5) is 5 to 20
            for(int i = 1; i <= num; i++){
                System.out.print("x");
            }
            System.out.println();
        }
    }
}
