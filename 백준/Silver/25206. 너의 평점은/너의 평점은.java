import java.io.*;
import java.util.*;

public class Main {
	//이건 list로 굳이 넣어줄 필요가 없는 거같은데.. 정렬도 아니고.
//	static class School{
//		String s;
//		int jum;
//		School(String s, int jum){
//			this.s = s;
//			this.jum = jum;
//		}
//	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 20;
		
		HashMap<String, Double> map = new HashMap<>();
		
		map.put("A+", 4.5);
		map.put("A0", 4.0);
		
		map.put("B+", 3.5);
		map.put("B0", 3.0);
		
		map.put("C+", 2.5);
		map.put("C0", 2.0);
		
		map.put("D+", 1.5);
		map.put("D0", 1.0);
		
		map.put("F", 0.0);
		
		Double bunja =0.0;
		Double sum =0.0;

		for(int i =0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//과목은 서로 다르며, 쓸일이 없으므로 받지 않음. -> 받아서 버리기
			st.nextToken(); // 과목명 (버림)
			double jum = Double.parseDouble(st.nextToken());
			String s = st.nextToken();
			
			if (s.equals("P")) continue;
			sum+= jum;
			//타입 맞춰서 써라.
			Double x = map.get(s);
			
			bunja += jum*x;
			
			//예외처리
			//P는 제외하기
			//오차 10의 -4승 처리하기
		}
		Double ans=bunja/sum;
		System.out.printf("%.6f", ans);//문제에서 요구한 오차보다 작으므로 가능함.
//		System.out.printf("%.4f", ans);

	}
}
