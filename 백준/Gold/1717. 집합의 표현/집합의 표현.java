import java.io.*;
import java.util.*;

public class Main {
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA != rootB) {
			parent[rootB] = rootA; 
		}
	}
	static int find(int x) {
		if(parent[x]==x)return x;
		return parent[x] = find(parent[x]);
	}
	
	static int[] parent;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		for(int i = 1; i<=n; i++)parent[i] = i;//처음에는 자기자신을 부모로 해서 시작함.
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			
			if(a==0) {
				if(find(b)!= find(c)) {
					union(b, c);
				}
			}else {
				if(find(b)==find(c)) {
					sb.append("YES").append("\n");
				}else {
					sb.append("NO").append("\n");
				}
			}
		}
		
		System.out.println(sb);
		
	}
}
