// import java.util.*;
public class test3 {
    public static void main(String[] args){
        int grade1 = 3;
        int grade2 = 4;
        

        Student Noah = new Student("feature", grade1, grade2, 3, 4);
        String word = Noah.getName();
        System.out.println(word);
        System.out.println(Noah.getName());

        System.out.println(Noah.getMath());

        double newmathgrade = 4.33;

        Noah.setMath(newmathgrade);

        System.out.println(Noah.getMath());
    }
}
