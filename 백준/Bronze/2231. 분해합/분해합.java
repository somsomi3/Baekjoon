import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //N은 자릿수의 합
        int N = Integer.parseInt(br.readLine());

        int start = Math.max(1, N - 9 * String.valueOf(N).length());

        for (int i = start; i < N; i++) {
            if (littleSum(i) == N) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }

    static int littleSum(int num) {
        int sum = num;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
