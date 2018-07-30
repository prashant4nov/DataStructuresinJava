import java.util.*;


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

 class Dijkstra {

    public static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        // distance of all vertices from the source in the graph.
        int dist[] = new int[adj.length];

        // initialize vertices cost from source to infinity.
        for(int i = 0; i < adj.length; i++) {
            dist[i] = Integer.MAX_VALUE/2;
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

        if(dist[t] != Integer.MAX_VALUE/2) {
            return dist[t];
        }
        return -1;
    }

}


public class ShortestPaths {


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

        static void relax(List<Integer> adj[], List<Integer> cost[], int[] dist, int[] prev) {


            for(int u = 0; u < adj.length; u++) {
                List<Integer> adjVertices = adj[u];

                for(int j = 0; j < adjVertices.size(); j++) {
                    int v = adj[u].get(j);
                    int costUV = cost[u].get(j);

                    if(dist[v] > dist[u] + costUV) {
                        dist[v] = dist[u] + costUV;
                        prev[v] = u;
                    }
                }
            }
        }

    private static void shortestPaths(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, long[] distance, int[] reachable, int[] shortest) {
      //write your code here
        int negCycle = 0;
        int dist[] = new int[adj.length];
        int prev[] = new int[adj.length];

        Set<Integer> A = new HashSet<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i = 0; i < adj.length; i++) {
            dist[i] = Integer.MAX_VALUE/2;
            prev[i] = -1;

        }

        dist[0] = 0;
        int repetitions = 0;

        while(repetitions < adj.length) {
            relax(adj, cost, dist, prev);
            repetitions++;
        }

        int temp[] = new int[adj.length];
        for(int i = 0; i < adj.length; i++) {
            temp[i] = dist[i];
        }

        relax(adj, cost, dist, prev);


        boolean visited[] = new boolean[adj.length];

        for(int i = 0; i < adj.length; i++) {
            if(temp[i] != dist[i]) {
                q.add(i);
                A.add(i);
                visited[i] = true;
                shortest[i] = 0;
            }/* else {
                int d = 0;
                if(s != i) {
                    int rea = -1;
                    rea = reach(adj, s, i);
                    if(rea == -1) {
                        reachable[i] = 0;
                    } else {
                        d = Dijkstra.distance(adj, cost, s, i);
                        distance[i] = d;
                    }

                } else {
                    distance[i] = 0;
                }
            } */
        }

        while(!q.isEmpty()) {
            int v = q.poll();
            for(int i = 0; i < adj[v].size(); i++) {
                if(visited[adj[v].get(i)] == false) {
                    q.add(adj[v].get(i));
                    visited[adj[v].get(i)] = true;
                    shortest[adj[v].get(i)] = 0;
                    dist[i] = 0;
                }
            }
        }

        for(int i = 0; i < adj.length; i++) {
            if(temp[i] == dist[i] && !A.contains(i)) {
                distance[i] = dist[i];
            }
        }
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
        int s = scanner.nextInt() - 1;
        long distance[] = new long[n];
        int reachable[] = new int[n];
        int shortest[] = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Long.MAX_VALUE;
            reachable[i] = 0;
            shortest[i] = 1;
        }
        shortestPaths(adj, cost, s, distance, reachable, shortest);
        for (int i = 0; i < n; i++) {
            if (reachable[i] == 0) {
                System.out.println('*');
            } else if (shortest[i] == 0) {
                System.out.println('-');
            } else {
                System.out.println(distance[i]);
            }
        }
    }

}

