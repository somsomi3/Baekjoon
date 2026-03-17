import java.io.*;
import java.util.*;

public class Main {
	static int a, b;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i =0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int lcm = M * N / gcd(M, N);

            int ans = -1;
  
            //완탐 대신 조건 활용
            for (int k = x; k <= lcm; k += M) {
                int ny = k % N == 0 ? N : k % N;//N에 대해, 12%12=0일때,12그자체를 넣어준다.
                if (ny == y) {
                    ans = k;
                    break;
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
	static int gcd(int a, int b) {
		while (b != 0) {
			int r = a%b;  
			a = b;
			b = r;
		}	
		return a;
	}
}