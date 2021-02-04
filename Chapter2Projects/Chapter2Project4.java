package Chapter2Projects;

public class Chapter2Project4 {
    public static final int SIZE = 5;

    public static void main(String[] args){
        for(int layer = 1; layer <= SIZE; layer++){ //Loops per layer
            HeadLine(layer);
            BodyLine(layer);
            FeetLine(layer);
        }
        Floor();
    }
    public static void HeadLine(int layer){
        Spaces(layer);
        System.out.print("  o  ");
        System.out.print("******");
        AntiSpaces(layer);
        System.out.println("*");
    }
    public static void BodyLine(int layer){
        Spaces(layer);
        System.out.print(" /|\\ ");
        System.out.print("*");
        AntiSpaces(layer + 1);
        System.out.println("*");
    }
    public static void FeetLine(int layer){
        Spaces(layer);
        System.out.print(" / \\ ");
        System.out.print("*");
        AntiSpaces(layer + 1);
        System.out.println("*");
    }
    public static void Floor(){
        for(int i = 1; i <= 5 * SIZE + 7; i++){
            System.out.print("*");
        }
        System.out.println();
    }
    public static void Spaces(int layer){ //These are the spaces before the person
        for(int j = 1; j <= 5 * SIZE - 5 * layer; j++){
            System.out.print(" ");
        }
    }
    public static void AntiSpaces(int layer){ //These are the spaces after the person
        for(int j = 1; j <= 5 * layer - 5; j++){
            System.out.print(" ");
        }
    }
}
