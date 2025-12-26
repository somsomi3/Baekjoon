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

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            // 남자
            if (gender == 1) {
                for (int k = num; k <= N; k += num) {
                    arr[k - 1] ^= 1;
                }
            }
            // 여자
            else {
                int center = num - 1;
                arr[center] ^= 1;

                int d = 1;
                while (center - d >= 0 && center + d < N) {
                    if (arr[center - d] == arr[center + d]) {
                        arr[center - d] ^= 1;
                        arr[center + d] ^= 1;
                        d++;
                    } else {
                        break;
                    }
                }
            }
        }

        // 출력 (20개씩)
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}
