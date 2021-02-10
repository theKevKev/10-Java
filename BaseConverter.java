public class BaseConverter {
    public static void main(String[] args){
        int starter = 812346;
        int base = 3;
        for (int i = 0; i <= 20; i++){
            
            System.out.println("number is " + starter);
            System.out.println(starter%base);
            starter = starter/base;
        }
        if (starter == 0){
            //stop program

        }
    }
}
