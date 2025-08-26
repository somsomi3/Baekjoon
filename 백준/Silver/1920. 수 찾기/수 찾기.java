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
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = nextInt();
        Arrays.sort(arr);
        int M = nextInt();
        for (int i = 0; i < M; i++) {
            int x = nextInt();
            sb.append(binSearch(arr, x) ? 1 : 0).append('\n');
        }
        System.out.print(sb);
    }

    static boolean binSearch(int[] a, int key) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int v = a[mid];
            if (v == key) return true;
            if (v < key) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}
