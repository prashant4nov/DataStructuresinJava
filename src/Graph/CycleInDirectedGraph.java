package Graph;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by Prashant on 6/24/16.
 * http://www.geeksforgeeks.org/detect-cycle-direct-graph-using-colors/
 */
public class CycleInDirectedGraph {
    public  Graph graph;
    public enum COLORS {
        WHITE, GRAY, BLACK
    }

    public  boolean DFSUTIL(int u, COLORS[] color) {
        color[u] = COLORS.GRAY;
        ListIterator<Integer> i = graph.adj[u].listIterator();
        while(i.hasNext()) {
            int n = i.next();

            if(color[n] == COLORS.GRAY) {
                return true;
            }

            if(color[n] == COLORS.WHITE && DFSUTIL(n, color)) {
                return true;
            }

        }

        color[u] = COLORS.BLACK;
        return false;
    }

    public boolean isCyclic(Graph g) {
        graph = g;
        COLORS[] color = new COLORS[graph.V];

        for(int i=0;i<graph.V;i++) {
            color[i] = COLORS.WHITE;
        }

        for(int i=0;i<graph.V;i++) {
            if(color[i] == COLORS.WHITE) {
                return DFSUTIL(i, color);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        CycleInDirectedGraph c = new CycleInDirectedGraph();
        boolean res = c.isCyclic(g);
        System.out.print(res + " ");
    }
}
