import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {

    private static void explore(ArrayList<Integer>[] adj, int v, boolean[] visited) {
        if(visited[v] == true) return;
        visited[v] = true;
        for(int i = 0; i < adj[v].size(); i++) {
            explore(adj, adj[v].get(i), visited);
        }
    }

    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        //write your code here
        int result = 0;
        boolean[] visited = new boolean[adj.length];
        for(int i = 0; i < adj[x].size(); i++) {
            explore(adj, adj[x].get(i), visited);
        }
        if(visited[y] == true) {
            result = 1;
        }
        return result;
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
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

