public class Main {

    // Function to calculate 
    // factorial of a number
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; ++i) {
            fact *= i;
        }
        return fact;
    }

    // Function to count trailing 
    // zeros in factorial
    public static int trailingZeroes(int n) {
        int count = 0;
        int fact = factorial(n);
      
        while(fact > 0) {
          int lastDigit = fact%10;
          if(lastDigit == 0) {
            count++;
          } else {
            break;
          }
          fact = fact/10;
        }
      
        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(trailingZeroes(n));  
    }
}
