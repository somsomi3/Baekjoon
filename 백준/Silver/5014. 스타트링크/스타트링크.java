import java.io.*;
import java.util.*;

public class Main {
	static int F, S, G, U, D;
	static int[] dist;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		dist = new int[F+1];
		Arrays.fill(dist, -1);
	
		bfs(S);

        if (dist[G] == -1) System.out.println("use the stairs");
        else System.out.println(dist[G]);
    }

	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		//방문했던 곳 또가도됨.
//		visited[start] = 
        dist[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
			
            int up = cur + U;
            if (up <= F && dist[up] == -1) {
                dist[up] = dist[cur] + 1;
                q.offer(up);
            }

            int down = cur - D;
            if (down >= 1 && dist[down] == -1) {
                dist[down] = dist[cur] + 1;
                q.offer(down);
            }
        }
    }
}