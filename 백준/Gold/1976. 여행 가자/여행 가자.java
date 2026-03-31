import java.io.*;
import java.util.*;

public class Main {
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA!= rootB) {
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
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		for(int i = 1; i<=N; i++)parent[i] = i;
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
//			for(int j = 0; j<=i; j++){
		    for(int j = 0; j<N; j++) {
				int x = Integer.parseInt(st.nextToken());
				if(j <= i && x == 1) {
//				if(x==1) {
					union(i+1, j+1);
					
				}
				
			}
		}
		int[] arr = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}

		int root = find(arr[0]);

		for(int i = 1; i<M; i++) {
		    if(find(arr[i]) != root) {
		        System.out.println("NO");
		        return;
		    }
		}
		System.out.println("YES");
	}
}
