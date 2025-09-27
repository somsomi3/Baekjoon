import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static long[] arr, tree, lazy;

    static long init(int node, int start, int end) {
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
    }

    static void propagate(int node, int start, int end) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[node*2] += lazy[node];
                lazy[node*2+1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    static void update(int node, int start, int end, int l, int r, long diff) {
        propagate(node, start, end);
        if (r < start || end < l) return;
        if (l <= start && end <= r) {
            lazy[node] += diff;
            propagate(node, start, end);
            return;
        }
        int mid = (start + end) / 2;
        update(node*2, start, mid, l, r, diff);
        update(node*2+1, mid+1, end, l, r, diff);
        tree[node] = tree[node*2] + tree[node*2+1];
    }

    static long sum(int node, int start, int end, int l, int r) {
        propagate(node, start, end);
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        return sum(node*2, start, mid, l, r) + sum(node*2+1, mid+1, end, l, r);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        for (int i=1; i<=N; i++) arr[i] = Long.parseLong(br.readLine());

        tree = new long[4*N];
        lazy = new long[4*N];
        init(1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                long d = Long.parseLong(st.nextToken());
                update(1, 1, N, b, c, d);
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                sb.append(sum(1, 1, N, b, c)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
