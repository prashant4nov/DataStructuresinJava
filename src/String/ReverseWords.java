package String;

/**
 * Created by Prashant on 7/3/16.
 */
public class ReverseWords {

    public String reverseWords(String s) {
        if(s==null||s.length()==0) return null;

        String[] a = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = a.length-1;i>=0;i--) {
                sb.append(a[i]).append(" ");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "hi how are you?";

        ReverseWords rw = new ReverseWords();

        System.out.print(rw.reverseWords(s));
    }
}
