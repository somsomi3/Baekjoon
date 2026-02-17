import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] bottom = new int[H + 2];
        int[] top = new int[H + 2];

        // 입력
        for (int i = 0; i < N; i++) {
            int len = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                bottom[len]++;//길이 위치만 +1
            } else {
                top[len]++;//길이 위치만 +1
            }
        }

        // 뒤에서부터 누적합
        for (int i = H - 1; i >= 1; i--) {
            bottom[i] += bottom[i + 1];
            top[i] += top[i + 1];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;

        // 각 높이에서 충돌 개수 계산
        for (int h = 1; h <= H; h++) {
            int x = bottom[h] + top[H - h + 1];

            if (x < min) {
                min = x;
                count = 1;
            } else if (x == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }

}
