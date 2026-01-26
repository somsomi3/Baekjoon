import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int max =0;//0으로 곱한 값은 없으므로, 아마 0이 가장 작은 값일것이다.
		for(int i =1; i<=M; i++) {
			int x = N*i;
			
			int na =0;
			int result =0;
			while(x>0) {
				na = x%10; 
				result = result*10+ na;
				x=x/10;
			}
			max = Math.max(max, result);
		}
		
		System.out.println(max);
	}
}
