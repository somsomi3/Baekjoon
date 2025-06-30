import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int maxDist = 0;
    static int farthestNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                tree[from].add(new Node(to, weight));
            }
        }

        // 1. 임의의 정점에서 DFS
        visited = new boolean[V + 1];
        dfs(1, 0);

        // 2. 찾은 정점에서 다시 DFS
        visited = new boolean[V + 1];
        maxDist = 0; // 다시 초기화
        dfs(farthestNode, 0);

        System.out.println(maxDist);
    }

    static void dfs(int current, int sum) {
        visited[current] = true;

        if (sum > maxDist) {
            maxDist = sum;
            farthestNode = current;
        }

        for (Node next : tree[current]) {
            if (!visited[next.to]) {
                dfs(next.to, sum + next.weight);
            }
        }
    }
}
