import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.lang.Math;

/**
 * Tarjan class to implement tarjan's algorithm to find strongly connected components in a graph.
 */
class Tarjan extends Graph{
    private  int scc; // int scc: number of strong connected components in the graph.
    private  int time; // int counter to keep track of discovery time of nodes/vertices and their low values.
    private  boolean[] onStack; // boolean array to keep a track of nodes present on the stack.
    private  int[] disc; // int array to keep track of time when nodes/vertices are discovered for the first time.
    private int[]low; // int array to maintain the lowest ancestor reachable from a given node.
    private int[] components; // int array to maintain the number of nodes present in a strongly connected component.
    private  Stack<Integer> stack; // stack to put nodes discovered during the dfs call.

    /**
     * initialize values and run tarjan's algorithm.
     */
    public Tarjan(int n) {
        super(n);
        time = 0;
        scc = 0;
        low = new int[adj.length];
        disc = new int[adj.length];
        onStack = new boolean[adj.length];
        components = new int[adj.length];
        stack = new Stack<Integer>();

        for(int i = 0; i < adj.length; i++) {
            disc[i] = -1;
            low[i] = -1;
            onStack[i] = false;
            components[i] = -1;
        }

        for(int i = 0; i < adj.length; i++)
            if (disc[i] == -1)
                dfs(i);
    }

    /**
     * Method for the dfs call and tarjan's algorithm implementation
     * @param u int currently undiscovered node/vertice in the graph.
     */
    private void dfs(int u) {
        stack.push(u);
        onStack[u] = true;
        disc[u] = low[u] = time++;

        for(int i = 0; i < adj[u].size(); i++) {
            int v = adj[u].get(i);
            if (disc[v] == -1) {
                dfs(v);
            }
            if(onStack[v] == true) {
                low[u] = Math.min(low[u], low[v]);
            }
        }

        int node = 0;
        if(low[u] == disc[u]) {
            while(!stack.isEmpty()) {
                node = stack.pop();
                onStack[node] = false;
                low[node] = disc[u];
                components[node] = scc;
                if(node == u) break;
            }
            scc++;
        }
    }

    public int equivalence() {
        boolean[] out = new boolean[scc];
        boolean[] in = new boolean[scc];
        for(int u = 0; u < adj.length; u++) {
            for(int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if(components[u] != components[v]) {
                    out[components[u]] = true;
                    in[components[v]] = true;
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
            return 0;
        } else {
            return Math.max(result1, result2);
        }

    }
}
/**
 * Graph class to represent the graph.
 */
class Graph {
    public List<Integer>[] adj; // adjacency list to represent the graph.

    public Graph(int n) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }


    public void addEdge(int u, int v) {
        adj[u].add(v);
    }
}

public class Main {
    private static Scanner input;

    @SuppressWarnings("unchecked")
    public static void main(String[] arg) throws java.lang.Exception{
        try {
            input = new Scanner(System.in);
            int x = (input.nextInt());

            for(int i = 0; i < x; i++) {
                int n = (input.nextInt());
                int m = (input.nextInt());
                Tarjan tarjan = new Tarjan(n);

                for(int j = 0; j < m; j++) {
                    int s1 = (input.nextInt());
                    int s2 = (input.nextInt());
                    tarjan.addEdge(--s1, --s2);

                }

                int result = tarjan.equivalence();
                System.out.println(result);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
