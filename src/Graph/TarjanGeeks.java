import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.lang.Math.*;

public class Main {
    private static Scanner input;
    private static List<Integer>[] adj;
    private static int scc, time;
    private static boolean[] onStack;
    private static int[] disc, low, contract;
    private static Stack<Integer> stack;


    public static void tarjan() {
        time = 0;
        scc = 0;
        low = new int[adj.length];
        disc = new int[adj.length];
        onStack = new boolean[adj.length];
        contract = new int[adj.length];
        stack = new Stack<Integer>();

        for(int i = 0; i < adj.length; i++) {
            disc[i] = -1;
            low[i] = -1;
            onStack[i] = false;
            contract[i] = -1;
        }

        for(int i = 0; i < adj.length; i++)
            if (disc[i] == -1)
                dfs(i);
    }

    private static void dfs(int u) {

        stack.push(u);
        onStack[u] = true;
        disc[u] = low[u] = time++;

        for(int i = 0; i < adj[u].size(); i++) {
            int v = adj[u].get(i);
            if (disc[v] == -1) {
                dfs(v);
                low[u] = min(low[u], low[v]);
            } else if(onStack[v] == true) {
                low[u] = min(low[u], disc[v]);
            }
        }


        int node = 0;
        if(low[u] == disc[u]) {
            while(stack.peek() != u) {
                node = stack.pop();
                onStack[node] = false;
                contract[node] = scc;
            }
            node = stack.pop();
            onStack[node] = false;
            contract[node] = scc;
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
        for(int u = 0; u < adj.length; u++) {
            for(int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if(contract[u] != contract[v]) {
                    out[contract[u]] = true;
                    in[contract[v]] = true;
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
