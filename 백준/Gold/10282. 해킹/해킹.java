import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int to;
		int cost;
		Node(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
		public int compareTo(Node o) {
			return this.cost -o.cost;
		}
	}
	static List<Node>[] graph;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[n+1];
			for(int i =1; i<=n; i++) graph[i]=new ArrayList<>();
			
	        dist = new int[n + 1];
	        Arrays.fill(dist, INF);
			
			for(int i =0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());			
				
				//양방향도 아니고, 입력이 역으로 된다.
				graph[y].add(new Node(x, z));
			}
			//최단 경로 합을 출력하는데... 이중 배열로 해야 하려나?
			dijkstra(c);
			
			int count = 0;
			int maxTime = 0;
			for(int i =1; i<=n; i++) {
				if(dist[i]!=INF) {
					count++;
					maxTime = Math.max(maxTime, dist[i]);
				}
			}
            sb.append(count).append(" ").append(maxTime).append("\n");
        }

        System.out.print(sb.toString());
    }
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		dist[start]=0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int curNode = cur.to;
            int curDist = cur.cost;
            
            if(curDist>dist[curNode])continue;
            
            for(Node next: graph[curNode]) {      	
            	if(curDist+next.cost<dist[next.to]) {
            		dist[next.to]= curDist +next.cost;
            		pq.offer(new Node(next.to, dist[next.to]));

            	}
            }    
		}
	}
}
