import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int idx = -1;
        for (int i = N - 1; i > 0; i--) {
            if (arr[i - 1] > arr[i]) {
                idx = i - 1;
                break;
            }
        }

        if (idx == -1) {
            System.out.println(-1);
            return;
        }

        for (int i = N - 1; i > idx; i--) {
            if (arr[i] < arr[idx]) {
                int tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
                break;
            }
        }

        Arrays.sort(arr, idx + 1, N);
        for (int i = idx + 1, j = N - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
