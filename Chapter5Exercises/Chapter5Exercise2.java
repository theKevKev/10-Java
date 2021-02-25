package Chapter5Exercises;

public class Chapter5Exercise2 { //GCD Calculator
    public static void main(String[] args){
        int a = 1416, b = -33571;
        int GCD = GCD(a,b);
        System.out.println("The greatest common divisor of " + a + " and " + b + " is " + GCD + ".");
    }
    public static int GCD(int a, int b){ 
        System.out.println("GCD(" + a + ", " + b + ")");
        a = Math.abs(a);
        b = Math.abs(b);
        if(a < b){
            a = a + b; //switch a and b
            b = a - b;
            a = a - b;
        } //now b is always >= a
        while(a != 0 && b != 0){
            //want a = b and b = a % b
            int temp = b;
            b = a % b;
            a = temp;
            System.out.println("GCD(" + a + ", " + b + ")");
        } //euclidian algorithm takes place
        //currently should be left with and integer and zero
        //choose non-zero number:
        if(a == 0){
            return b;
        } else{ //b must be zero
            return a;
        }
    }
}
