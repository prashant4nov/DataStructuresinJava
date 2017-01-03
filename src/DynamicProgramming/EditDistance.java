package DynamicProgramming;

/**
 * Created by Prashant on 6/25/16.
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * complexity: O(mn)
 */

// TODO: 1. use String a and b 2. add check if a and b are null e.g. 
// if(a==null&&b==null) return 0;
// if(a==null) return b.length();
// if(b==null) return a.length();
// which one is for (m-1,n), (m,n-1) and (m-1,n-1)

public class EditDistance {
    public int editDistance(char[] a, char[] b) {
        int[][] edit = new int[a.length+1][b.length+1];

        for(int i=0;i<b.length+1;i++) {
            edit[0][i] = i;
        }

        for(int i=0;i<a.length+1;i++) {
            edit[i][0] = i;
        }

        for(int i=1;i<edit.length;i++) {
            for(int j=1;j<edit[i].length;j++) {
                if(a[i-1]==b[j-1]) {
                    edit[i][j] = edit[i-1][j-1];
                } else {
                    edit[i][j] = Math.min(edit[i][j-1], Math.min(edit[i-1][j-1], edit[i-1][j]))+1;
                }
            }
        }
        return edit[a.length][b.length];
    }

    public static void main(String[] args) {
        String str1 = "azced";
        String str2 = "abcdef";
        EditDistance ed = new EditDistance();
        int result = ed.editDistance(str1.toCharArray(), str2.toCharArray());
        System.out.print(result);
    }
}
