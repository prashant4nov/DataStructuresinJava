https://www.geeksforgeeks.org/batch/dsa-at-your-own-pace/track/DSASP-Mathematics/video/MTg1Mw%3D%3D
class GFG {

    static boolean isPalindrome(int n) {
        int reverse = 0;
        int tmp = n;
        while (tmp > 0) {
            int digit = tmp%10;
            reverse = reverse*10 + digit;
            tmp = tmp/10;
        }

        // If reverse is equal to the original number, the
        // number is palindrome
        return (reverse == n);
    }

    public static void main(String[] args) {
        int n = 12321;
        if (isPalindrome(n) == true) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }
}
