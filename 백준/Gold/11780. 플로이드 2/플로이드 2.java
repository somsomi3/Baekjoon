import java.io.*;
import java.util.*;

public class Main {
    static int[][] dist;
    static int[][] next;
    static final int INF = 1_000_000_000;   
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());	
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());	
		dist = new int[n+1][n+1];
		next = new int[n+1][n+1];
		
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
		
		for(int i =0; i<m ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			//단방향
			if(c<dist[a][b]) {
				dist[a][b] = c;
				next[a][b] = b;// 가장 처음 정점 -> 전체 경로
			}
			
		}
		
		//플로이드
		for (int k = 1; k <= n; k++) {
		    for (int i = 1; i <= n; i++) {
		        for (int j = 1; j <= n; j++) {
					if(dist[i][j] > dist[i][k]+ dist[k][j]) {
						dist[i][j] = dist[i][k]+ dist[k][j];
						next[i][j] = next[i][k];
					}
				}
			}
		}
		//1. 최소비용 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
		    for (int j = 1; j <= n; j++) {
		        sb.append(dist[i][j] == INF ? 0 : dist[i][j]).append(" ");
		    }
		    sb.append("\n");
		}

		System.out.print(sb);
		
		//2. 경로 출력
		sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || dist[i][j] == INF) {
                    sb.append("0\n");
                } else {
                    List<Integer> path = getPath(i, j);
                    sb.append(path.size()).append(" ");
                    for (int v : path) sb.append(v).append(" ");
                    sb.append("\n");
                }
            }
        }System.out.print(sb); 

    }
	
		//경로 복원 함수
		static List<Integer> getPath(int start, int end) {
	        List<Integer> path = new ArrayList<>();
	        if (next[start][end] == 0) return path;
	        
	        path.add(start);
	        while(start != end) {
	        	start = next[start][end];
	        	path.add(start);
	        }
	        return path;
		}
}