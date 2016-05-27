package Mathematical;

/**
 * http://www.geeksforgeeks.org/lucky-numbers/
 * Created by jp on 5/26/16.
 */
public class LuckyNumber {
    static int counter = 2;

    static boolean isLucky(int n) {
        if(n<counter) return true;
        if(n%counter==0) return false;
        int nextPos = n-(n/counter);
        counter++;
        return isLucky(nextPos);

    }
    public static void main(String[] args) {
        System.out.print(isLucky(19));
    }
}
