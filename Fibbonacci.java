public class Fibbonacci {
    public static void main(String[] args){
        int i = 1, j = 1;
        System.out.println(i);
        for(int num = 1; num <= 40; num++){
            System.out.println(i);
            i = i + j;
            j = i - j;
        }
    }
}
