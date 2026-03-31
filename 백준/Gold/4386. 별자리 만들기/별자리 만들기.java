import java.io.*;
import java.util.*;

public class Main {
	static class Edge {
        int from, to;
        double cost;

        Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //유니온 파인드 초기화
        parent = new int[N+1];
        for(int i = 1; i<=N; i++)parent[i] = i;
        
//        Edge[] edges = new Edge[N];
        
        double[] x = new double[N+1];
        double[] y = new double[N+1];
        		
        for(int i =1; i<=N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	x[i] = Double.parseDouble(st.nextToken());
        	y[i] = Double.parseDouble(st.nextToken());
        	
        }
        //간선을 저장하려면, 간선갯수가 안정해져 있어서 list를 만들어서 넣어준다.
        List<Edge> edges = new ArrayList<>();
        
        // 간선 생성하기
        for(int i = 1; i<=N; i++) {
        	for(int j = i+1; j<=N; j++) {
        		double dx = x[i] - x[j];
        		double dy = y[i] - y[j];
        		
        		double cost = Math.sqrt(dx* dx+ dy*dy);
        		
        		edges.add(new Edge(i, j, cost));
        	}
        }
        
//        Arrays.sort(edges, (o1, o2) -> o1.cost - o2.cost);
        edges.sort((a, b) -> Double.compare(a.cost, b.cost));
        
        
        double result = 0;
        int count = 0;
        
        for(Edge cur: edges) {
        	if(find(cur.from)!= find(cur.to)) {
        		union(cur.from, cur.to);
        		result += cur.cost;
        		count++;
        		
        		if(count == N- 1)break;
        	}
        }
        
        System.out.printf("%.2f\n",result);
        
    }
}

