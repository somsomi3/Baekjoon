import java.io.*;
import java.util.*;

public class Main {
	static void union(int a, int b) {
		int rootA  = find(a);
		int rootB  = find(b);
		if(rootA!= rootB) {
			parent[rootB]= rootA; 
		}
	}
	static int find(int x) {
		if(parent[x]==x)return x;
		return parent[x] = find(parent[x]);
	}
	
	static int N, M;
	static int[] parent;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for(int i = 0; i<= N; i++)parent[i]=i;//일단 부모는 자기자신
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a==0) {
				if(find(b)!=find(c)) {
					union(b, c);
				}
			}else {
				if(find(b)!= find(c))sb.append("NO").append("\n");
				else sb.append("YES").append("\n");
			}
		}
		System.out.println(sb);
		
	}
}
