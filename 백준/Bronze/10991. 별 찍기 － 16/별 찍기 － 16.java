import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			for(int j=N-i; j>0; j--) {
				sb.append(" ");
			}
			for(int j=0; j<=i; j++) {
				if(j!=i) {
					sb.append("*").append(" ");
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
	}
}
