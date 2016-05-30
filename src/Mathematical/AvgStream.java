package Mathematical;

/**
 * Average of a stream of numbers.
 * Created by jp on 5/28/16.
 */
public class AvgStream {
    static int sum = 0;
    static float getAvg(int n, int size) {
        float avg = 0;
        sum = sum + n;
        return (float)sum/++size;
    }

    static void streamAvg(int[] a) {
        for(int i=0;i<a.length;i++){
            System.out.print(getAvg(a[i], i) + " ");
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        streamAvg(a);
    }
}
