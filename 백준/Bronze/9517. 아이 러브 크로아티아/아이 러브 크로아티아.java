import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		int total = 210;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			String t = st.nextToken();
			
			total-=a;
			
			if(total<=0)break;
			//total값 계산 후에 break유무 확인 부터 하고
			//그 이후 문자 읽기
			
			if(t.equals("T")) {
				x += 1;
				if(x > 8) x = 1;
			}
			
		}
		System.out.println(x);
	}
}
