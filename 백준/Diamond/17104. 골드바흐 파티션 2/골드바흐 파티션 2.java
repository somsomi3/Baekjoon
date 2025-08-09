import java.io.*;
import java.util.*;

public class Main {

    static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c, s = 1, x = 0;
            do { c = read(); } while (c <= 32);
            if (c == '-') { s = -1; c = read(); }
            while (c > 32) { x = x * 10 + (c - '0'); c = read(); }
            return x * s;
        }
    }

    static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        if (n >= 2) Arrays.fill(isPrime, 2, n + 1, true);
        for (int p = 2; p * p <= n; p++) {
            if (!isPrime[p]) continue;
            for (int q = p * p; q <= n; q += p) isPrime[q] = false;
        }
        return isPrime;
    }

    static void fft(double[] re, double[] im, boolean invert) {
        int n = re.length;
        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >>> 1;
            for (; (j & bit) != 0; bit >>>= 1) j ^= bit;
            j ^= bit;
            if (i < j) {
                double tr = re[i]; re[i] = re[j]; re[j] = tr;
                double ti = im[i]; im[i] = im[j]; im[j] = ti;
            }
        }
        for (int len = 2; len <= n; len <<= 1) {
            double ang = 2 * Math.PI / len * (invert ? -1 : 1);
            double wlenRe = Math.cos(ang), wlenIm = Math.sin(ang);
            for (int i = 0; i < n; i += len) {
                double wRe = 1, wIm = 0;
                int half = len >>> 1;
                for (int j = 0; j < half; j++) {
                    int u = i + j, v = u + half;
                    double vr = re[v] * wRe - im[v] * wIm;
                    double vi = re[v] * wIm + im[v] * wRe;
                    double ur = re[u], ui = im[u];
                    re[u] = ur + vr;
                    im[u] = ui + vi;
                    re[v] = ur - vr;
                    im[v] = ui - vi;
                    double nWRe = wRe * wlenRe - wIm * wlenIm;
                    double nWIm = wRe * wlenIm + wIm * wlenRe;
                    wRe = nWRe; wIm = nWIm;
                }
            }
        }
        if (invert) {
            for (int i = 0; i < n; i++) { re[i] /= n; im[i] /= n; }
        }
    }

    static double[] convolution(double[] a) {
        int need = a.length * 2 - 1;
        int n = 1; while (n < need) n <<= 1;
        double[] re = new double[n], im = new double[n];
        System.arraycopy(a, 0, re, 0, a.length);
        fft(re, im, false);
        for (int i = 0; i < n; i++) {
            double r = re[i], m = im[i];
            double nr = r * r - m * m;
            double ni = 2 * r * m;
            re[i] = nr; im[i] = ni;
        }
        fft(re, im, true);
        double[] res = new double[need];
        System.arraycopy(re, 0, res, 0, need);
        return res;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int T = fs.nextInt();
        int[] Q = new int[T];
        int maxN = 0;
        for (int i = 0; i < T; i++) {
            Q[i] = fs.nextInt();
            if (Q[i] > maxN) maxN = Q[i];
        }

        boolean[] isPrime = sieve(maxN);
        double[] A = new double[maxN + 1];
        for (int i = 2; i <= maxN; i++) if (isPrime[i]) A[i] = 1.0;

        double[] C = convolution(A);

        StringBuilder sb = new StringBuilder();
        for (int n : Q) {
            long ordered = Math.round(C[n]);
            long add = (n % 2 == 0 && isPrime[n / 2]) ? 1 : 0;
            long ans = (ordered + add) / 2;
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
