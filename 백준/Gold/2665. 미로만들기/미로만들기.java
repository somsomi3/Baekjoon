import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int x, y, cost;
		Node(int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost =cost;
		}
	}
	
	static int[][] graph;
	static int[][] dist;
	static int N;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		//그래프와 dist초기화
		graph = new int[N][N];
		dist = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j =0; j<N; j++) {
				if (line.charAt(j) == '1') graph[i][j] = 0; // 흰 방
				else graph[i][j] = 1;                      // 검은 방
				dist[i][j] =Integer.MAX_VALUE;
			}
		}
		
		dijkstra();
		
		System.out.println(dist[N-1][N-1]);
		
	}
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b)-> a.cost -b.cost);
		dist[0][0] =0;
		pq.add(new Node(0, 0, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.cost > dist[cur.x][cur.y]) continue;
			
			for(int i=0; i<4; i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				
				if(nx<0||ny<0||nx>=N||ny>=N)continue;
				if(dist[cur.x][cur.y]+graph[nx][ny]<dist[nx][ny]) {
					dist[nx][ny] = dist[cur.x][cur.y]+graph[nx][ny];
					pq.add(new Node(nx, ny, dist[cur.x][cur.y]+graph[nx][ny]));
				}
			}	
		}
	}
}