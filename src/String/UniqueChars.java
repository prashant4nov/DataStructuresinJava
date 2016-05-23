package String;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * Created by jp on 5/23/16.
 */
public class UniqueChars {
    public static boolean isUniqueChars(String str) {
        if (str.length()>256) return false;
        boolean[] chars = new boolean[256];
        for(int i=0;i<str.length();i++) {
            int val = str.charAt(i);
            if(chars[val]) return false;
            chars[val]=true;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "abcde";
        boolean bool = isUniqueChars(str);
        System.out.println(bool);
    }
}
