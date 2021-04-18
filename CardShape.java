public class CardShape {
    public static final int SIZE = 8;
    public static void main(String[] args){
        Close();
        Top();
        Bottom();
        Close();
    }
    public static void Close(){
        System.out.print("#");
        for(int i = 1; i <= 4 * SIZE; i++){
            System.out.print("=");
        }
        System.out.println("#");
    }
    public static void Top(){
        for(int line = 1; line <= SIZE; line++){
            System.out.print("|");
            Spaces(line);
            System.out.print("<>");
            for(int period = 1; period <= 4 * line - 4; period++){
                System.out.print(".");
            }
            System.out.print("<>");
            Spaces(line);
            System.out.println("|");
        }
    }
    public static void Bottom(){
        for(int line = SIZE; line > 0; line--){
            System.out.print("|");
            Spaces(line);
            System.out.print("<>");
            for(int period = 1; period <= 4 * line - 4; period++){
                System.out.print(".");
            }
            System.out.print("<>");
            Spaces(line);
            System.out.println("|");
        }
    }
    public static void Spaces(int here){
        for(int space = 1; space <= 2 * SIZE - 2 * here; space++){
            System.out.print(" ");
        }
    }
}
