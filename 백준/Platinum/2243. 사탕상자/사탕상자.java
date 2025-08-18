import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 1000000;
    static int[] segTree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        segTree = new int[4 * MAX];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int B = Integer.parseInt(st.nextToken());
                int flavor = query(1, MAX, 1, B);
                sb.append(flavor).append("\n");
                update(1, MAX, 1, flavor, -1);
            } else {
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                update(1, MAX, 1, B, C);
            }
        }
        System.out.print(sb);
    }

    static void update(int left, int right, int node, int idx, int diff) {
        if (idx < left || idx > right) return;
        segTree[node] += diff;
        if (left == right) return;

        int mid = (left + right) / 2;
        update(left, mid, node * 2, idx, diff);
        update(mid + 1, right, node * 2 + 1, idx, diff);
    }

    static int query(int left, int right, int node, int k) {
        if (left == right) return left;

        int mid = (left + right) / 2;
        if (segTree[node * 2] >= k) {
            return query(left, mid, node * 2, k);
        } else {
            return query(mid + 1, right, node * 2 + 1, k - segTree[node * 2]);
        }
    }
}
