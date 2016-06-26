package DynamicProgramming;

/**
 * Created by Prashant on 6/25/16.
 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 * Complexity: O(mn)
 */
public class MinCostPath {
    public int minCost(int[][] cost, int m, int n) {
        int[][] res = new int[m][n];
        res[0][0] = cost[0][0];
        for(int i=1;i<m;i++) {
            res[i][0] = res[i-1][0] + cost[i][0];
        }

        for(int i=1;i<n;i++) {
            res[0][i] = res[0][i-1] + cost[0][i];
        }

        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                res[i][j] = cost[i][j] + Math.min(res[i-1][j-1], Math.min(res[i-1][j], res[i][j-1]));
            }
        }
        return res[m-1][n-1];
    }

    public static void main(String[] args) {
        MinCostPath mcp = new MinCostPath();
        int cost[][] = {
                {1,2,3},
                {4,8,2},
                {1,5,3}};
        int result = mcp.minCost(cost, 3, 3);
        System.out.println(result);
    }
}
