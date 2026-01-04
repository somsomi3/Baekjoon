import java.io.*;

public class Main {
    static final InputStream in = System.in;
    static final byte[] buf = new byte[1 << 16];
    static int ptr = 0, len = 0;

    static int read() throws IOException {
        if (ptr == len) {
            len = in.read(buf);
            ptr = 0;
            if (len == -1) return -1;
        }
        return buf[ptr++];
    }

    static int nextInt() throws IOException {
        int c, sign = 1, val = 0;

        // 공백 넘기기
        do {
            c = read();
        } while (c <= 32);


        if (c == '-') {
            sign = -1;
            c = read();
        }
        while (c > 32) {
            val = (val << 3) + (val << 1) + (c - '0');
            c = read();
        }

        return val * sign;
    }

    public static void main(String[] args) throws IOException {
        int K = nextInt();
        int N = nextInt();

        int[] cables = new int[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            cables[i] = nextInt();
            if (cables[i] > max) max = cables[i];
        }

        long left = 1;
        long right = max;
        long answer = 0;

        while (left <= right) {
            long mid = left + ((right - left) >> 1);
            long count = 0;

            for (int len : cables) {
                count += len / mid;
            }

            if (count >= N) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
