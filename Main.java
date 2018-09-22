import java.util.*;
import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.Math.toIntExact;

public class Main {
    private static Scanner input;
    private  List<Integer>[] adj;
    private  int sccCount;
    private  int[] visited;
    private  int[] inStack;
    private  int findIdx, stkIdx;
    private  int[] stack;
    private  int[] vFind;
    private  int[] contract;

    private int scc(int nd) {
        inStack[nd] = visited[nd] = 1;
        stack[++stkIdx] = nd;
        vFind[nd] = ++findIdx;
        int mn = vFind[nd];

        for(int i = 0; i < adj[nd].size(); i++) {
            if(visited[adj[nd].get(i)] == 0) {
                mn = min(mn, scc(adj[nd].get(i)));
            }
            if(inStack[adj[nd].get(i)] == 1) {
                mn = min(mn, vFind[adj[nd].get(i)]);
            }
        }
        if(mn == vFind[nd]) {
            sccCount++;
            do {
                inStack[stack[stkIdx]] = 0;
                contract[stack[stkIdx]] = sccCount;
            } while(stack[stkIdx--] != nd);
        }
        return mn;
    }

    private void solve() {
        input = new Scanner(System.in);
        int n, m, x, y;
        n = toIntExact(input.nextLong());
        m = toIntExact(input.nextLong());

        adj = new ArrayList[n+1];
        for(int i = 0; i <=n; i++ ) {
            adj[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            int s1 = toIntExact(input.nextLong());
            int s2 = toIntExact(input.nextLong());
            adj[s1].add(s2);
        }

        visited = new int[adj.length];
        inStack = new int[adj.length];
        stack = new int[adj.length];
        vFind = new int[adj.length];
        contract = new int[adj.length];
        sccCount = 0;
        findIdx = 0;
        stkIdx = 0;

        for(int i = 1; i <= n; i++) {
            if(visited[i] == 0) {
                findIdx = stkIdx = 0;
                scc(i);
            }
        }

        int indeg[] = new int[adj.length];
        int outdeg[] = new int[adj.length];

        for(int i = 1; i <= n; i++) {
            int u = contract[i], v;
            for(int j = 0; j < adj[i].size(); j++) {
                v = contract[adj[i].get(j)];
                if(u != v) {
                    outdeg[u]++;
                    indeg[v]++;
                }
            }
        }

        int in = 0, out = 0;
        for(int i = 1; i <= sccCount; i++) {
            if(indeg[i] == 0) in++;
            if(outdeg[i] == 0) out++;
        }

        if(sccCount == 1) {
            System.out.println(0);
        }
        else {
            System.out.println(max(in, out));
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        Main sol = new Main();
        input = new Scanner(System.in);
        int testcase, n, m, x, y;

        testcase = toIntExact(input.nextLong());

        while(testcase-- > 0) {
            sol.solve();
        }
    }
}
