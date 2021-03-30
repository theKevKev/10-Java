package Chapter7Exercises;

public class Chapter7Exercise4 {
    public static void main(String[] args){
        double[] list = {1.5, 4.3, 7.0, 19.5, 25.1, 46.2};
        boolean result = isSorted(list);
        System.out.println(result);
    }
    public static boolean isSorted(double[] list){
        for(int i = 0; i < list.length - 1; i++){
            if(list[i] > list[i + 1]){
                return false;
            }
        }
        return true;
    }
}
