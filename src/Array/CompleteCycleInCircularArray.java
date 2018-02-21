/**
 * Given a circular array of relative indices, find out if there is a complete cycle. Each cell
 * points relatively to another cell (e.g., -1 to the previous cell, 2 to the second next cell and 0
 * to the same cell). A complete cycle corresponds to visiting all the cells, only once each.
 *
 * Example:
 *   [2, 2, -1] --> true
 *   [2, 2, 0] --> false
 *   [0] --> true
 *   [1, -1] --> true
 *
 * reference: https://github.com/frncsrss/interviews/blob/master/src/core/interviews/arrays/CompleteCycleInCircularArray.java
 */
 import java.util.*;
public class CompleteCycleInCircularArray {
  /**
   * Let n = length(arr).
   * Time complexity:  O(n)
   * Space complexity: O(1)
   */
  public static boolean f(int[] arr) {
      int index = 0;  // starting index, the value does not matter if there is indeed a complete cycle
      int n = arr.length;
      for(int i = 0; i < n; i++) {
       // in Java, -b < a % b < b but 0 < (a % b + b) % b < b
          index = ((index + arr[index]) % n + n) % n; 
          if(index == 0 && i < n-1) return false;   // subcyle
      }
      return index == 0;
  }
  
  
  public static void main(String args[]) {
      int a[] = {2, 2, -1};
      System.out.println(f(a));
      int b[] = {2,2,0};
      System.out.println(f(b));
      int[] c = {0};
      System.out.println(f(c));
      int[] d = {1,-1};
      System.out.println(f(d));
  }
  
}
