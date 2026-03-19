import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long x = M / N;

        long a = 1, b = x;

        for(long i = 1; i * i <= x; i++) {//i는 작은 약수부터 증가
    	//자동으로 마지막에 30 36 이렇게 차이가 적은 값이 남게 된다.
            if(x % i == 0) {
                long j = x / i;

                if(gcd(i, j) == 1) {
                    a = i;
                    b = j;
                }
            }
        }

        System.out.println(N * a + " " + N * b);
    }

    static long gcd(long a, long b) {
        while(b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}