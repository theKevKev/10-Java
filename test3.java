import java.util.*;
import java.io.*;
public class test3 {
    public static void main(String[] args) throws FileNotFoundException{
        int grade1 = 3;
        int grade2 = 4;
        
        Scanner input = new Scanner(System.in);
        int userinput;
        do{    
            System.out.println("Enter 1 to create a student or enter -1 to exit the program");
            userinput = input.nextInt();
            input.nextLine();
            if(userinput == 1){
                //Create a studnet
                System.out.println("Please type your name");
                String name = input.nextLine();
                System.out.println("Please type your grade");
                String year = input.nextLine();
                //mathgrade = coolectgrade math
                Student Student1 = new Student(name, grade1, grade2, 3, 4);
                do{    
                    System.out.println("Enter 1 to get average, enter 2 to generate report, enter 3 to look at strenghts/weaknesses or enter -1 to stop looking at this student");
                    userinput = input.nextInt();
                    input.nextLine();
                    if(userinput == 1){
                        System.out.print("here is your average gpa: ");
                        System.out.println(Student1.getAverage());
                    }
                    else if(userinput == 2){
                        Student1.CreateDocumentReport();
                        System.out.println("Success! ");
                    }
                    else if(userinput == 3){
                        Student1.strengthweaknesses();

                    }
                }
                while(userinput != -1);
            }
        }
        while(userinput != -1);
        System.out.println("End of program. BYEBYE");
    }
}
