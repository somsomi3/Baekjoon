import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<s.length(); j++) {
				char c = s.charAt(j);
				//문자열의 가장 첫 문자는 1번째 문자이고, 
				if(j+1==M) {
					continue;
				}
				else {
					sb.append(c);
				}
			}
			System.out.println(sb);
			
		}

		//문자열의 길이는 80을 넘지 않고, => 범위 초과는 따로 없을 것 같다.
		
	}
}