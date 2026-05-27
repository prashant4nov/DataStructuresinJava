import java.io.*;

class GFG {
    static int trailingZeroes(int n)
    {
        // Edge Case
        if (n < 0)
            return -1;

        // Initialize result
        int count = 0;

        // Keep dividing n by powers
        // of 5 and update count
        for (int i = 5; i <= n; i = i*5)
            count += n / i;

        return count;
    }

  
    public static void main(String[] args)
    {
        int n = 10;
        System.out.println(trailingZeroes(n));
    }
}
