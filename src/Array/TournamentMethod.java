package Array;

/**
 * Created by Prashant on 6/12/16.
 * Maximum and minimum of an array using minimum number of comparisons
 * total number of comparisons is 3/2 n - 2
 */

public class TournamentMethod {
    static class MinMax {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    }

    public static MinMax minMax(int a[], int l, int r) {
        MinMax mm = new MinMax();
        if (l == r) {
            mm.max = a[l];
            mm.min = a[l];
            return mm;
        }

        if (r == l + 1) {
            if (a[l] < a[r]) {
                mm.min = a[l];
                mm.max = a[r];
            } else {
                mm.max = a[l];
                mm.min = a[r];
            }
            return mm;
        }


        int mid = (l + r) / 2;

        MinMax minMaxL = minMax(a, l, mid);
        MinMax minMaxR = minMax(a, mid + 1, r);

        if (minMaxL.min < minMaxR.min) {
            mm.min = minMaxL.min;
        } else {
            mm.min = minMaxR.min;
        }

        if (minMaxL.max > minMaxR.max) {
            mm.max = minMaxL.max;
        } else {
            mm.max = minMaxR.max;
        }
        return mm;
    }

    public static void main(String[] args) {
        int[] a = {1000, 11, 445, 1, 330, 3000};
        MinMax mm = minMax(a, 0, a.length - 1);
        System.out.print(mm.min + " " + mm.max);
    }
}
