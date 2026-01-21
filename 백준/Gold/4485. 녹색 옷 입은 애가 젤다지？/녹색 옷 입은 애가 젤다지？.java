import java.io.*;
import java.util.*;

public class Main {
	
	static class Node{
		int x;
		int y;
		int cost;
		Node(int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	
	static int[][] graph;
	static int[][] dist;
	static int N;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0)break;
			//break를 만들기 위해서 while문 안에 넣었다

			graph = new int[N][N];
			dist = new int[N][N];
			
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j]= Integer.MAX_VALUE;
				}
			}
			
			dijkstra();
			
			System.out.println("Problem "+x+": "+dist[N-1][N-1]);
			
			x++;
		}

	}
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b)-> a.cost- b.cost);
		dist[0][0] =graph[0][0];
		pq.add(new Node(0, 0, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.cost>dist[cur.x][cur.y])continue;
			
			for(int i =0; i<4; i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				
				if(nx<0||ny<0||nx>=N||ny>=N)continue;
				if(dist[nx][ny]>dist[cur.x][cur.y]+graph[nx][ny]) {
					dist[nx][ny]= dist[cur.x][cur.y]+graph[nx][ny];
					pq.add(new Node(nx, ny, dist[cur.x][cur.y]+graph[nx][ny]));
				}
				
			}
			
			
		}
	}
	
}