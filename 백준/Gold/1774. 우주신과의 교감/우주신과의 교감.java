import java.io.*;
import java.util.*;

public class Main {
	//크루스칼 => a, b, cost다 Edge에 선언해야함.
	//크루스칼은 이렇게 작동함:
	//모든 간선을 리스트에 저장
	//가중치 기준 정렬
	//작은 것부터 union-find로 연결
	static class Edge{
		int a, b;
		double cost;
		
		Edge(int a, int b, double cost){
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
//	    @Override
//	    public int compareTo(Edge o) {
//	        return Double.compare(this.cost, o.cost);
//	    }
	}
	
	static int[] parent;
	static int N, M;
	static List<Edge> edges;
	static int[] x, y;
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA!= rootB)parent[rootB]=rootA;
	}
	static int find(int a) {
		if(parent[a]==a) return a;
		return parent[a] = find(parent[a]);
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		edges = new ArrayList<>();
		//Edge[] edges = new Edge[100000];
		
		x = new int[N+1];
		y = new int[N+1];
		parent = new int[N+1];
		for(int i = 1; i<= N; i++)parent[i] = i;
		
		for(int i = 1; i<= N; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i  =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
		}
		
		for(int i =1; i<= N; i++) {
			for(int j =i+1; j<=N; j++) {
				double dx = x[i] - x[j];
				double dy = y[i] - y[j];
				double d = Math.sqrt(dx*dx + dy*dy);
				edges.add(new Edge(i, j, d));
			}
		}
		
//		Collections.sort(edges);
		edges.sort((w, r) -> Double.compare(w.cost, r.cost));
		
		double ans = 0;
        for (Edge e : edges) {
            if (find(e.a) != find(e.b)) {
                union(e.a, e.b);
                ans += e.cost;
            }
        }

        System.out.printf("%.2f\n", ans);
    }
}
