package Chapter5Exercises;

public class Chapter5Exercise10 { //hopscotch 
    public static void main(String[] args){
        hopscotch(3);
    }
    public static void hopscotch(int hops){
        if(hops >= 0){
            System.out.println("   1   ");
            int i = 1;
            while(i <= 3 * hops){
                System.out.println((i + 1) + "     " + (i + 2));
                System.out.println("   " + (i + 3) + "   ");
                i += 3;
            }
        }
    }
}
