import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<N; i++) {
			for(int j= 0; j<i; j++) {
				sb.append(" ");
			}
			for(int j=2*(N-i)-1; j>0; j--) {
				sb.append("*");
			}
			sb.append("\n");
		}
		for(int i =N-1; i>0; i--) {
			for(int j= 1; j<i; j++) {
				sb.append(" ");
			}
			for(int j=2*(N-i+1)-1; j>0; j--) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}