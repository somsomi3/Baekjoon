import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr[N - 1];
        int ans = 0;

        while (left <= right) {//탐색 구간을 “완전히 다 보기 위해서” <=를 쓴다
            int mid = (left + right) / 2;

            if (canCut(mid) >= M) {//배열에 있는 값이 아닌, 그 값 그자체를 넣어서 따질수 있어야함.
                ans = mid;//그 값 그자체
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }

    static long canCut(int h) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > h) {
                sum += arr[i] - h;
            }
        }
        return sum;
    }
}