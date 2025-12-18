import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//어느게 클지 모름
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		long x = Math.max(N, M);
		long y = Math.min(N, M);
		
		
		//두수가 같을 경우,.,,
		long cnt = x - y - 1;
		if (cnt < 0) cnt = 0;
		System.out.println(cnt);
		
		for(long i=y+1; i<x; i++) {
			System.out.print(i+" ");
		}
		
	}
}
