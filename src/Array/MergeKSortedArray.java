package Array;

import java.util.PriorityQueue;

/**  Priority Queue is Heap in Java.
 * Created by Prashant on 7/2/16.
 * http://www.geeksforgeeks.org/merge-k-sorted-arrays/
 */

class ArrayContainer implements Comparable<ArrayContainer>{
    int[] a;
    int index;

    public ArrayContainer(int[] a, int index) {
        this.a = a;
        this.index = index;
    }

    @Override
    public int compareTo(ArrayContainer o) {
        return this.a[this.index] - o.a[o.index];
    }
}

public class MergeKSortedArray {
    public static void main(String[] args) {
        int arr[][] = { {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}} ;

        PriorityQueue<ArrayContainer> q = new PriorityQueue<ArrayContainer>();

        int total = 0;
        for(int i=0;i<arr.length;i++) {
            q.add(new ArrayContainer(arr[i], 0));
            total+=arr.length;
        }

        int[] res = new int[total];

        while(!q.isEmpty()) {
            ArrayContainer ac = q.poll();

            System.out.print(ac.a[ac.index] + ",");

            if(ac.index < ac.a.length-1) {
                q.add(new ArrayContainer(ac.a, ac.index+1));
            }
        }

        System.out.print(" ");
    }
}
