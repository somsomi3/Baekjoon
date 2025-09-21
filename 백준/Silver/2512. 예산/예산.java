import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 0;
        int right = arr[N - 1];
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(mid)) {
                answer = mid;
                left = mid + 1; // 상한액을 더 키워보기
            } else {
                right = mid - 1; // 상한액 줄이기
            }
        }

        System.out.println(answer);
    }

    static boolean isPossible(int mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.min(arr[i], mid); // 상한액 적용
        }
        return sum <= S;
    }
}
