import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int maxVal = 0;
        long sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxVal = Math.max(maxVal, arr[i]);
            sum += arr[i];
        }

        long left = maxVal; // 최소 하루치 이상
        long right = sum;   // 전체 합
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (canUse(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean canUse(long money) {
        int count = 1; // 첫 인출
        long remain = money;

        for (int i = 0; i < N; i++) {
            if (remain < arr[i]) { // 오늘 쓸 돈 부족 >> 다시 인출
                count++;
                remain = money;
            }
            remain -= arr[i];
        }

        return count <= M;
    }
}
