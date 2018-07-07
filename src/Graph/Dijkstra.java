import java.util.*;

 // https://www.geeksforgeeks.org/implement-priorityqueue-comparator-java/
 // https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-using-priority_queue-stl/
 // Dijkstra's algorithm finds the minimum cost of reaching all vertices from a single source in a graph having positive weight on edges. 
 
class Vertex {
    int vertex;
    // cost of the vertex from the source vertex.
    int cost;

    public Vertex(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
}

 class VertexComparator implements Comparator<Vertex> {

    @Override
    public int compare(Vertex u, Vertex v) {
        // for ascending order.
        return u.cost - v.cost;
        // for descending order.
        // return v.cost - u.cost;
    }
}

public class Dijkstra {

    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        // distance of all vertices from the source in the graph.
        int dist[] = new int[adj.length];

        // initialize vertices cost from source to infinity.
        for(int i = 0; i < adj.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // initialize source cost to zero since it is the staring vertex.
        dist[s] = 0;

        // add source vertex to the queue. Default size of priority queue in Java is 11.
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>(new VertexComparator());
        queue.add(new Vertex(s, dist[s]));

        while(!queue.isEmpty()) {
            int u = queue.poll().vertex;
            List<Integer> adjVertices = adj[u];

            for(int i = 0; i < adjVertices.size(); i++) {
                int v = adjVertices.get(i);
                int costUV = cost[u].get(i);

                if(dist[v] > dist[u] + costUV) {
                    dist[v] = dist[u] + costUV;
                    // add vertex and its cost value from source in priority queue.
                    Vertex currVertex = new Vertex(v, dist[v]);
                    queue.add(currVertex);
                }
            }
        }

        if(dist[t] != Integer.MAX_VALUE) {
            return dist[t];
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

