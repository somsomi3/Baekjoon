import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int start = N - 9 * String.valueOf(N).length();
		if (start < 0) start = 0;

		int ans = 0;

		for (int i = start; i < N; i++) {
		    int temp = i;
		    int sum = temp;

		    while (temp > 0) {
//		    	temp = temp / 10 → 18 / 10 = 1
		        sum += temp % 10;
		        temp /= 10;
		        
//		        sum += temp % 10 → 206 + 1 = 207
//		        		temp = temp / 10 → 1 / 10 = 0
		    }

		    if (sum == N) {
		        ans = i;
		        break;
		    }
		}

		System.out.println(ans);
	}
}
