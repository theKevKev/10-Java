public class Classwork {
    public static void main(String[] args){
        for(int line = 1; line <= 5; line++){
            frontdots(line);
            System.out.print(line);
            backdots(line);
            System.out.println();
        }
    }
    public static void frontdots(int line){
        for(int dots = 1; dots <= 5-line; dots++){
            System.out.print(".");
        }
    }
    public static void backdots(int asterisk) {
        for(int dots = 1; dots <= asterisk - 1; dots++){
            System.out.print(".");
        }
    }
}
