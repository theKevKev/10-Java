package Chapter2Projects;

public class Chapter2Project3 {
    public static final int SIZE = 4;
    public static void main(String[] args){
        HorLine();
        Top();
        Bottom();
        HorLine();
        Bottom();
        Top();
        HorLine();
    }
    public static void HorLine(){
        System.out.print("+");
        for(int i = 1; i <= 2 * SIZE + 1; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }
    public static void Top(){
        for(int line = 1; line <= SIZE; line++){
            System.out.print("|");
            Spaces(line);
            F_slash(line);
            System.out.print("*");
            B_slash(line);
            Spaces(line);
            System.out.println("|");
        }
    }
    public static void Bottom(){
        for(int line = SIZE; line >= 1; line--){
            System.out.print("|");
            Spaces(line);
            B_slash(line);
            System.out.print("*");
            F_slash(line);
            Spaces(line);
            System.out.println("|");
        }
    }
    public static void Spaces(int line){
        for(int i = 1; i <= SIZE - line + 1; i++){
            System.out.print(" ");
        }
    }
    public static void F_slash(int line){
        for(int i = 1; i <= line - 1; i++){
            System.out.print("/");
        }
    }
    public static void B_slash(int line){
        for(int i = 1; i <= line - 1; i++){
            System.out.print("\\");
        }
    }
}
