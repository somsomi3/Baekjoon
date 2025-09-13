import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= 32) if (c == -1) return Long.MIN_VALUE;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            long val = c - '0';
            while ((c = read()) > 32) val = val * 10 + (c - '0');
            return val * sign;
        }
        int nextInt() throws IOException { return (int) nextLong(); }
    }

    static class Pair {
        long w, h;
        Pair(long w, long h){ this.w = w; this.h = h; }
    }

    static class Line {
        long m, b;
        Line(long m, long b){ this.m = m; this.b = b; }
        long f(long x){ return m * x + b; }
    }

    static boolean bad(Line l1, Line l2, Line l3){
        // (l3.b - l1.b)*(l1.m - l2.m) <= (l2.b - l1.b)*(l1.m - l3.m)
        return (l3.b - l1.b) * (l1.m - l2.m) <= (l2.b - l1.b) * (l1.m - l3.m);
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int N = fs.nextInt();
        Pair[] a = new Pair[N];
        for (int i = 0; i < N; i++) {
            long w = fs.nextLong();
            long h = fs.nextLong();
            a[i] = new Pair(w, h);
        }
        Arrays.sort(a, (p1, p2) -> {
            if (p1.w == p2.w) return Long.compare(p2.h, p1.h);
            return Long.compare(p1.w, p2.w);
        });
        ArrayList<Pair> v = new ArrayList<>();
        long maxH = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (a[i].h > maxH) {
                v.add(a[i]);
                maxH = a[i].h;
            }
        }
        Collections.reverse(v);
        int M = v.size();
        long[] W = new long[M + 1];
        long[] H = new long[M + 1];
        for (int i = 1; i <= M; i++) {
            W[i] = v.get(i - 1).w;
            H[i] = v.get(i - 1).h;
        }
        long[] dp = new long[M + 1];
        ArrayDeque<Line> dq = new ArrayDeque<>();
        dq.addLast(new Line(H[1], 0));
        for (int i = 1; i <= M; i++) {
            long x = W[i];
            while (dq.size() >= 2) {
                Line l1 = dq.peekFirst();
                Line l2 = dq.toArray(new Line[0])[1];
                if (l1.f(x) >= l2.f(x)) dq.pollFirst();
                else break;
            }
            dp[i] = dq.peekFirst().f(x);
            if (i + 1 <= M) {
                Line nl = new Line(H[i + 1], dp[i]);
                while (dq.size() >= 2) {
                    Line l2 = dq.pollLast();
                    Line l1 = dq.peekLast();
                    if (bad(l1, l2, nl)) continue;
                    dq.addLast(l2);
                    break;
                }
                dq.addLast(nl);
            }
        }
        System.out.println(dp[M]);
    }
}
