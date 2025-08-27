import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 30001;
    static int N, Q;
    static int[] penguin = new int[MAX];
    static int[] size = new int[MAX], depth = new int[MAX], parent = new int[MAX];
    static int[] top = new int[MAX], in = new int[MAX];
    static ArrayList<Integer>[] adj = new ArrayList[MAX], tree = new ArrayList[MAX];
    static int[] uf = new int[MAX];
    static boolean[] visited = new boolean[MAX], connected = new boolean[MAX];
    static int[] seg = new int[MAX * 2];
    static int time = 0;
    static List<String[]> queries = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        InputStream inStream = System.in;
        BufferedReader br = new BufferedReader(new InputStreamReader(inStream));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < MAX; i++) {
            adj[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
            uf[i] = i;
        }

        for (int i = 1; i <= N; i++) penguin[i] = Integer.parseInt(st.nextToken());

        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            String[] q = br.readLine().split(" ");
            queries.add(q);
            if (q[0].equals("bridge")) {
                int a = Integer.parseInt(q[1]);
                int b = Integer.parseInt(q[2]);
                if (find(a) != find(b)) {
                    union(a, b);
                    adj[a].add(b);
                    adj[b].add(a);
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (find(1) != find(i) && !connected[find(i)]) {
                adj[1].add(i);
                connected[find(i)] = true;
            }
        }

        makeTree(1);
        dfs1(1);
        dfs2(1);

        for (int i = 1; i <= N; i++) {
            update(in[i], penguin[i]);
        }

        Arrays.fill(uf, 0);
        for (int i = 1; i < MAX; i++) uf[i] = i;

        StringBuilder sb = new StringBuilder();
        for (String[] q : queries) {
            String op = q[0];
            int a = Integer.parseInt(q[1]);
            int b = Integer.parseInt(q[2]);
            if (op.equals("bridge")) {
                if (find(a) == find(b)) sb.append("no\n");
                else {
                    union(a, b);
                    sb.append("yes\n");
                }
            } else if (op.equals("excursion")) {
                if (find(a) != find(b)) sb.append("impossible\n");
                else sb.append(query(a, b)).append('\n');
            } else {
                update(in[a], b);
            }
        }

        System.out.print(sb);
    }

    static int find(int x) {
        if (uf[x] == x) return x;
        return uf[x] = find(uf[x]);
    }

    static void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb) uf[pa] = pb;
    }

    static void makeTree(int u) {
        visited[u] = true;
        for (int v : adj[u]) {
            if (!visited[v]) {
                tree[u].add(v);
                makeTree(v);
            }
        }
    }

    static void dfs1(int u) {
        size[u] = 1;
        for (int i = 0; i < tree[u].size(); i++) {
            int v = tree[u].get(i);
            depth[v] = depth[u] + 1;
            parent[v] = u;
            dfs1(v);
            size[u] += size[v];
            if (size[v] > size[tree[u].get(0)]) {
                Collections.swap(tree[u], 0, i);
            }
        }
    }

    static void dfs2(int u) {
        in[u] = time++;
        for (int v : tree[u]) {
            top[v] = (v == tree[u].get(0)) ? top[u] : v;
            dfs2(v);
        }
    }

    static void update(int idx, int val) {
        for (seg[idx += N] = val; idx > 1; idx >>= 1) seg[idx >> 1] = seg[idx] + seg[idx ^ 1];
    }

    static int sum(int l, int r) {
        int res = 0;
        for (l += N, r += N; l < r; l >>= 1, r >>= 1) {
            if ((l & 1) == 1) res += seg[l++];
            if ((r & 1) == 1) res += seg[--r];
        }
        return res;
    }

    static int query(int a, int b) {
        int res = 0;
        while (top[a] != top[b]) {
            if (depth[top[a]] < depth[top[b]]) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            res += sum(in[top[a]], in[a] + 1);
            a = parent[top[a]];
        }
        if (depth[a] > depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        res += sum(in[a], in[b] + 1);
        return res;
    }
}
