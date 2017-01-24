package Graph;
import java.util.*;
import java.util.ListIterator;
// bfs for shortest path and dfs for connected components
/**
 * Created by Prashant on 6/23/16.
 * http://beginnersbook.com/2014/06/difference-between-iterator-and-listiterator-in-java/
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
        
        boolean visited[] = new boolean[V];

        
        Queue<Integer> q = new LinkedList<>();
        
        visited[s] = true;
        q.add(s);
        
        while(!q.isEmpty()) {
             int node = q.poll();
             System.out.println(node + "");
             for(int i=0; i<adj[node].size(); i++) {
               if(visited[adj[node].get(i)]==false) {
            	   visited[adj[node].get(i)] = true;
                q.add(adj[node].get(i));
               }
             }
        }
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

    public void DFSUTIL(int n, boolean[] visited) {
		visited[n] = true;
		System.out.println(n);
		for (int i = 0; i < adj[n].size(); i++) {
			if (visited[adj[n].get(i)] == false) {
				DFSUTIL(adj[n].get(i), visited);
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

     public void DFSIterative(int n) {
		Stack<Integer> s = new Stack();
		boolean[] visited = new boolean[V];
		s.push(n);
		while (!s.isEmpty()) {
			n = s.pop();
			if (visited[n] == false) {
				System.out.println(n);
				visited[n] = true;
			}
			for (int i = 0; i < adj[n].size(); i++) {
				if (visited[adj[n].get(i)] == false) {
					s.push(adj[n].get(i));
				}
			}
		}
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
	    
	    
		  Graph g1 = new Graph(5); // Total 5 vertices in graph
		    g1.addEdge(1, 0);
		    g1.addEdge(0, 2);
		    g1.addEdge(2, 1);
		    g1.addEdge(0, 3);
		    g1.addEdge(1, 4);
		System.out.println("Following is Dept First Traversal " + "(starting from vertex 2) iterative");
		g1.DFSIterative(0);
    }
}
