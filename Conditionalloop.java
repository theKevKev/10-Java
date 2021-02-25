/*
Learning about while loops, reviewing methods, and practicing if statements
Kevin Han
February 22, 2021
*/
public class Conditionalloop {
    public static void main(String[] args){
        boolean test = LessUseless(8, "Grade");
        UselessMethod(2, "Peter", test);    // static method: no object reference
                                           //void: does not return values
    }
    private static void UselessMethod(int num, String name, boolean test){
        //checks for condition first
        System.out.println(num);
        while(test){ //automatically means while true (only for booleans)
            System.out.println(num);
            num++;                                  //what if we want it to happen once before checking?
            if(num > 5){
                test = false;
            }
        }
        //runs once before checking condition
        do{
            System.out.println(num);
            num--;
        }                               //print once, then do while next
        while(num > 2);
    }
    public static boolean LessUseless(int num, String name){ //replace "void" with the variable type you want to return
        if(num > 7 && name.equalsIgnoreCase("grade")){
            return true;
        }
        else{
            return false;
        }
    }
}
