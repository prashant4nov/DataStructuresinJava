package String;

/**
 * Write a method to replace all spaces in a string with ‘%20’.
 *  check string buffer solution as well: https://gist.github.com/cclxz/2575945
 * Created by jp on 5/25/16.
 * TODO: http://articles.leetcode.com/microsoft-string-replacement-problem/
 */
public class ReplaceSpaces {
    private static String ReplaceSpaces(String str) {
        char[] s = str.toCharArray();
        int len = s.length;
        int spaceCount = 0;
        for(int i=0;i<len;i++) {
            if(s[i]==' ') spaceCount++;
        }
        int newLen = len+spaceCount*2;
        char[] r = new char[newLen];
        for(int j=len-1;j>=0;j--) {
            if(s[j]==' ') {
                r[newLen-1]='0';
                r[newLen-2]='2';
                r[newLen-3]='%';
                newLen=newLen-3;
            } else {
                r[newLen - 1] = s[j];
                newLen--;
            }
        }
        return new String(r);
    }

    public static void main(String[] args) {
        System.out.println(ReplaceSpaces("hello   how are you?"));
    }
}
