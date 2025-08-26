import java.io.*;
import java.util.*;

public class Main {
    static final InputStream in = System.in;
    static final byte[] buf = new byte[1 << 16];
    static int ptr = 0, len = 0;

    static int read() throws IOException {
        if (ptr >= len) {
            len = in.read(buf);
            ptr = 0;
            if (len <= 0) return -1;
        }
        return buf[ptr++];
    }

    static int nextInt() throws IOException {
        int c, sign = 1, val = 0;
        c = read();
        while (c <= 32) {
            if (c == -1) return Integer.MIN_VALUE;
            c = read();
        }
        if (c == '-') {
            sign = -1;
            c = read();
        }
        while (c > 32) {
            val = (val << 3) + (val << 1) + (c & 15);
            c = read();
        }
        return val * sign;
    }

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int N = nextInt();
        HashSet<Integer> set = new HashSet<>(N * 2);

        for (int i = 0; i < N; i++) {
            set.add(nextInt());
        }

        int M = nextInt();
        for (int i = 0; i < M; i++) {
            int x = nextInt();
            sb.append(set.contains(x) ? 1 : 0).append('\n');
        }

        System.out.print(sb);
    }
}
