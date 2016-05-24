package String;

/**
 * Design an algorithm and write code to remove the duplicate characters in a string.
 * Created by jp on 5/23/16.
 */
public class RemoveDuplicateChars {
    public static String removeDuplicates(String str) {
        if(str == null || str.length()<2) return null;
        char[] s = str.toCharArray();
        boolean[] map = new boolean[256];
        for(int i=0;i<256;i++) {
            map[i]=false;
        }
        map[s[0]]=true;
        int j=1;
        for (int i=1;i<s.length;i++) {
            if(map[s[i]]==false) {
                map[s[i]]=true;
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
