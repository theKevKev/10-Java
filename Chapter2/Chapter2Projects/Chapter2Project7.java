package Chapter2.Chapter2Projects;

public class Chapter2Project7 {
    public static final int SIZE = 8; //This program work for all SIZE ≥ 8
    public static void main(String[] args){
        for(int i = 1; i <= SIZE + 1; i++){
            System.out.print(" ");
        }
        HorizontalLine();
        System.out.println();
        Book();
        HorizontalLine();
        for(int i = 1; i <= SIZE; i++){
            System.out.print("/");
        }
        System.out.println();
        Pages();
        HorizontalLine();
        System.out.println();
    }
    public static void HorizontalLine(){
        System.out.print("+");
        for(int i = 1; i <= 3 * SIZE; i++){
            System.out.print("-");
        }
        System.out.print("+");
    }
    public static void Book(){
        for(int line = 1; line <= SIZE; line++){
            for(int space = 1; space <= SIZE + 1 - line; space++){
                System.out.print(" ");
            }
            System.out.print("/");
            for(int longspace = 1; longspace <= 3 * SIZE - 3 * line; longspace++){
                System.out.print(" ");
            }
            System.out.print("_");
            for(int repeat = 1; repeat <= line; repeat++){
                System.out.print("__/");
            }
            for(int slash = 1; slash <= line - 1; slash++){
                System.out.print("/");
            }
            System.out.println();
        }
    }
    public static void Pages(){
        for(int line = 1; line <= SIZE / 2; line++){
            System.out.print("|");
            for(int space = 1; space <= (3 * SIZE - 22) / 2; space++){
                System.out.print(" ");
            }
            System.out.print("Building Java Programs");
            for(int space = 1; space <= (3 * SIZE - 22) / 2; space++){
                System.out.print(" ");
            }
            for(int i = 1; i <= SIZE % 2; i++){ //In case SIZE is odd, we need to print an extra space after the text
                System.out.print(" ");
            }
            System.out.print("|");
            for(int slash = 1; slash <= 2 + SIZE - 2 * line; slash++){
                System.out.print("/");
            }
            System.out.println();
        }
    }
}
