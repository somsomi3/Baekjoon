import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int MAX = 10000;
        int[] count = new int[MAX + 1];
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            int w = Integer.parseInt(br.readLine());
            count[w]++;
        }

        int idx = 0;
        for (int i = 1; i <= MAX; i++) {
            while (count[i]-- > 0) {
                arr[idx++] = i;
            }
        }

        int maxDist = 0;
        for (int i = 0; i < N; i++) {
            int weight = arr[i] * (N - i);
            maxDist = Math.max(maxDist, weight);
        }

        System.out.println(maxDist);
    }
}
