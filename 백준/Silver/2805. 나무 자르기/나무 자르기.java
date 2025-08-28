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
        int c, val = 0, sign = 1;
        do { c = read(); } while (c <= 32);
        if (c == '-') { sign = -1; c = read(); }
        while (c > 32) {
            val = (val << 3) + (val << 1) + (c & 15);
            c = read();
        }
        return val * sign;
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt(); // 나무 수
        int m = nextInt(); // 필요한 길이
        int[] trees = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = nextInt();
            if (trees[i] > max) max = trees[i];
        }

        int left = 0, right = max, answer = 0;

        while (left <= right) {
            int mid = (left + right) >>> 1;

            if (canCut(trees, m, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean canCut(int[] trees, int m, int mid) {
        long total = 0;
        for (int tree : trees) {
            if (tree > mid) total += (tree - mid);
        }
        return total >= m;
    }
}
