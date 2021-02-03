public class Exercize1_9 {
    public static void main(String[] args){
        Top();
        Bottom();
        Middle();
        Top();
        Bottom();
        Middle();
        Bottom();
        Top();
        Middle();
        Bottom();
    }
    public static void Top() {
        System.out.println("  _______");
        System.out.println(" /       \\");
        System.out.println("/         \\");
    }   
    public static void Bottom() {
        System.out.println("\\         /");
        System.out.println(" \\_______/");
        System.out.println("");
    }   
    public static void Middle() {
        System.out.println("-\"-'-\"-'-\"-");
    }
}
