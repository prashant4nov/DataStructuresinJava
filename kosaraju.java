import java.util.*;
import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.Math.toIntExact;

public class Main {
    private static Scanner input;

    static int N = 20010;

    static boolean marked[];
    static int comp[] = new int[N];
    static int comps;
    static int t,n,m,u,v;
    static Stack<Integer> s = new Stack<Integer>();
    static List<Integer>[] g;
    static List<Integer>[] gi;

    static void dfs(int v) {
        if(marked[v]) return;
        marked[v] = true;
        for(int i = 0; i < g[v].size(); i++) {
            dfs(g[v].get(i));
        }
        s.push(v);
    }

    static void dfs2(int v, int c) {
        if(marked[v]) return;

        marked[v] = true;
        comp[v] = c;
        for(int i = 0; i < gi[v].size(); i++) {
            dfs2(gi[v].get(i), c);
        }
    }


    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws java.lang.Exception {

        //try {
            input = new Scanner(System.in);
            int t, n, m, x, y;

            t = toIntExact(input.nextLong());

            while(t-- > 0) {
                n = toIntExact(input.nextLong());
                m = toIntExact(input.nextLong());

                g = new ArrayList[n];
                gi = new ArrayList[n];

                for(int i = 0; i < n; i++) {
                    g[i] = new ArrayList<Integer>();
                    gi[i] = new ArrayList<Integer>();
                }

                for(int i = 0; i < m; i++) {
                    u = toIntExact(input.nextLong());
                    v = toIntExact(input.nextLong());
                    u--; v--;
                    g[u].add(v);
                    gi[v].add(u);
                }

                marked = new boolean[N];
                for(int i = 0; i < n; i++) {
                    dfs(i);
                }

                marked = new boolean[N];

                comps = 0;

                while(!s.isEmpty()) {
                    int v = s.pop();
                    if(!marked[v]) {
                        dfs2(v, comps++);
                    }
                }

                boolean in[] = new boolean[comps];
                boolean out[] = new boolean[comps];

                for(int i = 0; i < comps; i++) {
                    for(int j = 0; j < g[i].size(); j++) {
                        u = i; v = g[i].get(j);
                        if(comp[u] != comp[v]) {
                            out[comp[u]]=true;
                            in[comp[v]]=true;
                        }
                    }
                }

                int need_in = 0, need_out = 0;
                for (int i=0;i<comps;i++){
                    if (!in[i]) need_in++;
                    if (!out[i]) need_out++;
                }

                if(comps == 1) System.out.println(0);
                else {
                    System.out.println(max(need_in, need_out));
                }

            }

        //} catch (Exception e) {
            //System.out.println(e.getMessage());
        //}
            }
}
