import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.*;

public class Toposort {

    private static void toposortUtil(List<Integer>[] adj, int v, boolean[] visited, Stack<Integer> orderStack) {
        visited[v] = true;

        for(int i = 0; i < adj[v].size(); i++) {
            if(!visited[adj[v].get(i)]) {
                toposortUtil(adj, adj[v].get(i), visited, orderStack);
            }
        }

        orderStack.push(v);
    }

    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        int used[] = new int[adj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();
        //write your code here

        Stack<Integer> orderStack = new Stack<Integer>();
        boolean[] visited = new boolean[adj.length];

        for(int i = 0; i < adj.length; i++) {
            if(!visited[i]) {
                toposortUtil(adj, i, visited, orderStack);
            }
        }

        while(!orderStack.empty()) {
            order.add(orderStack.pop());
        }
        return order;
    }

    private static void dfs(ArrayList<Integer>[] adj, int[] used, ArrayList<Integer> order, int s) {
        //write your code here
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}

