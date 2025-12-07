import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] g;
    static int N;
    static boolean[] visited;
    static int sum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        g = new ArrayList[N+1];
        for (int i=1;i<=N;i++) g[i] = new ArrayList<>();

        for (int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }

        visited = new boolean[N+1];
        dfs(1, 0);

        if (sum % 2 == 1) System.out.println("Yes");
        else System.out.println("No");
    }

    static void dfs(int node, int depth){
        visited[node] = true;
        boolean leaf = true;
        for(int nxt : g[node]){
            if(!visited[nxt]){
                leaf = false;
                dfs(nxt, depth+1);
            }
        }
        if(leaf) sum += depth;
    }
}
