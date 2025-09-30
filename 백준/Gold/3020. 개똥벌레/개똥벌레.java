import java.io.*;
import java.util.*;

public class Main {
    static int N, H;
    static int[] down, up;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        down = new int[H + 2];
        up = new int[H + 2];

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                down[h]++;
            } else {
                up[h]++;
            }
        }

        for (int i = H - 1; i >= 1; i--) {
            down[i] += down[i + 1];
            up[i] += up[i + 1];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int h = 1; h <= H; h++) {
            int crash = down[h] + up[H - h + 1];
            if (crash < min) {
                min = crash;
                count = 1;
            } else if (crash == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }
}
