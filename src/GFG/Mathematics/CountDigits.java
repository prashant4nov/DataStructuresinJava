// Give a number, count the number of digits.
// https://www.geeksforgeeks.org/batch/dsa-at-your-own-pace/track/DSASP-Mathematics/video/MTgzNQ%3D%3D

import java.util.*;

public class Main {
  public static int digitsCount(int num) {
      int digits = 0;

      while(num > 0) {
          num = num / 10;
          digits++;
      }
      return digits;
  }
  
  public static void main(String[] args) {
    List<Integer> numbers = List.of(00, 1, 123, 10000);
    
    for(int num: numbers){
        System.out.println(digitsCount(num));
    }
  }
}
