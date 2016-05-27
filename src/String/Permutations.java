package String;

/**
 * Complexity O(n*n!)
 * Created by jp on 5/26/16.
 */
public class Permutations {
    static void swap(char[] s, int i, int j) {
        char tmp = s[j];
        s[j] = s[i];
        s[i] = tmp;

    }
    static void permute(char[] s, int l, int r) {
        if(l==r) {
            System.out.println(s);
        } else {
            int i;
            for (i = l; i <= r; i++) {
                swap(s, i, l);
                permute(s, l + 1, r);
                swap(s, i, l);
            }
        }

    }
    public static void main(String[] args) {
        char[] str = "abc".toCharArray();
        permute(str, 0, str.length-1);
    }
}
