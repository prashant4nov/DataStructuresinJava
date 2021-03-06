import java.util.*;

/**
 * My solution fails at test case 5 and I'm unable to decipher why it does so.

 I have used belmanFord's algorithm to find shortest paths and then performed BFS to check for nodes in the infinite cycle reachable from a node relaxed in the nth iteration of the belmanford algorithm. Can someone give me some hints as to where I may be going wrong?

 OK. I got the problem. If anyone is struggling with this don't forget to check nodes that are unreachable from starting node but have a negative weight edge between them. The belmanford algorithm will relax that edge which will lead to an error.
 */
public class NegativeCycle {
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

    private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        // write your code here
        int negCycle = 0;
        int dist[] = new int[adj.length];
        int prev[] = new int[adj.length];

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


        for(int i = 0; i < adj.length; i++) {
            if(temp[i] != dist[i]) {
                negCycle = 1;
            }
        }

        return negCycle;
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
        System.out.println(negativeCycle(adj, cost));
    }
}

