import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		String s;
		while(!(s=br.readLine()).equals("#")) {
			StringTokenizer st = new StringTokenizer(s);

			String c= st.nextToken();
			char cc = c.charAt(0);
			
			//인덱스 n부터 끝까지 잘라서 반환
			String t = s.substring(2);
//			String t = st.nextToken();
			String lower = t.toLowerCase();
			
			int count =0;
			for(int i=0; i<lower.length(); i++) {
				if(cc==lower.charAt(i)) {
					count++;
				}
			}
			sb.append(cc).append(" ").append(count).append("\n");
//			System.out.println(cc+" "+count);
			
		}
		System.out.println(sb);
	}
}
