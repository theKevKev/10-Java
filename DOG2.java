//Class Declaration
public class DOG2 {
    //Instance Variables Fields
    private String name; //By making variables private, outside programs cannot change it. 
    private String breed;//so dog1.name would not work, and they would be forced to use the set methods. 
    private int age;
    private String color;

    //Constructors
    public DOG2(){
        name = "Niagra Falls Math Worksheet";
        
        age = 0;
        color = "agh";
    }
    public DOG2(String name1, String breed1, int age1, String color1){
        if(name1.length() <= 10){
            name = name1;
        }
        else{
            name = name1.substring(0, 9);
        }
        breed = breed1;
        if(age1 <= 20){
            age = age1;
        }
        else{
            age = 0;
        }
        color = color1;
    }

    //Assesor Methods - get values of your fields
    public String getName(){
        return name;
    }
    public String getBreed(){
        return breed;
    }
    public int getAge(){
        return age;
    }
    public String getColor(){
        return color;
    }

    //Mutator Methods - Change values of your fields
    public void setName(String newName){
        name = newName;
    }
    public void setBreed(String newBreed){
        breed = newBreed;
    }
    public void setAge(int newAge){
        age = newAge;
    }
    public void setColor(String newColor){
        color = newColor;
    }

    //Print Methods
    public static String toString(DOG2 ob){
        return ("The dog's name is " + ob.name + "      " + ob.breed + "  " + ob.age + "   " + ob.color);
    }
    @Override //unnecessary, but to show it's overriding an already created method. 
    public String toString(){
        return("Hi my name is " + name + ", and my breed, age, and color are " + breed + ", " + age + ", and " + color + ". ");
    }

    //
    public String bark(){
        return (name + " is barking right now Guau Guau! ");
    }
}
