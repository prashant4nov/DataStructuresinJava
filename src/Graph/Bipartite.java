import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {
        //write your code here
        int color[] = new int[adj.length];
        for(int i = 0; i < adj.length; i++) {
            color[i] = -1;
        }
        color[0] = 0;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);

        while(!q.isEmpty()) {
            int u = q.poll();
            int vertexColor = color[u];
            for(int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if(color[v] == -1) {
                    q.add(v);
                    color[v] = (vertexColor == 1) ? 0 : 1;
                } else if(color[v] == vertexColor) {
                    return 0;
                }
            }
        }
        return 1;
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
        System.out.println(bipartite(adj));
    }
}

