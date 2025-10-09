import java.util.*;
class Solution {
    static int[] parent;
	
	static int find(int x) {
		if(parent[x]==x)return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a !=b )parent[b]=a;
	}
	
        public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        int answer = 0, edgeCount = 0;
        for (int[] e : costs) {
            int a = e[0], b = e[1], w = e[2];
            if (find(a) != find(b)) {
                union(a, b);
                answer += w;
                // if (++edgeCount == n - 1) break;
            }
        }
        return answer;
    }
}