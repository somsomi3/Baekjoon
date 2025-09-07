import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static long[] arr, tree;
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        tree = new long[4 * N];
        build(1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if (cmd == 1) {
                update(1, 1, N, a, b);
            } else if (cmd == 2) {
                sb.append(query(1, 1, N, a, (int)b)).append("\n");
            }
        }

        System.out.print(sb);
    }

    static long build(int node, int start, int end) {
        if (start == end) return tree[node] = arr[start] % MOD;
        int mid = (start + end) / 2;
        return tree[node] = (build(node * 2, start, mid) * build(node * 2 + 1, mid + 1, end)) % MOD;
    }

    static long query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return 1;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return (query(node * 2, start, mid, left, right)
              * query(node * 2 + 1, mid + 1, end, left, right)) % MOD;
    }

    static void update(int node, int start, int end, int idx, long val) {
        if (idx < start || idx > end) return;
        if (start == end) {
            tree[node] = val % MOD;
            return;
        }
        int mid = (start + end) / 2;
        update(node * 2, start, mid, idx, val);
        update(node * 2 + 1, mid + 1, end, idx, val);
        tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % MOD;
    }
}
