package Homework5;

public class Homework5_2 {
    public static void main(String[] args){
        Five();
        Dice();
        System.out.println("");
        Five();
        Dice();
        Five();
        System.out.println("");
        One();
        Five();
        Dice();
    }
    public static void Five() {
        System.out.println("*****");
        System.out.println("*****");
    }
    public static void Dice() {
        System.out.println(" * * ");
        System.out.println("  *  ");
        System.out.println(" * * ");
    }
    public static void One() {
        for (int i = 0; i <= 2; i++){
            System.out.println("  *  ");
        }
    }
}
