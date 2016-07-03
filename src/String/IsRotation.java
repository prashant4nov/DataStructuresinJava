package String;

/**
 * Created by Prashant on 7/3/16.
 * Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (i e , “waterbottle” is a rotation of “erbottlewat”).
 */
public class IsRotation {
    public boolean isRotation(String a, String b) {
        if(a.length()==b.length()&& (a+b).indexOf(b)!=-1) return true;
        return false;
    }
    public static void main(String[] args) {
        IsRotation ir = new IsRotation();

        System.out.print(ir.isRotation("waterbottle", "erbottlewat"));
    }
}
