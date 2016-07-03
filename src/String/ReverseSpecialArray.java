package String;

/**
 * Created by Prashant on 7/3/16.
 */
public class ReverseSpecialArray {
    public boolean isAlphabet(char c) {
        if((c>='A'&&c<='Z')||(c>='a'&&c<='z')) return true;
        return false;
    }
    public void reverse(char[] s) {
        int start = 0, end = s.length-1;
        while(start<end) {
            if(!isAlphabet(s[start])) start++;
            else if(!isAlphabet(s[end])) end--;
            else {
                char tmp = s[start];
                s[start] = s[end];
                s[end] = tmp;
                start++;end--;
            }
        }
    }
    public static void main(String[] args) {
        ReverseSpecialArray ra = new ReverseSpecialArray();
        char[] a = "a,b$c".toCharArray();
        ra.reverse(a);
        System.out.print(a);
    }
}
