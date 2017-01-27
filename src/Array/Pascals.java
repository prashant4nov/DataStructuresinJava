public class Pascals {
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
