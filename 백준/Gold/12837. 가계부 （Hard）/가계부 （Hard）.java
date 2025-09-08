import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        tree = new long[4 * N];

        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (type == 1) {
                update(1, 1, N, a, b);
            } else {
                sb.append(query(1, 1, N, a, b)).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void update(int node, int start, int end, int idx, long diff) {
        if (idx < start || idx > end) return;
        tree[node] += diff;
        if (start != end) {
            int mid = (start + end) / 2;
            update(node * 2, start, mid, idx, diff);
            update(node * 2 + 1, mid + 1, end, idx, diff);
        }
    }

    static long query(int node, int start, int end, int L, int R) {
        if (end < L || start > R) return 0;
        if (L <= start && end <= R) return tree[node];
        int mid = (start + end) / 2;
        return query(node * 2, start, mid, L, R) +
               query(node * 2 + 1, mid + 1, end, L, R);
    }
}
