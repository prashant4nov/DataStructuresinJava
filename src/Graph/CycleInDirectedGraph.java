package Graph;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by Prashant on 6/24/16.
 * http://www.geeksforgeeks.org/detect-cycle-direct-graph-using-colors/
 * http://quiz.geeksforgeeks.org/connected-components-in-an-undirected-graph/
 */
public class CycleInDirectedGraph extends Graph{
    public enum COLORS {
        WHITE, GRAY, BLACK
    }

    CycleInDirectedGraph(int v) {
        super(4);
    }

    public  boolean DFSUTIL(int u, COLORS[] color) {
        color[u] = COLORS.GRAY;
        ListIterator<Integer> i = adj[u].listIterator();
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

    public boolean isCyclic() {
        COLORS[] color = new COLORS[V];

        for(int i=0;i<V;i++) {
            color[i] = COLORS.WHITE;
        }

        for(int i=0;i<V;i++) {
            if(color[i] == COLORS.WHITE) {
                return DFSUTIL(i, color);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CycleInDirectedGraph g = new CycleInDirectedGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        boolean res = g.isCyclic();
        System.out.print(res + " ");
    }
}
