import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//아무도 안타고 아무도 안내리는 경우는.. 흠.. 그래도 0명이니까... max초기값을 0으로 하자.
		int N = 4;
		int sum =0;
		int max =0;
		for(int i =0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sum-=a;
			sum+=b;
//			System.out.println(sum);
//			System.out.println(max);
			if(sum>max)max=sum;
		}
		
		System.out.println(max);
	}
}
