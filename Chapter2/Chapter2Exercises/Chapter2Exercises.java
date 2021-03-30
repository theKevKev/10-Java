
package Chapter2.Chapter2Exercises;
public class Chapter2Exercises {

    //Question 9 Variables: 

    public static final int SIZE = 40;

    //Question 11 Variables: 
    public static final int Base = 8;
    public static final int NumberOfRepetitions = 7;

    //Question 17 Variables:
    public static final int Height = 8;
    
    //Main Program
    public static void main(String[] args){
        
        //Question 7

        System.out.println("\nQuestion 7: \n");
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= 5 - i; j++){
                System.out.print(" ");
            }
            System.out.println(i);
        }

        //Question 9

        System.out.println("\nQuestion 9: \n");
        FortyDash();
        System.out.println();
        Line2();
        System.out.println();
        DoubleCount();
        System.out.println();
        FortyDash();
        System.out.println();

        //Question 11

        System.out.println("\nQuestion 11: \n");
        PrintBars(Base);
        PrintNumbers(Base);

        //Question 13

        System.out.println("\nQuestion 13: \n");
        for(int j = 1; j <= 5; j++){
            for(int i = 9; i >= 0; i--){
                for(int k = 1; k <= 5; k++){
                    System.out.print(i);
                }
            }
            System.out.println();
        }

        //Question 15

        System.out.println("\nQuestion 15: \n");
        printDesign();

        //Question 17

        System.out.println("\nQuestion 17: \n");
        for(int line = 1; line <= Height; line++){
            for(int i = 1; i <= line - 1; i++){
                System.out.print("\\\\");
            }
            for(int j = 1; j <= (2 * Height - 1) - 2 * (line - 1); j++){
                System.out.print("!!");
            }
            for(int i = 1; i <= line - 1; i++){
                System.out.print("//");
            }
            System.out.println();
        }
    }

    //Question 9 Methods:

    public static void FortyDash() {
        for(int i = 1; i <= SIZE; i++){
            System.out.print("-");
        }
    }
    public static void Line2(){
        for(int i = 1; i <= SIZE/4; i++){
            System.out.print("_-^-");
        }
    }
    public static void DoubleCount(){
        for(int i = 1; i <= SIZE/2; i++){
            System.out.print(i%10);
            System.out.print(i%10);
        }
    }

    //Question 11 Methods: 

    public static void PrintBars(int Receive){
        for(int i = 1; i <= NumberOfRepetitions; i++){
            for(int j = 1; j <= Base - 1; j++){
                System.out.print(" ");
            }
            System.out.print("|");
        }
        System.out.println();
    }
    public static void PrintNumbers(int Reciever){
        for(int i = 1; i <= Base * NumberOfRepetitions; i++){
            System.out.print(i % Base);
        }
        System.out.println();
    }
    
    //Question 15 Methods: 

    public static void printDesign(){
        for(int line = 1; line <= 5; line++){
            Dashes(line);
            for(int j = 1; j <= 2 * line - 1; j++){
                System.out.print(2 * line - 1);
            }
            Dashes(line);
            System.out.println();
        }
    }
    public static void Dashes(int line){
        for(int i = 1; i <= 6 - line; i++){
            System.out.print("-");
        }
    }
}
