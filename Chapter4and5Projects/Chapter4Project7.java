package Chapter4and5Projects;
public class Chapter4Project7 {
    public static final int rows = 11;
    public static void main(String[] args){
        for(int line = 0; line <= rows - 1; line++){
            for(int i = 1; i <= 2 * rows - 2 * line; i++){
                System.out.print(" ");
            }
            for(int j = 0; j <= line; j++){
                System.out.printf("%4d", Choose(line, j));
            }
            System.out.println();
        }
    }
    public static int Choose(int x, int y){
        return Fact(x)/(Fact(y) * Fact(x - y));
    }
    public static int Fact(int x){
        int product = 1;
        for(int i = 1; i <= x; i++){
            product *= i;
        }
        return product;
    }
}
/*                  1                   0 choose 0
                  1   1                 1 choose 0/1
                1   2   1
              1   3   3   1             i choose 
            1   4   6   4   1
          1   5   10  10  5   1
        1   6   15  20  15  6   1
      1   7   21  35  35  21  7   1
    1   8   28  56  70  56  28  8   1
  1   9   36  84  126 126 84  36  9   1
1   10  45  120 210 252 210 120 45  10  1 */
