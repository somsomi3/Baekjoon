import java.io.*;
import java.util.*;

public class Main {
	static class Edge{
		int from, to, cost;
		Edge(int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	static int[] parent;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Edge[] edges = new Edge[E];
		
		for(int i = 0; i< E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(a, b, c);
		}
		
		Arrays.sort(edges, (a, b)-> a.cost - b.cost);
		
		parent = new int[V + 1];
        for (int i = 1; i <= V; i++) parent[i] = i;

        long result = 0;
        int cnt = 0;

        for (Edge e : edges) {
        	if(find(e.from)!= find(e.to)) {
        		union(e.from, e.to);
        		result += e.cost;
        		cnt++;
        		
        		if(cnt == V-1)break;
        	}
        }
        System.out.println(result);
		
	}
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA != rootB) {
			parent[rootB]= rootA;
		}
	}
	static int find(int x) {
		if(parent[x]==x)return x;
		return parent[x]= find(parent[x]);
	}
}