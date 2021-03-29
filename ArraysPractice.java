/* Recieves data about temperatures and calculates number of days that were above average weather. 
This program was made to be able to accept non-integer temperature values and still work. 

Kevin Han
Java: C-Block
*/
import java.util.*;

public class ArraysPractice {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("How many days' temperatures? ");
        int size = input.nextInt(), counter = 0;
        double average = 0;
        double[] numbers = new double[size];
        for(int i = 0; i < size; i++){
            System.out.print("Day " + (i + 1) + "'s high temp: ");
            numbers[i] = input.nextDouble();
            average += numbers[i];
        }
        average /= size;
        System.out.printf("Average temp = %.1f\n", average);
        input.close();
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] > average){
                counter++;
            }
        }
        System.out.println(counter + " days were above average. ");

        //Day 2 of Arrays:
        
        // double[] otherNumbers = Arrays.copyOf(numbers, size);
        // System.out.println(Arrays.toString(otherNumbers));
        // double[] otherNumbers2 = Arrays.copyOf(numbers, size - 1);
        // System.out.println(Arrays.toString(otherNumbers2));

        // Arrays.sort(otherNumbers);
        // System.out.println(Arrays.toString(otherNumbers));
        // if(Arrays.equals(numbers, otherNumbers)){
        //     System.out.println("Same array");
        // } else{
        //     System.out.println("Not the same array");
        // }
        // if(Arrays.binarySearch(otherNumbers, 54) < 0){
        //     System.out.println("54 is not a value in the array");
        // }

        //Finding lowest and highest temperatures:

        //System.out.println("\nTemperatures: " + Arrays.toString(numbers));
        int[] newnumbers = new int[size];
        for(int i = 0; i < size; i++){
            newnumbers[i] = (int)Math.round(numbers[i]); 
        }
        System.out.println("\nTemperatures (rounded): " + Arrays.toString(newnumbers));
        Arrays.sort(numbers);
        System.out.printf("Two coldest days: %.0f, %.0f\n", numbers[0], numbers[1]);
        //System.out.println("Two coldest days: " + numbers[0] + ", " + numbers[1]);
        System.out.printf("Two hottest days: %.0f, %.0f\n", numbers[numbers.length - 1], numbers[numbers.length - 2]);
        //System.out.println("Two hottest days: " + numbers[numbers.length - 1] + ", " + numbers[numbers.length - 2]);
    }
}