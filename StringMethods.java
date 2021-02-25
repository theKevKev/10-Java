import java.util.Random;
public class StringMethods {
    public static void main(String[] args){
        //String Stuff
        String anothername = "Percent";
        String name = "MAria Suarez";
        char letter = name.charAt(3); //What letter is at that index?
        System.out.println(letter);
        int index = anothername.indexOf("e"); //What index is that letter at?
        System.out.println(index);
        String temp = anothername.substring(index + 1); //substring of a number is the letters including and after that index
        System.out.println(temp);
        System.out.println(temp.indexOf("e") + index + 1); //prints second instance of the letter e

        //Math stuff
        int num = 31;
        double result = Math.sqrt(num);
        System.out.printf("The answer is %.2f", result);
        System.out.println();

        //Random generation
        double randomNum = Math.random(); //gives you a real number between 0 and 1
        System.out.println(randomNum);
        int randomInt = (int) (Math.random()*10000); //random number between 0 and 10000
        System.out.println(randomInt);

        Random randy = new Random();
        int number = randy.nextInt(5) + 1;
        double num1 = randy.nextDouble() + 1;
        System.out.println(number);
        System.out.println(num1);
    }   
}
