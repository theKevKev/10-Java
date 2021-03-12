import java.util.Scanner;
public class omnomnom {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("omnomnom??? ");
        String playerResponse = input.nextLine();
        if(playerResponse.contains("omnomnom")){
            System.out.println("\nomnomnom :)");
            omnomnomMethod(0);
        } else{
            System.out.println("\nOmNomNom!?!?! >:(");
            omnomnomMethod(40);
        }
        input.close();
    }
    public static void omnomnomMethod(int x){
        for(int i = 1; i <= 50; i++){
            System.out.print("omnomnom! OmNomNom?! OMNOMNOM!!! ");
            if(x == 0){
                System.out.println(":)");
            } else{
                System.out.println(">:(");
                x--;
            }
        }
    }
}
