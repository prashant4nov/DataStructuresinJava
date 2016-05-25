package String;

/**
 * http://javahungry.blogspot.com/2014/12/5-ways-to-reverse-string-in-java-with-example.html
 * using character array and string builder.
 * Created by jp on 5/24/16.
 */
public class ReverseString {
    private static String reverseString(String str) {
        char[] s = str.toCharArray();
        int i=0,j;
        j=s.length-1;
        while(i<j) {
            char tmp = s[i];
            s[i]=s[j];
            s[j]=tmp;
            i++;j--;
        }
        return new String(s);
    }

    private static String reverseStringBuilder(String str) {
        StringBuilder s = new StringBuilder();
        s.append(str);
        s.reverse();
        return new String(s);
    }
    public static void main(String[] args) {
        System.out.println(reverseString("hello").toString());
        System.out.println(reverseStringBuilder("hello").toString());

    }
}
