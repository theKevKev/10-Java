import java.util.Scanner;
public class Chapter4Exercise3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean variable = true;
        do{
            System.out.print("Month?: ");
            int month = input.nextInt();
            System.out.print("Date?: ");
            int day = input.nextInt();
            String season = Season(month, day);
        
            if(season.equals("false") == true){
                System.out.println("The entered date of " + month + "/" + day + " is not a valid date. Please enter a valid date:");
            } else{
                System.out.println("This date is during the season of " + season + ".");
                System.out.println("Would you like to check another date?");
                season = input.next();
                variable = false;
                if(season.contains("y") || season.contains("Y")){
                    variable = true;
                }
            }
        } while(variable == true);
        input.close();
    }
    public static String Season(int m, int d){
        if((m == 12 && d >= 16 && d <= 31) || (m == 1 && d >= 1 && d <= 31) || (m == 2 && d >= 1 && d <= 29) || (m == 3 && d <= 15 && d >= 1)){
            return ("winter");
        } else if((m == 3 && d >= 16 && d <= 31) || (m == 4 && d >= 1 && d <= 30) || (m == 5 && d >= 1 && d <= 31) || (m == 6 && d <= 15 && d >= 1)){
            return ("spring");
        } else if((m == 6 && d >= 16 && d <= 30) || (m == 7 && d >= 1 && d <= 31) || (m == 8 && d >= 1 && d <= 31) || (m == 9 && d <= 15 && d >= 1)){
            return ("summer");
        } else if((m == 9 && d >= 16 && d <= 30) || (m == 10 && d >= 1 && d <= 31) || (m == 11 && d >= 1 && d <= 30) || (m == 12 && d <= 15 && d >= 1)){
            return ("spring");
        } else {
            return ("false");
        }
    }
}

