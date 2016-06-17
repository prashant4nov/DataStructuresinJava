package Array;

/**
 * Created by Prashant on 5/30/16.
 * Write a program to print all the LEADERS in the array. 
 * An element is leader if it is greater than all the elements to its right side.
 */
public class Leaders {
    static void leaders(int[] a) {
        int leader = a.length-1;
        System.out.print(a[leader]+" ");
        for(int i=a.length-2;i>=0;i--) {
            if(a[i]>a[leader]) {
                leader = i;
                System.out.print(a[leader]+" ");
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {16, 17, 4, 3, 5, 2};
        leaders(arr);
    }
}
