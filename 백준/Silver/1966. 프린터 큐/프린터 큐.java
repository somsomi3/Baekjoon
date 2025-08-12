import java.io.*;
import java.util.Arrays;

public class Main {
    static final class FastScanner {
        private final InputStream in;
        private final byte[] buf = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { this.in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buf);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buf[ptr++];
        }
        int nextInt() throws IOException {
            int c, s = 1, n = 0;
            do { c = read(); } while (c <= 32);
            if (c == '-') { s = -1; c = read(); }
            while (c > 32) { n = n * 10 + (c - '0'); c = read(); }
            return n * s;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int T = fs.nextInt();
        int[] freq = new int[10];

        while (T-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();

            // 원형 큐: cap = n
            int[] q = new int[n];
            int head = 0, tail = 0, size = 0;

            Arrays.fill(freq, 0);
            int currentMax = 0;

            for (int i = 0; i < n; i++) {
                int p = fs.nextInt();
                q[tail] = p;
                tail++; if (tail == n) tail = 0;
                size++;
                freq[p]++;
                if (p > currentMax) currentMax = p;
            }

            int printed = 0;

            while (size > 0) {
                int p = q[head];
                head++; if (head == n) head = 0;
                size--;

                if (p == currentMax) {    
                    printed++;
                    freq[p]--;
                    if (m == 0) {            
                        out.append(printed).append('\n');
                        break;
                    }
                    m--;                   

                    if (freq[currentMax] == 0) {
                        while (currentMax > 0 && freq[currentMax] == 0) currentMax--;
                    }
                } else {                  
                    q[tail] = p;
                    tail++; if (tail == n) tail = 0;
                    size++;
                    m = (m == 0 ? size - 1 : m - 1);
                }
            }
        }

        System.out.print(out.toString());
    }
}
