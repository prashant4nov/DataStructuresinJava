import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;
import java.util.Scanner;

/*
 * https://www.youtube.com/watch?v=RpgcYiky7uw
 */
public class StronglyConnected {

    private static void dfsUtil(List<Integer>[] adj, int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for(int i = 0; i < adj[v].size(); i++) {
            if(!visited[adj[v].get(i)]) {
                dfsUtil(adj, adj[v].get(i), visited, stack);
            }
        }

        stack.push(v);
    }

    private static void dfsUtil2(List<Integer>[] adj, int v, boolean[] visited, List<Integer> component) {
        visited[v] = true;
        component.add(v);

        for(int i = 0; i < adj[v].size(); i++) {
            if(!visited[adj[v].get(i)]) {
                dfsUtil2(adj, adj[v].get(i), visited, component);
            }
        }

    }


    public static List<Integer>[] reverseGraph(ArrayList<Integer>[] adj) {
        List<Integer>[] reverseGraph = new ArrayList[adj.length];
        for (int i = 0; i < adj.length; i++) {
            reverseGraph[i] = new ArrayList<Integer>();
        }
        for(int v = 0; v < adj.length; v++) {
            List<Integer> children = adj[v];
            for(Integer child : children) {
                reverseGraph[(int)child].add(v);
            }
        }

        return reverseGraph;
    }


    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
        //write your code here
        boolean[] visited = new boolean[adj.length];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < adj.length; i++) {
            if(!visited[i]) dfsUtil(adj, i, visited, stack);
        }

        visited = new boolean[adj.length];
        List<List<Integer>> components = new ArrayList<List<Integer>>();
        List<Integer>[] reverseGraph = reverseGraph(adj);

        int cnt = 0;
        while(!stack.isEmpty()) {
            int v = stack.pop();
            if(!visited[v]) {
                cnt++;
                List<Integer> component = new ArrayList<Integer>();
                dfsUtil2(reverseGraph, v, visited, component);
                components.add(component);
            }
        }
        //return cnt;
        System.out.println("strong connected components: ");
        for(List<Integer> component : components) {
            for(Integer v : component) {
                System.out.print((v+1) + ", ");
            }
            System.out.println();
        }
        return components.size();
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
        }
        System.out.println(numberOfStronglyConnectedComponents(adj));
    }
}

