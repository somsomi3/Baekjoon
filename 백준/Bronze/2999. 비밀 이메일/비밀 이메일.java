import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = br.readLine();
		
		int N = s.length();
		
		int max =0;//1부터 있으니까 0이 가장 작은 값.
//		for(int i=1; i<=N/2; i++) {
		for (int i = 1; i * i <= N; i++) {
			if(N%i==0) {
				max = Math.max(max, i);//R을 구함.
			}
		}
		int x = N/max;
        char[][] graph = new char[max][x];
		
		int idx = 0;
		for (int j = 0; j < x; j++) {
		    for (int i = 0; i < max; i++) {
                graph[i][j] = s.charAt(idx++);
			}
		}
		StringBuilder sb = new StringBuilder();
		//출력
		for (int i = 0; i < max; i++) {
		    for (int j = 0; j < x; j++) {
				sb.append(graph[i][j]);
			}
		}
		System.out.println(sb);
	}
}
