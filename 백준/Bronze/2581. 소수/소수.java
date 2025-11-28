import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[N+1];
		prime[0]= true;//소수아니다.
		prime[1]= true;//true가 소수아니다.
		
		for(int i =2; i*i<=N; i++) {
			if(!prime[i]) {
				for(int j =i*i; j<=N; j+=i) {
					prime[j] = true;//소수아니다.
				}
			}
		}
		
		int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = M; i <= N; i++) {
            if (!prime[i]) {
                sum += i;
                if (min == Integer.MAX_VALUE) min = i;
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}