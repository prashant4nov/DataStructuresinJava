package Graph;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Prashant on 6/23/16.
 */
public class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void BFS(int s) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while(queue.isEmpty() == false) {
            s = queue.poll();
            System.out.print(s+" ");
            ListIterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()) {
                int n = i.next();
                if(visited[n]==false) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public void DFSUTIL(int s, boolean[] visited) {
        System.out.print(s+" ");
        visited[s] = true;
        ListIterator<Integer> i = adj[s].listIterator();

        while(i.hasNext()) {
            int n = i.next();
            if(visited[n] == false) {
                DFSUTIL(n, visited);
            }
        }

    }

    public void DFS(int s) {
        boolean[] visited = new boolean[V];
        DFSUTIL(s, visited);
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");
        g.BFS(2);


        System.out.println(" ");
        System.out.println("Following is Dept First Traversal "+
                "(starting from vertex 2)");
        g.DFS(2);
    }
}
