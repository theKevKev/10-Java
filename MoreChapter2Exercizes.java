public class MoreChapter2Exercizes {
    
    public static final int NumOfFibonacci = 12;
    public static final int NumOfLines = 5;
    public static void main(String[] args){
        
        //Question 3

        System.out.println("\nQuestion 3: \n");        
        int Num1 = 1, Num2 = 1;
        System.out.print(Num1 + " ");
        for(int num = 1; num <= NumOfFibonacci - 1; num++){
            System.out.print(Num1 + " ");
            Num1 = Num1 + Num2;
            Num2 = Num1 - Num2;
        }
        System.out.println();
        
        //Question 5

        System.out.println("\nQuestion 5: \n");
        for(int line = 1; line <= NumOfLines; line++){
            for(int i = 1; i <= line; i++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("\n\nProblems 9, 11, and 15 are on the other link from last class' homework.\n\n");
    }
}
