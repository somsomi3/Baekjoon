import java.io.*;
import java.util.*;

public class Main {
	static char[][] graph;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		graph = new char[N][N];
		//세로 가로
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j =0; j<N; j++) {
				graph[i][j]=s.charAt(j);
			}
		}
		
		int x = Integer.parseInt(br.readLine());
		
		if(x ==1) {
			for(int i=0; i<N; i++) {
				for(int j =0; j<N; j++) {
					System.out.print(graph[i][j]);
				}
				System.out.println();
			}
		}else if(x==2) {
			for(int i=0; i<N; i++) {
				for(int j =N-1; j>=0; j--) {
					System.out.print(graph[i][j]);
				}
				System.out.println();
			}
		}else if(x==3) {
			for(int i=N-1; i>=0; i--) {
				for(int j =0; j<N; j++) {
					System.out.print(graph[i][j]);
				}
				System.out.println();
			}
		}
		
	}
}
