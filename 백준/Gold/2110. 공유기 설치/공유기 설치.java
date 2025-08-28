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
        int c, val = 0;
        do {
            c = read();
        } while (c <= 32); // 공백, 개행 무시

        boolean neg = false;
        if (c == '-') {
            neg = true;
            c = read();
        }

        while (c > 32) {
            val = (val << 3) + (val << 1) + (c - '0'); 
            c = read();
        }
        return neg ? -val : val;
    }

    static int[] house;

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int C = nextInt();
        house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = nextInt();
        }

        Arrays.sort(house);

        int left = 1;
        int right = house[N - 1] - house[0];
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (canInstall(mid, C, N)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean canInstall(int minDist, int C, int N) {
        int count = 1;
        int last = house[0];

        for (int i = 1; i < N; i++) {
            if (house[i] - last >= minDist) {
                count++;
                last = house[i];
            }
        }

        return count >= C;
    }
}
