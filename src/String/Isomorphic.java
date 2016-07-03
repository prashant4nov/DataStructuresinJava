package String;

/**
 * Created by Prashant on 7/3/16.
 * http://www.geeksforgeeks.org/check-if-two-given-strings-are-isomorphic-to-each-other/
 */
public class Isomorphic {
    public boolean isIsomorphic(char[] a, char[] b) {
        int aLen = a.length;
        int bLen = b.length;
        if(aLen!=bLen) return false;
        int[] mp = new int[256]; // to map str 1 to str 2.
        boolean[] visited = new boolean[256]; // to check whether the char at i has been already visited in str2 or not.
        int i=0;
        while(i<aLen) {
            if(mp[a[i]]==0) { // no mapping present yet.
                if(visited[b[i]]) return false;
                visited[b[i]] = true;
                mp[a[i]] = b[i]; // create mapping.
            } else if(mp[a[i]]!=b[i]) return false; // if already mapped with different char.
            i++;
        }
        return true;
    }
    public static void main(String[] args) {
        Isomorphic is = new Isomorphic();
        char[] a = "aab".toCharArray();
        char[] b = "xxy".toCharArray();
        //char[] b = "xyz".toCharArray();
        System.out.println(is.isIsomorphic(a,b));
    }
}
