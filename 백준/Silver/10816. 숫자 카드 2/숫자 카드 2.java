import java.io.*;

public class Main {
    static final int OFFSET = 10_000_000;
    static final int SIZE = 20_000_001;
    static final InputStream in = System.in;
    static final byte[] buf = new byte[1 << 16];
    static int ptr = 0, len = 0;

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int[] count = new int[SIZE];

        for (int i = 0; i < N; i++) {
            int num = nextInt();
            count[num + OFFSET]++;
        }

        int M = nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int query = nextInt();
            sb.append(count[query + OFFSET]).append(' ');
        }

        System.out.println(sb);
    }

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
        do {
            c = read();
        } while (c <= 32);

        if (c == '-') {
            sign = -1;
            c = read();
        }

        while (c >= '0' && c <= '9') {
            val = (val << 3) + (val << 1) + (c & 15); // val*10 + (c-'0')
            c = read();
        }

        return val * sign;
    }
}
