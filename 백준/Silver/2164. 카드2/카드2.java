import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int L = Integer.highestOneBit(N);  // N 이하 최대 2의 거듭제곱

        if (N == L) System.out.println(N);
        else System.out.println((N - L) << 1);  // 2 * (N - L)을 비트연산으로
    }
}
