import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y, cost;
        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    
    static int[][] graph;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	static int[][] dist;
    static int N, M;
    
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M= Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        dist = new int[N][M];
		for(int i= 0; i<N; i++) {
			 String line = br.readLine();
			for(int j= 0; j<M; j++) {
				graph[i][j] = line.charAt(j) - '0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dijkstra();
		
		System.out.println(dist[N-1][M-1]);
		
	}
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost-b.cost);
		dist[0][0] =0; //시작점
		pq.add(new Node(0, 0, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.cost > dist[cur.x][cur.y]) continue;
			
			for(int d =0; d<4; d++) {
				int nx = cur.x+dx[d];
				int ny = cur.y+dy[d];
				
				if(nx<0|| ny<0||nx>=N||ny>=M)continue;
				
				if(dist[cur.x][cur.y]+graph[nx][ny]<dist[nx][ny]) {
					dist[nx][ny] = dist[cur.x][cur.y]+graph[nx][ny];
					pq.add(new Node(nx, ny, dist[cur.x][cur.y]+graph[nx][ny]));
				}
			}
		}
	}
}