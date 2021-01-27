public class Rocket2{
    public static void main(String [] args){     //2 args  in  and out
        TOP();
        VShape();
        System.out.println();
        VShape();
        TOP();
        System.out.println();
        TOP();
        BOX();
        System.out.println("|United|");
        System.out.println("|States|");
        BOX();
        TOP();
    }
    public static void TOP() {
        System.out.println("   /\\");
        System.out.println("  /  \\"); 
        System.out.println(" /    \\");
    }
    public static void VShape(){
        System.out.println(" \\    /");
        System.out.println("  \\  /");
        System.out.println("   \\/");
    }
    public static void BOX(){
        System.out.println("+------+");
        System.out.println("|      |");
        System.out.println("|      |");
        System.out.println("+------+");
    }
}