import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
//		while((N*L+(N-1)*5)>=D) {
		int sum = N * L + (N - 1) * 5;
		int t = D;

		while(true) {
			if(t > sum) {
				System.out.println(t);
				break;
			}
			
			int mod = t % (L + 5);

            if (mod >= L) {
                System.out.println(t);
                break;
            }

            t += D;
			
		}
		
	}
}
