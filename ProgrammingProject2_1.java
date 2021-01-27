public class ProgrammingProject2_1 {
    public static final int Height = 37;
    public static void main(String[] args){
        for(int line = 1; line <= Height; line++){
            asterisk(line);
            space(line);
            forwardslash(line);
            backwardsslash(line);
            space(line);
            asterisk(line);
            System.out.println();
        }
    }
    public static void asterisk(int line){
        for(int i = 1; i <= Height - line; i++){
            System.out.print("*");
        }
    }
    public static void space(int line){
        for(int i = 1; i <= line; i++){
            System.out.print(" ");
        }
    }
    public static void forwardslash(int line){
        for(int i = 1; i <= 2 * Height - 2 - 2 * (line - 1); i++){
            System.out.print("/");
        }
    }
    public static void backwardsslash(int line){
        for(int i = 1; i <= 2 * (line - 1); i++){
            System.out.print("\\");
        }
    }
}
