import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
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
        c = read();
        while (c <= 32) {
            if (c == -1) return -1;
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
        int N = nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = nextInt();
        }

        Arrays.sort(arr);

        int maxDist = 0;
        for (int i = 0; i < N; i++) {
            int weight = arr[i] * (N - i);
            maxDist = Math.max(maxDist, weight);
        }

        System.out.println(maxDist);
    }
}
