package String;

/**
 * Created by Prashant on 7/3/16.
 * Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (i e , “waterbottle” is a rotation of “erbottlewat”).
 */
public class IsRotation {
    public boolean isRotation(String a, String b) {
        if(a==null&&b==null) return true;
        if(a==null||b==null) return false;
        int m = a.length();
        int n = b.length();
        if(m!=n) return false;
        String x = a+b;
        if(x.indexOf(b)==-1) return false;
        return true;
    }
    public static void main(String[] args) {
        IsRotation ir = new IsRotation();

        System.out.print(ir.isRotation("waterbottle", "erbottlewat"));
    }
}
