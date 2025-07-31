import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 10000;
    static boolean[] isNotPrime = new boolean[MAX + 1];
    static List<Integer> primeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 1. 소수 구하기 (에라토스테네스의 체)
        sieve();

        // 2. 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int a = 0, b = 0;
            
            // 3. n/2부터 양쪽으로 퍼지며 소수 쌍 찾기
            for (int i = n / 2; i >= 2; i--) {
                if (!isNotPrime[i] && !isNotPrime[n - i]) {
                    a = i;
                    b = n - i;
                    break;
                }
            }
            sb.append(a).append(" ").append(b).append("\n");
        }

        System.out.print(sb);
    }

    // 소수 구하기 (에라토스테네스의 체)
    static void sieve() {
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i * i <= MAX; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        for (int i = 2; i <= MAX; i++) {
            if (!isNotPrime[i]) {
                primeList.add(i);
            }
        }
    }
}
