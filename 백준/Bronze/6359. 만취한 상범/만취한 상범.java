import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			boolean[] moon = new boolean[N+1];
			
			for(int i=1; i<=N; i++) {
				for(int j=i; j<=N; j+=i ) {// 배수의 개념을 j+=i로 더하는 것이 중요하다!!!
//					if(i*j==true) i=false;
//					else i=true
					moon[j] = !moon[j];
				}
			}
			int count =0;
			for(int i =1; i<=N; i++) {
				if(moon[i]) count++;
			}
			System.out.println(count);
		}
	}
}
