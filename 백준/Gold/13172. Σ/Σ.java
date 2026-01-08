import java.io.*;
import java.util.*;

public class Main {
	
    static final int MOD = 1_000_000_007;
    
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int MOD = 1_000_000_007;
		
		int M = Integer.parseInt(br.readLine());
        long ans = 0;
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			
//			int x = S*inv(N)*MOD;
			//누적합
			ans = (ans + S * inv(N) % MOD) % MOD;	
		}

		System.out.println(ans);
		

	}
	//inv에 입력은 int여도, 연산은 long으로 해야 안
    static long inv(long a) {
//		return pow(Q, MOD-2)%m;
        return pow(a, MOD - 2);
	}
    static long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}