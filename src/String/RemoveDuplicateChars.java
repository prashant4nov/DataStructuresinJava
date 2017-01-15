package String;

/**
 *
 * Design an algorithm and write code to remove the duplicate characters in a string.
 * Created by jp on 5/23/16.
 * using Set: http://code.geeksforgeeks.org/Jdkm8m
 * http://www.geeksforgeeks.org/remove-all-duplicates-from-the-input-string/
 */
public class RemoveDuplicateChars {
    private static String removeDuplicates(String str) {
        if(str == null || str.length()<2) return null;
        char[] s = str.toCharArray();
        boolean[] mp = new boolean[256];
        for(int i=0;i<256;i++) {
            mp[i]=false;
        }
        mp[s[0]]=true;
        int j=1;
        for (int i=1;i<s.length;i++) {
            if(!mp[s[i]]) {
                mp[s[i]]=true;
                s[j]=s[i];
                j++;
            }
        }
        return new String(s,0,j);
    }
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.print(removeDuplicates(str));
    }
}
