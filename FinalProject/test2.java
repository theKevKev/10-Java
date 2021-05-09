package FinalProject;

public class test2 {
    public static void main(String[] args){
        CourtSheet1();
        //version 2
        // CourtSheet2();
    }
    public static void CourtSheet1(){
        System.out.print("\t  ");
        for(int courts = 1; courts <= 16; courts++){
            System.out.printf("Court %-2d   ", courts);
        }
        System.out.println();
        for(int k = 1; k <= 14; k++){
            for(int d = 1; d <= 4; d++){
                System.out.print("{");
                if((k + 7) / 10 == 0){
                    System.out.print("0");
                }
                System.out.print(k + 7 + ":");
                if(d == 1){
                    System.out.print("0");
                }
                System.out.print(15 * d - 15 + "}\t");
                for(int j = 1; j <= 16; j++){
                    System.out.print("[");
                    for(int i = 1; i <= 9; i++){
                        System.out.print(" ");
                    }
                    System.out.print("]");
                }
                System.out.println();
            }
            System.out.print("--------");
            for(int e = 1; e <= 16; e++){
                System.out.print("+---------+");
            }
            System.out.println();
        }
    }
    public static void CourtSheet2(){
        System.out.print("\t  ");
        for(int courts = 1; courts <= 16; courts++){
            System.out.printf("Court %-2d   ", courts);
        }
        System.out.println();
        for(int k = 1; k <= 10; k++){
            for(int d = 1; d <= 4; d++){
                System.out.print("{12:00}\t");
                System.out.print("[");
                for(int j = 1; j <= 15; j++){
                    for(int i = 1; i <= 10; i++){
                        System.out.print(" ");
                    }
                    System.out.print("|");
                }
                System.out.print("          ]");
                System.out.println();
            }
            System.out.print("--------+");
            for(int e = 1; e <= 16; e++){
                System.out.print("----------+");
            }
            System.out.println();
        }
    }
}
