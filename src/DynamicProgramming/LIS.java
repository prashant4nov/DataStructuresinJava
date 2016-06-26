package DynamicProgramming;

/**
 * Created by Prashant on 6/25/16.
 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 * TODO: nlogn solution
 */
public class LIS {
    public int lis(int[] a) {
        int[] t = new int[a.length];
        for(int i=0;i<t.length;i++) {
            t[i]=1;
        }

        for(int i=1;i<a.length;i++) {
            for(int j=0;j<i;j++) {
                if(a[j]<a[i]) {
                    t[i]=Math.max(t[i], t[j]+1);
                }
            }
        }

        int maxIndex = 0;
        for(int i=1;i<a.length;i++) {
            if(a[i]>a[maxIndex]) {
                maxIndex = i;
            }
        }
        return t[maxIndex];
    }
    public static void main(String[] args) {
        LIS lis = new LIS();
        int[] a = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        System.out.println(lis.lis(a)+" ");

        int [] b = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.print(lis.lis(b)+" ");


    }
}
