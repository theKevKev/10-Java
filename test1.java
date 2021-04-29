public class test1 {
    public static void main(String[] args){
        int x = 0;
        
        while(x < 3){
            try {
                System.out.println("hello");
                System.out.println(3/x);
                x++;
            } catch (Exception e) {
                System.out.println("problem");
                x++;
            }
        }
    }
}
