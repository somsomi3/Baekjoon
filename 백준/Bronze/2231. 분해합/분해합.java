import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ans = 0;

        //최소값이 보장이 안되서 무조건 다돌아야함.
//        시간을 단축 시키기 위해선 최소값을 보장 받는 형태로 가야함
        for (int i = N - 1; i >= 1; i--) {
            if (littleSum(i) == N) {
                ans = i;
            }
        }

        System.out.println(ans);
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