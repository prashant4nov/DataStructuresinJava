public class Pascals {
    
    // time and space complexity O(n*n)
   public void printPascal(int n) {
        int a[][] = new int[n][n];
        
        for(int line = 0; line < n; line++) {
            for(int i = 0; i <= line; i++) {
               if(i == 0 || i == line) {
                System.out.print(1);
                a[line][i] = 1;
               } else {
                   System.out.print(a[line-1][i-1]+a[line-1][i]);
                   a[line][i] = a[line-1][i-1]+a[line-1][i];
               }   
            }
            System.out.println(" ");
       }
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        for (int line = 1; line <= numRows; line++) {
            List<Integer> li = new LinkedList<>();
            int c = 1;
            for (int i = 1; i <= line; i++) {
                li.add(c);
                c = ((line-i) * c) / i;
            }
            res.add(li);
        }
        return res;
    }
}
