import java.io.*;

public class GCD {

    static int gcdNaive(int a, int b)
    {
        int gcd = Math.min(a, b);
        while(gcd >= 1) {
          if(a%gcd == 0 && b%gcd == 0) {
            break;
          } else {
            gcd--;
          }
        }
      
        return gcd;
    }
  
  static int gcdEuclideanSubstraction(int a, int b) {
    while(a != b) {
      if(a > b) {
        a = a-b;
      } else {
        b = b-a;
      }
    }
    
    return a;
  }
  
    static int gcdEuclideanOptimized(int a, int b) {
        if(b == 0) return a;
        return gcdEuclideanOptimized(b, a%b);
    }

    public static void main(String[] args)
    {
        int a = 20, b = 28;
        System.out.println(gcdNaive(a, b));
        System.out.println(gcdEuclideanSubstraction(a, b));
        System.out.println(gcdEuclideanOptimized(a, b));
    }
} 
