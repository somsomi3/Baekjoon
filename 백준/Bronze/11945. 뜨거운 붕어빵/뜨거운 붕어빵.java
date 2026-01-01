import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			//초기화 위치 항상 주의!
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<s.length(); j++) {
				//charAt(i)넣지말고 !!!! j넣어라 !!!!!
				char c = s.charAt(j);
				sb.append(c);
			}
			System.out.println(sb.reverse());
		}
		
	}
}
