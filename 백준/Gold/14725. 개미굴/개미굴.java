import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        Map<String, Node> child = new TreeMap<>();
    }

    static Node root = new Node();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            Node cur = root;
            for (int j = 0; j < K; j++) {
                String s = st.nextToken();
                cur.child.putIfAbsent(s, new Node());
                cur = cur.child.get(s);
            }
        }

        dfs(root, 0);
        System.out.print(sb);
    }

    static void dfs(Node node, int depth) {
        for (String key : node.child.keySet()) {
            for (int i = 0; i < depth; i++) sb.append("--");
            sb.append(key).append('\n');
            dfs(node.child.get(key), depth + 1);
        }
    }
}
