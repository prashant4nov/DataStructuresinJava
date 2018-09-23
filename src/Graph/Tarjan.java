
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


        adj = new ArrayList[toIntExact(n)];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            int s1 = toIntExact(input.nextLong());
            int s2 = toIntExact(input.nextLong());
            adj[--s1].add(--s2);
        }

        tarjan();



        boolean[] out = new boolean[scc];
        boolean[] in = new boolean[scc];
        for(int s = 0; s < scc; s++) {
            for(int i = 0; i < adj[s].size(); i++) {
                int t = adj[s].get(i);
                if(visited[s] != visited[t]) {
                    out[visited[s]] = true;
                    in[visited[t]] = true;
                }
            }
        }

        int result1 = 0;
        int result2 = 0;
        for(int i = 0; i < scc; i++) {
            if(!out[i])  {
                result1++;
            }
            if(!in[i]) {
                result2++;
            }
        }

        if(scc == 1) {
            System.out.println(0);
        } else {
            System.out.println(max(result1, result2));
        }

    }

    public static void main(String[] arg) throws java.lang.Exception{
        try {
            input = new Scanner(System.in);
            int x = toIntExact(input.nextLong());

                for(int i = 0; i < x; i++) {
                    solve();
                }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}



















