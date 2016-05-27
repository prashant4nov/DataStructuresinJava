package Mathematical;

/**
 * Created by jp on 5/26/16.
 */
public class MultipleofThree {
    static boolean isMultipleofThree(int n) {
        if(n==0) return true;
        if(n==1) return false;
        if(n<0) n = -n;
        int oddCount = 0, evenCount = 0;
        int res;
        while(n != 0) {
            res = n&1;
            if(res == 1) {
                oddCount++;
            }
            n=n>>1;

            res = n&1;
            if(res==1) {
                evenCount++;
            }
            n=n>>1;
        }
        return isMultipleofThree(oddCount-evenCount);
    }
    public static void main(String[] args) {
       System.out.print(isMultipleofThree(9));
    }
}
