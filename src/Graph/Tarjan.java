
import static java.lang.Math.min;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class Tarjan {
    static Scanner scanner;
    private int n;
    private List<List<Integer>> graph;

    private boolean solved;
    private int sccCount, id;
    private boolean[] onStack;
    private static int[] ids, low;
    private Deque<Integer> stack;

    private static final int UNVISITED = -1;

    public Tarjan(List<List<Integer>> graph) {
        if (graph == null) throw new IllegalArgumentException("Graph cannot be null.");
        n = graph.size();
        this.graph = graph;
    }

    public int sccCount() {
        if (!solved) solve();
        return sccCount;
    }


    public int[] getSccs() {
        if (!solved) solve();
        return low;
    }

    public void solve() {
        if (solved) return;

        ids = new int[n];
        low = new int[n];
        onStack = new boolean[n];
        stack = new ArrayDeque<>();
        Arrays.fill(ids, UNVISITED);

        for(int i = 0; i < n; i++)
            if (ids[i] == UNVISITED)
                dfs(i);

        solved = true;
    }

    private void dfs(int at) {

        stack.push(at);
        onStack[at] = true;
        ids[at] = low[at] = id++;

        for(int to : graph.get(at)) {
            if (ids[to] == UNVISITED) dfs(to);
            if (onStack[to]) low[at] = min(low[at], low[to]);
        }

        if (ids[at] == low[at]) {
            for(int node = stack.pop();;node = stack.pop()) {
                onStack[node] = false;
                low[node] = ids[at];
                if (node == at) break;
            }
            sccCount++;
        }

    }

    public static List<List<Integer>> createGraph(int n) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        return graph;
    }

    public static void addEdge(List<List<Integer>> graph, int from, int to) {
        graph.get(from).add(to);
    }


    public static void run() {
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        List<List<Integer>> graph = createGraph(n);

        for(int i=0;i<m;++i) {
            int a=scanner.nextInt(); --a;
            int b=scanner.nextInt(); --b;
            addEdge(graph, a, b);
        }



        Tarjan solver = new Tarjan(graph);

        int[] sccs = solver.getSccs();
        Map<Integer, List<Integer>> multimap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!multimap.containsKey(sccs[i]))
                multimap.put(sccs[i], new ArrayList<>());
            multimap.get(sccs[i]).add(i);
        }

        int[] comp=new int[n];
        int ncomp = solver.sccCount();

        if(ncomp==1) {
            System.out.println(0);
            return;
        }


        int[] outdeg=new int[ncomp];
        int[] indeg=new int[ncomp];
        for(int at=0;at<n;++at) {
            List<Integer> cure=graph.get(at);
            for(int i=0;i<cure.size();++i) {
                int to=cure.get(i);
                if(ids[at]==ids[to]) continue;
                outdeg[ids[at]]++;
                indeg[ids[to]]++;
            }
        }

        int nhead=0,ntail=0;
        for(int i=0;i<ncomp;++i) {
            if(outdeg[i]==0) ++ntail;
            if(indeg[i]==0) ++nhead;
        }
        System.out.println(Math.max(nhead,ntail));

    }

    public static void main(String[] arg) {

        scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        for(int i=0;i<n;++i) run();
    }

}



















