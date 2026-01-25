import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = st.nextToken();
		String t = st.nextToken();
		
		char[] ss = new char[s.length()];
		char[] tt = new char[t.length()];
		
		for(int i =0; i<s.length(); i++) {
			ss[i]= s.charAt(i);
		}
		
		for(int i =0; i<t.length(); i++) {
			tt[i] = t.charAt(i);
		}
		
		int x = 0;
		int y =0;
		boolean found = false;
//		for(int i =0; i<t.length(); i++) {
//		for (int i = 0; i < t.length() && !found; i++) {
//			for(int j =0; j<s.length(); j++) {
		for (int j = 0; j < s.length() && !found; j++) {
		    for (int i = 0; i < t.length(); i++) {
				if(tt[i]==ss[j]) {
					x =j;
					y=i;
//					System.out.println(x);
//					System.out.println(y);
		            found = true;
		            break;
				}
			}
		}
		
		char[][] graph = new char[t.length()][s.length()];// 세로 먼저 , 가로 
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t.length(); i++) {
			
			for(int j=0; j<s.length(); j++) {
				if(j==x) {
					graph[i][j] = tt[i];
//					sb.append(graph[i][j]);
				}else {
					graph[i][j]= '.';
//					sb.append(graph[i][j]);
				}
				
				if(i==y) {
					graph[i][j] = ss[j];
				}
				sb.append(graph[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}