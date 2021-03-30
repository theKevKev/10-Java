package Chapter7Exercises;

public class Chapter7Exercise5 {
    public static void main(String[] args){
        int[] array = {23, 15, 29, 23, 25, 13, 19, 14, 17, 13, 25, 23, 53, 46, 12, 19, 10, 20, 20, 10, 22, 12, 22, 19, 21, 23, 27, 49, 21};
        int mode = modeFind(array);
        System.out.println(mode);
    }
    public static int modeFind(int[] array){
        int[] counter = new int[101];
        for(int i = 0; i < array.length; i++){
            counter[array[i]]++;
        }
        int max = 0, index = 0;
        for(int i = 0; i < counter.length; i++){
            if(counter[i] > max){
                max = counter[i];
                index = i;
            }
        }
        return index;
    }
}
