import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<N; i++) {//한줄씩 전체 줄 돌기
			
			for(int j=0; j<i; j++) {//그안에 이어붙이기
				sb.append(" ");
			}
			for(int j =0; j<N-i;j++) {//그안에 이어붙이기
				sb.append("*");
			}
			sb.append("\n");//그안에 이어붙여서 줄끊기
		}
		System.out.println(sb);// 위에 서 끊은 한줄씩 모두를 출력
	}
}