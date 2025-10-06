import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int len;      // LIS 길이
        long cnt;     // LIS 개수
        Node(int len, long cnt) {
            this.len = len;
            this.cnt = cnt;
        }
    }

    static Node merge(Node a, Node b) {
        if (a.len == b.len) return new Node(a.len, (a.cnt + b.cnt) % MOD);
        return a.len > b.len ? a : b;
    }

    static final int MOD = 1_000_000_007;
    static Node[] seg;
    static int size;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> idxMap = new HashMap<>();
        int idx = 1;
        for (int x : sorted) {
            if (!idxMap.containsKey(x)) idxMap.put(x, idx++);
        }

        size = idx;
        seg = new Node[size * 4];
        for (int i = 0; i < seg.length; i++) seg[i] = new Node(0, 0);

        int maxLen = 0;
        long totalCnt = 0;

        for (int x : arr) {
            int pos = idxMap.get(x);
            Node best = query(1, 1, size, 1, pos - 1);

            int newLen = best.len + 1;
            long newCnt = best.cnt == 0 ? 1 : best.cnt;

            update(1, 1, size, pos, newLen, newCnt);

            if (newLen > maxLen) {
                maxLen = newLen;
                totalCnt = newCnt;
            } else if (newLen == maxLen) {
                totalCnt = (totalCnt + newCnt) % MOD;
            }
        }

        System.out.println(maxLen + " " + totalCnt % MOD);
    }

    static Node query(int node, int s, int e, int l, int r) {
        if (r < s || e < l) return new Node(0, 0);
        if (l <= s && e <= r) return seg[node];
        int mid = (s + e) >> 1;
        return merge(query(node*2, s, mid, l, r),
                     query(node*2+1, mid+1, e, l, r));
    }

    static void update(int node, int s, int e, int idx, int len, long cnt) {
        if (idx < s || e < idx) return;
        if (s == e) {
            if (seg[node].len == len) seg[node].cnt = (seg[node].cnt + cnt) % MOD;
            else if (seg[node].len < len) seg[node] = new Node(len, cnt);
            return;
        }
        int mid = (s + e) >> 1;
        update(node*2, s, mid, idx, len, cnt);
        update(node*2+1, mid+1, e, idx, len, cnt);
        seg[node] = merge(seg[node*2], seg[node*2+1]);
    }
}
