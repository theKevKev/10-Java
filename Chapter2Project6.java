public class Chapter2Project6 {
    public static final int SIZE = 1;
    public static void main(String[] args){
        Needle();
        Head();
        Bottom();
        Needle();
        Support();
        Head();
    }

    public static void Needle(){
        for(int line = 1; line <= SIZE; line++){
            for(int i = 1; i <= 3 * SIZE; i++){
                System.out.print(" ");
            }
            System.out.println("||");
        }
    }

    public static void Head(){
        for(int line = 1; line <= SIZE; line++){
            for(int i = 1; i <= 3 * (SIZE - line); i++){
                System.out.print(" ");
            }
            System.out.print("__/");
            for(int j = 1; j <= 3 * line - 3; j++){
                System.out.print(":");
            }
            System.out.print("||");
            for(int k = 1; k <= 3 * line - 3; k++){
                System.out.print(":");
            }
            System.out.println("\\__");
        }
        System.out.print("|");
        for(int l = 1; l <= 6 * SIZE; l++){
            System.out.print("\"");
        }
        System.out.println("|");
    }

    public static void Bottom(){
        for(int line = 1; line <= SIZE; line++){
            for(int i = 1; i <= 2 * line - 2; i++){
                System.out.print(" ");
            }
            System.out.print("\\_");
            for(int j = 1; j <= -2 * line + 3 * SIZE + 1; j++){
                System.out.print("/\\");
            }
            System.out.print("_/");
            System.out.println();
        }
    }

    public static void Support(){
        for(int line = 1; line <= 4 * SIZE; line++){
            for(int i = 1; i <= 3 * SIZE - 3; i++){
                System.out.print(" ");
            }
            System.out.println("|%%||%%|");
        }
    }
}
