import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 소수 여부를 저장할 배열
        boolean[] isNotPrime = new boolean[N + 1];

        // 0과 1은 소수가 아님
        isNotPrime[0] = isNotPrime[1] = true;

        // 에라토스테네스의 체
        for (int i = 2; i * i <= N; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }
}
