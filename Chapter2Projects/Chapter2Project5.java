package Chapter2Projects;

public class Chapter2Project5 {
    public static final int SIZE = 3;

    public static void main(String[] args){
        Cone();
        LineThing();
        Top();
        Bottom();
        LineThing();
        Bottom();
        Top();
        LineThing();
        Cone();
    }
    public static void Cone(){
        for(int line = 1; line <= 2 * SIZE - 1; line++){
            Spaces(line);
            for(int fslash = 1; fslash <= line; fslash++){
                System.out.print("/");
            }
            System.out.print("**");
            for(int bslash = 1; bslash <= line; bslash++){
                System.out.print("\\");
            }
            Spaces(line);
            System.out.println();
        }
    }
    public static void LineThing(){
        System.out.print("+");
        for(int i = 1; i <= 2 * SIZE; i++){
            System.out.print("=*");
        }
        System.out.println("+");
    }
    public static void Top(){
        for(int line = 1; line <= SIZE; line++){
            System.out.print("|");
            for(int reps = 1; reps <= 2; reps++){
                dots(line);
                A(line);
                dots(line);
            }
            System.out.println("|");
        }
    }
    public static void Bottom(){
        for(int line = SIZE; line >= 1; line--){
            System.out.print("|");
            for(int reps = 1; reps <= 2; reps++){
                dots(line);
                V(line);
                dots(line);
            }
            System.out.println("|");
        }
    }
    public static void Spaces(int line){
        for(int spaces = 1; spaces <= 2 * SIZE - line; spaces++){
            System.out.print(" ");
        }
    }
    public static void dots(int line){
        for(int dot = 1; dot <= SIZE - line; dot++){
            System.out.print(".");
        }
    }
    public static void A(int line){
        for(int A = 1; A <= line; A++){
            System.out.print("/\\");
        }
    }
    public static void V(int line){
        for(int V = 1; V <= line; V++){
            System.out.print("\\/");
        }
    }
}
