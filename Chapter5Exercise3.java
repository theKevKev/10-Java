import java.util.Scanner;
public class Chapter5Exercise3 {
    public static void main(String[] args){
        // toBinary. From decimal to binary
        Scanner input = new Scanner(System.in);
        System.out.println("What number would you like to convert?");
        int x = input.nextInt(); 
        System.out.println("What base would you like to convert to? (2 to 10 only)");
        int base = input.nextInt();
        input.close();
        toBinary(x);
        toOcto(x);
        toBase(x, base);
    }
    public static void toBinary(int x){
        int total = 0, place = 0;
        while(x > 0){
            total += (x % 2 * (int) Math.pow(10, place));
            x = x / 2;
            place++;
        }
        System.out.println("Your number in base 2 is " + total);
    }
    public static void toOcto(int x){
        int total = 0, place = 0;
        while(x > 0){
            total += (x % 8 * (int) Math.pow(10, place));
            x = x / 8;
            place++;
        }
        System.out.println("Your number in base 8 is " + total);
    }
    public static void toBase(int x, int base){
        int total = 0, place = 0;
        while(x > 0){
            total += (x % base * (int) Math.pow(10, place));
            x = x / base;
            place++;
        }
        System.out.println("Your number in base " + base + " is " + total);
    }
}
