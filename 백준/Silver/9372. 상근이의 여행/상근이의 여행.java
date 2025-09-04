import java.io.*;

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
        int c, n = 0;
        while ((c = read()) <= 32) if (c == -1) return -1;
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            n = (n << 3) + (n << 1) + (c & 15);
        } while ((c = read()) > 32);
        return neg ? -n : n;
    }

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int T = nextInt();
        while (T-- > 0) {
            int N = nextInt();
            int M = nextInt();
            for (int i = 0; i < M; i++) {
                nextInt(); // a
                nextInt(); // b
            }
            sb.append(N - 1).append('\n');
        }
        System.out.print(sb);
    }
}
