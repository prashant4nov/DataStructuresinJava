
import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.Math.toIntExact;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tarjan {
    private static Scanner input;
    private static List<Integer>[] adj;
    private static int scc, id;
    private static boolean[] onStack;
    private static int[] visited, lowLink;
    private static Stack<Integer> stack;


    public static void tarjan() {
        id = 0;
        scc = 0;
        visited = new int[adj.length];
        lowLink = new int[adj.length];
        onStack = new boolean[adj.length];
        stack = new Stack<Integer>();

        for(int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }

        for(int i = 0; i < adj.length; i++)
            if (visited[i] == -1)
                dfs(i);
    }

    private static void dfs(int s) {

        stack.push(s);
        onStack[s] = true;
        visited[s] = lowLink[s] = id++;

        for(int i = 0; i < adj[s].size(); i++) {
            int t = adj[s].get(i);
            if (visited[t] == -1) {
                dfs(t);
            }
            if (onStack[t] == true) {
                lowLink[s] = min(lowLink[s], lowLink[t]);
            }
        }

        if (visited[s] == lowLink[s]) {
            while(!stack.isEmpty()) {
                int v = stack.pop();
                onStack[v] = false;
                lowLink[v] = visited[s];
                if (v == s) break;
            }
            scc++;
        }

    }

    @SuppressWarnings("unchecked")
    public static void solve() {
        int n = toIntExact(input.nextLong());
        int m = toIntExact(input.nextLong());

        if(n < 1 || n > 20000) {
            System.out.println(0);
            return;
        }

        if(m < 0 || m > 50000) {
            System.out.println(0);
            return;
        }


         adj = new ArrayList[toIntExact(n)];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            int s1 = toIntExact(input.nextLong());
            if(s1 < 1) {
                System.out.println(0);
                return;
            }
            int s2 = toIntExact(input.nextLong());
            if(s2 > n) {
                System.out.println(0);
                return;
            }
            if(s1 == s2) {
                System.out.println(0);
                return;
            }

            adj[--s1].add(--s2);
        }

        tarjan();

        if(scc <= 1) {
            System.out.println(0);
            return;
        }


        int[] out = new int[scc];
        int[] in = new int[scc];
        for(int s = 0; s < n; s++) {
            for(int i = 0; i < adj[s].size(); i++) {
                int t = adj[s].get(i);
                if(visited[s] != visited[t]) {
                    out[visited[s]]++;
                    in[visited[t]]++;
                }
            }
        }

        int result1 = 0;
        int result2 = 0;
        for(int i = 0; i < scc; i++) {
            if(out[i] == 0)  {
                result1++;
            }
            if(in[i] == 0) {
                result2++;
            }
        }
        System.out.println(max(result1, result2));

    }

    public static void main(String[] arg) {
        try {
            input = new Scanner(System.in);
            int x = toIntExact(input.nextLong());
            if(x <= 100) {
                for(int i = 0; i < x; i++) {
                    solve();
                }
            } else {
                System.out.println(0);
            }

        } catch (Exception e) {
            System.out.println(0);
        }

    }
}



















