import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        // B
        for (int b = 1; b < N; b++) {
            // A (A ≥ B + 2)
            for (int a = b + 2; a < N; a++) {
                int c = N - a - b;

                if (c <= 0) continue;   // C ≥ 1
                if (c % 2 == 0) cnt++;  // C는 짝수
            }
        }

        System.out.println(cnt);
    }
}
