import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] cnt  = new int[101];
		
		
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for(int j =a; j<b; j++) {
				cnt[j]++;
			}
		}
		
		int sum=0;
		for(int i=0; i<cnt.length; i++) {
			int x =0;
			if(cnt[i]==1) {
				x = 1*A;
			}else if(cnt[i]==2) {
				x = 2*B;
			}else if(cnt[i]==3) {
				x = 3*C;
			}
			
			sum+=x;
		}
		
		System.out.println(sum);
	}
}
