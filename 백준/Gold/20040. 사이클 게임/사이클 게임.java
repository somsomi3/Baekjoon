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
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int result = 0;
		boolean flag = false;
		
		parent = new int[n+1];
		for(int i = 1; i<=n; i++)parent[i] = i;
		
		for(int i = 0; i<m; i++) {
			st =new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(find(a)!= find(b)) {
				union(a, b);
				result++;
			}else {
				flag = true;
				result++;
				break;
			}
			
		}
		if(flag)System.out.println(result);
		else System.out.println(0);
	}
}