import java.util.*;
import java.io.*;

public class Main {
    static class FenwickTree {
        long[] tree;

        FenwickTree(int size) {
            tree = new long[size + 1];
        }

        void update(int idx, long diff) {
            while (idx < tree.length) {
                tree[idx] += diff;
                idx += (idx & -idx);
            }
        }

        long prefixSum(int idx) {
            long result = 0;
            while (idx > 0) {
                result += tree[idx];
                idx -= (idx & -idx);
            }
            return result;
        }

        long rangeSum(int left, int right) {
            return prefixSum(right) - prefixSum(left - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N + 1];
        FenwickTree tree = new FenwickTree(N);

        for (int i = 1; i <= N; i++) {
            long num = Long.parseLong(br.readLine());
            arr[i] = num;
            tree.update(i, num);
        }

        int Q = M + K;
        StringBuilder sb = new StringBuilder();

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if (cmd == 1) {
                long diff = b - arr[a];
                arr[a] = b;
                tree.update(a, diff);
            } else if (cmd == 2) {
                int bInt = (int) b;
                sb.append(tree.rangeSum(a, bInt)).append('\n');
            }
        }

        System.out.print(sb);
    }
}
