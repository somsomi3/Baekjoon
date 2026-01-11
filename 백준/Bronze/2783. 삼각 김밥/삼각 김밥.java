import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//int / int → 정수 나눗셈 (소수점 버림)
		//double / double → 실수 나눗셈 (소수점까지 계산)
		
		Double sevenX = Double.parseDouble(st.nextToken());
		Double sevenY = Double.parseDouble(st.nextToken());
		
		Double sevenA = sevenX/sevenY*1000;
		
		int N = Integer.parseInt(br.readLine());
		
		Double answer = sevenA;
		
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			Double x = Double.parseDouble(st.nextToken());
			Double y = Double.parseDouble(st.nextToken());
			
			Double a = x/y*1000;
			
			if(a<answer)answer = a;
		}
//		System.out.println(answer);
		System.out.printf("%.2f\n", answer);
//		%.2f => 소수점 둘째자리까지
//		\n => 줄바꿈
//		, answer =>출력할 값
	}
}
