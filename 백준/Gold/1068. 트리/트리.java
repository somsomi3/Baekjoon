import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int deleteNode;
    static int leafCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                tree[parent].add(i);
            }
        }

        deleteNode = Integer.parseInt(br.readLine());

        if (deleteNode == root) {
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(leafCount);
        }
    }

    static void dfs(int node) {
        visited[node] = true;
        int childCount = 0;

        for (int child : tree[node]) {
            if (child == deleteNode) continue;
            dfs(child);
            childCount++;
        }

        if (childCount == 0) {
            leafCount++;
        }
    }
}
