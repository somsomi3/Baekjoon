import java.io.*;
import java.util.*;

public class Main {
    static final InputStream in = System.in;
    static final byte[] buffer = new byte[1 << 16];
    static int ptr = 0, len = 0;

    static int read() throws IOException {
        if (ptr >= len) {
            len = in.read(buffer);
            ptr = 0;
            if (len <= 0) return -1;
        }
        return buffer[ptr++];
    }
    static int nextInt() throws IOException {
        int c, sign = 1, val = 0;
        do { c = read(); } while (c <= 32);
        if (c == '-') { sign = -1; c = read(); }
        while (c > 32) {
            val = (val << 3) + (val << 1) + (c - '0');
            c = read();
        }
        return val * sign;
    }

    static class Wire {
        int a, b;
        Wire(int a, int b) { this.a = a; this.b = b; }
    }

    static int lowerBound(int[] arr, int len, int key) {
        int l = 0, r = len;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr[m] < key) l = m + 1;
            else r = m;
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        int N = nextInt();
        Wire[] w = new Wire[N];
        for (int i = 0; i < N; i++) {
            int a = nextInt();
            int b = nextInt();
            w[i] = new Wire(a, b);
        }

        Arrays.sort(w, (x, y) -> Integer.compare(x.a, y.a));

        int[] tail = new int[N];
        int[] tailIdx = new int[N];
        int[] prevIdx = new int[N];
        int[] posArr = new int[N];
        Arrays.fill(prevIdx, -1);

        int lenLIS = 0;
        for (int i = 0; i < N; i++) {
            int b = w[i].b;
            int pos = lowerBound(tail, lenLIS, b);
            posArr[i] = pos;
            if (pos == lenLIS) lenLIS++;
            tail[pos] = b;
            tailIdx[pos] = i;
            if (pos > 0) prevIdx[i] = tailIdx[pos - 1];
        }

        boolean[] inLIS = new boolean[N];
        int idx = tailIdx[lenLIS - 1];
        while (idx != -1) {
            inLIS[idx] = true;
            idx = prevIdx[idx];
        }

        ArrayList<Integer> removeA = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!inLIS[i]) removeA.add(w[i].a);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(removeA.size()).append('\n');
        for (int a : removeA) sb.append(a).append('\n');

        System.out.print(sb.toString());
    }
}
