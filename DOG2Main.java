import java.util.*;

public class DOG2Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        DOG2 dog1 = new DOG2();
        DOG2 dog2 = new DOG2("fluffy", "terrier", 6, "black");
        // dog1.name = "fluffy";
        // dog1.breed = "terrier";
        // dog1.age = 6;
        // dog1.color = "black";
        System.out.println(DOG2.toString(dog1)); //static methods require calling of the class
        System.out.println(dog1.toString());     //non-static methods require calling of the object
        System.out.println(dog1.getName());

        // dog1.name = "peter";                  Through use of private variables, these no longer work. 
        // System.out.println(dog1.name);
        
        dog2.setName("Peter");
        System.out.println(dog2.getName());

        DOG2[] doggies = new DOG2[4];
        for(int i = 0; i < doggies.length; i++){
            System.out.print("\nPlease enter name: ");
            String name = input.next();
            System.out.print("\nPlease enter breed: ");
            String breed = input.next();
            System.out.print("\nPlease enter age: ");
            int age = input.nextInt();
            System.out.print("\nPlease enter color: ");
            String color = input.next();
            doggies[i] = new DOG2(name, breed, age, color);
        }
        System.out.println(Arrays.toString(doggies));
        System.out.println();
        input.close();

        System.out.println(dog1.bark());
    }
}