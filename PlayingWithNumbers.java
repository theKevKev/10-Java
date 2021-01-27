public class PlayingWithNumbers {
    /*public static final double tax = 8.0/100; //static constant (final) or static variable (if not final)
    public static final double tips = 0.15; //the keywords public static allow the variable/constant to be used in every method
    //global variables or constants
    public static void main(String[] args){
        double bill1 = 23.89; //only usable in this method
        double bill2 = 34.45; //local variables or constants
        double bill3 = 41.29;
        double sum = bill1 + bill2 + bill3;
        System.out.println("The total is " + sum);
        System.out.println("The tax is " + sum*tax);
        System.out.println("The tips are " + sum * tips);
        tax(sum);
    }
    public static void tax(double summer){
        double taxes = summer*tax;
        System.out.println(taxes);

    }*/
    public static void main(String[] args){
        for(int line = 1; line <=5; line++){
            for(int star = 0; star < line; star++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
