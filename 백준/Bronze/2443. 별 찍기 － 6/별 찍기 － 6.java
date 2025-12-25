import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++) {
			for(int j=0; j<i; j++) {
				sb.append(" ");
			}
			for(int j = 2*(N-i)-1; j>0; j--) {// 범위 중요
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.print(sb);	
	}
}