import java.util.*;

public class test {
    public static void main(String[] args){
        Scanner sc = new Scanner("word1 word2 word3 word4 word5");
        while(sc.hasNext()){
            if(sc.next().equals("name") != true){
                System.out.println(sc.next());
            }
        }
        
        sc.close();
    }
}
