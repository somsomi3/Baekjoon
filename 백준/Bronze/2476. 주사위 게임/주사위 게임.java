import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int ans =0;
		int maxAns = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//매줄마다 새로운 a, b, c를 받아야 한다. for밖에 st가 있다면 1줄만 읽고 말 것이다.
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
		
			if(a==b&& b==c) {
				ans = 10000+a*1000;

            }else if((a==b && b!=c) || (a==c && b!=c)) {
				ans = 1000+ a*100;
			}else if(b==c&& a!=b) {
                ans = 1000+ b*100;
				
			}else if(a!=b && b!=c) {
				int x = Math.max(a, Math.max(c, b));
				ans = x*100;
			}
			
			maxAns = Math.max(maxAns, ans);
		}
		System.out.println(maxAns);		
	}
}