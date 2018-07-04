import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {
    private static boolean acyclicUtil(ArrayList<Integer>[] adj, int v, boolean[] visited, boolean[] recStack) {
        if(recStack[v]) return true;

        if(visited[v]) return false;

        recStack[v] = true;
        visited[v] = true;

        for(int i = 0; i < adj[v].size(); i++) {
            if(acyclicUtil(adj, adj[v].get(i), visited, recStack)) return true;
        }

        recStack[v] = false;

        return false;
    }
    private static int acyclic(ArrayList<Integer>[] adj) {
        //write your code here
        boolean[] visited = new boolean[adj.length];
        boolean[] recStack = new boolean[adj.length];

        for(int i = 0; i < adj.length; i++)
            if(acyclicUtil(adj, i, visited, recStack))
                return 1;

        return 0;
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
        System.out.println(acyclic(adj));
    }
}

