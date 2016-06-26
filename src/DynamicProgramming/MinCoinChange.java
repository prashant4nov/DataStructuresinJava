package DynamicProgramming;

/**
 * Created by Prashant on 6/26/16.
 * http://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 *
 */
public class MinCoinChange {
    public int minCoins(int total, int[] coins) {
        int[] res = new int[total+1];
        res[0]=0;
        for(int i=1;i<=total;i++) {
            res[i] = Integer.MAX_VALUE-1;
        }

        for(int j=0;j<coins.length;j++) {
            for(int i=coins[j];i<=total;i++) {
                if(res[i-coins[j]]+1 < res[i]) {
                    res[i] = res[i-coins[j]] + 1;
                }
            }
        }
        return res[total];
    }
    public static void main(String[] args) {
        int total = 4;
        int coins[] = {1,2,3};
        MinCoinChange cc = new MinCoinChange();
        int bottomUpValue = cc.minCoins(total, coins);
        System.out.print(bottomUpValue+" ");
    }
}
