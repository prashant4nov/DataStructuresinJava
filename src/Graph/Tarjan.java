
import static java.lang.Math.min;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class Tarjan {
    static Scanner input;
    private static ArrayList<Integer>[] adj;
    private static int count, id;
    private static boolean[] onStack;
    private static int[] visited, lowLink;
    private static Stack<Integer> stack;
    private static final int UNVISITED = -1;


    public static void tarjan() {
        id = 0;
        count = 0;
        visited = new int[adj.length];
        lowLink = new int[adj.length];
        onStack = new boolean[adj.length];
        stack = new Stack<Integer>();

        for(int i = 0; i < visited.length; i++) {
            visited[i] = UNVISITED;
        }

        for(int i = 0; i < adj.length; i++)
            if (visited[i] == UNVISITED)
                dfs(i);
    }

    private static void dfs(int s) {

        stack.push(s);
        onStack[s] = true;
        visited[s] = lowLink[s] = id++;

        for(int i = 0; i < adj[s].size(); i++) {
            int t = adj[s].get(i);
            if (visited[t] == UNVISITED) {
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
            count++;
        }

    }

    public static void solve() {
        int n = input.nextInt();
        int m = input.nextInt();
        adj = (ArrayList<Integer>[])new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            int s = input.nextInt() - 1;
            int t = input.nextInt() - 1;
            adj[s].add(t);
        }

        tarjan();

        if(count == 1) {
            System.out.println(0);
            return;
        }


        int[] outdeg=new int[count];
        int[] indeg=new int[count];
        for(int s = 0; s < n; s++) {
            for(int i = 0; i < adj[s].size(); i++) {
                int t = adj[s].get(i);
                if(visited[s]==visited[t]) continue;
                outdeg[visited[s]]++;
                indeg[visited[t]]++;
            }
        }

        int nhead=0,ntail=0;
        for(int i = 0; i < count; i++) {
            if(outdeg[i]==0) ++ntail;
            if(indeg[i]==0) ++nhead;
        }
        System.out.println(Math.max(nhead,ntail));

    }

    public static void main(String[] arg) {

        input = new Scanner(System.in);
        int x = input.nextInt();
        for(int i = 0; i < x; i++) {
            solve();
        }
    }
}
