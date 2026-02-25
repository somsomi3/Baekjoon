import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parent;

	static void union(int a, int b) {
	    int rootA = find(a);
	    int rootB = find(b);

	    if (rootA != rootB) {
	        parent[rootB] = rootA;
	    }
	}
	static int find(int x) {
	    if (parent[x] == x) return x;
	    return parent[x] = find(parent[x]); // 경로 압축
	}
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N+1];
		
		for (int i = 0; i <= N; i++)
		    parent[i] = i;

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.print(sb);
    }
}