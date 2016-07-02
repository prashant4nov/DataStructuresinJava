package Mathematical;
import java.util.ArrayList;

/**
 * Created by jp on 5/27/16.
 * http://www.geeksforgeeks.org/print-all-combinations-of-points-that-can-compose-a-given-number/
 */
public class ComposeGivenNumber {
    static ArrayList<Integer> arr = new ArrayList<Integer>();
    static void printCombinations(int n, int i) {
        if(n == 0) {
            for(int j = 0; j<i; j++) {
                System.out.print(arr.get(j) + " ");
            }
            System.out.println(" ");
        } else if(n>0){
            for(int k = 1; k<=3; k++) {
                arr.add(i,k);
                printCombinations(n-k,i+1);
            }
        }
    }
    public static void main(String[] args) {
        printCombinations(3,0);
    }
}
